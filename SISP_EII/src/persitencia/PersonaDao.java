/**
 * 
 */
package persitencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;





import logica.ExpLaboral;
import logica.Persona;

/**
 * @author Harold Patiño
 *
 */
public class PersonaDao {
//Attributes-------------------------------------------
	private PersonaSql sql;
	private ConexionBD conexion;
//Building---------------------------------------------
	public PersonaDao(){
		sql=new PersonaSql();
		conexion=new ConexionBD();
	}
//Methods----------------------------------------------
	/**
	 * 
	 * @param personas
	 */
	public void insertarPersonas(ArrayList<Persona> personas){
		if(conexion.conectar()){
			for(int i=0;i<personas.size();i++){
				try {
					Persona person=personas.get(i);
					Statement sentence=conexion.getConexion().createStatement();
					sentence.execute(sql.InsertarPersona(person));
					ResultSet codPerson=sentence.executeQuery(sql.idPersona(String.valueOf(person.getNumeroDocumento())));
					String codigo=codPerson.getString("ID_PERSONA");
					ArrayList<ExpLaboral> expPerson=person.getExperiencias();
					for(int j=0;j<expPerson.size();j++){
						sentence.execute(sql.insertarExp(codigo, expPerson.get(i)));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
	}
}
