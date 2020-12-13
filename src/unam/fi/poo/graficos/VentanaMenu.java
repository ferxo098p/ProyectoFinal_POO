package unam.fi.poo.graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JTextField;

/**
* Clase VentanaMenu
* Esta clase define el diseño y lógica que tendra el menu 
* del sistema
* @author Fernando Sánchez Escobar
* @version 1.0
*/

public class VentanaMenu extends JFrame implements ActionListener{
	//Atributos
	/**
	* Panel que servira de contenedor para 
	* los elementos de la ventana 
	*/
	JPanel ventana;
	/**
	* Area de texto en donde se mostrarán los mensajes
	* de error
	*/
	JTextArea cajaMensaje;
	/**
	* ButtonGroup para los JRadioButton
	*/
	ButtonGroup grupo;
	/**
	* JRadioButton que desplegara la venta de registro
	* del sistema al ser seleccionado
	*/
	JRadioButton registro;
	/**
	* JRadioButton que desplegara la venta de entrega
	* del sistema al ser seleccionado
	*/
	JRadioButton entrega;
	/**
	* JRadioButton que desplegara la venta de cambios
	* del sistema al ser seleccionado
	*/
	JRadioButton cambios;
	/**
	* Boton cancelar: terminará la ejecución del sistema
	*/
	JButton cancelar;
	/**
	* Boton aceptar: mostrara la ventana del JRadioButton seleccionado 
	*/
	JButton aceptar;
	/**
	* Instancia de VentanaMenu
	*/
	private static VentanaMenu instancia;

	//Constructor
	/**
	* Constructor por defecto crea una instancia de VentanaMenu 
	*/
	private VentanaMenu() {
		super();	
		this.crearVentanaMenu();
		this.agregarComponentes();
		this.setVisible(true);
	}

	//Get
	/**
	* Comprueba que la instancia de VentanaMenu no sea nula, en caso
	* de serlo, la inicializa
	* @return <ul>
	*	<li> VentanaMenu: instancia de si misma </li>
	*	</ul>
	*/
	public static VentanaMenu getInstance(){
		if(instancia == null){
			instancia = new VentanaMenu();
		}
		return instancia;
	}

	//Metodos
	/**
	* Crea el diseño de la ventanaMenu
	*/
	public void crearVentanaMenu(){
		//Propiedades de la ventanaMenu
		this.setTitle("SDVP Menu");
		this.setSize(800,500);
		//Impide que se pueda redimensionar la ventana
		this.setResizable(false);
		//creando las ventanas auxiliares
		this.ventana = new JPanel(null);
		//agregamos las ventanas auxiliares en la principal
		this.setContentPane(this.ventana);
		//Con esto se indica que al cerrar la ventana se termine la aplicación
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}
	/**
	* Crea y agrega los componentes que tendrá la ventanaMenu
	*/
	public void agregarComponentes(){
		JLabel etiqueta = new JLabel("Bienvenido al Sistema - "+Login.texto);
		JLabel mensaje = new JLabel("Seleccione la opcion de su preferencia");
		this.cajaMensaje = new JTextArea(100,10);
		this.grupo = new ButtonGroup(); 
		//Botones
		this.cancelar = new JButton("Cancelar");
		this.aceptar = new JButton("Aceptar");
		this.cancelar.addActionListener(this);
		this.aceptar.addActionListener(this);
		this.registro = new JRadioButton("Registro");
		this.entrega = new JRadioButton("Entrega");
		this.cambios = new JRadioButton("Cambios");
		//Agregando bounds
		etiqueta.setBounds(320,30,200,30);
		mensaje.setBounds(290,45,400,30);
		registro.setBounds(320,130,90,25);
		entrega.setBounds(320,160,90,25);
		cambios.setBounds(320,190,90,25);
		cancelar.setBounds(460,340,90,25);
		aceptar.setBounds(570,340,90,25);
		cajaMensaje.setBounds(320,390,200,30);
		//Agregando los elementos al contenedor
		this.grupo.add(registro);
		this.grupo.add(entrega);
		this.grupo.add(cambios);
		this.ventana.add(etiqueta);
		this.ventana.add(mensaje);
		this.ventana.add(registro);
		this.ventana.add(entrega);
		this.ventana.add(cambios);
		this.ventana.add(cancelar);
		this.ventana.add(aceptar);
		this.ventana.add(cajaMensaje);
	}
	/**
	* Implementación del método de la interfaz ActionListener
	*/
	public void actionPerformed(ActionEvent e){
		this.validarBoton();

		if(e.getSource() == cancelar){
			//Con esto hacemos que la ventana se cierre al momento de presionar el boton de "cancelar"
			System.exit(0); //Cierra todo el sistema
		}
	}
	/**
	* Valida que un boton haya sido seleccionado y despliega la ventana
	* correspondiente, en caso contrario muestra un mensaje de error
	* @see unam.fi.poo.graficos.VentanaRegistro
	* @see unam.fi.poo.graficos.VentanaEntrega
	* @see unam.fi.poo.graficos.VentanaCambio
	*/
	public void validarBoton(){
		String message;
		if(registro.isSelected()){
			new VentanaRegistro();
			this.setVisible(false);
		}else if(entrega.isSelected()){
			new VentanaEntrega();
			this.setVisible(false);
		}else if(cambios.isSelected()){
			new VentanaCambio();
			this.setVisible(false);
		}else{
			message = "Seleccione una opcion";
			this.cajaMensaje.setText(message);
		}
	}
}