/**
 * 
 */
package logica;

/**
 * @author Harold Patiño
 *
 */
public class Seleccion {
//Attributes----------------------------
	private String id;
	private String nombres;
	private String apellidos;
	private String fecha_nacimiento;
	private String telefono;
	private String direccion;
	private String email;
	private String documento;
	private String tipoDoc;
	private String sexo;
	private String pregrado;
	private String postgrado;
	private String edad;
	private String exp;
//Building-----------------------------
	/**
	 * @param id
	 * @param nombres
	 * @param apellidos
	 * @param fecha_nacimiento
	 * @param telefono
	 * @param direccion
	 * @param email
	 * @param documento
	 * @param tipoDoc
	 * @param sexo
	 * @param pregrado
	 * @param postgrado
	 * @param edad
	 * @param exp
	 */
	public Seleccion(String id, String nombres, String apellidos,
			String fecha_nacimiento, String telefono, String direccion,
			String email, String documento, String tipoDoc, String sexo,
			String pregrado, String postgrado, String edad, String exp) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.telefono = telefono;
		this.direccion = direccion;
		this.email = email;
		this.documento = documento;
		this.tipoDoc = tipoDoc;
		this.sexo = sexo;
		this.pregrado = pregrado;
		this.postgrado = postgrado;
		this.edad = edad;
		this.exp = exp;
	}
//Methods----------------------------------
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id id a colocar
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}
	/**
	 * @param nombres nombres a colocar
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * @param apellidos apellidos a colocar
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	/**
	 * @return the fecha_nacimiento
	 */
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	/**
	 * @param fecha_nacimiento fecha_nacimiento a colocar
	 */
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono telefono a colocar
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion direccion a colocar
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email email a colocar
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}
	/**
	 * @param documento documento a colocar
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	/**
	 * @return the tipoDoc
	 */
	public String getTipoDoc() {
		return tipoDoc;
	}
	/**
	 * @param tipoDoc tipoDoc a colocar
	 */
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * @param sexo sexo a colocar
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return the pregrado
	 */
	public String getPregrado() {
		return pregrado;
	}
	/**
	 * @param pregrado pregrado a colocar
	 */
	public void setPregrado(String pregrado) {
		this.pregrado = pregrado;
	}
	/**
	 * @return the postgrado
	 */
	public String getPostgrado() {
		return postgrado;
	}
	/**
	 * @param postgrado postgrado a colocar
	 */
	public void setPostgrado(String postgrado) {
		this.postgrado = postgrado;
	}
	/**
	 * @return the edad
	 */
	public String getEdad() {
		return edad;
	}
	/**
	 * @param edad edad a colocar
	 */
	public void setEdad(String edad) {
		this.edad = edad;
	}
	/**
	 * @return the exp
	 */
	public String getExp() {
		return exp;
	}
	/**
	 * @param exp exp a colocar
	 */
	public void setExp(String exp) {
		this.exp = exp;
	}
}
