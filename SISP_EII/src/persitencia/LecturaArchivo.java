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
import java.util.StringTokenizer;

import logica.ExpLaboral;
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
		ArrayList<Persona> personas=new ArrayList<Persona>();
		String linea=br.readLine();
		while(linea!=null){
			Persona persona=new Persona();
			StringTokenizer cadena=new StringTokenizer(linea,";");
			while(cadena.hasMoreTokens()){
				persona.setNombres(cadena.nextToken());
				persona.setApellidos(cadena.nextToken());
				persona.setTipoDocumento(cadena.nextToken());
				persona.setNumeroDocumento(Long.parseLong(cadena.nextToken()));
				persona.setFechaNacimiento(cadena.nextToken());
				persona.setSexo(cadena.nextToken().charAt(0));
				persona.setTelefono(Long.parseLong(cadena.nextToken()));
				persona.setCorreo(cadena.nextToken());
				persona.setPregrado(cadena.nextToken());
				persona.setPostgrado(cadena.nextToken());
				int numeroExpLaborales=(cadena.countTokens()-10)/2;
				ArrayList<ExpLaboral> experiencias=new ArrayList<ExpLaboral>();
				for(int i=0;i<numeroExpLaborales;i++){
					ExpLaboral exp=new ExpLaboral();
					exp.setFechaInicio(cadena.nextToken());
					exp.setFechaFin(cadena.nextToken());
					experiencias.add(exp);
				}
				personas.add(persona);
			}
		}
		
	}
	/**
	 * @return the personasArchivo
	 */
	public ArrayList<Persona> getPersonasArchivo() {
		return personasArchivo;
	}	
}
