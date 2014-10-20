/**
 * 
 */
package logica;

import java.util.ArrayList;

import persitencia.UsuarioDao;

/**
 * @author Harold Patiño
 *
 */
public class GestionUsuarios {
//Attributes--------------------------------
	private ArrayList<Usuario> usuarios;
	private UsuarioDao dao;
//Building----------------------------------
	public GestionUsuarios(){
		usuarios=new ArrayList<Usuario>();
		dao=new UsuarioDao();
	}
//Methods-----------------------------------
	/**
	 * Metodo para cargar los usuarios de la BD al arreglo de usuarios
	 */
	public void setUsuarios(){
		usuarios=dao.cargarUsuarios();
	}
	/**
	 * Metodo para consultar los usuarios
	 * @return
	 */
	public ArrayList<Usuario> getUsuarios(){
		return (ArrayList<Usuario>) usuarios.clone();
	}
}
