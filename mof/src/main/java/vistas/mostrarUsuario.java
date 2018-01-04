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
public class mostrarUsuario extends FrameBase2 implements ActionListener {
	 

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel texto;           // etiqueta o texto no editable

    
	private JLabel nombreUsuario;
	private JLabel nombre;
	private JLabel apellido;
	private JLabel telefono;
	private JLabel email;
	private JLabel edad;
	private JLabel sexo;
	private JLabel fechaNac;
	private JLabel comAuton;
	private JLabel provincia;
	private JLabel localidad;
	
	private String userName, name, surName, correo, sex, comAut, provi, local, dateString, gUser = "";
	private int tel,age = 0;
	
	
	
	private JButton botonReturn;          // boton con una determinada accion

    public mostrarUsuario(String gUser) {
        super();                    // usamos el contructor de la clase padre JFrame
        this.gUser = gUser;
        inicializarComponentes();   // inicializamos los atributos o componentes
    }


    private void inicializarComponentes() {
        // creamos los componentes
    	Usuario user = new Usuario();
    	ResultSet us;
		try {
			us = user.mostUsuario(this.gUser);
	    	us.next();
	    	userName = us.getString(1);
	    	name = us.getString(2);
	    	surName = us.getString(3);
	    	tel = us.getInt(4);
	    	correo = us.getString(5);
	    	age = us.getShort(6);
	    	sex = us.getString(7);
	    	dateString = us.getString(8);
	    	comAut = us.getString(9);
	    	provi = us.getString(10);
	    	local = us.getString(11);
	    	
	    	
		} catch (SQLException e) {
			
		}
		 nombreUsuario = new JLabel();
    	 nombre = new JLabel();
    	 apellido= new JLabel();
    	 telefono= new JLabel();
    	 email= new JLabel();
    	 edad= new JLabel();
    	 sexo= new JLabel();
    	 fechaNac= new JLabel();
    	 comAuton= new JLabel();
    	 provincia= new JLabel();
    	 localidad= new JLabel();
    	 
    	 
    	 //añadimos mensaje
    	 nombreUsuario.setText("Nombre de usuario: " + userName);
    	 nombre.setText("Nombre: " + name);    // colocamos un texto a la etiqueta
    	 apellido.setText("Apellidos: " + surName);    // colocamos un texto a la etiqueta
    	 telefono.setText("Telefono: " + tel);    // colocamos un texto a la etiqueta
    	 email.setText("Email: " + correo );    // colocamos un texto a la etiqueta
    	 edad.setText("Edad: " + age);    // colocamos un texto a la etiqueta
    	 sexo.setText("Sexo: " + sex);    // colocamos un texto a la etiqueta
    	 fechaNac.setText("FechaNac: " + dateString);    // colocamos un texto a la etiqueta
    	 comAuton.setText("ComAuton: " + comAut);    // colocamos un texto a la etiqueta
    	 provincia.setText("Provincia: " + provi);    // colocamos un texto a la etiqueta
    	 localidad.setText("Localidad: " + local);    // colocamos un texto a la etiqueta
    	 
    	 //Configuramos posicion
    	 
    	 nombreUsuario.setBounds(250, 100, 600, 30);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
    	 nombre.setBounds(250, 150, 600, 30); 
    	 apellido.setBounds(250, 200, 600, 30);
    	 telefono.setBounds(250, 250, 600, 30);
    	 email.setBounds(250, 300, 600, 30);
    	 edad.setBounds(250, 350, 600, 30);
    	 sexo.setBounds(250, 400, 600, 30);
    	 fechaNac.setBounds(250, 450, 600, 30);
    	 comAuton.setBounds(250, 500, 600, 30);
    	 provincia.setBounds(250, 550, 600, 30);
    	 localidad.setBounds(250, 600, 600, 30);


        texto = new JLabel();

        texto.setFont(new Font(texto.getFont().getName(), texto.getFont().getStyle(), 33));        //caja = new JTextField();
        botonReturn = new JButton();

        // configuramos los componentes
        
        texto.setText("Mostar Usuario");    // colocamos un texto a la etiqueta
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
        
        this.add(nombreUsuario);
        this.add(nombre);
        this.add(apellido);
        this.add(telefono);
        this.add(email);
        this.add(edad);
        this.add(sexo);
        this.add(fechaNac);
        this.add(comAuton);
        this.add(provincia);
        this.add(localidad);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
    }

}