/**
 * 
 */
package logica;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * @author Harold Patiño
 *
 */
public class Persona {
//Attributes------------------------------
	private String idPersona;
	private String nombres;
	private String apellidos;
	private String fechaNacimiento;
	private long telefono;
	private String direccion;
	private String correo;
	private long numeroDocumento;
	private String tipoDocumento;
	private char sexo;
	private String pregrado;
	private String postgrado;
	private ArrayList<ExpLaboral> experiencias;
//Building--------------------------------
	public Persona(){
		experiencias=new ArrayList<ExpLaboral>();
	}
//Methods---------------------------------
	/**
	 * @return the idPersona
	 */
	public String getIdPersona() {
		return idPersona;
	}
	/**
	 * @param idPersona idPersona a colocar
	 */
	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
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
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	/**
	 * @param fechaNacimiento fechaNacimiento a colocar
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	/**
	 * @return the telefono
	 */
	public long getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono telefono a colocar
	 */
	public void setTelefono(long telefono) {
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
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * @param correo correo a colocar
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * @return the numeroDocumento
	 */
	public long getNumeroDocumento() {
		return numeroDocumento;
	}
	/**
	 * @param numeroDocumento numeroDocumento a colocar
	 */
	public void setNumeroDocumento(long numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	/**
	 * @param tipoDocumento tipoDocumento a colocar
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	/**
	 * @return the sexo
	 */
	public char getSexo() {
		return sexo;
	}
	/**
	 * @param sexo sexo a colocar
	 */
	public void setSexo(char sexo) {
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
	 * @return the experiencias
	 */
	public ArrayList<ExpLaboral> getExperiencias() {
		return experiencias;
	}
	/**
	 * @param experiencias experiencias a colocar
	 */
	public void setExperiencias(ArrayList<ExpLaboral> experiencias) {
		this.experiencias = experiencias;
	}	
}
