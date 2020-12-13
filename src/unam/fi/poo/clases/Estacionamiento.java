package unam.fi.poo.clases;
import java.util.ArrayList;
import unam.fi.poo.clases.Automovil;

/**
* Clase Estacionamiento
* Esta clase almacena los automoviles registrados
* @author Fernando Sánchez Escobar
* @version 1.0
*/

public class Estacionamiento{
	//Atributos
	/**
	* Representa al estacionamiento
	*/
	private ArrayList<Automovil> automoviles;
	/**
	* Instancia de si misma (implementación de singleton)
	*/
	private static Estacionamiento instancia;

	//Constructor
	/**
	* Crea una instancia de estacionamiento
	* @see unam.fi.poo.clases.Automovil
	*/
	private Estacionamiento(){
		this.automoviles = new ArrayList<Automovil>();
	}

	//Getters y setters
	/**
	* Regresa la colección de automoviles
	* @return <ul>
	* 	<li> automoviles: ArrayList que almacena los elementos </li>
	*	</ul> 
	* @see unam.fi.poo.clases.Automovil 
	*/
	public ArrayList<Automovil> getAutomoviles(){
		return this.automoviles;
	}
	/**
	* Comprueba que la instancia de si misma no sea nula, en caso
	* de serlo, la inicializa
	* @return <ul>
	*	<li> instancia: instancia de si misma (Estacionamiento) </li>
	*	</ul>
	*/
	public static Estacionamiento getInstance(){
		if(instancia == null){
			instancia = new Estacionamiento(); 
		}
		return instancia;
	}
	/**
	* Verifica que aun hay espacio en el estacionamiento
	* @return <ul>
	*	<li>true: si aún hay espcio</li>
	*	<li>false: si no hay espacio</li>
	*	</ul>
	* @see unam.fi.poo.clases.Automovil
	*/
	public boolean verificarEspacio(){
		return automoviles.size() == 10;
	}
	/**
	* Verifica que aun hay elementos en el estacionamiento
	* @return <ul>
	*	<li>true: si almenos hay un elemento</li>
	*	<li>false: si no hay más elementos</li>
	*	</ul>
	*/
	public boolean verificarVacio(){
		return automoviles.size() == 0;
	}
	/**
	* Agrega el automovil al estacionamiento
	* @param auto elemento de tipo Automovil que será agregado
	* @see unam.fi.poo.clases.Automovil
	*/
	public void agregarAuto(Automovil auto){
		this.automoviles.add(auto);
	}
	/**
	* Verfifca si el automovil ya se encuentra registrado
	* @param matricula matricula (delantera) del automovil a buscar
	* @return <ul>
	*	<li>true: si el automovil ya se encuentra en el estacionamiento</li>
	*	<li>false: si el automovil no se encuentra en el estacionamiento</li>
	*	</ul>
	* @see unam.fi.poo.clases.Automovil
	*/
	public boolean buscarAuto(String matricula){
		Automovil aux;
		String matriculaD;
		for(int i=0;i<automoviles.size();i++){
			aux = automoviles.get(i);
			matriculaD = aux.getMatriculaD();
			if(matriculaD.equals(matricula)){
				return true;
			}
		}
		return false;
	}
	/**
	* Verfifca si el automovil ya se encuentra registrado
	* @param matricula matricula (delantera) del automovil a buscar
	* @return <ul>
	*	<li>i: posicion del automovil en el estacionamiento</li>
	*	<li>-1: si el automovil no se encuentra en el estacionamiento</li>
	*	</ul>
	* @see unam.fi.poo.clases.Automovil
	*/
	public int encontrarAuto(String matricula){
		Automovil aux;
		String matriculaD;
		for(int i=0;i<automoviles.size();i++){
			aux = automoviles.get(i);
			matriculaD = aux.getMatriculaD();
			if(matriculaD.equals(matricula)){
				return i;
			}
		}
		return -1;
	}
	/**
	* Elimina al automovil del estacionamiento
	* @param matricula matricula (delantera) del automovil a eliminar
	* @return <ul>
	*	<li>automovil: Objeto de tipo Automovil</li>
	*	</ul>
	* @see unam.fi.poo.clases.Automovil
	*/
	public Automovil entregarAuto(String matricula){
		int lugar = encontrarAuto(matricula);
		return automoviles.remove(lugar);
	}
}