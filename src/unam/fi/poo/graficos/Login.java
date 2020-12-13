package unam.fi.poo.graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JTextField;
import java.util.ArrayList;
import unam.fi.poo.validaciones.ValidacionCampo;
import unam.fi.poo.clases.Lector;
import unam.fi.poo.clases.Empleado;
import unam.fi.poo.clases.Consultor;
import unam.fi.poo.excepciones.*;

/**
* Clase Login
*
* Se encarga de permitir el acceso al sistema a un empleado por
* medio de su usuario y password
* @author Fernando Sánchez Escobar
* @version 1.0
*/

public class Login extends JFrame implements ActionListener{

	//Atributos
	/**
	* Panel que servira de contenedor para 
	* los elementos de la ventana 
	*/
	JPanel ventana;
	/**
	* Campo de texto en donde se ingresará el usuario
	*/
	JTextField cajaUsuario;
	/**
	* Campo de texto en donde se ingresará el password
	*/
	JPasswordField cajaPassword;
	/**
	* Area de texto en donde se mostrarán los mensajes
	* de error
	*/
	JTextArea cajaMensaje;
	/**
	* Boton cancelar: terminará la ejecución del sistema
	*/
	JButton cancelar;
	/**
	* Boton ingresar: permitire el acceso al sistema
	*/
	JButton ingresar;
	/**
	* Almacena el nombre del empleado que ingresa al sistema
	*/
	public static String texto;
	/**
	* Almacena el/los mensajes de error(es)
	*/
	private String mensaje;
	/**
	* Menu del sistema
	*/
	private VentanaMenu menu;

	//Constructor
	/**
	* Constructor por defecto
	* crea una ventana Login 
	*/
	public Login() {
		super();	
		this.crearLogin();
		this.agregarComponentes();
		this.setVisible(true);
	}
	/**
	* Crea el diseño de la ventana Login
	*/
	public void crearLogin(){
		//Propiedades de la ventana login
		this.setTitle("SDVP Inicio de sesion");
		this.setSize(700,500);
		//this.setLayout(new BorderLayout());
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
	* Crea y agrega los componentes que tendrá la ventana Login
	*/
	public void agregarComponentes(){
		JLabel etiqueta = new JLabel("Sistema de Valet Parking");
		JLabel usuario = new JLabel("Usuario");
		JLabel password = new JLabel("Password");
		this.cajaMensaje = new JTextArea(100,30);
		//Hacemos que la JTextArea no pueda ser editado
		this.cajaMensaje.setEditable(false);
		//Longitud de la cadena
		this.cajaUsuario = new JTextField(20);
		this.cajaPassword = new JPasswordField(20);
		//Botones
		this.cancelar = new JButton("Cancelar");
		this.ingresar = new JButton("Ingresar");
		this.cancelar.addActionListener(this);
		this.ingresar.addActionListener(this);
		//Agregando bounds
		etiqueta.setBounds(280,50,200,30);
		usuario.setBounds(230,120,100,30);
		cajaUsuario.setBounds(280,120,150,30);
		password.setBounds(215,150,100,30);
		cajaPassword.setBounds(280,150,150,30);
		cancelar.setBounds(240,250,90,25);
		ingresar.setBounds(340,250,90,25);
		cajaMensaje.setBounds(220,350,290,50);
		//Agregando los elementos al contenedor
		this.ventana.add(etiqueta);
		this.ventana.add(usuario);
		this.ventana.add(cajaUsuario);
		this.ventana.add(password);
		this.ventana.add(cajaPassword);
		this.ventana.add(cancelar);
		this.ventana.add(ingresar);
		this.ventana.add(cajaMensaje);
	}
	/**
	* Implementación del método de la interfaz ActionListener
	* @see unam.fi.poo.validaciones.ValidacionCampo
	* @see unam.fi.poo.clases.Consultor
	*/
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == ingresar){
			try{
				ValidacionCampo.campoVacio(cajaUsuario,"usuario");
				ValidacionCampo.campoVacio(cajaPassword,"password");
			}catch(TextoVacioException exp){
				mensaje = exp.getMessage();
				this.cajaMensaje.setText(mensaje);
			}
			Consultor ctr = new Consultor();
			ctr.consultarPersonal();
			ArrayList<Empleado> empleados = ctr.getPersonal().getEmpleados();
			if(this.accesar(cajaUsuario.getText(),new String(cajaPassword.getPassword()),empleados)){
				this.menu = VentanaMenu.getInstance();
				this.dispose();
			}
		}

		if(e.getSource() == cancelar){
			//Con esto hacemos que la ventana se cierre al momento de presionar el boton de "cancelar"
			System.exit(0); //Cierra todo el sistema
		}
	}

	//Métodos
	/**
	* Verifica que tanto el usuario y el password ingresados coincidan con los registrados
	* @param usuario usuario a verificar
	* @param password password a verificar
	* @param empleados empleados registrados para hacer uso del sistema
	* @return <ul>
	* 	<li>true: el usuario y el password son corrrectos </li>
	*	<li>false: el usuario y/o el password no son correctos </li>
	*	</ul>
	* @see unam.fi.poo.clases.Empleado
	*/
	public boolean accesar(String usuario,String password,ArrayList<Empleado> empleados){
		Empleado empleado;
		for(int i=0;i<empleados.size();i++){
			empleado = empleados.get(i);
			if(usuario.equals(empleado.getUsuario()) && password.equals(empleado.getPassword())){
				texto = empleado.getNombre();
				return true;
			}else{
				mensaje = "Usuario y/o password incorrectos, favor de verificar";
				this.cajaMensaje.setText(mensaje);
			}
		}
		return false;
	}
}