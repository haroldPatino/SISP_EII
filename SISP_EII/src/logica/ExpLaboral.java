/**
 * 
 */
package logica;


/**
 * @author Harold Patiño
 *
 */
public class ExpLaboral {
//Attributes-------------------------------------
	private String fechaInicio;
	private String fechaFin;
//Building---------------------------------------
	public ExpLaboral(){
		
	}
//Methods----------------------------------------
	/**
	 * @return the fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio fechaInicio a colocar
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin fechaFin a colocar
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
}
