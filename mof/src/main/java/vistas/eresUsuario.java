package vistas;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

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
public class eresUsuario extends FrameBase2 implements ActionListener {
	 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel texto;           // etiqueta o texto no editable
    private JTextField caja;        // caja de texto, para insertar datos
    private JButton botonUsuario;          // boton con una determinada accion


    public eresUsuario() {
        super();                    // usamos el contructor de la clase padre JFrame
        inicializarComponentes();   // inicializamos los atributos o componentes
    }


    private void inicializarComponentes() {
        // creamos los componentes
        texto = new JLabel();
        texto.setFont(new Font(texto.getFont().getName(), texto.getFont().getStyle(), 33));        //caja = new JTextField();
        botonUsuario = new JButton();
        // configuramos los componentes
        texto.setText("Eres un Usuario!!");    // colocamos un texto a la etiqueta
        texto.setBounds(250, 50, 600, 50);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        caja.setBounds(400, 50, 100, 25);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
        
        
        
        botonUsuario.setText("Usuario");			// colocamos un texto al boton
        botonUsuario.setBounds(555, 500,200, 100);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        botonUsuario.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase

        
        // adicionamos los componentes a la ventana
        this.add(texto);
        this.add(caja);
        this.add(botonUsuario);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
    }

}