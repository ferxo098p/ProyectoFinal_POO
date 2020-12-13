package unam.fi.poo.graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
* Clase VentanaConfirmacion
* Esta clase define el diseño y la lógica que tendrá
* una ventana de confirmación para el sistema
* @author Fernando Sánchez Escobar
* @version 1.0 
*/

public class VentanaConfirmacion extends JDialog implements ActionListener{
	/**
	* Panel que servira de contenedor para 
	* los elementos de la ventana 
	*/
	private JPanel ventana;
	/**
	* Titulo de la ventana
	*/
	private JLabel etiqueta;
	/**
	* Regresará a la ventana que haya desplegado a esta
	*/
	private JButton cancelar;
	/**
	* Confirmará la acción en caso de no presentarse errores
	*/
	private JButton aceptar;
	/**
	* Indica si se confirmo la acción
	*/
	private boolean confirm = false;
	/**
	* Instancia de VentanaMenu para regresar al menú
	*/
	private VentanaMenu menu;

	//Constructor
	/**
	* Constructor con dos parametros, crea una ventana de confirmación y bloquea
	* la ventana que la invoco
	* @param ventana ventana a la que pertenece esta subventana
	* @param modal indica si la ventana padre será bloqueada
	*/
	public VentanaConfirmacion(JFrame ventana,boolean modal){
		super(ventana,modal);
		this.crearVentanaDialogo();
		this.agregarComponentes();
		this.setVisible(true);
	}
	/**
	* Crea el diseño de la VentanaConfirmacion
	*/
	public void crearVentanaDialogo(){
		this.setSize(400,300);
		this.setTitle("Ventana de confirmacion");
		this.setResizable(false);
		this.ventana = new JPanel(null);
		this.setContentPane(this.ventana);
		//Indiicamos que no se pueda cerrar la ventana al presionar X
		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	/**
	* Crea y agrega los componentes que tendrá la VentanaConfirmacion
	*/
	public void agregarComponentes(){
		this.etiqueta = new JLabel("Seguro que desea continuar?");
		this.cancelar = new JButton("Cancelar");
		this.aceptar = new JButton("Aceptar");
		//Cambiando la fuente de la etiqueta
		etiqueta.setFont(new Font("Serif",Font.BOLD + Font.ITALIC,18));
		//Cambiamos el color de fondo
		this.ventana.setBackground(new Color(192,192,192));
		//Añadiendo bounds
		this.etiqueta.setBounds(100,50,250,55);
		this.cancelar.setBounds(180,200,85,25);
		this.aceptar.setBounds(280,200,80,25);
		this.cancelar.addActionListener(this);
		this.aceptar.addActionListener(this);
		//Agregando a la ventana
		this.ventana.add(etiqueta);
		this.ventana.add(cancelar);
		this.ventana.add(aceptar);
	}
	/**
	* Implementación del método de la interfaz ActionListener
	*/
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == aceptar){
			this.confirm = true;
			this.dispose();
		}

		if(e.getSource() == cancelar){
			this.confirm = false;
			this.dispose();
		}
	}
	/**
	* Indica si se ha confirmado la acción
	* @return <ul>
	*	<li> true: se confirmo la acción </li>
	*	<li> false: no se confirmo la acción </li>
	*	</ul>
	*/
	public boolean confirmar(){
		return confirm;
	}
}