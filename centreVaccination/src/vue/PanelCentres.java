package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class PanelCentres extends PanelPrincipal implements ActionListener, ItemListener{
	
	private JPanel panelForm= new JPanel();
	private JPanel panelTable= new JPanel();
	private JButton btAnnuler= new JButton("Annuler");
	private JButton btEnregistrer= new JButton("Enregistrer");
	private JTextField txtNom= new JTextField();
	private JTextField txtAdresse= new JTextField();
	private JTextField txtHoraire= new JTextField();
	private JTextField txtCapacite= new JTextField();
	private JTextField txtNbIntervenant= new JTextField();
	private JTable tableCentres;
	private JComboBox enumType;
	
	
	public PanelCentres() {
		super(new Color(224, 240, 227));
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
