import logica.GestionUsuarios;

/**
 * 
 */

/**
 * @author Lenovo Pc
 *
 */
public class Prueba {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GestionUsuarios gestion=new GestionUsuarios();
		gestion.setUsuarios();
		System.out.println(gestion.getUsuarios().get(0).getNickname());
	}

}
