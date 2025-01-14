/**
 * Panel2.java
 * 14 nov 2024 9:22:02
 * @author Subhan Muhammad Farman
 */
package swing_c_p02_MuhammadFarmanSubhan;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 * 
 */
public class Panel2 extends JPanel implements FocusListener {
	private JLabel labelNombre, labelApellidos, labelDni, labelTelefono, labelFechaEntrada, labelFechaSalida, labelDias;
	private JTextField textoNombre, textoApellidos, textoDias;
	private JFormattedTextField textoDni, textoTelefono, textoFechaEntrada, textoFechaSalida;
	
	private GridBagLayout layout;
	private GridBagConstraints constraints;
	private MaskFormatter mascaraDni, mascaraTelefono;

	public Panel2() {
		layout = new GridBagLayout();
		this.setLayout(layout);
		constraints = new GridBagConstraints();
		
		labelNombre = new JLabel("Introduce tu nombre: ");
		labelApellidos = new JLabel("Introduce tus apellidos: ");
		labelDni = new JLabel("Introduce tu DNI: ");
		labelTelefono = new JLabel("Introduce tu teléfono: ");
		labelFechaEntrada = new JLabel("Fecha de entrada: ");
		labelFechaSalida = new JLabel("Fecha de salida: ");
		labelDias = new JLabel("Número de dias estancia: ");
		
		textoNombre = new JTextField();
		textoApellidos = new JTextField();
		textoDni = new JFormattedTextField();
		textoTelefono = new JFormattedTextField();
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		textoFechaEntrada = new JFormattedTextField(formatoFecha);
		textoFechaEntrada.setValue(new Date());
		textoFechaEntrada.addFocusListener(this);
		
		
		textoFechaSalida = new JFormattedTextField(formatoFecha);
		Date dt = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(dt); 
		c.add(Calendar.DATE, 1);
		dt = c.getTime();
		textoFechaSalida.setValue(dt);
		textoFechaSalida.addFocusListener(this);
		
		textoDias = new JTextField();
		textoDias.setEnabled(false);
		
		try {
			mascaraDni = new MaskFormatter("########?");
			textoDni = new JFormattedTextField(mascaraDni);
			textoDni.setFocusLostBehavior(textoDni.COMMIT);
			
			mascaraTelefono = new MaskFormatter("#########");
			textoTelefono = new JFormattedTextField(mascaraTelefono);
			textoTelefono.setFocusLostBehavior(textoTelefono.COMMIT);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		
		//labelNombre.setFont(new Font("Impact", Font.BOLD, 30));
		//labelNombre.setForeground(new Color(153, 0, 204));
		
		this.setBackground(Color.CYAN);

		
		addComponent(labelNombre, 0, 0, 1, 1, 1, 1);
		addComponent(textoNombre, 1, 0, 1, 1, 1, 1);
		addComponent(labelApellidos, 0, 1, 1, 1, 1, 1);
		addComponent(textoApellidos, 1, 1, 1, 1, 1, 1);
		addComponent(labelDni, 0, 2, 1, 1, 1, 1);
		addComponent(textoDni, 1, 2, 1, 1, 1, 1);
		addComponent(labelTelefono, 0, 3, 1, 1, 1, 1);
		addComponent(textoTelefono, 1, 3, 1, 1, 1, 1);
		addComponent(labelFechaEntrada, 0, 4, 1, 1, 1, 1);
		addComponent(textoFechaEntrada, 1, 4, 1, 1, 1, 1);
		addComponent(labelFechaSalida, 0, 5, 1, 1, 1, 1);
		addComponent(textoFechaSalida, 1, 5, 1, 1, 1, 1);
		addComponent(labelDias, 0, 6, 1, 1, 1, 1);
		addComponent(textoDias, 1, 6, 1, 1, 1, 1);
		
		this.setVisible(true);
		
	}
	
	private void addComponent(Component component, int column, int row, int width, int height, int weightx, int weighty) {
		 constraints.gridx = column;
		 constraints.gridy = row;
		 constraints.gridwidth = width;
		 constraints.gridheight = height;
		 constraints.weightx = weightx;
		 constraints.weighty = weighty;
		 constraints.fill = GridBagConstraints.BOTH;
		 constraints.insets = new Insets(0, 50, 0, 50);
		 layout.setConstraints(component, constraints );
		 this.add(component);
	}


	@Override
	public void focusGained(FocusEvent e) {
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		
		try {
	        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

	        Date fechaEntrada = formatoFecha.parse(textoFechaEntrada.getText());
	        Date fechaSalida = formatoFecha.parse(textoFechaSalida.getText());

	        LocalDate localFechaEntrada = fechaEntrada.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();
	        LocalDate localFechaSalida = fechaSalida.toInstant().atZone(java.time.ZoneId.systemDefault()).toLocalDate();

	        long diasEstancia = ChronoUnit.DAYS.between(localFechaEntrada, localFechaSalida);
	        
	        if (diasEstancia < 0) {
	        	textoDias.setText("Error: el formato es incorrecto");
	        } else {
	        	textoDias.setText(String.valueOf(diasEstancia));
	        }
	        
	    } catch (ParseException ex) {
	        textoDias.setText("Error: el formato es incorrecto");
	        ex.printStackTrace();
	    }
		
	}

	
	public JTextField getTextoNombre() {
		return textoNombre;
	}
	
	public JTextField getTextoApellidos() {
		return textoApellidos;
	}
	
	public JTextField getTextoDni() {
		return textoDni;
	}
	
	public JFormattedTextField getTextoTelefono() {
		return textoTelefono;
	}
	
	public JTextField getTextoFechaEntrada() {
		return textoFechaEntrada;
	}
	
	public JTextField getTextoFechaSalida() {
		return textoFechaSalida;
	}
	
	public JTextField getTextoDias() {
		return textoDias;
	}
	
}
