package mof.mof;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;

/**
 * Clase Ventana
 * Muestra la estructuta que deberia tener una Ventana en Java con la libreria
 * Swing, contiene una etiqueta, un caja de texto y un boton, que tiene la
 * accion de mostrar el texto en la caja por una ventana de mensaje.
 * @author Daniel Alvarez (a3dany)
 */
public class Registrar extends JFrame implements ActionListener {

	/**
	 */
	private static final long serialVersionUID = -974237888149158577L;
	private JLabel texto;           // etiqueta o texto no editable
	private JLabel nombre;
	private JLabel apellidos;
	private JLabel email;
	private JLabel pass;
	private JLabel comAuton;
	private JLabel provincia;
	private JLabel localidad;
	private JLabel foto;
	private JLabel sex;
	private JLabel telefono;
    private JLabel edad;
	private JLabel fechaNac;
	private JTextField caja;        // caja de texto, para insertar datos
    private JTextField cnombre;
	private JTextField capellidos;
	private JTextField cemail;
	private JTextField cpass;
	
	private JTextField ccomAuton;        // caja de texto, para insertar datos
    private JTextField cprovincia;
	private JTextField clocalidad;
	private JTextField cfoto;
	private JTextField ctelefono;
    private JTextField cedad;
	private JTextField cfechaNac;
	
    private JButton boton;          // boton con una determinada accion
    private JLabel text2;
    private JRadioButton check1;
    private JRadioButton check2;
    
    public String msg;
    
    
    public Registrar() throws SQLException {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();   // inicializamos los atributos o componentes
    }

    private void configurarVentana() {
        this.setTitle("Registro MoF");                   // colocamos titulo a la ventana
        this.setSize(422, 670);                               // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }

    private void inicializarComponentes() throws SQLException {
        // creamos los componentes
        texto = new JLabel();
        nombre = new JLabel();
    	apellidos = new JLabel();
    	email = new JLabel();
    	pass = new JLabel();
    	sex = new JLabel();
        comAuton = new JLabel();
        provincia = new JLabel();
        localidad = new JLabel();
        foto = new JLabel();
    	telefono = new JLabel();
    	edad = new JLabel();
    	fechaNac = new JLabel();    	

    	
    	// ----------------------------------
        caja = new JTextField();
        cnombre = new JTextField();
    	capellidos = new JTextField();
    	cemail = new JTextField();
    	cpass = new  JPasswordField(); 
        ccomAuton = new JTextField();
        cprovincia = new JTextField();
        clocalidad = new JTextField();
        cfoto = new JTextField();
    	ctelefono = new JTextField();
    	cedad = new JTextField();
    	cfechaNac = new JTextField();
    	// ----------------------------------
        boton = new JButton();
        text2 = new JLabel();
        String hom = "H";
        String muj = "M";
        
        check1=new JRadioButton(hom);
        check2=new JRadioButton(muj);
        //check1.setSelected(true);
        
        /*while(msg != "xxx") {*/
	        if (check1.isSelected()) {
	        	msg = hom;
	        }else if(check2.isSelected()) {
	        	msg = muj;
	        }
       /* }*/
        
        
        
        // configuramos los componentes
        texto.setText("Nombre de usuario");    // colocamos un texto a la etiqueta
        texto.setBounds(31, 50, 160, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        nombre.setText("Nombre");    
        nombre.setBounds(31, 90, 100, 25);
        apellidos.setText("Apellidos");    
        apellidos.setBounds(31, 130, 100, 25);
        email.setText("Email");    
        email.setBounds(31, 170, 100, 25);
        pass.setText("Contraseña");    
        pass.setBounds(31, 210, 100, 25);
        sex.setText("Sexo");    
        sex.setBounds(31, 250, 100, 25);
        comAuton.setText("Comunidad Autonoma");    
        comAuton.setBounds(31, 290, 160, 25);
        provincia.setText("Provincia");    
        provincia.setBounds(31, 330, 100, 25);
        localidad.setText("Localidad");
        localidad.setBounds(31, 370, 100, 25);
        foto.setText("Foto");    
        foto.setBounds(31, 410, 100, 25);
        telefono.setText("Telefono");    
        telefono.setBounds(31, 450, 100, 25);
        edad.setText("Edad");    
        edad.setBounds(31, 490, 100, 25);
        
        fechaNac.setText("Fecha de Nacimiento");    
        fechaNac.setBounds(31, 530, 160, 25);
        
        
        
        
        caja.setBounds(180, 50, 200, 25);   // colocamos posicion y tamanio a la caja (x, y, ancho, alto)
        cnombre.setBounds(180, 90, 200, 25);
        capellidos.setBounds(180, 130, 200, 25);
        cemail.setBounds(180, 170, 200, 25);
        cpass.setBounds(180, 210, 200, 25);
        ccomAuton.setBounds(180, 290, 200, 25);   
        cprovincia.setBounds(180, 330, 200, 25);
        clocalidad.setBounds(180, 370, 200, 25);
        cfoto.setBounds(180, 410, 200, 25);  
        ctelefono.setBounds(180, 450, 200, 25);
        cedad.setBounds(180, 490, 200, 25);   
        cfechaNac.setBounds(180, 530, 200, 25);
        
  
        
        
        
        
        
        boton.setText("Registrar");   // colocamos un texto al boton
        boton.setBounds(121, 580, 180, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        boton.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
        
        // adicionamos los componentes a la ventana
        ButtonGroup group = new ButtonGroup();
        group.add(check1);
        group.add(check2);
        check1.setBounds(180,247,40,30);
        check2.setBounds(240,247,40,30);
        text2.setText(msg);  //"Master of Food"
        text2.setBounds(10, 10, 100, 25);
        
      
        
        
        this.add(nombre);
        this.add(apellidos);
        this.add(email);
        this.add(pass);
        this.add(sex);
        this.add(comAuton);
        this.add(provincia);
        this.add(localidad);
        this.add(foto);
        this.add(telefono);
        this.add(edad);
        this.add(fechaNac);

        
        this.add(ccomAuton);
        this.add(cprovincia);
        this.add(clocalidad);
        this.add(cfoto);
        this.add(ctelefono);
        this.add(cedad);
        this.add(cfechaNac);
        this.add(cnombre);
        this.add(capellidos);
        this.add(cemail);
        this.add(cpass);
        this.add(text2);
        this.add(texto);
        this.add(caja);
        this.add(boton);
        this.add(check1);
        this.add(check2);
        
        
      //etiResultado.setText(mensaje);
        /*
        while(check1.isSelected()== true) {
        	check2.setSelected(false);
      
     
       if(check1.isSelected()==true) {
            check2.setSelected(false);
       }else if (check2.isSelected()==true) {
    	   check1.setSelected(false);
       }else {
        
        	check2.setSelected(false);
        	check1.setSelected(false);
        }
       
        }*/
    }
    
    
    /*public void stateChanged(ChangeEvent e) {
        if (check1.isSelected()==true) {
            check2.setSelected(false);
        } else {
        	check2.setSelected(true);
        	check1.setSelected(false);
        }
    }*/
    

    @Override
    public void actionPerformed(ActionEvent e) {
    	// obtenemos el contenido de la caja de texto
    	String nombreUsuario = caja.getText(); 
        String nombre = cnombre.getText();
        String apellido = capellidos.getText();
        String email = cemail.getText();
        String pass = cpass.getText();
        String comAuton = ccomAuton.getText();
        String provincia = cprovincia.getText();
        String localidad = clocalidad.getText();
        String foto = cfoto.getText();
        int edad = Integer.parseInt(cedad.getText());
        int telefono = Integer.parseInt(ctelefono.getText());
        Date fec = Date.valueOf(LocalDate.now());
        String sexo = msg;
        
       
        
        try {
			Usuario.registrar(nombreUsuario, nombre, apellido, telefono, email, edad, sexo, pass ,fec , comAuton, provincia, localidad, foto);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        JOptionPane.showMessageDialog(this, "Hola " + nombre + "  / " + apellido);    // mostramos un mensaje (frame, mensaje)
    }

    public static boolean validarEmailSimple(String email){
        
        String regex = "^(.+)@(.+)$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        
        return matcher.matches();
    }
    public static void main(String[] args) throws SQLException {
        Registrar V = new Registrar();      // creamos una ventana
        V.setVisible(true);             // hacemos visible la ventana creada
    }
}