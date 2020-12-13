package unam.fi.poo.clases;

import java.io.*;

/**
* Clase Escritor
* Esta clase escribe en un archivo .txt
* @author Fernando Sánchez Escobar
* @version 1.0
*/

public class Escritor{
	/**
	* Constructor con un parámetro crea una instancia de Escritor
	* @param ruta ruta en donde se encuentra el archivo .txt 
	*/
	public Escritor(String ruta){
		this.verificarExistenciaArchivo(ruta);
	}
	/**
	* Verifica que el archivo .txt exista, en caso de no existir lo crea
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
	* Escribe el contenido especificado en el archivo .txt
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
		}catch(IOException exp){}
	}
}