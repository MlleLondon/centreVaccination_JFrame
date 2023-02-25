package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import controleur.C_Vaccin;
import controleur.Tableau;
import controleur.Vaccin;

public class PanelVaccins extends PanelPrincipal implements ActionListener{
	
	//Fenetre principale
	private JPanel panelTable= new JPanel();
	private JTable tableVaccins;
	private JButton btAjouter= new JButton("Ajouter Vaccin");
	
	private Tableau unTableau;
	private Object[] optionsPane = {"Supprimer", "Modifier", "Annuler"};
	
	//Fentre d'ajout
	private JFrame newFrame= new JFrame("Ajouter Vaccin");
	private JPanel panelAjout= new JPanel();
	private JButton btAnnuler= new JButton("Annuler");
	private JButton btAjout= new JButton("Ajouter");
	private JTextField txtNom= new JTextField();
	private JTextField txtLaboratoire= new JTextField();
	private JTextField txtPays= new JTextField();
	private JTextField txtConservation= new JTextField();
	
	private boolean nouvelleFrame=false;
	
	public PanelVaccins() {
		super(new Color(224, 240, 227));
		
		//Construction du tableau
		this.panelTable.setBounds(50, 50, 900, 300);
		this.panelTable.setBackground(new Color(224, 240, 227));
		this.panelTable.setLayout(null);
		String entetes[]= {"IdVaccin", "Nom", "Laboratoire", "Pays", "Conservation"};
		
		//Instanciation de la classe Tableau
		this.unTableau= new Tableau(this.obtenirVaccins(), entetes);
		this.tableVaccins= new JTable(this.unTableau);
		JScrollPane uneScroll= new JScrollPane(this.tableVaccins);
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
		this.panelAjout.setLayout(new GridLayout(5,2));
		//1er ligne
		JLabel nom= new JLabel("Nom: ");
		nom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(nom);
		this.panelAjout.add(this.txtNom);
		//2 ligne
		JLabel laboratoire= new JLabel("Laboratoire: ");
		laboratoire.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(laboratoire);
		this.panelAjout.add(this.txtLaboratoire);
		//3e ligne
		JLabel pays= new JLabel("Pays: ");
		pays.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(pays);
		this.panelAjout.add(this.txtPays);
		//4e ligne
		JLabel conservation= new JLabel("Conservation: ");
		conservation.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(conservation);
		this.panelAjout.add(this.txtConservation);
		//5 ligne ajout boutons annuler et ajout
		this.panelAjout.add(this.btAnnuler);
		this.panelAjout.add(this.btAjout);
		
		this.newFrame.add(this.panelAjout);
		this.newFrame.setVisible(false);
		
		//Rendre le bouton écoutable
		this.btAjouter.addActionListener(this);
		this.btAjout.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		
		
		//Rendre la JTable avec gestion de suppression et modification
		this.tableVaccins.addMouseListener(new MouseListener() {
			
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
					numLigne= tableVaccins.getSelectedRow();
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
						int idVaccin=Integer.parseInt(unTableau.getValueAt(numLigne, 0)+"");
						//Supprimer dans la BDD
						C_Vaccin.deleteVaccin(idVaccin);
						//Supprimer dans le tableau
						unTableau.supprimerLigne(numLigne);
					}
					else if(choice==JOptionPane.NO_OPTION) {
						//Modifier
						int idVaccin=Integer.parseInt(unTableau.getValueAt(numLigne, 0)+"");
						Vaccin unVaccin= C_Vaccin.selectWhereVaccin(idVaccin);
						txtNom.setText(unVaccin.getNom());
						txtLaboratoire.setText(unVaccin.getLaboratoire());
						txtPays.setText(unVaccin.getPays());
						txtConservation.setText(unVaccin.getConservation());
						btAjout.setText("Modifier");
						
						newFrame.setVisible(true);
						nouvelleFrame=true;
					}
				}
				
			}
		});
		
		
	}
	
	public static Object[][] obtenirVaccins(){
		ArrayList<Vaccin> lesVaccins= C_Vaccin.selectAllVaccins();
		Object[][] matrice= new Object[lesVaccins.size()][5];
		
		int i=0;
		for(Vaccin unVaccin: lesVaccins) {
			matrice[i][0]= unVaccin.getIdvaccin()+"";
			matrice[i][1]= unVaccin.getNom();
			matrice[i][2]= unVaccin.getLaboratoire();
			matrice[i][3]= unVaccin.getPays();
			matrice[i][4]= unVaccin.getConservation();
			i++;
		}
		return matrice;		
	}
	
	public void viderChamps() {
		this.txtNom.setText("");
		this.txtLaboratoire.setText("");
		this.txtPays.setText("");
		this.txtConservation.setText("");
		this.btAjout.setText("Ajouter");
	}
	
	public boolean traitement(String mot) {
		String nom=this.txtNom.getText();
		String laboratoire= this.txtLaboratoire.getText();
		String conservation= this.txtConservation.getText();
		String pays=this.txtPays.getText();
		if(mot=="Ajouter") {
			if(nom.equals("") || laboratoire.equals("") || conservation.equals("") || pays.equals("")) {
				JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs !");
				return false;
			}
			else {
				Vaccin unVaccin= new Vaccin(nom, laboratoire, pays, conservation);
				
				//On insère dans la BDD
				C_Vaccin.insertVaccin(unVaccin);
				unVaccin= C_Vaccin.selectWhereVaccin(nom, laboratoire, pays, conservation);
				int idVaccin=unVaccin.getIdvaccin();
				//On insère dans le tableau
				Object[] ligne= {idVaccin, nom, laboratoire, pays, conservation};
				unTableau.insererLigne(ligne);
				JOptionPane.showMessageDialog(this, "Insertion réussie !");
			}
		}
		
		//On modifie un vaccin déjà existant
		else {
			if(nom.equals("") || laboratoire.equals("") || conservation.equals("") || pays.equals("")) {
				JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs !");
				return false;
			}
			else {
				int numLigne=this.tableVaccins.getSelectedRow();
				int idVaccin= Integer.parseInt(this.unTableau.getValueAt(numLigne, 0)+"" );
				//On update dans la BDD
				Vaccin unVaccin= new Vaccin(idVaccin, nom, laboratoire, pays, conservation);
				C_Vaccin.updateVaccin(unVaccin);
				//On update dans le tableau
				Object[] ligne= {idVaccin, nom, laboratoire, pays, conservation};
				this.unTableau.modifierLigne(numLigne, ligne);
				JOptionPane.showMessageDialog(this, "Modification réussie !");
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
