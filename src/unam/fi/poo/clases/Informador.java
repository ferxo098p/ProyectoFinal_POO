package unam.fi.poo.clases;

/**
* Clase Informaddor
* Esta clase informa sobre el estado del estacionamiento
* @see unam.fi.poo.clases.Estacionamiento
* @author Fernando Sánchez Escobar
* @version 1.0
*/

public class Informador{
	//Atributos
	/**
	* Estacionamiento del sistema
	* @see unam.fi.poo.clases.Estacionamiento 
	*/
	private Estacionamiento estacionamiento;

	//Constructor
	/**
	* Constructor por defecto
	* crea un Informador
	* @see unam.fi.poo.clases.Estacionamiento
	*/
	public Informador(){
		this.estacionamiento = Estacionamiento.getInstance();
	}

	//Get y sets
	/**
	* Regresa el estacionamiento
	* @return <ul>
	*	<li>estacionamiento: estacionamiento del sistema </li>
	* </ul>
	* @see unam.fi.poo.clases.Estacionamiento
	*/
	public Estacionamiento getEstacionamiento(){
		return this.estacionamiento;
	}
	/**
	* Asigna el estacionamiento del sistema
	* @param estacionamiento estacionamiento del sistema
	* @see unam.fi.poo.clases.Estacionamiento
	*/
	public void setEstacionamiento(Estacionamiento estacionamiento){
		this.estacionamiento = estacionamiento;
	}	
}