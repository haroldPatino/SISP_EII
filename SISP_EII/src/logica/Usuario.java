/**
 * 
 */
package logica;

/**
 * @author Harold Patiño
 *
 */
public class Usuario {
//Attributes--------------------------
	private String nickname;
	private String password;
//Building----------------------------
	/**
	 * 
	 */
	public Usuario(){
		
	}
//Methods----------------------------
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
}
