/**
 * 
 */
package logica;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import persitencia.ConexionBD;

/**
 * @author Harold Pati�o
 *
 */
public class ManejoSeleccion implements Serializable{
//Attributes-------------------------------------------------
	private static final long serialVersionUID = -1213456789L;
	private String edadInit;
	private String edadEnd;
	private String pregrado;
	private String postgrado;
	private String sexo;
	private String expMin;
	private String expMax;
	private boolean redirigir=false;
	private ConexionBD conexion;
	private static List<Seleccion> consulta;
//Methods----------------------------------------------------
	
	/**
	 * @param redirigir redirigir a colocar
	 */
	public void setRedirigir(boolean redirigir) {
		this.redirigir = redirigir;
	}

	/**
	 * @return the redirigir
	 */
	public boolean esRedirigido() {
		return redirigir;
	}

	/**
	 * @return the edadInit
	 */
	public String getEdadInit() {
		return edadInit;
	}
	/**
	 * @param edadInit edadInit a colocar
	 */
	public void setEdadInit(String edadInit) {
		this.edadInit = edadInit.toUpperCase();
	}
	/**
	 * @return the edadEnd
	 */
	public String getEdadEnd() {
		return edadEnd;
	}
	/**
	 * @param edadEnd edadEnd a colocar
	 */
	public void setEdadEnd(String edadEnd) {
		this.edadEnd = edadEnd.toUpperCase();
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
		this.pregrado = pregrado.toUpperCase();
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
		this.sexo = sexo.toUpperCase();
	}
	/**
	 * @return the expMin
	 */
	public String getExpMin() {
		return expMin;
	}
	/**
	 * @param expMin expMin a colocar
	 */
	public void setExpMin(String expMin) {
		this.expMin = expMin.toUpperCase();
	}
	/**
	 * @return the expMax
	 */
	public String getExpMax() {
		return expMax;
	}
	/**
	 * @param expMax expMax a colocar
	 */
	public void setExpMax(String expMax) {
		this.expMax = expMax.toUpperCase();
	}
	/**
	 * @return the consulta
	 */
	public List<Seleccion> getConsulta() {
		return consulta;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the conexion
	 */
	public ConexionBD getConexion() {
		return conexion;
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
		this.postgrado = postgrado.toUpperCase();
	}
	public void filtros(ActionEvent actionEvent){
	    FacesMessage msg = null;
	    RequestContext context = RequestContext.getCurrentInstance();
	    conexion=new ConexionBD();
	    consulta=new ArrayList<Seleccion>();
		String select="SELECT P.*,round((DATEDIFF(NOW(),P.FECHA_NACIMIENTO)/30)/12) as EDAD,SUM(round((DATEDIFF(E.FECHA_FIN,E.FECHA_INICIO)/30))) as EXP_TOTAL FROM PERSONA AS P, EXP_LAB AS E WHERE P.ID_PERSONA=E.ID_PERSONA";
		if(edadInit!="" && edadEnd!="" && edadInit!=null && edadEnd!=null){
			select=select+sqlEdad(getEdadInit(), getEdadEnd());
		}
		if(pregrado!="" && pregrado!=null){
			select=select+sqlPregrado(getPregrado());
		}
		if(postgrado!="" && postgrado!=null){
			select=select+sqlPostgrado(getPostgrado());
		}
		if(sexo!="" && sexo!=null){
			select=select+sqlSexo(getSexo());
		}
		
		select=select+" group by P.ID_PERSONA";
		
		if(expMin!="" && expMax!="" && expMin!=null && expMax!=null) {
			select=select+sqlExperiencia(expMin,expMax);
		}
		System.out.println(select);
		if(getConexion().conectar()){
			ResultSet result;
			try{
				Statement sentence=conexion.getConexion().createStatement();
				result=sentence.executeQuery(select);
				while(result.next()){
					String id=result.getString("ID_PERSONA");
					String nombres=result.getString("NOMBRES");
					String apellidos=result.getString("APELLIDOS");
					String fecha_nacimiento=result.getString("FECHA_NACIMIENTO");
					String telefono=result.getString("TELEFONO");
					String direccion=result.getString("DIRECCION");
					String email=result.getString("CORREO");
					String documento=result.getString("NUMERO_DOCUMENTO");
					String tipoDoc=result.getString("TIPO_DOCUMENTO");
					String sexo=result.getString("SEXO");
					String pregrado=result.getString("PREGRADO");
					String postgrado=result.getString("POSTGRADO");
					String edad=result.getString("EDAD");
					String exp=result.getString("EXP_TOTAL");
					Seleccion seleccionado=new Seleccion(id, nombres, apellidos, fecha_nacimiento, telefono, direccion, email, documento, tipoDoc, sexo, pregrado, postgrado, edad, exp);
					consulta.add(seleccionado);
				}
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		}
		if(((edadInit=="" && edadEnd=="") || (edadInit==null && edadEnd==null)) && (pregrado=="" || pregrado==null) && (postgrado=="" || postgrado==null) && (sexo=="" || sexo==null) && ((expMin=="" && expMax=="") || (expMin==null && expMax==null))){
			redirigir=false;
			context.addCallbackParam("esRedirigido", redirigir);
			msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "CONSULTA DE DATOS", "No se puede generar el filtro, porque no se han a�adido criterios");
			consulta=new ArrayList<Seleccion>();
		}
		else{
			if (consulta.size()>0) {
				redirigir=true;
			    context.addCallbackParam("esRedirigido", redirigir);
			    context.addCallbackParam("view2", "resultadofiltro.xhtml");
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "CONSULTA DE DATOS", "En breve se mostraran los resultados");
			}
			else{
				redirigir=false;
				context.addCallbackParam("esRedirigido", redirigir);
				msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "CONSULTA DE DATOS", "No existen resultados con los filtros seleccionados");
			}
		}
		
		
		 FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	private String sqlPregrado(String pregrado){
		return " AND `PREGRADO` LIKE '%"+pregrado+"%'";
	}
	private String sqlPostgrado(String postgrado){
		return " AND `POSTGRADO` LIKE '%"+postgrado+"%'";
	}
	private String sqlEdad(String edadmin,String edadmax){
		return " AND round((DATEDIFF(NOW(),FECHA_NACIMIENTO)/30)/12) BETWEEN "+edadmin+" AND "+edadmax;
	}
	private String sqlSexo(String sexo){
		return " AND `SEXO` LIKE '"+sexo+"'";
	}
	private String sqlExperiencia(String mesesMin,String mesesMax){
		return " having SUM(round((DATEDIFF(E.FECHA_FIN,E.FECHA_INICIO)/30))) BETWEEN "+mesesMin+" AND "+mesesMax;
	}
}
