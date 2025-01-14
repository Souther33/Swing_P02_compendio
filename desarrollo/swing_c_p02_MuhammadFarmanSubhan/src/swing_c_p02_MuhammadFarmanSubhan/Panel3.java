/**
 * Panel3.java
 * 14 nov 2024 9:22:14
 * @author Subhan Muhammad Farman
 */
package swing_c_p02_MuhammadFarmanSubhan;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.MaskFormatter;

/**
 * 
 */
public class Panel3 extends JPanel implements ChangeListener, ActionListener {
	private JLabel labelCombo, labelSpinner, labelCheckbox, labelImporte, labelEdad, labelImagenSimple, labelImagenDoble, labelImagenSuit, labelSimple, labelDoble, labelSuit;
	private JComboBox<String> combo;
	private JSpinner spinnerHabitaciones, spinnerNinos;
	private JCheckBox checkbox;
	private JPanel panelPrincipal1, panelImagenes;
	private JTextField textoImporte, textoExtras;
	private JFormattedTextField textoTelefono, textoFechaEntrada, textoFechaSalida;
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	private MaskFormatter mascaraTelefono;
	private Panel2 panel2;
	private Image imagenSimple, imagenSimpleEscalada, imagenDoble, imagenDobleEscalada, imagenSuit, imagenSuitEscalada;

	public Panel3(Panel2 panel2) {
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		layout = new GridBagLayout();
		panelPrincipal1 = new JPanel(layout);
		constraints = new GridBagConstraints();
		
		
		
		labelCombo = new JLabel("Tipo de habitación: ");
		labelSpinner = new JLabel("Número de habitaciones: ");
		labelCheckbox = new JLabel("Rellena este campo: ");
		labelCheckbox.setVisible(false);
		labelImporte = new JLabel("Importe habitación: ");
		labelEdad = new JLabel("Edad de niños: ");
		
		labelSimple = new JLabel("Habitación Simple");
		labelDoble = new JLabel("Habitación Doble");
		labelSuit = new JLabel("Habitación Suit");
		
		textoImporte = new JTextField();
		textoImporte.setEnabled(false);
		textoExtras = new JTextField();
		textoExtras.setEnabled(false);
		textoTelefono = new JFormattedTextField();
		
		this.panel2 = panel2;
		
		String[] tipo = {"Simple", "Doble", "Suite"};
		combo = new JComboBox<String>(tipo);
		combo.addActionListener(this);
		
		spinnerHabitaciones = new JSpinner(new SpinnerNumberModel(0, 0, 50, 1));
		spinnerHabitaciones.addChangeListener(this);
		
		spinnerNinos = new JSpinner(new SpinnerNumberModel(0, 0, 14, 1));
		spinnerNinos.setEnabled(false);
		spinnerNinos.addChangeListener(this);
		
		checkbox = new JCheckBox("¿Niños?");
		checkbox.addActionListener(this);
		checkbox.setBackground(Color.MAGENTA);
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		textoFechaEntrada = new JFormattedTextField(formatoFecha);
		textoFechaEntrada.setValue(new Date());
		
		
		textoFechaSalida = new JFormattedTextField(formatoFecha);
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		textoFechaSalida.setValue(dt);
		
		try {
			
			mascaraTelefono = new MaskFormatter("#########");
			textoTelefono = new JFormattedTextField(mascaraTelefono);
			textoTelefono.setFocusLostBehavior(textoTelefono.COMMIT);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		crearImagenes();
		
		panelImagenes = new JPanel();
		panelImagenes.setLayout(new BoxLayout(panelImagenes, BoxLayout.X_AXIS));
		panelImagenes.setBackground(Color.MAGENTA);
		panelImagenes.add(labelImagenSimple);
		panelImagenes.add(Box.createHorizontalStrut(10));
		panelImagenes.add(labelImagenDoble);
		panelImagenes.add(Box.createHorizontalStrut(10));
		panelImagenes.add(labelImagenSuit);
		
		
		panelPrincipal1.setBackground(Color.MAGENTA);

		
		addComponent(labelCombo, 0, 0, 1, 1, 1, 1, panelPrincipal1);
		addComponent(combo, 1, 0, 2, 1, 1, 1, panelPrincipal1);
		addComponent(labelSpinner, 0, 1, 1, 1, 1, 1, panelPrincipal1);
		addComponent(spinnerHabitaciones, 1, 1, 2, 1, 1, 1, panelPrincipal1);
		addComponent(checkbox, 0, 2, 1, 1, 1, 1, panelPrincipal1);
		addComponent(labelCheckbox, 1, 2, 2, 1, 1, 1, panelPrincipal1);
		
		addComponent(labelEdad, 0, 3, 1, 1, 1, 1, panelPrincipal1);
		addComponent(spinnerNinos, 1, 3, 1, 1, 1, 1, panelPrincipal1);
		addComponent(textoExtras, 2, 3, 1, 1, 1, 1, panelPrincipal1);
		
		addComponent(labelImporte, 0, 4, 1, 1, 1, 1, panelPrincipal1);
		addComponent(textoImporte, 1, 4, 2, 1, 1, 1, panelPrincipal1);
		
		addComponent(panelImagenes, 0, 5, 3, 1, 1, 1, panelPrincipal1);
		
		addComponent(labelSimple, 0, 6, 1, 1, 1, 1, panelPrincipal1);
		addComponent(labelDoble, 1, 6, 1, 1, 1, 1, panelPrincipal1);
		addComponent(labelSuit, 2, 6, 1, 1, 1, 1, panelPrincipal1);
		
		this.add(panelPrincipal1);
		
		calcularImporte();
		
		
		
		this.setVisible(true);
		
	}

	private void addComponent(Component component, int column, int row, int width, int height, int weightx, int weighty, JPanel panel) {
		 constraints.gridx = column;
		 constraints.gridy = row;
		 constraints.gridwidth = width;
		 constraints.gridheight = height;
		 constraints.weightx = weightx;
		 constraints.weighty = weighty;
		 constraints.fill = GridBagConstraints.BOTH;
		 constraints.insets = new Insets(1, 50, 1, 50);
		 layout.setConstraints(component, constraints );
		 panel.add(component);
	}
	
	private void crearImagenes() {
		imagenSimple = new ImageIcon(getClass().getResource("/recursos/simple.jpg")).getImage();
		imagenSimpleEscalada = imagenSimple.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
		labelImagenSimple = new JLabel(new ImageIcon(imagenSimpleEscalada));
		
		imagenDoble = new ImageIcon(getClass().getResource("/recursos/doble.jpg")).getImage();
		imagenDobleEscalada = imagenDoble.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
		labelImagenDoble = new JLabel(new ImageIcon(imagenDobleEscalada));
		
		imagenSuit = new ImageIcon(getClass().getResource("/recursos/suit.jpg")).getImage();
		imagenSuitEscalada = imagenSuit.getScaledInstance(200, 100, Image.SCALE_SMOOTH);
		labelImagenSuit = new JLabel(new ImageIcon(imagenSuitEscalada));
		
	}
	
	public void calcularImporte() {
		int importe = 0;
		
		if(combo.getSelectedIndex() == 0) {
			importe = 50;
		} else if(combo.getSelectedIndex() == 1) {
			importe = 75;
		} else if(combo.getSelectedIndex() == 2) {
			importe = 125;
		}
		
		
		
		try {
			String dias = panel2.getTextoDias().getText();
			importe = Integer.parseInt(dias) * importe;
			
			if(checkbox.isSelected()) {
				importe = importe + 20;
			}
			
			textoImporte.setText(importe + " €");
        } catch (NumberFormatException e) {
            textoImporte.setText("Calculando");
        }
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int edad;
		
		if (e.getSource() == spinnerNinos) {
			edad = (int) spinnerNinos.getValue();
			if(edad >= 0 && edad <= 3) {
				textoExtras.setText("Cuna");
			} else if(edad >= 4 && edad <= 10) {
				textoExtras.setText("Cama supletoria pequeña");
			} else if(edad >= 11 && edad <= 14) {
				textoExtras.setText("Cama supletoria normal");
			}
		}
		
		calcularImporte();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == checkbox) {
			if(checkbox.isSelected()) {
				labelCheckbox.setVisible(true);
				spinnerNinos.setEnabled(true);
			} else {
				labelCheckbox.setVisible(false);
				spinnerNinos.setEnabled(false);
			}
			
		}
		
		calcularImporte();
		
	}

	public JComboBox<String> getCombo() {
		return combo;
	}

	public JSpinner getSpinnerHabitaciones() {
		return spinnerHabitaciones;
	}

	public JSpinner getSpinnerNinos() {
		return spinnerNinos;
	}
	
	public JTextField getTextoImporte() {
		return textoImporte;
	}
	
	public JTextField getTextoExtras() {
		return textoExtras;
	}

}
