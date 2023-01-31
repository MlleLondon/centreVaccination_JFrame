package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controleur.C_Personne;
import controleur.C_User;
import controleur.Personne;
import controleur.User;
import controleur.centreVaccination;

public class PanelPersonnes extends PanelPrincipal implements ActionListener{

	
	private JPanel panelTable= new JPanel();
	private JTable tablePersonnes;
	private JButton btAjouter= new JButton("Ajouter");
	private User unUtilisateur;
	
	
	public PanelPersonnes(User unUser) {
		super(new Color(224, 240, 227));
		//On veut les données de l'utilisateur connecté
		this.unUtilisateur=unUser;
		
		
		//Construction du panelTable
		this.panelTable.setBounds(20, 50, 800, 300);
		this.panelTable.setBackground(new Color(224, 240, 227));
		this.panelTable.setLayout(null);
		String entetes[]= {"IdPersonne", "Prenom", "Nom", "Tel", "Adresse", "Email", "Age"};
		this.tablePersonnes= new JTable(this.obtenirPersonnes(), entetes);
		JScrollPane uneScroll= new JScrollPane(this.tablePersonnes);
		uneScroll.setBounds(0, 0, 750, 300);
		this.panelTable.add(uneScroll);
		this.add(this.panelTable);
		
		//Ajouter le bouton d'ajout
		this.btAjouter.setBounds(350, 350, 100, 30);
		this.add(this.btAjouter);
		
		//Rendre le bouton cliquable
		this.btAjouter.addActionListener(this);
		
	}
	
	public Object[][] obtenirPersonnes(){
		ArrayList<Personne> lesPersonnes= C_Personne.selectAllPersonnes();
		Object[][] matrice= new Object[lesPersonnes.size()][7];
		int i=0;
		for(Personne unePersonne: lesPersonnes) {
			matrice[i][0]=unePersonne.getIdpersonne();
			matrice[i][1]=unePersonne.getNom();
			matrice[i][2]=unePersonne.getPrenom();
			matrice[i][3]=unePersonne.getTel();
			matrice[i][4]=unePersonne.getAdresse();
			matrice[i][5]=unePersonne.getEmail();
			matrice[i][6]=unePersonne.getAge();
			i++;
		}
		return matrice;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btAjouter) {
			centreVaccination.gererVueAjoutPersonne(true, unUtilisateur);
		}
		
	}

}
