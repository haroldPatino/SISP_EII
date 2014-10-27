/**
 * 
 */
package persitencia;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import logica.Usuario;

/**
 * @author Harold Patiño
 *
 */
public class UsuarioDao {
//Attributes-----------------------------
	private UsuarioSql sql;
	private static ConexionBD conexion;
//Building-------------------------------
	public UsuarioDao(){
		sql=new UsuarioSql();
		conexion=new ConexionBD();
	}
//Methods--------------------------------
	/**
	 * Metodo para cargar los usuarios de la Base de Datos
	 * @return
	 */
	public ArrayList<Usuario> cargarUsuarios(){
		ResultSet result;
		ArrayList<Usuario> usuarios=new ArrayList<Usuario>();
		if(conexion.conectar()){
			try{
				Statement sentence=conexion.getConexion().createStatement();
				result=sentence.executeQuery(sql.selectUsuarios());
				while(result.next()){
					Usuario user=new Usuario();
					user.setNickname(result.getString("NICK_USUARIO"));
					user.setPassword(result.getString("PASSWORD"));
					usuarios.add(user);
				}
			}catch (SQLException e){
				e.printStackTrace();
			}
		}
		return usuarios;
	}
}
