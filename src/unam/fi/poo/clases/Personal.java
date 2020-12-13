package unam.fi.poo.clases;

import java.util.ArrayList;

/**
* Clase Personal
* Esta clase contiene a los empleados que pueden hacer uso 
* del sistema
* @see unam.fi.poo.clases.Empleado
* @author Fernando Sánchez Escobar
* @version 1.0
*/

public class Personal{
	//Atributos
	/**
	* Empleados registrados
	*/
	private ArrayList<Empleado> empleados;
	/**
	* Instancia de si misma (singleton)
	*/
	private static Personal instancia;

	//Constructor
	/**
	* Constructor por defecto
	* crea una instancia de Personal
	*/
	private Personal(){
		this.empleados = new ArrayList<Empleado>();
	}

	//Getters y setters
	/**
	* Regresa la colección de empleados
	* @return <ul> 
	* 	<li>empleados: empleados registrados</li>
	*	</ul>
	*/
	public ArrayList<Empleado> getEmpleados(){
		return this.empleados;
	}
	/**
	* Regresa la instancia de Personal
	* @return <ul> 
	* 	<li>personal: instancia de si misma</li>
	*	</ul>
	*/
	public static Personal getInstance(){
		if(instancia == null){
			instancia = new Personal();
		}
		return instancia;
	}
	/**
	* Asigna a los empleados
	* @param empleados empleados registrados
	*/
	public void setEmpleados(ArrayList<Empleado> empleados){
		this.empleados = empleados;
	}
	/**
	* Agrega un empleado 
	* @param empleado empleado nuevo
	*/
	public void agregarEmpleado(Empleado empleado){
		this.empleados.add(empleado);
	}
}