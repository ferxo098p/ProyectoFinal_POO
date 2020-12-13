package unam.fi.poo.clases;

import java.io.*;
import java.util.StringTokenizer;

/**
* Clase Lector
* Esta clase lee el contenido del archivo .txt
* donde estan registrados los empleado para el uso del sistema
* @author Fernando Sánchez Escobar
* @version 1.0
*/

public class Lector{
	/**
	* Archivo .txt de empleados
	*/
	private File archivo;

	//Constructor
	/**
	* Constructor con un parametro, crea una instancia de Lector
	* @param ruta ruta en donde se encuentra el archivo .txt
	*/
	public Lector(String ruta){
		this.archivo = new File(ruta);
		this.verificarExistenciaArchivo(archivo);
	}
	/**
	* Verifica que el archivo .txt exista en la ruta especificada,
	* de no ser así lo crea
	* @param archivo archivo a verificar
	*/
	public void verificarExistenciaArchivo(File archivo){
		if(!archivo.exists()){
			try{
				archivo.createNewFile();
			}catch(IOException ex){

			}
		}
	}
	/**
	* Lee el contenido del archivo .txt
	* @param ruta ruta en donde se encuentra el archivo .txt
	* @param personal personal de empleados
	* @see unam.fi.poo.clases.Personal
	* @throws IOException lanza le excepción
	*/
	public void leer(String ruta,Personal personal) throws IOException{
		int contador = 0;
		FileReader fr = new FileReader(ruta);
		BufferedReader bfr = new BufferedReader(fr);
		String chain = bfr.readLine();
		String cadena;
		StringTokenizer reader;
		Empleado empleado = new Empleado();
		while(chain!=null){
			reader = new StringTokenizer(chain,",");
			while(reader.hasMoreTokens()){
				contador = contador + 1;
				cadena = reader.nextToken();
				this.asignarInfo(empleado,contador,cadena);
			}
			personal.agregarEmpleado(empleado);
			chain = bfr.readLine();
			contador = 0;
			empleado = new Empleado();
		}
		fr.close();
	}
	/**
	* Asigna la información a un empleado ontenida del archivo .txt
	* @see unam.fi.poo.clases.Empleado
	* @param empleado empleado a asiganar la información
	* @param contador servira para decidir que atributo del empleado se asignara
	* @param cadena informacion a asiganar  
	*/
	public void asignarInfo(Empleado empleado,int contador,String cadena){
		switch(contador){
			//Asigna el nombre
			case 1:
				empleado.setNombre(cadena);
				break;
			//Asigna el apellido paterno
			case 2:
				empleado.setApellidoP(cadena);
				break;
			//Asigna el apellido materno
			case 3:
				empleado.setApellidoM(cadena);
				break;
			//Asigna la edad
			case 4:
				int edad = Integer.parseInt(cadena);
				empleado.setEdad(edad);
				break;
			//Asigna el usuario
			case 5:
				empleado.setUsuario(cadena);
				break;
			//Asigna el password
			case 6:
				empleado.setPassword(cadena);
				break;
		}
	}
}