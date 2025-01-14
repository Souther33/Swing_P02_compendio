/**
 * Panel1.java
 * 14 nov 2024 9:21:53
 * @author Subhan Muhammad Farman
 */
package swing_c_p02_MuhammadFarmanSubhan;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 
 */
public class Panel1 extends JPanel {
private JLabel labelTitulo;
	
	public Panel1() {
		labelTitulo = new JLabel("South Tower");
		
		labelTitulo.setFont(new Font("Impact", Font.BOLD, 30));
		labelTitulo.setForeground(new Color(153, 0, 204));
				
		this.setBackground(new Color(179, 179, 204));
				
		this.add(labelTitulo);
				
		this.setVisible(true);
	}

}
