package unam.fi.poo.graficos;

import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import unam.fi.poo.clases.Leyente;

/**
* Clase VentanaCambio
* Esta clase contine el diseño y la lógica que tendrá
* la ventana para cambios del sistema
* @see unam.fi.poo.clases.Leyente
* @author Fernando Sánchez Escobar
* @version 1.0
*/

public class VentanaCambio extends JFrame implements ActionListener{
	//Atributos
	/**
	* Panel que servira de contenedor para 
	* los elementos de la ventana 
	*/
	private JPanel ventana;
	/**
	* Tabla de listado de los automoviles registrados
	*/
	private JTable tabla;
	/**
	* Modelo que tendrá la tabla
	*/
	private DefaultTableModel modelo;
	/**
	* Regresa al menu del sistema
	*/
	private JButton cancelar;
	/**
	* Despliega la ventana de modificaciones si no hay errores
	*/
	private JButton aceptar;
	/**
	* Area de texto en donde se mostrarán los mensajes
	* de error
	*/
	private JTextArea cajaMensaje;
	/**
	* Instancia de leyente para operar sobre 
	* un archivo .txt
	*/
	private Leyente leyente = new Leyente("./archivos/autos.txt");
	/**
	* Ventana de modificaciones
	*/
	private VentanaCambioModificaciones vcm;
	/**
	* Fila de la tabla de listado que será actualizada
	*/
	public static ArrayList<String> filaActualizar = new ArrayList<String>();
	/**
	* Instancia de VentanaMenu
	*/
	private VentanaMenu menu;

	//Constructor
	/**
	* Constructor por defecto crea una instancia de VentanaCambio 
	*/
	public VentanaCambio(){
		super();	
		this.crearVentanaCambio();
		this.agregarComponentes();
		this.crearTabla();
		this.setVisible(true);
	}

	//Métodos
	/**
	* Crea el diseño de la VentanaCambio
	*/
	public void crearVentanaCambio(){
		//Propiedades de la ventana cambio
		this.setTitle("SDVP Cambios");
		this.setSize(1260,580);
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
	* Crea y agrega los componentes que tendrá la VentanaCambio
	*/
	public void agregarComponentes(){
		JLabel etiqueta = new JLabel("Sistema de Valet Parking - Cambios");
		JLabel subtitulo = new JLabel("Lista de Automovoles");
		//Cambiamos la fuente de la etiqueta principal
		etiqueta.setFont(new Font("Verdana",Font.BOLD + Font.ITALIC,16));
		this.cancelar = new JButton("Cancelar");
		this.aceptar = new JButton("Aceptar");
		this.cajaMensaje = new JTextArea(280,30);
		//Agregando bounds
		etiqueta.setBounds(468,20,320,30);
		subtitulo.setBounds(570,50,130,30);
		this.cancelar.setBounds(1015,400,85,25);
		this.aceptar.setBounds(1120,400,80,25);
		this.cajaMensaje.setBounds(220,350,335,50);
		this.cancelar.addActionListener(this);
		this.aceptar.addActionListener(this);
		//Agregando a la ventana
		this.ventana.add(etiqueta);
		this.ventana.add(subtitulo);
		this.ventana.add(cancelar);
		this.ventana.add(aceptar);
		this.ventana.add(cajaMensaje);
	}
	/**
	* Crea la tabla en donde se mostrará el listado de los automoviles registrados
	*/
	public void crearTabla(){
		String datos[][] = {};
		String cabecera[] = {"Marca","Modelo","Color","MatriculaD","MatriculaT","Capacidad","Tarifa($)","Estancia(hrs)","Nombre","ApellidoP","ApellidoM","Edad"};
		this.modelo = new DefaultTableModel(datos,cabecera);
		try{
			leyente.leer("./archivos/autos.txt",modelo);
		}catch(IOException iox){}
		this.tabla = new JTable(modelo){
			//Sobreescritura del metodo isCellEditable para que toda la tabla no pueda ser editada
			public boolean isCellEditable(int rowIndex,int colIndex){
				return false;
			}
		};
		JScrollPane tablaDeslizar = new JScrollPane(tabla);
		//Agregando bounds
		tablaDeslizar.setBounds(50,100,1150,180);
		this.ventana.add(tablaDeslizar);
	}
	/**
	* Implementación del método de la interfaz ActionListener
	*/
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == aceptar){
			this.modificarElemento();
		}
		if(e.getSource() == cancelar){
			this.menu = VentanaMenu.getInstance();
			menu.setVisible(true);
			this.dispose();
		}
	}
	/**
	* Modifica el registro del automovil seleccionado
	* @see unam.fi.poo.graficos.VentanaCambioModificaciones
	*/
	public void modificarElemento(){
		int filaSelec = tabla.getSelectedRow();
		if(filaSelec >= 0){
			this.cajaMensaje.setText("");
			this.llenarFilaActualizar(filaSelec);
			vcm = new VentanaCambioModificaciones(this,true);
			if(vcm.confirmar() == true){
				this.modelo.removeRow(filaSelec);
				vcm.agregarFila(tabla,modelo);
				leyente.vaciarArchivo("./archivos/autos.txt");
				actualizarArchivo();
				this.setVisible(false);
				//this.dispose();
			}
		}else{
			this.cajaMensaje.setText("Error! Debe de seleccionar un elemento antes de eliminarlo");
		}
	}
	/**
	* Agrega la información en filaActualizar
	* @param filaSelec fila a actualizar
	*/
	public void llenarFilaActualizar(int filaSelec){
		String text;
		for(int i=0;i<tabla.getColumnCount();i++){
			text = tabla.getValueAt(filaSelec,i).toString();
			filaActualizar.add(text); 
		}
	}
	/**
	* Actualiza los registros del sistema y el archivo .txt
	* @see unam.fi.poo.clases.Leyente
	*/
	public void actualizarArchivo(){
		Leyente leyente = new Leyente("./archivos/autos.txt");
		//Obtiene el contenido de cada celda de la JTable
		String aux;
		String texto = "";
		for(int i=0;i<tabla.getRowCount();i++){
			for (int j=0;j<tabla.getColumnCount();j++){
				aux = tabla.getValueAt(i,j).toString();
				texto += aux+",";
				if(j==tabla.getColumnCount()-1){
					leyente.escribirEnArchivo("./archivos/autos.txt",texto);
				}
			}
			texto = "";
		}
	}
}