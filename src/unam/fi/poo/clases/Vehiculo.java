package unam.fi.poo.clases;

/**
* Clase Abstracta Vehiculo
* Contiene la información de un vehiculo
* @author Fernando Sánchez Escobar
* @version 1.0
*/

public abstract class Vehiculo{
	//Atributos
	/**
	* Marca del vehiculo
	*/
	private String marca;
	/**
	* Modelo del vehiculo
	*/
	private String modelo;
	/**
	* Color del vehiculo
	*/
	private String color;
	/**
	* Matricula delantera del vehiculo
	*/
	private String matriculaD;
	/**
	* Matricula trasera del vehiculo 
	*/
	private String matriculaT;
	/**
	* Tarifa que tendrá el vehiculo
	*/
	private int tarifa;
	/**
	* Capacidad del vehiculo
	*/
	private int capacidad;
	/**
	* Tiempo de estabcia del vehiculo en el estacionamiento
	*/
	private int estancia;

	//Getters y setters
	/**
	* Regresa la marca del vehiculo
	* @return <ul>
	*	<li>marca: marca del vehiculo</li>
	*	</ul>
	*/
	public String getMarca(){
		return this.marca;
	}
	/**
	* Regresa el modelo del vehiculo
	* @return <ul>
	*	<li>modelo: modelo del vehiculo</li>
	*	</ul>
	*/
	public String getModelo(){
		return this.modelo;
	}
	/**
	* Regresa el color del vehiculo
	* @return <ul>
	*	<li>color: color del vehiculo</li>
	*	</ul>
	*/
	public String getColor(){
		return this.color;
	}
	/**
	* Regresa la matricula delantera del vehiculo
	* @return <ul>
	*	<li>matriculaD: matricula delantera del vehiculo</li>
	*	</ul>
	*/
	public String getMatriculaD(){
		return this.matriculaD;
	}
	/**
	* Regresa la matricula trasera del vehiculo
	* @return <ul>
	*	<li>matriculaT: matricula trasera del vehiculo</li>
	*	</ul>
	*/
	public String getMatriculaT(){
		return this.matriculaT;
	}
	/**
	* Regresa la tarifa del vehiculo
	* @return <ul>
	*	<li>tarifa: tarifa del vehiculo</li>
	*	</ul>
	*/
	public int getTarifa(){
		return this.tarifa;
	}
	/**
	* Regresa la capacidad del vehiculo
	* @return <ul>
	*	<li>capacidad: capacidad del vehiculo</li>
	*	</ul>
	*/
	public int getCapacidad(){
		return this.capacidad;
	}
	/**
	* Regresa el tiempo de estancia del vehiculo
	* @return <ul>
	*	<li>estancia: tiempo de estancia del vehiculo</li>
	*	</ul>
	*/
	public int getEstancia(){
		return this.estancia;
	}
	/**
	* Asigna la marca del vehiculo
	* @param marca marca del vehiculo
	*/
	public void setMarca(String marca){
		this.marca = marca;
	}
	/**
	* Asigna el modelo del vehiculo
	* @param modelo modelo del vehiculo
	*/
	public void setModelo(String modelo){
		this.modelo = modelo;
	}
	/**
	* Asigna el color del vehiculo
	* @param color color del vehiculo
	*/
	public void setColor(String color){
		this.color = color;
	}
	/**
	* Asigna la matricula delantera del vehiculo
	* @param matriculaD matricula delantera del vehiculo
	*/
	public void setMatriculaD(String matriculaD){
		this.matriculaD = matriculaD;
	}
	/**
	* Asigna la matricula trasera del vehiculo
	* @param matriculaT matricula trasera del vehiculo
	*/
	public void setMatriculaT(String matriculaT){
		this.matriculaT = matriculaT;
	}
	/**
	* Asigna la tarifa del vehiculo
	* @param tarifa tarifa del vehiculo
	*/
	public void setTarifa(int tarifa){
		this.tarifa = tarifa;
	}
	/**
	* Asigna la capacidad del vehiculo
	* @param capacidad capacidad del vehiculo
	*/
	public void setCapacidad(int capacidad){
		this.capacidad = capacidad;
	}
	/**
	* Asigna la estancia del vehiculo
	* @param estancia estancia del vehiculo
	*/
	public void setEstancia(int estancia){
		this.estancia = estancia;;
	}

	//Metodo abstracto
	/**
	* Metodo abstracto
	* @param tiempo tiempo de estancia del vehiculo
	*/
	public abstract void calcularTarifa(int tiempo);

	//Sobreescritura de toString
	/**
	* Regresa una cadena de texto con la información del vehiculo
	* @return<ul>
	*	<li>String: cadena de texto con la información del vehiculo </li>
	*	</ul>
	*/
	public String toString(){
		return marca+","+modelo+","+color+","+matriculaD+","+matriculaT+","+capacidad+","+tarifa+","+estancia;
	}
}