package unam.fi.poo.graficos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JTextField;
import unam.fi.poo.validaciones.*;
import unam.fi.poo.clases.Escritor;
import unam.fi.poo.clases.Propietario;
import unam.fi.poo.clases.Automovil;
import unam.fi.poo.clases.Informador;

/**
* Clase VentanaRegistro
* Esta clase define el diseño y la lógica que tendrá
* la ventana de registro del sistema
* @author Fernando Sánchez Escobar
* @version 1.0
*/

public class VentanaRegistro extends JFrame implements ActionListener{
	//Atributos
	/**
	* Panel que servira de contenedor para 
	* los elementos de la ventana 
	*/
	private JPanel ventana;
	/**
	* Almacena la marca del automovil
	*/
	private JTextField cajaMarca;
	/**
	* Almacena el modelo del automovil
	*/
	private JTextField cajaModelo;
	/**
	* Almacena el color del automovil
	*/
	private JTextField cajaColor;
	/**
	* Almacena la maatricula delantera del automovil
	*/
	private JTextField cajaMatriculaD;
	/**
	* Almacena la matricula trasera del automovil
	*/
	private JTextField cajaMatriculaT;
	/**
	* Almacena la capacidad del automovil
	*/
	private JTextField cajaCapacidad;
	/**
	* Almacena el nombre del propietario del automovil
	*/
	private JTextField cajaNombre;
	/**
	* Almacena el apellido paterno del propietario del automovil
	*/
	private JTextField cajaApellidoP;
	/**
	* Almacena el apellido materno del propietario del automovil
	*/
	private JTextField cajaApellidoM;
	/**
	* Almacena la edad del propietario del automovil
	*/
	private JTextField cajaEdad;
	/**
	* Almacena el tiempo de estancia del automovil
	*/
	private JTextField cajaEstancia;
	/**
	* Regresa al menu del sistema
	*/
	private JButton cancelar;
	/**
	* Registra al automovil en el sistema
	*/
	private JButton aceptar;
	/**
	* Area de texto en donde se mostrarán los mensajes
	* de error
	*/
	public static JTextArea cajaMensaje;
	/**
	* Almacena el/los mensaje(s) de error
	*/
	public static String mensaje = "";
	/**
	* Indica si se ha confirmado el registro
	*/
	public static boolean estado = false;
	/**
	* Instancia de VentanaMenu
	*/
	private VentanaMenu menu;

	//Constructor
	/**
	* Constructor por defecto crea una instancia de VentanaRegistro 
	*/
	public VentanaRegistro() {
		super();	
		this.crearVentanaRegistro();
		this.agregarComponentes();
		this.setVisible(true);
	}

	//Métodos
	/**
	* Crea el diseño de la VentanaRegistro
	*/
	public void crearVentanaRegistro(){
		//Propiedades de la ventana de registro
		this.setTitle("SDVP Registro");
		this.setSize(590,670);
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
	* Crea y agrega los componentes que tendrá la ventana de registro
	*/
	public void agregarComponentes(){
		JLabel etiqueta1 = new JLabel("Sistema de Valet Parking - Registro");
		JLabel etiqueta2 = new JLabel("Datos del automovil");
		JLabel marca = new JLabel("*Marca");
		JLabel modelo = new JLabel("*Modelo");
		JLabel color = new JLabel("*Color");
		JLabel matriculaD = new JLabel("*Matricula Delantera");
		JLabel matriculaT = new JLabel("*Matricula Trasera");
		JLabel capacidad = new JLabel("*Capacidad");
		JLabel etiqueta3 = new JLabel("Datos del propietario");
		JLabel nombre = new JLabel("*Nombre(s)");
		JLabel apellidoP = new JLabel("*Apellido Paterno");
		JLabel apellidoM = new JLabel("*Apellido Materno");
		JLabel edad = new JLabel("*Edad");
		JLabel estancia = new JLabel("*Tiempo de estancia");
		cajaMensaje = new JTextArea(100,30);
		//Agregamos una barra de dezplazamiento al TextArea encaso de que el texto
		//no quepa en el espacio asignado
		JScrollPane barraDesplazamiento = new JScrollPane(cajaMensaje);
		//Hacemos que la JTextArea no pueda ser editada
		cajaMensaje.setEditable(false);
		//Cambiamos la fuente de la etiqueta1
		etiqueta1.setFont(new Font("Verdana",Font.BOLD + Font.ITALIC,16));
		//Longitud de la cadena
		this.cajaMarca = new JTextField(20);
		this.cajaModelo = new JTextField(20);
		this.cajaColor = new JTextField(20);
		this.cajaMatriculaD = new JTextField(20);
		this.cajaMatriculaT = new JTextField(20);
		this.cajaCapacidad = new JTextField(20);
		this.cajaNombre = new JTextField(20);
		this.cajaApellidoP = new JTextField(20);
		this.cajaApellidoM = new JTextField(20);
		this.cajaEdad = new JTextField(20);
		this.cajaEstancia = new JTextField(20);
		//Botones
		this.cancelar = new JButton("Cancelar");
		this.aceptar = new JButton("Aceptar");
		this.cancelar.addActionListener(this);
		this.aceptar.addActionListener(this);
		//Agregando bounds para localizar a los elementos en la ventana
		etiqueta1.setBounds(140,20,320,30);
		etiqueta2.setBounds(230,50,180,30);
		marca.setBounds(120,90,50,30);
		this.cajaMarca.setBounds(183,90,230,25);
		modelo.setBounds(120,125,50,30);
		this.cajaModelo.setBounds(183,125,230,25);
		color.setBounds(120,160,50,25);
		this.cajaColor.setBounds(183,160,230,25);
		matriculaD.setBounds(50,195,130,25);
		this.cajaMatriculaD.setBounds(183,195,230,25);
		matriculaT.setBounds(60,230,130,25);
		this.cajaMatriculaT.setBounds(183,230,230,25);
		capacidad.setBounds(100,265,80,25);
		this.cajaCapacidad.setBounds(183,265,230,25);
		etiqueta3.setBounds(230,300,180,25);
		nombre.setBounds(100,335,70,25);
		this.cajaNombre.setBounds(183,335,230,25);
		apellidoP.setBounds(70,370,130,25);
		this.cajaApellidoP.setBounds(183,370,230,25);
		apellidoM.setBounds(70,405,130,25);
		this.cajaApellidoM.setBounds(183,405,230,25);
		edad.setBounds(90,460,50,25);
		this.cajaEdad.setBounds(130,460,80,25);
		estancia.setBounds(270,460,120,25);
		this.cajaEstancia.setBounds(390,460,80,25);
		this.cancelar.setBounds(340,530,85,25);
		this.aceptar.setBounds(450,530,80,25);
		barraDesplazamiento.setBounds(10,500,320,100);
		//Añadiendo las validaciones
		this.agregarValidaciones();
		//Agregando los elementos al contenedor
		this.ventana.add(etiqueta1);
		this.ventana.add(etiqueta2);
		this.ventana.add(marca);
		this.ventana.add(cajaMarca);
		this.ventana.add(modelo);
		this.ventana.add(cajaModelo);
		this.ventana.add(color);
		this.ventana.add(cajaColor);
		this.ventana.add(matriculaD);
		this.ventana.add(cajaMatriculaD);
		this.ventana.add(matriculaT);
		this.ventana.add(cajaMatriculaT);
		this.ventana.add(capacidad);
		this.ventana.add(cajaCapacidad);
		this.ventana.add(etiqueta3);
		this.ventana.add(nombre);
		this.ventana.add(cajaNombre);
		this.ventana.add(apellidoP);
		this.ventana.add(cajaApellidoP);
		this.ventana.add(apellidoM);
		this.ventana.add(cajaApellidoM);
		this.ventana.add(edad);
		this.ventana.add(cajaEdad);
		this.ventana.add(estancia);
		this.ventana.add(cajaEstancia);
		this.ventana.add(cancelar);
		this.ventana.add(aceptar);
		this.ventana.add(barraDesplazamiento);
	}
	/**
	* Implementación del método de la interfaz ActionListener
	* @see unam.fi.poo.clases.Informador
	*/
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == aceptar){
			cajaMensaje.setText("");
			this.verificarCampos();
			if(estado == false){
				Informador info = new Informador();
				if(!info.getEstacionamiento().verificarEspacio()){
					if(info.getEstacionamiento().buscarAuto(cajaMatriculaD.getText()) == true){
						cajaMensaje.setText("Placa delantera registrada previamente");
					}else{
						JOptionPane.showMessageDialog(this, "Automovil registrado!!!");
						this.registrarAutomovil(info);
						this.menu = VentanaMenu.getInstance();
						menu.setVisible(true);
						this.dispose();
					}
				}else{
					cajaMensaje.setText("Estacionamiento lleno!!!");
				}
			}else{
				estado = false;
			}
		}

		if(e.getSource() == cancelar){
			this.menu = VentanaMenu.getInstance();
			menu.setVisible(true);
			this.dispose();
		}
	}
	/**
	* Agrega las validaciones que tendrá la VentanaRegsitro
	* @see unam.fi.poo.validaciones.ValidacionCampo
	*/
	public void agregarValidaciones(){
		ValidacionCampo.soloLetras(cajaMarca);
		ValidacionCampo.soloLetras(cajaColor);
		ValidacionCampo.soloNumeros(cajaCapacidad);
		ValidacionCampo.soloLetras(cajaNombre);
		ValidacionCampo.soloLetras(cajaApellidoP);
		ValidacionCampo.soloLetras(cajaApellidoM);
		ValidacionCampo.soloNumeros(cajaEdad);
		ValidacionCampo.soloNumeros(cajaEstancia);
		ValidacionCampo.limitarCaracteres(cajaMarca,15);
		ValidacionCampo.limitarCaracteres(cajaModelo,15);
		ValidacionCampo.limitarCaracteres(cajaMatriculaD,6);
		ValidacionCampo.limitarCaracteres(cajaMatriculaT,6);
		ValidacionCampo.limitarCaracteres(cajaColor,15);
		ValidacionCampo.limitarCaracteres(cajaCapacidad,0);
		ValidacionCampo.limitarCaracteres(cajaNombre,25);
		ValidacionCampo.limitarCaracteres(cajaApellidoP,50);
		ValidacionCampo.limitarCaracteres(cajaApellidoM,50);
		ValidacionCampo.limitarCaracteres(cajaEstancia,0);
	}
	/**
	* Verifica el contenido de los JTextField 
	* @see unam.fi.poo.validaciones.ValidacionVentanaRegistro
	*/
	public void verificarCampos(){
		ValidacionVentanaRegistro.verificarCajaMarca(cajaMarca);
		ValidacionVentanaRegistro.verificarCajaModelo(cajaModelo);
		ValidacionVentanaRegistro.verificarCajaColor(cajaColor);
		ValidacionVentanaRegistro.verificarCajaMatriculaD(cajaMatriculaD);
		ValidacionVentanaRegistro.verificarCajaMatriculaT(cajaMatriculaT);
		ValidacionVentanaRegistro.verificarCajaCapacidad(cajaCapacidad);
		ValidacionVentanaRegistro.verificarCajaNombre(cajaNombre);
		ValidacionVentanaRegistro.verificarCajaApellidoP(cajaApellidoP);
		ValidacionVentanaRegistro.verificarCajaApellidoM(cajaApellidoM);
		ValidacionVentanaRegistro.verificarCajaEdad(cajaEdad);
		ValidacionVentanaRegistro.verificarCajaEstancia(cajaEstancia);
	}

	/**
	* Guarda el registro del utomovil en el sistema
	* @see unam.fi.poo.clases.Propietario
	* @see unam.fi.poo.clases.Automovil
	* @see unam.fi.poo.clases.Escritor
	* @param info para operarv sobre un archivo .txt
	*/
	public void registrarAutomovil(Informador info){
		//Creamos el propietario del automovil con los datos obtenidos
		Propietario propietario = new Propietario(cajaNombre.getText().trim(),cajaApellidoP.getText(),cajaApellidoM.getText(),cajaEdad.getText());
		//Creamos nuestro automovil con los datos registrados
		Automovil auto = new Automovil(propietario);
		int tiempo = Integer.parseInt(cajaEstancia.getText());
		auto.setMarca(cajaMarca.getText());
		auto.setModelo(cajaModelo.getText());
		auto.setColor(cajaColor.getText());
		auto.setMatriculaD(cajaMatriculaD.getText());
		auto.setMatriculaT(cajaMatriculaT.getText());
		int capacidad = Integer.parseInt(cajaCapacidad.getText());
		auto.setCapacidad(capacidad);
		auto.calcularTarifa(tiempo);
		auto.setEstancia(tiempo);
		info.getEstacionamiento().agregarAuto(auto);
		String g = "Tarifa: "+auto.getTarifa();
		cajaMensaje.setText(g);
		Escritor escritor = new Escritor("./archivos/autos.txt");
		escritor.escribirEnArchivo("./archivos/autos.txt",auto.toString());		
	}
}