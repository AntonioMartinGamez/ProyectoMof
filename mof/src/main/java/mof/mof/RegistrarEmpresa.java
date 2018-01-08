package mof.mof;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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

/**
 * Clase Ventana
 * Muestra la estructuta que deberia tener una Ventana en Java con la libreria
 * Swing, contiene una etiqueta, un caja de texto y un boton, que tiene la
 * accion de mostrar el texto en la caja por una ventana de mensaje.
 * @author Daniel Alvarez (a3dany)
 */
public class RegistrarEmpresa extends JFrame implements ActionListener {

	/**
	 * 
	 * "INSERT INTO restaurante "
				+ "(nombre, fijo, movil, email, descripcion, propietario, comida, url, localizacion, precMedio, foto) "
			
		
	 * 
	 * 
	 */
	private static final long serialVersionUID = -974237888149158577L;
	private JLabel nombre;           // etiqueta o texto no editable
	private JLabel fijo;
	private JLabel movil;
	private JLabel email;
	private JLabel descripcion;
	private JLabel propietario;
	private JLabel comida;
	private JLabel url;
	private JLabel localizacion;
	private JLabel precMedio;
	private JLabel foto;
	

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
	
    private JButton boton;          // boton con una determinada accion
    private JLabel text2;
    private static JRadioButton check1;
    private static JRadioButton check2;
    
    public static String msg;
    
    
    public RegistrarEmpresa() throws SQLException {
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
        nombre = new JLabel();
        fijo = new JLabel();
    	movil = new JLabel();
    	email = new JLabel();
    	descripcion = new JLabel();
    	propietario = new JLabel();
        comida = new JLabel();
        url = new JLabel();
        localizacion = new JLabel();
        precMedio = new JLabel();
    	foto = new JLabel();  	

    	
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
    	// ----------------------------------
        
        
        
        
        // configuramos los componentes
        //"(nombre, fijo, movil, email, descripcion, propietario, comida, url, localizacion, precMedio, foto) "
        nombre.setText("Nombre de Empresa");    // colocamos un texto a la etiqueta
        nombre.setBounds(31, 50, 160, 25);   // colocamos posicion y tamanio al texto (x, y, ancho, alto)
        fijo.setText("Telefono Fijo");    
        fijo.setBounds(31, 90, 100, 25);
        movil.setText("Telefono Movil");    
        movil.setBounds(31, 130, 100, 25);
        email.setText("Email");    
        email.setBounds(31, 170, 100, 25);
        descripcion.setText("Descripcion");    
        descripcion.setBounds(31, 210, 100, 25);
        propietario.setText("Propietario");    
        propietario.setBounds(31, 250, 100, 25);
        comida.setText("Comida");    
        comida.setBounds(31, 290, 160, 25);
        url.setText("URL");    
        url.setBounds(31, 330, 100, 25);
        localizacion.setText("Localizacion");
        localizacion.setBounds(31, 370, 100, 25);
        precMedio.setText("Precio Medio");    
        precMedio.setBounds(31, 410, 100, 25);
        foto.setText("Foto");    
        foto.setBounds(31, 450, 100, 25);


        
        
        
        
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
        
  
        
        
        
        
        
        boton.setText("Registrar");   // colocamos un texto al boton
        boton.setBounds(121, 580, 180, 30);  // colocamos posicion y tamanio al boton (x, y, ancho, alto)
        boton.addActionListener(this);      // hacemos que el boton tenga una accion y esa accion estara en esta clase
        
        // adicionamos los componentes a la ventana
        ButtonGroup group = new ButtonGroup();
        group.add(check1);
        group.add(check2);
        check1.setBounds(180,247,40,30);
        check2.setBounds(240,247,40,30);
        text2.setText("Master of Food");  //"Master of Food"
        text2.setBounds(10, 10, 100, 25);
        
      
        
        //"(nombre, fijo, movil, email, descripcion, propietario, comida, url, localizacion, precMedio, foto) "
        this.add(nombre);
        this.add(fijo);
        this.add(movil);
        this.add(email);
        this.add(descripcion);
        this.add(propietario);
        this.add(comida);
        this.add(url);
        this.add(localizacion);
        this.add(precMedio);
        this.add(foto);

        
        this.add(ccomAuton);
        this.add(cprovincia);
        this.add(clocalidad);
        this.add(cfoto);
        this.add(ctelefono);
        this.add(cedad);
        this.add(cnombre);
        this.add(capellidos);
        this.add(cemail);
        this.add(cpass);
        this.add(text2);
        this.add(caja);
        this.add(boton);
        
        
      //etiResultado.setText(mensaje);
        /*
        while(check1.isSelected()== true) {
        	check2.setSelected(false);
      
     //fgggh
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
    	String nombre = caja.getText(); 
        int fijo = Integer.parseInt(cnombre.getText());
        int movil = Integer.parseInt(capellidos.getText());
        String email = cemail.getText();
        String descripcion = cpass.getText();
        String propietario = ccomAuton.getText();
        String comida = cprovincia.getText();
        String url = clocalidad.getText();
        String localizacion = cfoto.getText();
        int precMedio = Integer.parseInt(cedad.getText());
        String foto = ctelefono.getText();
        
       
        
        try {
        	Restaurante.registro(nombre, fijo, movil, email, descripcion, propietario, comida, url, localizacion, precMedio, foto);
			//Usuario.registrar(nombreUsuario, nombre, apellido, telefono, email, edad, sexo, pass ,fec , comAuton, provincia, localidad, foto);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
        JOptionPane.showMessageDialog(this, "Hola " + nombre + ", ha sido registado con exito." );    // mostramos un mensaje (frame, mensaje)
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