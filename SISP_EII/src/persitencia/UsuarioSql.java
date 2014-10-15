/**
 * 
 */
package persitencia;

import java.sql.Statement;

import com.mysql.jdbc.ResultSet;

/**
 * @author Harold Patiño
 *
 */
public class UsuarioSql {
//Attributes----------------------------
	private static String sql="";
	private ConexionBD conexion;
//Building------------------------------
	/**
	 * 
	 */
	public UsuarioSql(){
		conexion=new ConexionBD();
	}
//Methods-------------------------------
	/**
	 * 
	 * @return
	 */
	public ResultSet selectUsuarios(){
		if(conexion.conectar()){
			Statement statement;
			ResultSet result;
		}
	}
}
