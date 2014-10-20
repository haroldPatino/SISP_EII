/**
 * 
 */
package persitencia;

import java.sql.Statement;
import java.util.ArrayList;

import logica.Usuario;

import com.mysql.jdbc.ResultSet;

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
