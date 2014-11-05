/**
 * 
 */
package logica;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

import persitencia.LecturaArchivo;
import persitencia.PersonaDao;

/**
 * @author Harold Patiño
 *
 */
public class SubirFichero implements Serializable{
//Attributes----------------------------------
	private static final long serialVersionUID = 4352236420460919694L;
	private String destination="C:\\Users\\Lenovo Pc\\git\\SISP_EII\\SISP_EII\\presentacion\\recursos\\";
    private UploadedFile file;
    private PersonaDao dao;
//Building------------------------------------
	public SubirFichero(){
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
	public void transferirArchivo(String fileName,InputStream in){
		try{
			OutputStream out= new FileOutputStream(new File(destination+file.getFileName()));
			
			System.out.println(out);
			int reader=0;
			byte[] bytes=new byte[(int) getFile().getSize()];
			while((reader=in.read(bytes))!=-1){
				out.write(bytes,0,reader);
			}
			in.close();
			out.flush();
			out.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	public void upload(){
		String extension;
		if(getFile()!=null){
			String ext=getFile().getFileName();
			extension=ext.substring(ext.indexOf(".")+1);
			if(extension.equals("csv")){
				try{
					transferirArchivo(getFile().getFileName(), getFile().getInputstream());
					LecturaArchivo lect=new LecturaArchivo();
					lect.leerFichero(destination+getFile().getFileName());
					dao.insertarPersonas(lect.getPersonasArchivo());
					FacesMessage msg = new FacesMessage("Ok", "El Fichero " + file.getFileName() + " fue subido correctamente.");
			    	FacesContext.getCurrentInstance().addMessage(null, msg);
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
	 * @return the destination
	 */
	public String getDestination() {
		return destination;
	}
	/**
	 * @return the dao
	 */
	public PersonaDao getDao() {
		return dao;
	}
}
