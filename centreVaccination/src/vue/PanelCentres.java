package vue;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import controleur.Centre;
import controleur.Tableau;

public class PanelCentres extends PanelPrincipal implements ActionListener, KeyListener{
	
	//Fenetre principale
	private JPanel panelTable= new JPanel();
	private JTable tableCentres;
	private JButton btAjouter= new JButton("Ajouter Centre");
	
	private Tableau unTableau;
	private Object[] optionsPane = {"Supprimer", "Modifier", "Annuler"};
	
	//Fenetre ajout
	private JFrame newFrame= new JFrame("Formulaire");
	private JPanel panelAjout= new JPanel();
	private JButton btAnnuler= new JButton("Annuler");
	private JButton btAjout= new JButton("Ajouter");
	private JTextField txtNom= new JTextField();
	private JTextField txtAdresse= new JTextField();
	private JComboBox<String> cbxType= new JComboBox<String>();
	private String[] type= {"1- caserne", "2- hospital", "3- centre mobile", "4- centre temporaire"};
	private int lenght=type.length;
	private JTextField txtCapacite= new JTextField();
	private JTextField txtNbIntervenant= new JTextField();
	private JTextField txtHoraire= new JTextField();
	
	private boolean nouvelleFrame=false;
	
	
	
	
	public PanelCentres() {
		super(new Color(224, 240, 227));
		//Initialisation de la ComboBox
		for(int i=0; i<this.lenght; i++) {
			this.cbxType.addItem(this.type[i]);
		}
		
		//Construction du tableau
		this.panelTable.setBounds(50, 50, 900, 300);
		this.panelTable.setBackground(new Color(224, 240, 227));
		this.panelTable.setLayout(null);
		String entetes[]= {"IdCentre", "Nom", "Adresse", "Type", "Capacité", "Nb Intervenant", "Horaire"};
		
		//Instanciation de la classe Tableau
		this.unTableau= new Tableau(this.obtenirCentres(), entetes);
		this.tableCentres= new JTable(this.unTableau);
		JScrollPane uneScroll= new JScrollPane(this.tableCentres);
		uneScroll.setBounds(25, 0, 850, 300);
		this.panelTable.add(uneScroll);
		this.add(this.panelTable);
		//Ajouter le bouton pour ajouter un enregistrement
		this.btAjouter.setBounds(425, 350, 150, 40);
		this.add(this.btAjouter);
		
		//Ajout d'une frame de formulaire
		this.newFrame.setBounds(300, 100, 400, 500);
		this.newFrame.setBackground(new Color(224, 240, 227));
		this.newFrame.setLayout(null);
		this.panelAjout.setBounds(10, 10, 300, 400);
		this.panelAjout.setLayout(new GridLayout(7, 2));
		//1er ligne
		JLabel nom= new JLabel("Nom: ");
		nom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(nom);
		this.panelAjout.add(this.txtNom);
		//2e ligne
		JLabel adresse= new JLabel("Adresse: ");
		adresse.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(adresse);
		this.panelAjout.add(this.txtAdresse);
		//3e ligne
		JLabel type= new JLabel("Type: ");
		type.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(type);
		this.panelAjout.add(this.cbxType);
		//4e ligne
		JLabel capacite= new JLabel("Capacite: ");
		capacite.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(capacite);
		this.panelAjout.add(this.txtCapacite);
		//5e ligne
		JLabel nbIntervenant= new JLabel("Nb Intervenant: ");
		nbIntervenant.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(nbIntervenant);
		this.panelAjout.add(this.txtNbIntervenant);
		//6e ligne
		JLabel horaire= new JLabel("Horaire: ");
		horaire.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(horaire);
		this.panelAjout.add(this.txtHoraire);
		//7e ligne: Buttons Annuler et Ajouter
		this.panelAjout.add(this.btAnnuler);
		this.panelAjout.add(this.btAjout);
		
		this.newFrame.add(this.panelAjout);
		this.newFrame.setVisible(false);
		
		//Rendre le bouton cliquable
		this.btAjouter.addActionListener(this);
		this.btAjout.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		
		//Rendre la JTable avec gestion de suppression et modification
		this.tableCentres.addMouseListener(new MouseListener() {
			
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
					numLigne=tableCentres.getSelectedRow();
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
						int idCentre=Integer.parseInt(unTableau.getValueAt(numLigne, 0)+"");
						//Supprimer dans la BDD
						C_Centre.deleteCentre(idCentre);
						//Supprimer dans le tableau
						unTableau.supprimerLigne(numLigne);
					}
					else if(choice==JOptionPane.NO_OPTION) {
						//Modifier
						numLigne=tableCentres.getSelectedRow();
						int idCentre=Integer.parseInt(unTableau.getValueAt(numLigne, 0)+"");
						Centre unCentre=C_Centre.selectWhereCentre(idCentre);
						txtNom.setText(unCentre.getNom());
						txtAdresse.setText(unCentre.getAdresse());
						txtCapacite.setText(unCentre.getCapacite()+"");
						txtNbIntervenant.setText(unCentre.getNbIntervenant()+"");
						txtHoraire.setText(unCentre.getHoraire());
						btAjout.setText("Modifier");
						
						newFrame.setVisible(true);
						nouvelleFrame=true;
						
					}
				}
				
			}
		});
	}
	
	public static Object[][] obtenirCentres(){
		ArrayList<Centre> lesCentres=C_Centre.selectAllCentres();
		Object[][] matrice= new Object[lesCentres.size()][7];
		int i=0;
		
		for(Centre unCentre: lesCentres) {
			matrice[i][0]=unCentre.getIdcentre()+"";
			matrice[i][1]=unCentre.getNom();
			matrice[i][2]=unCentre.getAdresse();
			matrice[i][3]=unCentre.getType();
			matrice[i][4]=unCentre.getCapacite()+"";
			matrice[i][5]=unCentre.getNbIntervenant()+"";
			matrice[i][6]=unCentre.getHoraire();
			i++;
		}
		return matrice;
	}
	
	
	public void viderChamps() {
		this.txtNom.setText("");
		this.txtAdresse.setText("");
		this.cbxType.setSelectedIndex(0);
		this.txtCapacite.setText("");
		this.txtNbIntervenant.setText("");
		this.txtHoraire.setText("");
		this.btAjout.setText("Ajouter");
	}
	
	
	
	public boolean traitement(String mot) {
		String nom=this.txtNom.getText();
		String adresse=this.txtAdresse.getText();
		//On récupère le type sélectionner dans la ComboBoxType
		String type=this.cbxType.getSelectedItem().toString();
		String tab[]=type.split("- ");
		type=tab[1];
		int capacite=0;
		int nbIntervenant=0;
		String horaire=this.txtHoraire.getText();
		try {
			capacite=Integer.parseInt(this.txtCapacite.getText());
			nbIntervenant=Integer.parseInt(this.txtNbIntervenant.getText());
		}
		catch(NumberFormatException exp) {
			JOptionPane.showMessageDialog(this, "La capacité et le nombre\n d'intervenant doivent être\n des entiers !",
					"Erreur", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		if(mot=="Ajouter") {
			//On vérifie que tous les champs sont remplis
			if(nom.equals("") || adresse.equals("") || type.equals("") ||
					capacite==0 || nbIntervenant==0 || horaire.equals("") ) {
				JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs");
				return false;
				
			}
			else {
				Centre unCentre= new Centre(nom, adresse, type, capacite, nbIntervenant, horaire);
				
				//On insert dans la BDD
				C_Centre.insertCentre(unCentre);
				unCentre=C_Centre.selectWhereCentre(nom, adresse, type, capacite, nbIntervenant, horaire);
				int idCentre=unCentre.getIdcentre();
				//On insère dans le tableau
				Object[] ligne={idCentre, nom, adresse, type, capacite+"", nbIntervenant+"", horaire};
				unTableau.insererLigne(ligne);
				JOptionPane.showMessageDialog(this, "Insertion réussie !");
			}
		}
		//On modifie un centre déjà existant
		else {
			//On vérifie que tous les champs sont remplis
			if(nom.equals("") || adresse.equals("") || type.equals("") ||
					capacite==0 || nbIntervenant==0 || horaire.equals("") ) {
				JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs");
				return false;
				
			}
			else {
				int numLigne=this.tableCentres.getSelectedRow();
				int idCentre=Integer.parseInt(unTableau.getValueAt(numLigne, 0)+"");
				//On update dans la Bdd
				Centre updateCentre= new Centre(idCentre, nom, adresse, type, capacite, nbIntervenant, horaire);
				C_Centre.updateCentre(updateCentre);
				//On update dans le tableau
				Object[] ligne={idCentre, nom, adresse, type, capacite+"", nbIntervenant+"", horaire};
				unTableau.modifierLigne(numLigne, ligne);
				JOptionPane.showMessageDialog(this,  "Modification réussie !");
			}
		}
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
		else if(e.getSource()==this.btAjout && this.btAjout.getText()=="Ajouter") {
			boolean result=this.traitement("Ajouter");
			if(result==true) {
				this.newFrame.setVisible(false);
				this.nouvelleFrame=false;
				this.viderChamps();
			}
		}
		else if(e.getSource()==this.btAjout && this.btAjout.getText()=="Modifier") {
			boolean result=this.traitement("Modifier");
			if (result==true) {
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar()==KeyEvent.VK_ENTER && this.nouvelleFrame==true) {
			if(this.btAjout.getText()=="Ajouter") {
				boolean result=this.traitement("Ajout");
				if(result==true) {
					this.newFrame.setVisible(false);
					this.nouvelleFrame=false;
					this.viderChamps();
				}
				
			}
			//btAjout=="Modifier"
			else {
				boolean result=this.traitement("Modifier");
				if(result==true) {
					this.newFrame.setVisible(false);
					this.nouvelleFrame=false;
					this.viderChamps();
				}
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
