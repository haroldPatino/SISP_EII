/**
 * 
 */
package persitencia;


/**
 * @author Harold Pati�o
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
