/**
 * 
 */
package logica;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import persitencia.PersonaDao;

/**
 * @author Harold Patiño
 *
 */
public class SubirFichero implements Serializable{
//Attributes----------------------------------
	private static final long serialVersionUID = 4352236420460919694L;
    private UploadedFile file;
    private PersonaDao dao;
    private ArrayList<Persona> aspirantes;
    private int countLinea=1;
//Building------------------------------------
	public SubirFichero(){
		aspirantes=new ArrayList<Persona>();
		dao=new PersonaDao();
	}
//Methods-------------------------------------
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the file
	 */
	public UploadedFile getFile() {
		return file;
	}
	/**
	 * @param file file a colocar
	 */
	public void setFile(UploadedFile file) {
		this.file = file;
	}
	private String formatoFecha(String fecha){
		String fechaFinal = null;
		StringTokenizer cadenaFecha=new StringTokenizer(fecha, "/");
		while(cadenaFecha.hasMoreTokens()){
			String dia=cadenaFecha.nextToken();
			String mes=cadenaFecha.nextToken();
			String anio=cadenaFecha.nextToken();
			fechaFinal=anio+"-"+mes+"-"+dia;
		}
		return fechaFinal;
		
	}
	public Persona buscarPersonaNum(String numero){
		for(int i=0;i<aspirantes.size();i++){
			Persona person=aspirantes.get(i);
			if(person.getNumeroDocumento().equals(numero)){
				return person;
			}
		}
		return null;
	}
	public boolean transferirArchivo(String fileName,InputStream in){
		try{
			InputStreamReader isr=new InputStreamReader(in,"ISO-8859-1");
			BufferedReader br= new BufferedReader(isr);
			String linea=br.readLine();
			linea=br.readLine();
			while((linea=br.readLine())!=null){
				StringTokenizer cadena=new StringTokenizer(linea,";");
				while(cadena.hasMoreTokens()){
					Persona persona=new Persona();
					int numeroExpLaborales=(cadena.countTokens()-11)/2;
					persona.setNombres(cadena.nextToken().toUpperCase());
					System.out.println("----------------------------Nombres:"+persona.getNombres());
					persona.setApellidos(cadena.nextToken().toUpperCase());
					System.out.println("----------------------------Apellidos:"+persona.getApellidos());
					persona.setTipoDocumento(cadena.nextToken().toUpperCase());
					System.out.println("----------------------------Tipo Documento:"+persona.getTipoDocumento());
					persona.setNumeroDocumento(cadena.nextToken());
					System.out.println("----------------------------Numero Documento:"+persona.getNumeroDocumento());
					persona.setFechaNacimiento(formatoFecha(cadena.nextToken()));
					System.out.println("----------------------------Fecha nacimiento:"+persona.getFechaNacimiento());
					persona.setSexo(cadena.nextToken().toUpperCase().charAt(0));
					System.out.println("----------------------------Sexo:"+persona.getSexo());
					persona.setTelefono(Long.parseLong(cadena.nextToken()));
					System.out.println("----------------------------Telefono:"+persona.getTelefono());
					persona.setDireccion(cadena.nextToken());
					System.out.println("----------------------------Direccion:"+persona.getDireccion());
					persona.setCorreo(cadena.nextToken());
					System.out.println("----------------------------Correo:"+persona.getCorreo());
					persona.setPregrado(cadena.nextToken().toUpperCase());
					System.out.println("----------------------------Pregrado:"+persona.getPregrado());
					persona.setPostgrado(cadena.nextToken().toUpperCase());
					System.out.println("----------------------------Postgrado:"+persona.getPostgrado());
					System.out.println("----------------------------Experiencias:"+numeroExpLaborales);
					ArrayList<ExpLaboral> experiencias=new ArrayList<ExpLaboral>();
					for(int i=0;i<numeroExpLaborales;i++){
						ExpLaboral exp=new ExpLaboral();
						exp.setFechaInicio(formatoFecha(cadena.nextToken()));
						System.out.println("----------------------------Inicio Exp "+(i+1)+":"+exp.getFechaInicio());
						exp.setFechaFin(formatoFecha(cadena.nextToken()));
						System.out.println("----------------------------Fin Exp "+(i+1)+":"+exp.getFechaFin());
						experiencias.add(exp);
					}
					persona.setExperiencias(experiencias);
					if(persona.getNombres()!=null && persona.getApellidos()!=null && persona.getCorreo()!=null && buscarPersonaNum(persona.getNumeroDocumento())==null){
						aspirantes.add(persona);
						System.out.println("---------------------------------------------Se agrego el aspirante");
						countLinea++;
					}
					else{
						FacesMessage msg = new FacesMessage("Error", "El Fichero " + file.getFileName() + " tiene un error en la linea "+countLinea);
				    	FacesContext.getCurrentInstance().addMessage(null, msg);
						return false;
					}
				}
			}
		}catch(Exception e){
			Logger.getLogger(SubirFichero.class.getName()).log(Level.SEVERE,null,e);
			FacesMessage msg = new FacesMessage("Error", "El Fichero " + file.getFileName() + " tiene un error en la linea "+countLinea);
	    	FacesContext.getCurrentInstance().addMessage(null, msg);
	    	return false;
		}
		return true;
	}
	public void upload(){
		String extension;
		if(getFile()!=null){
			String ext=getFile().getFileName();
			extension=ext.substring(ext.indexOf(".")+1);
			if(extension.equals("csv")){
				try{
					if(transferirArchivo(getFile().getFileName(), getFile().getInputstream())){
						dao.insertarPersonas(getAspirantes());
						FacesMessage msg = new FacesMessage("Ok", "El Fichero " + file.getFileName() + " fue subido correctamente.");
				    	FacesContext.getCurrentInstance().addMessage(null, msg);
					}
				}catch(IOException e){
					Logger.getLogger(SubirFichero.class.getName()).log(Level.SEVERE,null,e);
					FacesMessage msg = new FacesMessage("Error", "El Fichero " + file.getFileName() + " no pudo ser cargado.");
			    	FacesContext.getCurrentInstance().addMessage(null, msg);
				}
				
			}
			else{
				FacesMessage msg = new FacesMessage("Error", "El Fichero " + file.getFileName() + " no posee una extension valida.");
		    	FacesContext.getCurrentInstance().addMessage(null, msg);
			}
		}
		else{
			FacesMessage msg = new FacesMessage("Error", "No hay ningun archivo seleccionado.");
	    	FacesContext.getCurrentInstance().addMessage(null, msg);
		}
	}
	/**
	 * @return the dao
	 */
	public PersonaDao getDao() {
		return dao;
	}
	/**
	 * @return the aspirantes
	 */
	public ArrayList<Persona> getAspirantes() {
		return aspirantes;
	}
}
