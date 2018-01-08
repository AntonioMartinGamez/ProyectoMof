package vistas;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.AbstractButton;
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
public class primeraVista extends FrameBase2 implements ActionListener {
	 

    private JLabel texto;           // etiqueta o texto no editable
    private JTextField caja;        // caja de texto, para insertar datos
    private JButton botonEmpresa;          // boton con una determinada accion
    private JButton botonUsuario;          // boton con una determinada accion
    private JButton botonRegistrar;          // boton con una determinada accion

    public primeraVista() {
        super();                    // usamos el contructor de la clase padre JFrame
        inicializarComponentes();   // inicializamos los atributos o componentes
    }


    private void inicializarComponentes() {
        // creamos los componentes
        texto = new JLabel();
        texto.setFont(new Font(texto.getFont().getName(), texto.getFont().getStyle(), 33));        //caja = new JTextField();
        botonEmpresa = new JButton();
        botonUsuario = new JButton();
        
        botonRegistrar = new JButton();
        
        // configuramos los componentes
        texto.setText("Eres una Empresa o un Usuario?");    // colocamos un texto a la etiqueta
        texto.setBounds(250, 50, 600, 50);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        //caja.setBounds(400, 50, 100, 25);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
        
        botonEmpresa.setText("Empresa"); 		    // colocamos un texto al boton
        botonEmpresa.setFont(new Font(texto.getFont().getName(), texto.getFont().getStyle(), 50));        //caja = new JTextField();
        botonEmpresa.setBounds(75, 184, 400, 400);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        botonEmpresa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			 	new vistas.eresEmpresa().setVisible(true);
				setVisible(false);

			}
        });       // hacemos que el boton tenga una accion y esa accion estara en esta clase
        
        botonRegistrar.setText("Registar"); 		    // colocamos un texto al boton
        botonRegistrar.setFont(new Font(texto.getFont().getName(), texto.getFont().getStyle(), 13));        //caja = new JTextField();
        botonRegistrar.setBounds(20, 20, 100, 50);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        botonRegistrar.addActionListener(new ActionListener() {
			private AbstractButton check1;
			private AbstractButton check2;

			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = null;
		        check1 = null;
				check2 = null;
				
			 	try {
					new mof.mof.Registrar().setVisible(true);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				setVisible(false);

			}
        });       // hacemos que el boton tenga una accion y esa accion estara en esta clase
        
        
        botonUsuario.setText("Usuario");// colocamos un texto al boton
        botonUsuario.setFont(new Font(texto.getFont().getName(), texto.getFont().getStyle(), 50));        //caja = new JTextField();
        botonUsuario.setBounds(555, 184, 400, 400);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        botonUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			 	new vistas.eresUsuario().setVisible(true);
				setVisible(false);

			}
        });       // hacemos que el boton tenga una accion y esa accion estara en esta clase
        
        // adicionamos los componentes a la ventana
        this.add(texto);
        //this.add(caja);
        this.add(botonEmpresa);
        this.add(botonUsuario);
        this.add(botonRegistrar);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
    }

    public static void main(String[] args) {
    	FrameBase2 F = new primeraVista();      // creamos una ventana
        F.setVisible(true);             // hacemos visible la ventana creada
    }
}