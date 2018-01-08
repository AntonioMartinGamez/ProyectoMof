package vistas;
import mof.mof.*;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
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
public class mostrarEmpresa extends FrameBase2 implements ActionListener {
	 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel texto;           // etiqueta o texto no editable

	private JLabel nombre;
	private JLabel fijo;
	private JLabel movil;
	private JLabel email;
	private JLabel descripcion;
	private JLabel propietario;
	private JLabel comida;
	private JLabel url;
	private JLabel localizacion;
	private JLabel precMedio;
	
	private String name, correo, desc, prop, comid, pag, local, eRest = "";
	private int fij, mov, prec = 0;
	
	private ResultSet res;
	
	
	private JButton botonReturn;          // boton con una determinada accion

    public mostrarEmpresa(String eRest) {
        super();                    // usamos el contructor de la clase padre JFrame
        this.eRest = eRest;
        inicializarComponentes();   // inicializamos los atributos o componentes
    }


    private void inicializarComponentes() {
        // creamos los componentes
    	Restaurante rest = new Restaurante();
    	
		try {
			res = rest.mostRest(eRest);
	    	res.next();
	    	name = res.getString(1);
	    	fij = res.getInt(2);
	    	mov = res.getInt(3);
	    	correo = res.getString(4);
	    	desc = res.getString(5);
	    	prop = res.getString(6);
	    	comid = res.getString(7);
	    	pag = res.getString(8);
	    	local = res.getString(9);
	    	prec = res.getInt(10);
	    	
	    	
		} catch (SQLException e) {
			
		}
		 nombre = new JLabel();
		 fijo = new JLabel();
		 movil= new JLabel();
		 email= new JLabel();
		 descripcion= new JLabel();
		 propietario= new JLabel();
		 comida= new JLabel();
		 url= new JLabel();
		 localizacion= new JLabel();
		 precMedio= new JLabel();
    	 
    	 
    	 //añadimos mensaje
		 nombre.setText("Nombre del Restaurante: " + name);
		 fijo.setText("Fijo: " + fij);    // colocamos un texto a la etiqueta
		 movil.setText("Movil: " + mov);    // colocamos un texto a la etiqueta
		 email.setText("Email: " + correo);    // colocamos un texto a la etiqueta
		 descripcion.setText("Descripcion: " + desc );    // colocamos un texto a la etiqueta
		 propietario.setText("Propietario: " + prop);    // colocamos un texto a la etiqueta
		 comida.setText("Comida: " + comid);    // colocamos un texto a la etiqueta
		 url.setText("URL: " + pag);    // colocamos un texto a la etiqueta
		 localizacion.setText("Localizacion: " + local);    // colocamos un texto a la etiqueta
		 precMedio.setText("Precio Medio: " + prec);    // colocamos un texto a la etiqueta
    	 
    	 //Configuramos posicion
    	 
		 nombre.setBounds(250, 100, 600, 30);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
		 fijo.setBounds(250, 150, 600, 30); 
		 movil.setBounds(250, 200, 600, 30);
		 email.setBounds(250, 250, 600, 30);
		 descripcion.setBounds(250, 300, 600, 30);
		 propietario.setBounds(250, 350, 600, 30);
		 comida.setBounds(250, 400, 600, 30);
		 url.setBounds(250, 450, 600, 30);
		 localizacion.setBounds(250, 500, 600, 30);
		 precMedio.setBounds(250, 550, 600, 30);


        texto = new JLabel();

        texto.setFont(new Font(texto.getFont().getName(), texto.getFont().getStyle(), 33));        //caja = new JTextField();
        botonReturn = new JButton();

        // configuramos los componentes
        
        texto.setText("Mostar Restaurante");    // colocamos un texto a la etiqueta
        texto.setBounds(250, 50, 600, 50);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)

        botonReturn.setText("Return"); 		    // colocamos un texto al boton
        botonReturn.setBounds(20, 20, 80, 80);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        botonReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				 new primeraVista().setVisible(true);
			     setVisible(false);
				
			}
        });       

        
              // hacemos que el boton tenga una accion y esa accion estara en esta clase
        
        
        
        // adicionamos los componentes a la ventana
        this.add(texto);
        this.add(botonReturn);

        
        //instanciamos los labels
        
        this.add(nombre);
        this.add(propietario);
        this.add(comida);
        this.add(precMedio);
        this.add(email);
        this.add(url);
        this.add(localizacion);
        this.add(fijo);
        this.add(movil);
        this.add(descripcion);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
    }

}