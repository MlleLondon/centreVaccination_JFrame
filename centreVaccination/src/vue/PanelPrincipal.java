package vue;
import java.awt.Color;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel{
	
	
	public PanelPrincipal(Color uneCouleur) {
		this.setBounds(100, 100, 1000, 500);
		this.setBackground(uneCouleur);
		this.setLayout(null);
		
		this.setVisible(false);
	}
}
