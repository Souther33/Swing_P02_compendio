/**
 * Ventana.java
 * 13 nov 2024 9:25:07
 * @author Subhan Muhammad Farman
 */
package swing_c_p02_MuhammadFarmanSubhan;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


/**
 * 
 */
public class Ventana extends JFrame implements ActionListener {
	private JMenuBar miBarra;
	private JMenu archivo, registro, ayuda;
	private JMenuItem salir, altaReservas, bajaReservas, acercaDe;
	private Image miIcono, imagenHotel, imagenHotelEscalada, imagenBotonAlta, imagenBotonAltaEscalada, imagenBotonBaja, imagenBotonBajaEscalada;
	private JLabel labelTitulo, labelTexto, labelImagenHotel;
	private JButton botonAltaReservas, botonBajaReservas;
	private JPanel panelPrincipal;
	
	public Ventana() {
		super("Gestión Hotel South Tower");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit miPantalla = Toolkit.getDefaultToolkit();
		
		Dimension tamanoPantalla = miPantalla.getScreenSize();
		int altoPantalla = tamanoPantalla.height;
		int anchoPantalla = tamanoPantalla.width;
		this.setBounds((anchoPantalla/4), (altoPantalla/4), (anchoPantalla/2), (altoPantalla/2));
		
		panelPrincipal = new JPanel();
	    panelPrincipal.setLayout(new BoxLayout(panelPrincipal, BoxLayout.Y_AXIS));
		
		miIcono = miPantalla.getImage(getClass().getResource("/recursos/icono.png"));
		this.setIconImage(miIcono);
		
		imagenHotel = new ImageIcon(getClass().getResource("/recursos/hotel.jpg")).getImage();
		imagenHotelEscalada = imagenHotel.getScaledInstance(300, 150, Image.SCALE_SMOOTH);
		
		panelPrincipal.setBackground(new Color(179, 179, 204));
		
		crearMenu();
		
		labelTitulo = new JLabel(" Gestión Hotel South Tower ");
		labelTitulo.setFont(new Font("Impact", Font.BOLD, 30));
		labelTitulo.setForeground(new Color(153, 0, 204));
		labelTitulo.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED, Color.WHITE, Color.WHITE, Color.BLACK, Color.BLACK));
		labelTexto = new JLabel("Reserva en nuestro magnifico hotel con vistas hacia el mar y precios asequibles para todo tipo de personas.");
		labelTexto.setFont(new Font("Rubik", Font.PLAIN, 13));
		labelImagenHotel = new JLabel(new ImageIcon(imagenHotelEscalada));
		
		botonAltaReservas = new JButton("Alta Reservas");
		botonAltaReservas.setBackground(new Color(51, 204, 255));
		imagenBotonAlta = new ImageIcon(getClass().getResource("/recursos/alta.png")).getImage();
		imagenBotonAltaEscalada = imagenBotonAlta.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		botonAltaReservas.setIcon(new ImageIcon(imagenBotonAltaEscalada));
	    botonAltaReservas.addActionListener(this);
	    
	    botonBajaReservas = new JButton("Baja Reservas");
	    botonBajaReservas.setBackground(new Color(255, 102, 153));
	    imagenBotonBaja = new ImageIcon(getClass().getResource("/recursos/baja.png")).getImage();
	    imagenBotonBajaEscalada = imagenBotonBaja.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
	    botonBajaReservas.setIcon(new ImageIcon(imagenBotonBajaEscalada));
	    botonBajaReservas.addActionListener(this);
		
		labelTitulo.setAlignmentX(CENTER_ALIGNMENT);
		labelTexto.setAlignmentX(CENTER_ALIGNMENT);
		botonAltaReservas.setAlignmentX(CENTER_ALIGNMENT);
		botonBajaReservas.setAlignmentX(CENTER_ALIGNMENT);
		labelImagenHotel.setAlignmentX(CENTER_ALIGNMENT);
		
		
		panelPrincipal.add(labelTitulo);
		panelPrincipal.add(Box.createVerticalStrut(20));
		panelPrincipal.add(labelImagenHotel);
		panelPrincipal.add(Box.createVerticalStrut(20));
		panelPrincipal.add(labelTexto);
		panelPrincipal.add(Box.createVerticalStrut(20));
		panelPrincipal.add(botonAltaReservas);
		panelPrincipal.add(Box.createVerticalStrut(20));
		panelPrincipal.add(botonBajaReservas);
		this.add(panelPrincipal);
		
		this.setVisible(true);
	}
	
	public void crearMenu() {
		miBarra = new JMenuBar();
		archivo = new JMenu("Archivo");
		archivo.setMnemonic(0);//Al presionar Alt+A, se activa el elemento
		registro = new JMenu("Registro");
		registro.setMnemonic(KeyEvent.VK_A);
		ayuda = new JMenu("Ayuda");
		salir = new JMenuItem("Salir");
		salir.addActionListener(this);
		altaReservas = new JMenuItem("Alta Reservas");
		altaReservas.addActionListener(this);
		bajaReservas = new JMenuItem("Baja Reservas");
		bajaReservas.addActionListener(this);
		acercaDe = new JMenuItem("Acerca de ...");
		acercaDe.addActionListener(this);
		
		archivo.add(salir);
		registro.add(altaReservas);
		registro.add(bajaReservas);
		ayuda.add(acercaDe);
		
		miBarra.add(archivo);
		miBarra.add(registro);
		miBarra.add(ayuda);
		
		this.setJMenuBar(miBarra);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == salir) {
			super.dispose();
		} else if(e.getSource() == altaReservas || e.getSource() == botonAltaReservas) {
			Dialogo claseDialogo = new Dialogo();
			claseDialogo.setVisible(true);
		} else if(e.getSource() == bajaReservas || e.getSource() == botonBajaReservas) {
			JOptionPane.showMessageDialog(null, "Esta opción esta en desarrollo", "En desarrollo", JOptionPane.WARNING_MESSAGE);
		} else if(e.getSource() == acercaDe) {
			JOptionPane.showMessageDialog(null, "Programa desarrollado por: Muhammad Farman Subhan \nAsignatura: Desarrollo de Interfaces \nVersión: 1.0.2", "Información", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
}
