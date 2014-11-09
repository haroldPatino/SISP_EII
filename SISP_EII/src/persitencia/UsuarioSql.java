/**
 * 
 */
package persitencia;


/**
 * @author Harold Patiño
 *
 */
public class UsuarioSql {
//Attributes----------------------------

//Building------------------------------
	/**
	 * 
	 */
	public UsuarioSql(){
		
	}
//Methods-------------------------------
	/**
	 * 
	 * @return
	 */
	public String selectUsuarios(){
		return "SELECT * FROM usuarios";
	}
}
