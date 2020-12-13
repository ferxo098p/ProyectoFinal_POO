package unam.fi.poo.clases;

import java.io.*;

/**
* Clase Consultor
* Esta clase informa de los empleados registrados para
* hacer uso del sistema
* @author Fernando Sánchez Escobar
* @version 1.0
*/

public class Consultor{
	//Atributo
	/**
	* Representa a los empleados registrados
	* @see unam.fi.poo.clases.Personal
	*/
	private Personal personal;

	//Constructor
	/**
	* Constructor por defecto
	* crea una instancia de Consultor inicializando
	* su atributo Personal
	*/
	public Consultor(){
		this.personal = Personal.getInstance();
	}

	//Get
	/**
	* Regresa el personal
	* @return <ul>
	*	<li>Personal: personal registrado </li>
	*	</ul>
	*/
	public Personal getPersonal(){
		return this.personal;
	}

	//Metodo
	/**
	* Lee el contenido del archivo .txt donde estan
	* registrados los empleados
	* @see unam.fi.poo.clases.Lector
	*/
	public void consultarPersonal(){
		Lector reader = new Lector("./archivos/empleados.txt");
		Personal personal = this.personal;

		try{
			reader.leer("./archivos/empleados.txt",personal);
		}catch(IOException e){}
	}
}