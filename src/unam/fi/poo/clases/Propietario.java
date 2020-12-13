package unam.fi.poo.clases;

/**
* Clase Propietario
* Esta clase contiene la informacion de un propietario
* @author Fernando Sánchez Escobar
* @version 1.0
*/

public class Propietario{
	//Atributos
	/**
	* Nombre del propietario
	*/
	private String nombre;
	/**
	* Apellido paterno del propietario
	*/
	private String apellidoP;
	/**
	* Apellido materno del propietario
	*/
	private String apellidoM;
	/**
	* Edad del propietario
	*/
	private int edad;

	//Constructores
	/**
	* Constructor por defecto, crea una instancia de
	* propietario 
	*/
	public Propietario(){
		this.nombre = new String();
		this.apellidoP = new String();
		this.apellidoM = new String();
		this.edad = 18;
	}
	/**
	* Constructor con 4 parámetros
	* @param nombre nombre del propietario
	* @param apellidoP apellido paterno del propietario
	* @param apellidoM apellido materno del propietario
	* @param age edad del propietario
	*/
	public Propietario(String nombre,String apellidoP,String apellidoM,String age){
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.edad = Integer.parseInt(age);
	}

	//Getters y setters 
	/**
	* Regresa el nombre del propietario
	* @return <ul>
	* 	<li>nombre: nombre del propietario</li>
	*	</ul>
	*/
	public String getNombre(){
		return this.nombre;
	}
	/** 
	* Regresa el apellido paterno del propietario
	* @return <ul>
	* 	<li>apelidoP: apellido paterno del propietario</li>
	*	</ul>
	*/
	public String getApellidoP(){
		return this.apellidoP;
	}
	/** 
	* Regresa el apellido materno del propietario
	* @return <ul>
	* 	<li>apelidoM: apellido materno del propietario</li>
	*	</ul>
	*/
	public String getApellidoM(){
		return this.apellidoM;
	}
	/** 
	* Regresa la edad del propietario
	* @return <ul>
	* 	<li>edad: edad del propietario</li>
	*	</ul>
	*/
	public int getEdad(){
		return this.edad;
	}
	/**
	* Asigna el nombre del propietario
	* @param nombre nombre del propietario
	*/
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	/**
	* Asigna el apellido paterno del propietario
	* @param apellidoP apellido paterno del propietario
	*/
	public void setApellidoP(String apellidoP){
		this.apellidoP = apellidoP;
	}
	/**
	* Asigna el apellido materno del propietario
	* @param apellidoM apellido materno del propietario
	*/
	public void setApellidoM(String apellidoM){
		this.apellidoM = apellidoM;
	}
	/**
	* Asigna la edad del propietario
	* @param edad edad del propietario
	*/
	public void setEdad(int edad){
		this.edad = edad;
	}

	//Sobreescritura de toString
	/**
	* Regresa una cadena de texto con la información del propietario
	* @return <ul>
	*	<li>String: cadena de texto con la información del propietario</li>
	*	</ul> 
	*/
	public String toString(){
		return nombre+","+apellidoP+","+apellidoM+","+edad;
	}
}