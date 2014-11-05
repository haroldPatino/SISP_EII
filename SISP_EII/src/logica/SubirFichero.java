/**
 * 
 */
package logica;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.model.UploadedFile;

/**
 * @author Harold Patiño
 *
 */
public class SubirFichero implements Serializable{
//Attributes----------------------------------
	private static final long serialVersionUID = 4352236420460919694L;
	private String destination="C:\\tmpSisp\\";
    private UploadedFile file;
//Building------------------------------------
	public SubirFichero(){
		
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
	public void upload(){
		FacesMessage msg = new FacesMessage("Ok", "Fichero " + file.getFileName() + " subido correctamente.");
    	FacesContext.getCurrentInstance().addMessage(null, msg);
	}
}
