package unam.fi.poo.clases;

import java.io.*;
import java.util.StringTokenizer;
import javax.swing.table.DefaultTableModel;
import java.util.Vector;

/**
* Clase Leyente
* Esta clase lee y actualiza el contenido del archivo .txt
* donde estan registrados los automoviles
* @author Fernando Sánchez Escobar
* @version 1.0
*/

public class Leyente{
	//Constructor
	/**
	* Constructor con un parametro, crea una instancia de Leyente
	* @param ruta ruta en donde se encuentra el archivo .txt
	*/
	public Leyente(String ruta){
		this.verificarExistenciaArchivo(ruta);
	}
	/**
	* Verifica que el archivo .txt exista en la ruta especificada,
	* de no ser así lo crea
	* @param ruta ruta en donde se encuentra el archivo .txt
	*/
	public void verificarExistenciaArchivo(String ruta){
		File archivo = new File(ruta);
		if(!archivo.exists()){
			try{
				archivo.createNewFile();
			}catch(IOException ex){

			}
		}
	}
	/**
	* Lee el contenido del archivo .txt y modifica el modelo de una JTable
	* @param ruta ruta en donde se encuentra el archivo .txt
	* @param modelo modelo de la JTable
	* @throws IOException lanza la excepción
	*/
	public void leer(String ruta,DefaultTableModel modelo) throws IOException{
		FileReader fr = new FileReader(ruta);
		BufferedReader bfr = new BufferedReader(fr);
		String chain = bfr.readLine();
		StringTokenizer reader;
		while(chain!=null){
			reader = new StringTokenizer(chain,",");
			Vector<String> informacion = new Vector<String>();
			while(reader.hasMoreTokens()){
				informacion.addElement(reader.nextToken());
			}
			modelo.addRow(informacion);
			chain = bfr.readLine();
		}
		fr.close();
	}
	/**
	* Machaca el contenido del archivo .txt
	* @param ruta ruta en donde se encuentra el archivo .txt
	*/
	public void vaciarArchivo(String ruta){
		try{
			FileWriter fw = new FileWriter(ruta);
			BufferedWriter bw = new BufferedWriter(fw);
			//Con esto eliminamos todo el contenido del archivo .txt
			bw.write("");
			bw.close();
		}catch(IOException ioe){}
	}
	/**
	* Escribe contenido en un archivo .txt
	* @param ruta ruta en donde se encuentra el archivo .txt
	* @param texto texto a escribir en el archivo .txt
	*/
	public void escribirEnArchivo(String ruta,String texto){
		try{
			File archivo = new File(ruta);
			//Nos ayudara a escribir, conservando el contenido previo del archivo
			FileWriter wr = new FileWriter(archivo, true);
			//Nos ayudara a escribir dando saltos de linea
			PrintWriter pwtr = new PrintWriter(wr);
			pwtr.println(texto);
			wr.close();
		}catch(IOException ep){}
	}
}