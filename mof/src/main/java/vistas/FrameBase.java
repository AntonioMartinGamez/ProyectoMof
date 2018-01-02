package vistas;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FrameBase extends JFrame {

    public FrameBase() {
        
        initUI();
    }
    
    private void initUI() {
        
        ImageIcon webIcon = new ImageIcon("web.png");

        setIconImage(webIcon.getImage());

        setTitle("Icon");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
        	FrameBase ex = new FrameBase();
            ex.setVisible(true);
        });
    }
}