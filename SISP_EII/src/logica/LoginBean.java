/**
 * 
 */
package logica;

/**
 * @author Harold Patiño
 *
 */
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionListener;
import javax.servlet.http.HttpSession;

import org.primefaces.context.RequestContext;

public class LoginBean implements Serializable {
//Attributes-----------------------------------------------------------
	private static final long serialVersionUID = -2152389656664659476L;
	private String nickname;
	private String password;
	private boolean logeado = false;
	private GestionUsuarios gestionUsuarios;
//Building-------------------------------------------------------------
	public LoginBean(){
		gestionUsuarios=new GestionUsuarios();
		gestionUsuarios.setUsuarios();
	}
//Methods--------------------------------------------------------------
	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	/**
	 * @param nickname nickname a colocar
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password password a colocar
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * @return the logeado
	 */
	public boolean estaLogeado() {
		return logeado;
	}
	/**
	 * @return the gestionUsuarios
	 */
	public GestionUsuarios getGestionUsuarios() {
		return gestionUsuarios;
	}
	/**
	 * Este metodo permite validar los datos de inicio de sesion para el acceso a las funciones del menu principal
	 * @param actionEvent
	 */
	 public void login(ActionListener actionListener) {
		    RequestContext context = RequestContext.getCurrentInstance();
		    FacesMessage msg = null;
		    //ACTUALIZAR EL CODIGO
		    if (nickname != null && nickname.equals("admin") && password != null
		        && password.equals("admin")) {
		      logeado = true;
		      msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", nickname);
		    } else {
		      logeado = false;
		      msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Login Error",
		                             "Credenciales no válidas");
		    }

		    FacesContext.getCurrentInstance().addMessage(null, msg);
		    context.addCallbackParam("estaLogeado", logeado);
		    if (logeado)
		      context.addCallbackParam("view", "menuprincipal.html");
		  }
	/**
	 * 
	 * @param nickname
	 * @return
	 */
	public Usuario buscarUsuario(String nickname){
		for(int i=0;i<gestionUsuarios.getUsuarios().size();i++){
			Usuario user=gestionUsuarios.getUsuarios().get(i);
			if(user.getNickname().equals(nickname)){
				return user;
			}
		}
		return null;
	}
	/**
	 * Este metodo permite el cierre de sesion para cuestiones de seguridad
	 */
	public void logout(){
		HttpSession session= (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		session.invalidate();
		logeado=false;
		
	}
}
