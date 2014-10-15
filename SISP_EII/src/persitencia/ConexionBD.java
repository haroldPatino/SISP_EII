/**
 * 
 */
package persitencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Harold Patino
 *
 */
public class ConexionBD {
//Attributes---------------------------------
	private Connection conexion;
	private final String BaseDatos = "sisp";	
	private final String DRIVER="com.mysql.jdbc.Driver";
	private final String URL="jdbc:mysql://localhost:3306/sisp";
	private final String USER="root";
	private final String PASSWORD="";
//Building----------------------------------
	public ConexionBD(){
		
	}
//Methods-----------------------------------
	/**
	 * @return the conexion
	 */
	public Connection getConexion() {
		return conexion;
	}
	/**
	 * @param conexion conexion a colocar
	 */
	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}
	/**
	 * @return the baseDatos
	 */
	public String getBaseDatos() {
		return BaseDatos;
	}
	/**
	 * @return the dRIVER
	 */
	public String getDRIVER() {
		return DRIVER;
	}
	/**
	 * @return the uRL
	 */
	public String getURL() {
		return URL;
	}
	/**
	 * @return the uSER
	 */
	public String getUSER() {
		return USER;
	}
	/**
	 * @return the pASSWORD
	 */
	public String getPASSWORD() {
		return PASSWORD;
	}
	/**
	 * 
	 * @return true si se logro conectar de manera exitosa con la BD
	 */
	public boolean conectar(){
		boolean resp=false;
		try{
			Class.forName(DRIVER).newInstance();
			conexion=DriverManager.getConnection(URL,USER,PASSWORD);
			
			if(getConexion() != null){
                resp = true;
            }else{
                System.out.println("Conexion Fallida!");                
            }
			
			
		}catch(SQLException e){
			System.out.println(e.getMessage());
		}catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (IllegalAccessException e) {
			System.out.println(e.getMessage());
		}catch (InstantiationException e) {
			System.out.println(e.getMessage());
		}
		return resp;
	}
	public void close(){
		try{
			conexion.close();
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
