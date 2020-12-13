package unam.fi.poo.validaciones;

import javax.swing.JTextField;
import unam.fi.poo.graficos.VentanaRegistro;
import unam.fi.poo.excepciones.*;

/**
* Clase ValidacionVentanaRegistro
* Esta clase contiene las validaciones para una
* VentanaRegistro
* @author Fernando Sánchez Escobar
* @version 1.0
*/

public class ValidacionVentanaRegistro{
	//Métodos estaticos
	/**
	* Verifica que el contenido del JTextField sea valido
	* @param cajaMarca campo de texto en donde se aplicará la validación
	* @see unam.fi.poo.validaciones.ValidacionCampo
	* @see unam.fi.poo.graficos.VentanaCambioModificaciones
	*/
	public static void verificarCajaMarca(JTextField cajaMarca){
		try{
			ValidacionCampo.campoVacio(cajaMarca,"marca");
		}catch(TextoVacioException tve){
			VentanaRegistro.mensaje += tve.getMessage()+"\n";
			VentanaRegistro.cajaMensaje.setText(VentanaRegistro.mensaje);
			VentanaRegistro.estado = true;
		}
	}
	/**
	* Verifica que el contenido del JTextField sea valido
	* @param cajaModelo campo de texto en donde se aplicará la validación
	* @see unam.fi.poo.validaciones.ValidacionCampo
	* @see unam.fi.poo.graficos.VentanaCambioModificaciones
	*/
	public static void verificarCajaModelo(JTextField cajaModelo){
		try{
			ValidacionCampo.campoVacio(cajaModelo,"modelo");
		}catch(TextoVacioException tve){
			VentanaRegistro.mensaje += tve.getMessage()+"\n";
			VentanaRegistro.cajaMensaje.setText(VentanaRegistro.mensaje);
			VentanaRegistro.estado = true;
		}
	}
	/**
	* Verifica que el contenido del JTextField sea valido
	* @param cajaColor campo de texto en donde se aplicará la validación
	* @see unam.fi.poo.validaciones.ValidacionCampo
	* @see unam.fi.poo.graficos.VentanaCambioModificaciones
	*/
	public static void verificarCajaColor(JTextField cajaColor){
		try{
			ValidacionCampo.campoVacio(cajaColor,"color");
		}catch(TextoVacioException tve){
			VentanaRegistro.mensaje +=  tve.getMessage()+"\n";
			VentanaRegistro.cajaMensaje.setText(VentanaRegistro.mensaje);
			VentanaRegistro.estado = true;
		}
	}
	/**
	* Verifica que el contenido del JTextField sea valido
	* @param cajaMatriculaD campo de texto en donde se aplicará la validación
	* @see unam.fi.poo.validaciones.ValidacionCampo
	* @see unam.fi.poo.graficos.VentanaCambioModificaciones
	*/
	public static void verificarCajaMatriculaD(JTextField cajaMatriculaD){
		try{
			ValidacionCampo.campoVacio(cajaMatriculaD,"matricula delantera");
		}catch(TextoVacioException tve){
			VentanaRegistro.mensaje += tve.getMessage()+"\n";
			VentanaRegistro.cajaMensaje.setText(VentanaRegistro.mensaje);
			VentanaRegistro.estado = true;
		}
	}
	/**
	* Verifica que el contenido del JTextField sea valido
	* @param cajaMatriculaT campo de texto en donde se aplicará la validación
	* @see unam.fi.poo.validaciones.ValidacionCampo
	* @see unam.fi.poo.graficos.VentanaCambioModificaciones
	*/
	public static void verificarCajaMatriculaT(JTextField cajaMatriculaT){
		try{
			ValidacionCampo.campoVacio(cajaMatriculaT,"matricula trasera");
		}catch(TextoVacioException tve){
			VentanaRegistro.mensaje += tve.getMessage()+"\n";
			VentanaRegistro.cajaMensaje.setText(VentanaRegistro.mensaje);
			VentanaRegistro.estado = true;
		}
	}
	/**
	* Verifica que el contenido del JTextField sea valido
	* @param cajaCapacidad campo de texto en donde se aplicará la validación
	* @see unam.fi.poo.validaciones.ValidacionCampo
	* @see unam.fi.poo.graficos.VentanaCambioModificaciones 
	*/
	public static void verificarCajaCapacidad(JTextField cajaCapacidad){
		try{
			ValidacionCampo.campoVacio(cajaCapacidad,"capacidad");
		}catch(TextoVacioException tve){
			VentanaRegistro.mensaje += tve.getMessage()+"\n";
			VentanaRegistro.cajaMensaje.setText(VentanaRegistro.mensaje);
			VentanaRegistro.estado = true;
		}
	}
	/**
	* Verifica que el contenido del JTextField sea valido
	* @param cajaNombre campo de texto en donde se aplicará la validación
	* @see unam.fi.poo.validaciones.ValidacionCampo
	* @see unam.fi.poo.graficos.VentanaCambioModificaciones
	*/
	public static void verificarCajaNombre(JTextField cajaNombre){
		try{
			ValidacionCampo.campoVacio(cajaNombre,"nombre");
		}catch(TextoVacioException tve){
			VentanaRegistro.mensaje += tve.getMessage()+"\n";
			VentanaRegistro.cajaMensaje.setText(VentanaRegistro.mensaje);
			VentanaRegistro.estado = true;
		}
	}
	/**
	* Verifica que el contenido del JTextField sea valido
	* @param cajaApellidoP campo de texto en donde se aplicará la validación
	* @see unam.fi.poo.validaciones.ValidacionCampo
	* @see unam.fi.poo.graficos.VentanaCambioModificaciones
	*/
	public static void verificarCajaApellidoP(JTextField cajaApellidoP){
		try{
			ValidacionCampo.campoVacio(cajaApellidoP,"apellido paterno");
		}catch(TextoVacioException tve){
			VentanaRegistro.mensaje += tve.getMessage()+"\n";
			VentanaRegistro.cajaMensaje.setText(VentanaRegistro.mensaje);
			VentanaRegistro.estado = true;
		}
	}
	/**
	* Verifica que el contenido del JTextField sea valido
	* @param cajaApellidoM campo de texto en donde se aplicará la validación
	* @see unam.fi.poo.validaciones.ValidacionCampo
	* @see unam.fi.poo.graficos.VentanaCambioModificaciones
	*/
	public static void verificarCajaApellidoM(JTextField cajaApellidoM){
		try{
			ValidacionCampo.campoVacio(cajaApellidoM,"apellido Materno");
		}catch(TextoVacioException tve){
			VentanaRegistro.mensaje += tve.getMessage()+"\n";
			VentanaRegistro.cajaMensaje.setText(VentanaRegistro.mensaje);
			VentanaRegistro.estado = true;
		}
	}
	/**
	* Verifica que el contenido del JTextField sea valido
	* @param cajaEdad campo de texto en donde se aplicará la validación
	* @see unam.fi.poo.validaciones.ValidacionCampo
	* @see unam.fi.poo.graficos.VentanaCambioModificaciones
	*/
	public static void verificarCajaEdad(JTextField cajaEdad){
		try{
			ValidacionCampo.campoVacio(cajaEdad,"edad");
			ValidacionCampo.verificarEdad(cajaEdad);
		}catch(TextoVacioException tve){
			VentanaRegistro.mensaje += tve.getMessage()+"\n";
			VentanaRegistro.cajaMensaje.setText(VentanaRegistro.mensaje);
			VentanaRegistro.estado = true;
		}catch(EdadInvalidaException eie){
			VentanaRegistro.mensaje += eie.getMessage()+"\n";
			VentanaRegistro.cajaMensaje.setText(VentanaRegistro.mensaje);
			VentanaRegistro.estado = true;
		}
	}
	/**
	* Verifica que el contenido del JTextField sea valido
	* @param cajaEstancia campo de texto en donde se aplicará la validación
	* @see unam.fi.poo.validaciones.ValidacionCampo
	* @see unam.fi.poo.graficos.VentanaCambioModificaciones
	*/
	public static void verificarCajaEstancia(JTextField cajaEstancia){
		try{
			ValidacionCampo.campoVacio(cajaEstancia,"tiempo de estancia");
			ValidacionCampo.verificarTiempo(cajaEstancia);
		}catch(TextoVacioException tve){
			VentanaRegistro.mensaje += tve.getMessage()+"\n";
			VentanaRegistro.cajaMensaje.setText(VentanaRegistro.mensaje);
			VentanaRegistro.estado = true;
		}catch(TiempoInvalidoException tie){
			VentanaRegistro.mensaje += tie.getMessage()+"\n";
			VentanaRegistro.cajaMensaje.setText(VentanaRegistro.mensaje);
			VentanaRegistro.estado = true;
		}
	}
}