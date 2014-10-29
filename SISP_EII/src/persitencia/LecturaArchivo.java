/**
 * 
 */
package persitencia;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import logica.Persona;

/**
 * @author Harold Patiño
 *
 */
public class LecturaArchivo {
//Attributes-----------------------------------
	private ArrayList<Persona> personasArchivo;
//Building-------------------------------------
	public LecturaArchivo(){
		personasArchivo=new ArrayList<Persona>();
	}
//Methods--------------------------------------
	public void leerFichero(String rutaFichero) throws IOException{
		FileInputStream fis=new FileInputStream(rutaFichero);
		InputStreamReader isr=new InputStreamReader(fis,"ISO-8859-1");
		BufferedReader br= new BufferedReader(isr);
		
		String linea=br.readLine();
		while(linea!=null){
			
		}
		
	}
	
}
