package unam.fi.poo.clases;

/**
* Clase Empleado
* Esta clase contiene la información de un empleado
* @author Fernando Sánchez Escobar
* @version 1.0
*/

public class Empleado{
	//Atributos
	/**
	* Nombre del empleado
	*/
	private String nombre;
	/**
	* Apellido paterno del empleado
	*/
	private String apellidoP;
	/**
	* Apellido materno del empleado
	*/
	private String apellidoM;
	/**
	* Edad del empleado
	*/
	private int edad;
	/**
	* Usuario del empleado
	*/
	private String usuario;
	/**
	* Password del empleado
	*/
	private String password;

	//Constructores
	/**
	* Constructor por defecto, crea una instancia
	* de Empleado
	*/
	public Empleado(){
		this.nombre = "";
		this.apellidoP = "";
		this.apellidoM = "";
		this.edad = 18;
		this.usuario = "";
		this.password = "";
	}
	/**
	* Constructor con 6 parámetros
	* @param nombre nombre del empleado
	* @param apellidoP apellido paterno del empleado
	* @param apellidoM apellido materno del empleado
	* @param edad edad del empleado
	* @param usuario usuario del empleado
	* @param password password del empleado
	*/
	public Empleado(String nombre,String apellidoP,String apellidoM,int edad,String usuario,String password){
		this.nombre = nombre;
		this.apellidoP = apellidoP;
		this.apellidoM = apellidoM;
		this.edad = edad;
		this.usuario = usuario;
		this.password = password;
	}

	//Getters y setters
	/**
	* Regresa el nombre del empleado
	* @return <ul>
	* 	<li>nombre: nombre del empleado</li>
	*	</ul>
	*/
	public String getNombre(){
		return this.nombre;
	}
	/** 
	* Regresa el apellido paterno del empleado
	* @return <ul>
	* 	<li>apelidoP: apellido paterno del empleado</li>
	*	</ul>
	*/
	public String getApellidoP(){
		return this.apellidoP;
	}
	/** 
	* Regresa el apellido materno del empleado
	* @return <ul>
	* 	<li>apelidoM: apellido materno del empleado</li>
	*	</ul>
	*/
	public String getApellidoM(){
		return this.apellidoM;
	}
	/** 
	* Regresa la edad del empleado
	* @return <ul>
	* 	<li>edad: edad del empleado</li>
	*	</ul>
	*/
	public int getEdad(){
		return this.edad;
	}
	/** 
	* Regresa el usuario del empleado
	* @return <ul>
	* 	<li>usuario: usuario del empleado</li>
	*	</ul>
	*/
	public String getUsuario(){
		return this.usuario;
	}
	/** 
	* Regresa el password del empleado
	* @return <ul>
	* 	<li>password: password del empleado</li>
	*	</ul>
	*/
	public String getPassword(){
		return this.password;
	}
	/**
	* Asigna el nombre del empleado
	* @param nombre nombre del empleado
	*/
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	/**
	* Asigna el apellido paterno del empleado
	* @param apellidoP apellido paterno del empleado
	*/
	public void setApellidoP(String apellidoP){
		this.apellidoP = apellidoP;
	}
	/**
	* Asigna el apellido materno del empleado
	* @param apellidoM apellido materno del empleado
	*/
	public void setApellidoM(String apellidoM){
		this.apellidoM = apellidoM;
	}
	/**
	* Asigna la edad del empleado
	* @param edad edad del empleado
	*/
	public void setEdad(int edad){
		this.edad = edad;
	}
	/**
	* Asigna el usuario del empleado
	* @param usuario usuario del empleado
	*/
	public void setUsuario(String usuario){
		this.usuario = usuario;
	}
	/**
	* Asigna el password del empleado
	* @param password password del empleado
	*/
	public void setPassword(String password){
		this.password = password;
	}	
}