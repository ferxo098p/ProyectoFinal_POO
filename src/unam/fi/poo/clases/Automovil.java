package unam.fi.poo.clases;

/**
* Clase Automovil
* Esta clase contiene la información de un automovil
* @author Fernando Sánchez Escobar
* @version 1.0
*/

public class Automovil extends Vehiculo{
	//Atributo
	/**
	* Propietario del automovil
	*/
	private Propietario propietario;

	//Constructores
	/**
	* Constructor por defecto, crea un automovil
	* inicializando su propietario
	* @see unam.fi.poo.clases.Propietario
	*/
	public Automovil(){
		this.propietario = new Propietario();
	}
	/**
	* Constructor con un parametro, crea un automovil
	* @param propietario propietario del automovil
	* @see unam.fi.poo.clases.Propietario
	*/
	public Automovil(Propietario propietario){
		this.propietario = propietario;
	}

	//Getters y setters
	/**
	* Regresa el propietario del automovil
	* @return <ul>
	* 	<li>propietario: propietario del automovil </li>
	*	</ul>
	*/
	public Propietario getPropietario(){
		return this.propietario;
	}
	/**
	* Asigna el propietario del automovil
	* @param propietario propietario del automovil
	* @see unam.fi.poo.clases.Propietario
	*/
	public void setPropietario(Propietario propietario){
		this.propietario = propietario;
	}

	//Metodos
	/**
	* Implementación del método abstracto de vehiculo
	* @param tiempo tiempo de estancia del automovil
	* @see unam.fi.poo.clases.Vehiculo 
	*/
	public void calcularTarifa(int tiempo){
		int tarifa;
		tarifa = tiempo * getCapacidad();
		setTarifa(tarifa);
	}

	//Sobreescritura de toString
	/**
	* Regresa una cadena de texto con la infomación del automovil
	* @see unam.fi.poo.clases.Vehiculo
	* @see unam.fi.poo.clases.Propietario
	* @return <ul>
	*	<li>String cadena de texto con la información del automovil </li>
	*	</ul>
	*/
	public String toString(){
		return super.toString()+","+propietario.toString();
	}
}