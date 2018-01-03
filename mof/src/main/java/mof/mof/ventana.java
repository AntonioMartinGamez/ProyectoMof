package mof.mof;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Clase Ventana
 * Muestra la estructuta que deberia tener una Ventana en Java con la libreria
 * Swing, contiene una etiqueta, un caja de texto y un boton, que tiene la
 * accion de mostrar el texto en la caja por una ventana de mensaje.
 * @author Daniel Alvarez (a3dany)
 */
public class ventana extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -974237888149158577L;
	private JLabel texto;           // etiqueta o texto no editable
    private JTextField caja;        // caja de texto, para insertar datos
    private JButton boton;          // boton con una determinada accion
    private JLabel text2;
    private JLabel mostUser;
    
    public ventana() throws SQLException {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
    }

    private void configurarVentana() {
        this.setTitle("Esta Es Una Ventana");                   // colocamos titulo a la ventana
        this.setSize(900, 700);                               // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }

    private void inicializarComponentes() throws SQLException {
        // creamos los componentes
        texto = new JLabel();
        caja = new JTextField();
        boton = new JButton();
        text2 = new JLabel();
        mostUser = new JLabel();
        // configuramos los componentes
        texto.setText("Busqueda");    // colocamos un texto a la etiqueta
        texto.setBounds(31, 50, 100, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        caja.setBounds(111, 50, 100, 25);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
        boton.setText("Buscar");   // colocamos un texto al boton
        boton.setBounds(30, 80, 180, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        boton.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
        
        // adicionamos los componentes a la ventana
        Usuario u1 = new Usuario();
        
        
        mostUser.setText(u1.mostUsuario());
        mostUser.setBounds(100, 100, 100, 100);
        text2.setText("Master of Food");
        text2.setBounds(10, 10, 100, 25);
        
        this.add(text2);
        this.add(texto);
        this.add(caja);
        this.add(boton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = caja.getText();                                 // obtenemos el contenido de la caja de texto
        JOptionPane.showMessageDialog(this, "Hola " + nombre + ".");    // mostramos un mensaje (frame, mensaje)
    }

    public static void main(String[] args) throws SQLException {
        ventana V = new ventana();      // creamos una ventana
        V.setVisible(true);             // hacemos visible la ventana creada
    }
}