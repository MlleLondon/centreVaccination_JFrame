package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import controleur.User;
import controleur.centreVaccination;

public class vueGenerale extends JFrame implements ActionListener{
	private JPanel panelMenu= new JPanel();
	private JButton btPersonnes= new JButton("Personnes");
	private JButton btCentres= new JButton("Centres");
	private JButton btVaccins= new JButton("Vaccins");
	private JButton btVaccinations= new JButton("Vaccinations");
	private JButton btProfil= new JButton("Mon Profil");
	private JButton btQuitter= new JButton("Quitter");
	
	private static PanelProfil unPanelProfil;
	private static PanelPersonnes unPanelPersonnes;
	private static PanelCentres unPanelCentres= new PanelCentres();
	private static PanelVaccins unPanelVaccins= new PanelVaccins();
	private static PanelVaccinations unPanelVaccinations= new PanelVaccinations();
	
	public vueGenerale(User unUser) {
		this.unPanelProfil= new PanelProfil(unUser);
		this.unPanelPersonnes= new PanelPersonnes(unUser);
		
		this.setTitle("Site enregistrement vaccination");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(224, 240, 227));
		this.setBounds(100, 100, 1200, 700);
		this.setLayout(null);
		
		//Construction du Menu
		this.panelMenu.setBounds(100, 20, 1000, 40);
		this.panelMenu.setBackground(new Color(224, 240, 227));
		//1 ligne 6 colonnes
		this.panelMenu.setLayout(new GridLayout(1, 6));
		this.panelMenu.add(this.btProfil);
		this.panelMenu.add(this.btPersonnes);
		this.panelMenu.add(this.btCentres);
		this.panelMenu.add(this.btVaccins);
		this.panelMenu.add(this.btVaccinations);
		this.panelMenu.add(this.btQuitter);
		this.add(this.panelMenu);
		
		//Rendre les boutons écoutables
		this.btQuitter.addActionListener(this);
		this.btProfil.addActionListener(this);;
		this.btPersonnes.addActionListener(this);;
		this.btCentres.addActionListener(this);;
		this.btVaccins.addActionListener(this);;
		this.btVaccinations.addActionListener(this);
		
		//Insertion des panels
		this.add(unPanelProfil);
		this.add(unPanelPersonnes);
		this.add(unPanelCentres);
		this.add(unPanelVaccins);
		this.add(unPanelVaccinations);
		
		this.setVisible(false);
	}
	
	public static void activerPanel(int choix) {
		unPanelProfil.setVisible(false);
		unPanelPersonnes.setVisible(false);
		unPanelCentres.setVisible(false);
		unPanelVaccins.setVisible(false);
		unPanelVaccinations.setVisible(false);
		switch(choix) {
		case 1: unPanelProfil.setVisible(true); break;
		case 2: unPanelPersonnes.setVisible(true); break;
		case 3: unPanelCentres.setVisible(true); break;
		case 4: unPanelVaccins.setVisible(true); break;
		case 5: unPanelVaccinations.setVisible(true); break;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btQuitter) {
			int retour= JOptionPane.showConfirmDialog(this, "Voulez vous quitter l'application ? ", 
					"Quitter l'application ? " ,JOptionPane.YES_NO_OPTION);
			if(retour==0) {
				this.dispose();
				centreVaccination.gererVueConnexionInscription(true);
			}
		}
		else if(e.getSource()== this.btProfil) {
			activerPanel(1);
		}
		else if(e.getSource()== this.btPersonnes) {
			activerPanel(2);
		}
		else if(e.getSource()== this.btCentres) {
			activerPanel(3);
		}
		else if(e.getSource()== this.btVaccins) {
			activerPanel(4);
		}
		else if(e.getSource()== this.btVaccinations) {
			activerPanel(5);
		}
		
	}
}
