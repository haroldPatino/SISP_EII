/**
 * 
 */
package persitencia;

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
	public String SubirPersona(Persona persona) {
		return "INSERT INTO `sisp`.`persona` (`NOMBRES`, `APELLIDOS`, `FECHA_NACIMIENTO`, `TELEFONO`, `DIRECCION`, `CORREO`, `NUMERO_DOCUMENTO`, `TIPO_DOCUMENTO`, `SEXO`, `PREGRADO`, `POSTGRADO`) VALUES ('"
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
				+ persona.getPostgrado() + "')";
	}
	public String idPersona(String numeroDocumento){
		return "SELECT ID_PERSONA FROM PERSONA WHERE NUMERO_DOCUMENTO="+numeroDocumento;
	}
}
