/**
 * Dialogo.java
 * 13 nov 2024 19:19:50
 * @author Subhan Muhammad Farman
 */
package swing_c_p02_MuhammadFarmanSubhan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

/**
 * 
 */
public class Dialogo extends JFrame {
	private Panel1 panel1;
	private Panel2 panel2;
	private Panel3 panel3;
	private Panel4 panel4;
	private JPanel panelPrincipal;
	private JScrollPane scroll;
	public Dialogo() {
		super("Alta Reservas");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		int altoPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		this.setBounds((anchoPantalla/4), (altoPantalla/4), (anchoPantalla/2), (altoPantalla/2));
		
		panelPrincipal = new JPanel();
		panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		
		Image miIcono = miPantalla.getImage(getClass().getResource("/recursos/icono.png"));
		this.setIconImage(miIcono);
		
		//dialogo = new Dialogo();
		
		panel1 = new Panel1();
		panel2 = new Panel2();
		panel3 = new Panel3(panel2);
		panel4 = new Panel4(panel2, panel3);
		scroll = new JScrollPane();
		
		panel1.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
		panel2.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
		panel3.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
		panel4.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
		
		panel1.setPreferredSize(new Dimension(100, 50));
        panel2.setPreferredSize(new Dimension(100, 200));
        panel3.setPreferredSize(new Dimension(100, 300));
        panel4.setPreferredSize(new Dimension(100, 200));
		
		panelPrincipal.add(panel1);
		panelPrincipal.add(Box.createVerticalStrut(10));
		panelPrincipal.add(panel2);
		panelPrincipal.add(Box.createVerticalStrut(10));
		panelPrincipal.add(panel3);
		panelPrincipal.add(Box.createVerticalStrut(10));
		panelPrincipal.add(panel4);
		//panel4.setVisible(true);
		
		panelPrincipal.setBackground(Color.GRAY);
		this.add(panelPrincipal);
		
		scroll.setAutoscrolls(true);
	    getContentPane().add(scroll);
		scroll.setViewportView(panelPrincipal);
		
		this.setVisible(true);
	}

}
