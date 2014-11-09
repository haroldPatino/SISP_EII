/**
 * 
 */
package persitencia;

import logica.ExpLaboral;
import logica.Persona;

/**
 * @author Harold Patiño
 *
 */
public class PersonaSql {
	// Attributes----------------------------

	// Building------------------------------
	/**
	 * 
	 */
	public PersonaSql() {
		// TODO Auto-generated constructor stub
	}

	// Methods-------------------------------
	/**
	 * 
	 * @return
	 */
	public String InsertarPersona(Persona persona) {
		return "INSERT INTO `sisp`.`persona` (`ID_PERSONA`, `NOMBRES`, `APELLIDOS`, `FECHA_NACIMIENTO`, `TELEFONO`, `DIRECCION`, `CORREO`, `NUMERO_DOCUMENTO`, `TIPO_DOCUMENTO`, `SEXO`, `PREGRADO`, `POSTGRADO`) VALUES (NULL, '"
				+ persona.getNombres()
				+ "', '"
				+ persona.getApellidos()
				+ "', '"
				+ persona.getFechaNacimiento()
				+ "', '"
				+ persona.getTelefono()
				+ "', '"
				+ persona.getDireccion()
				+ "', '"
				+ persona.getCorreo()
				+ "', '"
				+ persona.getNumeroDocumento()
				+ "', '"
				+ persona.getTipoDocumento()
				+ "', '"
				+ persona.getSexo()
				+ "', '"
				+ persona.getPregrado()
				+ "', '"
				+ persona.getPostgrado() + "');";
	}
	public String idPersona(String numeroDocumento){
		return "SELECT * FROM persona WHERE `NUMERO_DOCUMENTO`="+numeroDocumento+";";
	}
	public String insertarExp(String idPersona,ExpLaboral exp){
		return "INSERT INTO `sisp`.`exp_lab` (`ID_EXP`, `ID_PERSONA`, `FECHA_INICIO`, `FECHA_FIN`) VALUES (NULL, '"+idPersona+"', '"+exp.getFechaInicio()+"', '"+exp.getFechaFin()+"');";
	}
}
