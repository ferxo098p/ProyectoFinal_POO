package unam.fi.poo.validaciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import unam.fi.poo.excepciones.*;

/**
* Clase ValidacionCampo
* Esta clase contiene las validaciones para los campos
* de texto
* @author Fernando Sánchez Escobar
* @version 1.0
*/

public class ValidacionCampo{
	//Métodos estaticos
	/**
	* Sólo permite que en el JTextField se puedan
	* ingresar letras
	* @param campo campo de texto en donde se aplicará la validación 
	*/
	public static void soloLetras(JTextField campo){
		KeyListener kl = new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char c = e.getKeyChar();
				if((c<'a' || c>'z') && (c<'A' || c>'Z')){
					e.consume();
				}
			}
		};
		campo.addKeyListener(kl);
	}
	/**
	* Sólo permite que en el JTextField se puedan
	* ingresar números
	* @param campo campo de texto en donde se aplicará la validación 
	*/
	public static void soloNumeros(JTextField campo){
		KeyListener klr = new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char c = e.getKeyChar();
				if(!Character.isDigit(c)){
					e.consume();
				}
			}
		};
		campo.addKeyListener(klr);
	}
	/**
	* Sólo permite que en el JTextField se puedan
	* ingresar un número especificado de caracteres
	* @param campo campo de texto en donde se aplicará la validación
	* @param cantidad número de caracteres que se permitirán ingresar 
	*/
	public static void limitarCaracteres(JTextField campo,int cantidad){
		KeyListener klr = new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				char c = e.getKeyChar();
				int tam = campo.getText().length();
				if(tam>cantidad){
					e.consume();
				}
			}
		};
		campo.addKeyListener(klr);
	}
	/**
	* Verifica que el JTextField no este vacío
	* @param campo campo de texto en donde se aplicará la validación
	* @param contenido error que se mostrará
	* @throws TextoVacioException si el campo de texto se encuentra vacío 
	*/
	public static void campoVacio(JTextField campo,String contenido) throws TextoVacioException{
		String texto = campo.getText();
		if(texto.length() == 0){
			String mensaje = "Error. No se ingreso "+contenido+", favor de verificar";
			throw new TextoVacioException(mensaje);
		}
	}
	/**
	* Verifica que el contenido del JTextField sea valido
	* @param campo campo de texto en donde se aplicará la validación
	* @throws TiempoInvalidoException si el contenido del campo de texto no se encuentra en el rango 
	*/
	public static void verificarTiempo(JTextField campo) throws TiempoInvalidoException{
		int estancia = Integer.parseInt(campo.getText()); 
		if(estancia<1 || estancia>5){
			throw new TiempoInvalidoException("Error. El tiempo de estancia debe de estar entre 1-5 horas");
		}
	}
	/**
	* Verifica que el contenido del JTextField sea valido
	* @param campo campo de texto en donde se aplicará la validación
	* @throws EdadInvalidaException si el contenido del campo de texto no se encuentra en el rango 
	*/
	public static void verificarEdad(JTextField campo) throws EdadInvalidaException{
		int edad = Integer.parseInt(campo.getText());
		if(edad<18){
			throw new EdadInvalidaException("Error. Edad no permitida. Solo mayores de edad");
		}
	}
}