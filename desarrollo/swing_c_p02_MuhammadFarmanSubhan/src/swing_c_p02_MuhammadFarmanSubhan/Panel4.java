/**
 * Panel4.java
 * 14 nov 2024 9:22:24
 * @author Subhan Muhammad Farman
 */
package swing_c_p02_MuhammadFarmanSubhan;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 * 
 */
public class Panel4 extends JPanel implements ActionListener {
	private JPanel panelPestana1, panelPestana2;
	private JTabbedPane pestanas;
	private JButton botonImprimir, botonNuevo, botonGuardar;
	private JTextArea areaTextoPanel1, areaTextoPanel2;
	private Panel2 panel2;
	private Panel3 panel3;
	private String textoNombre, textoApellidos, textoDni, textoTelefono, textoFechaEntrada, textoFechaSalida, textoDias, textoCombo, textoSpinnerHabitaciones, textoSpinnerNinos, textoImporte, textoExtras;
	private Image imagenBotonImprimir, imagenBotonImprimirEscalada, imagenBotonNuevo, imagenBotonNuevoEscalada, imagenBotonGuardar, imagenBotonGuardarEscalada;
	
	public Panel4(Panel2 panel2, Panel3 panel3) {
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		this.panel2 = panel2;
		this.panel3 = panel3;
		
		textoCombo = panel3.getCombo().getItemAt(1);
		
	    componentesPanel1();
		componentesPanel2();
		
		pestanas = new JTabbedPane();
		
		botonImprimir = new JButton("Imprimir");
		botonImprimir.setBackground(new Color(255, 221, 204));
		imagenBotonImprimir = new ImageIcon(getClass().getResource("/recursos/imprimir.png")).getImage();
		imagenBotonImprimirEscalada = imagenBotonImprimir.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		botonImprimir.setIcon(new ImageIcon(imagenBotonImprimirEscalada));
		botonImprimir.addActionListener(this);
		
		botonNuevo = new JButton("Nuevo");
		botonNuevo.setBackground(new Color(204, 255, 255));
		imagenBotonNuevo = new ImageIcon(getClass().getResource("/recursos/nuevo.png")).getImage();
		imagenBotonNuevoEscalada = imagenBotonNuevo.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		botonNuevo.setIcon(new ImageIcon(imagenBotonNuevoEscalada));
		botonNuevo.addActionListener(this);
		
		botonGuardar = new JButton("Guardar");
		botonGuardar.setBackground(new Color(255, 204, 255));
		imagenBotonGuardar = new ImageIcon(getClass().getResource("/recursos/guardar.png")).getImage();
		imagenBotonGuardarEscalada = imagenBotonGuardar.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		botonGuardar.setIcon(new ImageIcon(imagenBotonGuardarEscalada));
		botonGuardar.addActionListener(this);
		
		pestanas.addTab ("Datos Cliente", panelPestana1);
		pestanas.addTab ("Datos Habitación", panelPestana2);
		
		this.setBackground(Color.YELLOW);
		
		this.add(pestanas);
		this.add(Box.createHorizontalStrut(10));
		this.add(botonImprimir);
		this.add(Box.createHorizontalStrut(10));
		this.add(botonNuevo);
		this.add(Box.createHorizontalStrut(10));
		this.add(botonGuardar);
		this.add(Box.createHorizontalStrut(10));
		
		this.setVisible(true);
	}

	private void componentesPanel1() {
		panelPestana1 = new JPanel();
		panelPestana1.setLayout(new BoxLayout(panelPestana1, BoxLayout.Y_AXIS));
		
		areaTextoPanel1 = new JTextArea();
		
		panelPestana1.add(areaTextoPanel1);
		
	}

	private void componentesPanel2() {
		panelPestana2 = new JPanel();
		panelPestana2.setLayout(new BoxLayout(panelPestana2, BoxLayout.Y_AXIS));
		
		areaTextoPanel2 = new JTextArea();
		
		panelPestana2.add(areaTextoPanel2);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		textoNombre = panel2.getTextoNombre().getText();
		textoApellidos = panel2.getTextoApellidos().getText();
		textoDni = panel2.getTextoDni().getText();
		textoTelefono = panel2.getTextoTelefono().getText();
		textoFechaEntrada = panel2.getTextoFechaEntrada().getText();
		textoFechaSalida = panel2.getTextoFechaSalida().getText();
		textoDias = panel2.getTextoDias().getText();
		
		textoCombo = panel3.getCombo().getSelectedItem().toString();
		textoSpinnerHabitaciones = panel3.getSpinnerHabitaciones().getValue().toString();
		textoSpinnerNinos = panel3.getSpinnerNinos().getValue().toString();
		textoExtras = panel3.getTextoExtras().getText();
		textoImporte = panel3.getTextoImporte().getText();
		
		if(e.getSource() == botonImprimir) {
			if(comprobarDatos()) {
				areaTextoPanel1.setText("Nombre: " + textoNombre +
						"\nApellidos: " + textoApellidos + 
						"\nDni: " + textoDni +
						"\nTeléfono: " + textoTelefono +
						"\nFecha Entrada: " + textoFechaEntrada +
						"\nFecha Salida: " + textoFechaSalida +
						"\nDias: " + textoDias);

				areaTextoPanel2.setText("Tipo de habitación: " + textoCombo +
						"\nNúmero de habitaciones: " + textoSpinnerHabitaciones + 
						"\nEdad de niños: " + textoSpinnerNinos +
						"\nTipo de cama: " + textoExtras +
						"\nImporte: " + textoImporte);
			} else {
				areaTextoPanel1.setText("Error: el formato de los datos es incorrecto");
				areaTextoPanel2.setText("Error: el formato de los datos es incorrecto");
			}
			
			
		} else if(e.getSource() == botonNuevo) {
			panel2.getTextoNombre().setText("");
			panel2.getTextoNombre().requestFocus();
			panel2.getTextoApellidos().setText("");
			panel2.getTextoDni().setText("");
			panel2.getTextoTelefono().setText("");
			panel2.getTextoFechaEntrada().setText("" + LocalDate.now());
			panel2.getTextoFechaSalida().setText("" + LocalDate.now().plusDays(1));
			panel2.getTextoDias().setText("");
			
			panel3.getCombo().setSelectedIndex(0);
			panel3.getSpinnerHabitaciones().setValue(0);
			panel3.getSpinnerNinos().setValue(0);
			panel3.getTextoExtras().setText("");
			panel3.getTextoImporte().setText("Calculando");
			 
			areaTextoPanel1.setText("");
			areaTextoPanel2.setText("");
		} else if(e.getSource() == botonGuardar) {
			if(areaTextoPanel1.getText().matches("Error: el formato de los datos es incorrecto")) {
				JOptionPane.showMessageDialog(null, "El formato de los datos es incorrecto", "Error", JOptionPane.ERROR_MESSAGE);
			} else if(areaTextoPanel1.getText().matches("")) {
				JOptionPane.showMessageDialog(null, "El area de texto no tiene datos para guardar", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				JOptionPane.showMessageDialog(null, "Datos guardados correctamente", "Guardado", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		
	}
	
	public boolean comprobarDatos() {
		return !panel2.getTextoNombre().getText().matches("") &&
				!panel2.getTextoApellidos().getText().matches("") &&
				(panel2.getTextoDni().getText().trim().length() == 9) &&
				(panel2.getTextoTelefono().getText().trim().length() == 9);
	}
	
	

}
