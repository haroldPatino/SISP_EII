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
import javax.faces.event.ActionEvent;
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
	public boolean isLogeado() {
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
	public void login(ActionEvent actionEvent){
		RequestContext context=RequestContext.getCurrentInstance();
		FacesMessage msg=null;
		if(nickname!=null && password!=null){
			if(buscarUsuario(nickname)!=null){
				Usuario user=buscarUsuario(nickname);
				if(user.getPassword().equals(password)){
					logeado=true;
					msg=new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@ ", user.getNickname());
				}
				else{
					msg=new FacesMessage(FacesMessage.SEVERITY_ERROR, "La contraseña es incorrecta","Credenciales Invalidas");
				}
			}
			else{
				msg=new FacesMessage(FacesMessage.SEVERITY_INFO, "EL usuario no existe ","Credenciales Invalidas");
			}
		}
		else{
			msg=new FacesMessage(FacesMessage.SEVERITY_INFO, "El nickname o el password estan vacios"+"/n"+"intente de nuevo","Campos Vacios");
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
		context.addCallbackParam("EstaLogeado", logeado);
		if(logeado){
			context.addCallbackParam("View", "menuprincipal.html");
		}
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
