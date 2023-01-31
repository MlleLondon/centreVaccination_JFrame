package vue;
import java.awt.Color;
import javax.swing.JPanel;

public class PanelPrincipal extends JPanel{
	
	
	public PanelPrincipal(Color uneCouleur) {
		this.setBounds(200, 100, 800, 500);
		this.setBackground(uneCouleur);
		this.setLayout(null);
		
		this.setVisible(false);
	}
}
