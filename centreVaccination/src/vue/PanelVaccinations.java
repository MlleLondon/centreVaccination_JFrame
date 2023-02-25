package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.C_Centre;
import controleur.C_Personne;
import controleur.C_Vaccin;
import controleur.C_Vaccination;
import controleur.Centre;
import controleur.Date;
import controleur.Personne;
import controleur.Tableau;
import controleur.Vaccin;
import controleur.Vaccination;

public class PanelVaccinations extends PanelPrincipal implements ActionListener{

	//Fenetre principale
	private JPanel panelTable= new JPanel();
	private JTable tableVaccinations;
	private JButton btAjouter= new JButton("Ajouter Vaccinations");
		
	private Tableau unTableau;
	//Options boutons pour JOptionPane choix sur tableau
	private Object[] optionsPane = {"Supprimer", "Modifier", "Annuler"};
	private Date uneDate;
	
	//Fentre d'ajout
	private JFrame newFrame= new JFrame("Ajouter Vaccin");
	private JPanel panelAjout= new JPanel();
	private JButton btAnnuler= new JButton("Annuler");
	private JButton btAjout= new JButton("Ajouter");
	private JTextField txtDescription= new JTextField();
	private JTextField txtDateVacc= new JTextField();
	private JTextField txtHeure= new JTextField();
	private JTextField txtNbDose= new JTextField();
	private JTextField txtTemperature= new JTextField();
	private JTextField txtNomMedecin= new JTextField();
	private JComboBox<String> cbxIdCentre= new JComboBox<String>();
	private JComboBox<String> cbxIdPersonne= new JComboBox<String>();
	private JComboBox<String> cbxIdVaccin= new JComboBox<String>();
	
	private boolean nouvelleFrame=false;
	
	
	
	public PanelVaccinations() {
		super(new Color(224, 240, 227));
		this.txtHeure.setText("00:00");
		
		//Construction du tableau
		this.panelTable.setBounds(50, 50, 900, 300);
		this.panelTable.setBackground(new Color(224, 240, 227));
		this.panelTable.setLayout(null);
		String entetes[]= {"IdVaccin", "Desc", "DateVacc", "Heure", "Nb Dose", "Temperature", "Nom Medecin", "IdCentre", "IdPersonne", "IdVaccin"};
		
		//Instanciation de la classe Tableau
		this.unTableau= new Tableau(this.obtenirVaccinations(), entetes);
		this.tableVaccinations= new JTable(this.unTableau);
		JScrollPane uneScroll= new JScrollPane(this.tableVaccinations);
		uneScroll.setBounds(25, 0, 850, 300);
		this.panelTable.add(uneScroll);
		this.add(this.panelTable);
		//Ajouter le bouton pour ajouter un enregistrement
		this.btAjouter.setBounds(425, 350, 150, 40);
		this.add(this.btAjouter);
		
		
		//Ajout de la frame Formulaire
		this.newFrame.setBounds(300, 100, 400, 500);
		this.newFrame.setBackground(new Color(224, 240, 227));
		this.newFrame.setLayout(null);
		this.panelAjout.setBounds(10, 10, 300, 400);
		this.panelAjout.setLayout(new GridLayout(10,2));
		//1er ligne
		JLabel description= new JLabel("Description: ");
		description.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(description);
		this.panelAjout.add(this.txtDescription);
		//2e ligne
		JLabel dateVacc= new JLabel("Date Vaccination: ");
		dateVacc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(dateVacc);
		this.panelAjout.add(this.txtDateVacc);
		//3e ligne
		JLabel heure= new JLabel("Heure");
		heure.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(heure);
		this.panelAjout.add(this.txtHeure);
		//4e ligne
		JLabel nbDose= new JLabel("Nb Dose: ");
		nbDose.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(nbDose);
		this.panelAjout.add(this.txtNbDose);
		//5e ligne
		JLabel temperature= new JLabel("Température: ");
		temperature.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(temperature);
		this.panelAjout.add(this.txtTemperature);
		//6e ligne
		JLabel nomMedecin= new JLabel("Nom Medecin: ");
		nomMedecin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(nomMedecin);
		this.panelAjout.add(this.txtNomMedecin);
		//7e ligne
		JLabel idCentre= new JLabel("Id Centre: ");
		idCentre.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(idCentre);
		this.panelAjout.add(this.cbxIdCentre);
		//8e ligne
		JLabel idPersonne= new JLabel("Id Personne: ");
		idPersonne.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(idPersonne);
		this.panelAjout.add(this.cbxIdPersonne);
		//9e ligne
		JLabel idVaccin= new JLabel("Id Vaccin: ");
		idVaccin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(idVaccin);
		this.panelAjout.add(this.cbxIdVaccin);
		//10e ligne boutons annuler et ajout
		this.panelAjout.add(this.btAnnuler);
		this.panelAjout.add(this.btAjout);
		
		this.newFrame.setVisible(false);
		this.newFrame.add(this.panelAjout);
		
		this.remplirCbx();
		
		//Rendre le bouton écoutable
		this.btAjouter.addActionListener(this);
		this.btAjout.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		
		//Rendre la JTable en gestion supprime et modif'
		this.tableVaccinations.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int numLigne=0;
				if(e.getClickCount()==1) {
					numLigne=tableVaccinations.getSelectedRow();
					int choice = JOptionPane.showOptionDialog(null,
						    "Que voulez-vous faire ?",
						    "Choix enregistrement",
						    JOptionPane.YES_NO_CANCEL_OPTION,
						    JOptionPane.QUESTION_MESSAGE,
						    null,
						    optionsPane,
						    optionsPane[2]);
					if(choice==JOptionPane.YES_OPTION) {
						//Supprimer
						int idVaccination=Integer.parseInt(unTableau.getValueAt(numLigne, 0)+"");
						//Supprimer dans la BDD
						C_Vaccination.deleteVaccination(idVaccination);
						//Supprimer dans le tableau
						unTableau.supprimerLigne(numLigne);
					}
					else if(choice==JOptionPane.NO_OPTION) {
						//Modifier
						int idVaccination=Integer.parseInt(unTableau.getValueAt(numLigne, 0)+"");
						Vaccination uneVaccination= C_Vaccination.selectWhereVaccination(idVaccination);
						txtDescription.setText(uneVaccination.getDescription());
						txtDateVacc.setText(uneVaccination.getDateVacc());
						txtHeure.setText(uneVaccination.getHeure());
						txtNbDose.setText(uneVaccination.getNbDose()+"");
						txtTemperature.setText(uneVaccination.getTemperature());
						txtNomMedecin.setText(uneVaccination.getNomMedecin());
						btAjout.setText("Modifier");
						
						newFrame.setVisible(true);
						nouvelleFrame=true;
					}
				}
				
			}
		});
	}
	
	
	public static Object[][] obtenirVaccinations(){
		ArrayList<Vaccination> lesVaccinations= C_Vaccination.selectAllVaccinations();
		Object[][] matrice= new Object[lesVaccinations.size()][10];
		int i=0;
		for(Vaccination uneVaccination: lesVaccinations) {
			matrice[i][0]=uneVaccination.getIdVaccination()+"";
			matrice[i][1]=uneVaccination.getDescription();
			matrice[i][2]=uneVaccination.getDateVacc();
			matrice[i][3]=uneVaccination.getHeure();
			matrice[i][4]=uneVaccination.getNbDose()+"";
			matrice[i][5]=uneVaccination.getTemperature();
			matrice[i][6]=uneVaccination.getNomMedecin();
			matrice[i][7]=uneVaccination.getIdCentre()+"";
			matrice[i][8]=uneVaccination.getIdPersonne()+"";
			matrice[i][9]=uneVaccination.getIdVaccin()+"";
			i++;
		}
		return matrice;
	}
	
	public void remplirCbx() {
		this.cbxIdCentre.removeAllItems();
		this.cbxIdPersonne.removeAllItems();
		this.cbxIdVaccin.removeAllItems();
		
		//Remplir cbxCentre
		ArrayList<Centre> lesCentres=C_Centre.selectAllCentres();
		for(Centre unCentre: lesCentres) {
			this.cbxIdCentre.addItem(unCentre.getIdcentre()+"- "+unCentre.getNom());
		}
		
		//Remplir cbxPersonne
		ArrayList<Personne> lesPersonnes=C_Personne.selectAllPersonnes();
		for(Personne unePersonne: lesPersonnes) {
			this.cbxIdPersonne.addItem(unePersonne.getIdpersonne()+"- "+unePersonne.getNom()+" "+unePersonne.getPrenom());
		}
		
		//Remplir cbxVaccin
		ArrayList<Vaccin> lesVaccins=C_Vaccin.selectAllVaccins();
		for(Vaccin unVaccin: lesVaccins) {
			this.cbxIdVaccin.addItem(unVaccin.getIdvaccin()+"- "+unVaccin.getNom());
		}
	}
	
	public void viderChamps() {
		this.txtDescription.setText("");
		this.txtDateVacc.setText("");
		this.txtHeure.setText("00:00");
		this.txtNbDose.setText("");
		this.txtTemperature.setText("");
		this.txtNomMedecin.setText("");
		this.btAjout.setText("Ajouter");
	}
	
	public boolean verificationDate(String date) {
		boolean result=false;
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
		try {
			dateFormat.parse(date);
			result=true;
		}
		catch (ParseException e) {
		    //La date n'est pas dans un format valide
			JOptionPane.showMessageDialog(this, "La date donnée n'est pas au bon format\n(yyyy-mm-dd)",
					"Erreur", JOptionPane.ERROR_MESSAGE);
		}
		
		if(result==true) {
			int year=Integer.parseInt(date.split("-")[0]);
			int month=Integer.parseInt(date.split("-")[1]);
			int day=Integer.parseInt(date.split("-")[2]);
			this.uneDate= new Date(year, month, day);
			//On appelle la méthode verifDate dans la classe Date pour vérifié que la date rentrée est bonne 
			
			if(!uneDate.verifDate(year, month, day)) {
				JOptionPane.showMessageDialog(this, "La date donnée n'est pas correcte");
				return false;
			}
		}
		return true;
	}
	
	public String verificationHeure(String heure) {
		boolean result=false;
		String heureConcat="";
		if(heure.contains(":")) {
			String tab[]=heure.split(":");
			int recupHeures=0, recupMinutes=0;
			try {
				recupHeures=Integer.parseInt(tab[0]);
				recupMinutes=Integer.parseInt(tab[1]);
				result=true;
			}
			catch(NumberFormatException exp) {
				
				heureConcat="False";
				return heureConcat;
			}
			if(result==true) {
				if(recupHeures>0 && recupHeures<24 && recupMinutes>0 && recupMinutes<60) {
					heureConcat= recupHeures+":"+recupMinutes+":00";
				}
				else {
					heureConcat="False";
					return heureConcat;
				}
				
			}
		}
		
		return heureConcat;
	}
	
	public boolean traitement(String mot) {
		String description=this.txtDescription.getText();
		String temperature=this.txtTemperature.getText();
		String nomMedecin=this.txtNomMedecin.getText();
		String heure=this.verificationHeure(this.txtHeure.getText());
		int nbDose=0;
		if(heure.equals("False")) {
			JOptionPane.showMessageDialog(this, "L'heure donnée n'est pas correcte");
		}
		else {
			String dateVacc=this.txtDateVacc.getText();
			
			//On vérifie la dateVacc
			if(this.verificationDate(dateVacc)) {
				//On récupère le nombre de Dose
				try {
					nbDose=Integer.parseInt(this.txtNbDose.getText());
				}
				catch(NumberFormatException exp) {
					JOptionPane.showMessageDialog(this, "Le nombre de dose doit être un entier !");
					return false;
				}
				//On récupère les id
				String chaine=this.cbxIdCentre.getSelectedItem().toString();
				String tab[]=chaine.split("-");
				int idCentre=Integer.parseInt(tab[0]);
				
				chaine=this.cbxIdPersonne.getSelectedItem().toString();
				tab=chaine.split("-");
				int idPersonne=Integer.parseInt(tab[0]);
				
				chaine=this.cbxIdVaccin.getSelectedItem().toString();
				tab=chaine.split("-");
				int idVaccin=Integer.parseInt(tab[0]);
				
				//Traitement données
				if(mot=="Ajouter") {
					if(description.equals("") || temperature.equals("") || nomMedecin.equals("")) {
						JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs !");
						return false;
					}
					else {
						Vaccination uneVaccination= new Vaccination(description, dateVacc, heure, nbDose, temperature, nomMedecin, idCentre, idPersonne, idVaccin);
						
						//On insère dans la BDD
						C_Vaccination.insertVaccination(uneVaccination);
						//On insère dans le tableau
						uneVaccination=C_Vaccination.selectWhereVaccination(description, dateVacc, heure, nbDose, temperature, nomMedecin, idCentre, idPersonne, idVaccin);
						int idVaccination=uneVaccination.getIdVaccination();
						Object[] ligne={idVaccination, description, dateVacc, heure, nbDose, temperature, nomMedecin, idCentre, idPersonne, idVaccin};
						this.unTableau.insererLigne(ligne);
						JOptionPane.showMessageDialog(this, "Insertion réussie !");
					}
				}
				//Modification des données
				else {
					if(description.equals("") || temperature.equals("") || nomMedecin.equals("")) {
						JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs !");
						return false;
					}
					int numLigne=this.tableVaccinations.getSelectedRow();
					int idVaccination=Integer.parseInt(this.unTableau.getValueAt(numLigne, 0)+"");
					
					//On update dans la BDD
					Vaccination uneVaccination= new Vaccination(idVaccination, description, dateVacc, heure, nbDose, temperature, nomMedecin, idCentre, idPersonne, idVaccination);
					C_Vaccination.updateVaccination(uneVaccination);
					
					//On update dans le tableau
					Object[] ligne={idVaccination, description, dateVacc, heure, nbDose, temperature, nomMedecin, idCentre, idPersonne, idVaccin};
					this.unTableau.modifierLigne(numLigne, ligne);
					JOptionPane.showMessageDialog(this, "Modification réussie !");
				}
			}
		}
		
		this.viderChamps();
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btAjouter) {
			this.viderChamps();
			this.newFrame.setVisible(true);
			this.nouvelleFrame=true;
			this.btAjout.setText("Ajouter");
		}
		else if(e.getSource()==this.btAjout && this.btAjout.getText().equals("Ajouter")) {
			boolean result=this.traitement("Ajouter");
			if(result==true) {
				this.newFrame.setVisible(false);
				this.nouvelleFrame=false;
				this.btAjout.setText("Ajouter");
				this.viderChamps();
			}
		}
		else if(e.getSource()==this.btAjout && this.btAjout.getText().equals("Modifier")) {
			boolean result=this.traitement("Modifier");
			if(result==true) {
				this.newFrame.setVisible(false);
				this.nouvelleFrame=false;
				this.btAjout.setText("Ajouter");
				this.viderChamps();
			}
		}
		else if(e.getSource()==this.btAnnuler) {
			this.viderChamps();
			this.newFrame.setVisible(false);
			this.nouvelleFrame=false;
			this.btAjout.setText("Ajouter");
		}
		
	}

}
