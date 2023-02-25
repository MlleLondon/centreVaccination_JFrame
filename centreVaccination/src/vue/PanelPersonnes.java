package vue;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import controleur.*;

public class PanelPersonnes extends PanelPrincipal implements ActionListener, KeyListener{

	//Fenetre principale
	private JPanel panelTable= new JPanel();
	private JTable tablePersonnes;
	private JButton btAjouter= new JButton("Ajouter Personne");
	
	private Tableau unTableau;
	private Object[] optionsPane = {"Supprimer", "Modifier", "Annuler"};
	
	//Fenetre d'ajout
	private JFrame newFrame= new JFrame("Formulaire");
	private JPanel panelAjout= new JPanel();
	private JButton btAnnuler= new JButton("Annuler");
	private JButton btAjout= new JButton("Ajouter");
	private JTextField txtNom= new JTextField();
	private JTextField txtPrenom= new JTextField();
	private JTextField txtTel= new JTextField();
	private JTextField txtAdresse= new JTextField();
	private JTextField txtEmail= new JTextField();
	private JTextField txtAge= new JTextField();
	private JTextField txtNumeroSecu= new JTextField();
	
	private boolean nouvelleFrame=false;
	
	
	public PanelPersonnes(User unUser) {
		super(new Color(224, 240, 227));

		
		
		//Construction du panelTable
		this.panelTable.setBounds(50, 50, 900, 300);
		this.panelTable.setBackground(new Color(224, 240, 227));
		this.panelTable.setLayout(null);
		String entetes[]= {"IdPersonne", "Prenom", "Nom", "Tel", "Adresse", "Email", "Age", "Num Sécu"};
		
		//Instanciation de la classe Tableau
		this.unTableau= new Tableau(this.obtenirPersonnes(), entetes);
		this.tablePersonnes= new JTable(this.unTableau);
		JScrollPane uneScroll= new JScrollPane(this.tablePersonnes);
		uneScroll.setBounds(25, 0, 850, 300);
		this.panelTable.add(uneScroll);
		this.add(this.panelTable);
		//Ajouter le bouton d'ajout
		this.btAjouter.setBounds(425, 350, 150, 40);
		this.add(this.btAjouter);
		
		
		//Ajout du frame de formulaire
		this.newFrame.setBounds(300, 100, 400, 500);
		this.newFrame.setBackground(new Color(224, 240, 227));
		this.newFrame.setLayout(null);
		this.panelAjout.setBounds(10, 10, 300, 400);
		this.panelAjout.setLayout(new GridLayout(8, 2));
		//1ere ligne
		JLabel nom= new JLabel("Nom: ");
		nom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(nom);
		this.panelAjout.add(this.txtNom);
		//2e ligne
		JLabel prenom= new JLabel("Prénom: ");
		prenom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(prenom);
		this.panelAjout.add(this.txtPrenom);
		//3e ligne
		JLabel tel= new JLabel("Téléphone: ");
		tel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(tel);
		this.panelAjout.add(this.txtTel);
		//4e ligne
		JLabel adresse= new JLabel("Adresse: ");
		adresse.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(adresse);
		this.panelAjout.add(this.txtAdresse);
		//5e ligne
		JLabel email= new JLabel("Email: ");
		email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(email);
		this.panelAjout.add(this.txtEmail);
		//6e ligne
		JLabel age= new JLabel("Age: ");
		age.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(age);
		this.panelAjout.add(this.txtAge);
		//7e ligne
		JLabel numSecu= new JLabel("Numéro Sécu: ");
		numSecu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(numSecu);
		this.panelAjout.add(this.txtNumeroSecu);
		//8e ligne: Buttons Annuler et Ajouter
		this.panelAjout.add(this.btAnnuler);
		this.panelAjout.add(this.btAjout);
		
		this.newFrame.add(this.panelAjout);
		this.newFrame.setVisible(false);
		
		
		
		//Rendre le bouton cliquable
		this.btAjouter.addActionListener(this);
		this.btAjout.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		
		//Rendre la JTable avec gestion de la suppression d'une ligne
		this.tablePersonnes.addMouseListener(new MouseListener() {
			
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
				if(e.getClickCount()==1){
					numLigne=tablePersonnes.getSelectedRow();
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
						int idPersonne=Integer.parseInt(unTableau.getValueAt(numLigne, 0)+"");
						//Supprimer dans la BDD
						C_Personne.deletePersonne(idPersonne);
						//Supprimer dans le tableau
						unTableau.supprimerLigne(numLigne);
					}
					else if(choice==JOptionPane.NO_OPTION) {
						//Modifier
						int idPersonne=Integer.parseInt(unTableau.getValueAt(numLigne, 0)+"");
						Personne unePersonne= C_Personne.selectWherePersonne(idPersonne);
						txtNom.setText(unePersonne.getPrenom());
						txtPrenom.setText(unePersonne.getNom());
						txtTel.setText(unePersonne.getTel());
						txtAdresse.setText(unePersonne.getAdresse());
						txtEmail.setText(unePersonne.getEmail());
						txtAge.setText(unePersonne.getAge()+"");
						txtNumeroSecu.setText(unePersonne.getNumeroSecu());
						btAjout.setText("Modifier");
						
						newFrame.setVisible(true);;
						nouvelleFrame=true;
					}
				}
				
			}
		});
		
	}
	
	public Object[][] obtenirPersonnes(){
		ArrayList<Personne> lesPersonnes= C_Personne.selectAllPersonnes();
		Object[][] matrice= new Object[lesPersonnes.size()][8];
		int i=0;
		
		
		for(Personne unePersonne: lesPersonnes) {
			matrice[i][0]=unePersonne.getIdpersonne();
			matrice[i][1]=unePersonne.getNom();
			matrice[i][2]=unePersonne.getPrenom();
			matrice[i][3]=unePersonne.getTel();
			matrice[i][4]=unePersonne.getAdresse();
			matrice[i][5]=unePersonne.getEmail();
			matrice[i][6]=unePersonne.getAge();
			matrice[i][7]=unePersonne.getNumeroSecu();
			i++;
		}
		return matrice;
	}
	
	public void viderChamps() {
		this.txtNom.setText("");
		this.txtPrenom.setText("");
		this.txtTel.setText("");
		this.txtAdresse.setText("");
		this.txtEmail.setText("");
		this.txtAge.setText("");
		this.txtNumeroSecu.setText("");
		
	}
	
	
	
	public boolean traitement(String mot) {
		String nom=this.txtNom.getText();
		String prenom=this.txtPrenom.getText();
		String tel=this.txtTel.getText();
		String adresse=this.txtAdresse.getText();
		String email=this.txtEmail.getText();
		String numSecu=this.txtNumeroSecu.getText();
		int age=0;
		//On parse l'age récupéré en entier
		try {
			age=Integer.parseInt(this.txtAge.getText());
		}
		catch(NumberFormatException exp) {
			JOptionPane.showMessageDialog(this, "L'âge doit être un entier");
			return false;
		}
		
		if(mot=="Ajout") {
			//On vérifie que tous les champs sont remplis
			if(nom.equals("") || prenom.equals("") || tel.equals("") || 
					adresse.equals("") || email.equals("") || numSecu.equals("") || 
					age==0) {
				JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs");
				return false;
				
			}
			else if(age<18) {
				JOptionPane.showMessageDialog(this, "La personne doit être majeure");
				return false;
			}
			else {
				Personne unePersonne= new Personne(nom, prenom, tel, adresse, email, numSecu, age);
				C_Personne.insertPersonne(unePersonne);
				unePersonne=C_Personne.selectWherePersonne(nom, prenom, tel, adresse, email, numSecu, age);
				int idPersonne=unePersonne.getIdpersonne();
				Object[] ligne= {idPersonne, prenom, nom, tel, adresse, email, age, numSecu};
				unTableau.insererLigne(ligne);
				JOptionPane.showMessageDialog(this, "Insertion effectuée avec succès !");
			}
		}
		//On modifie une personne déjà existante
		else {
			//On vérifie que tous les champs sont remplis
			if(nom.equals("") || prenom.equals("") || tel.equals("") || 
					adresse.equals("") || email.equals("") || numSecu.equals("") || 
					age==0) {
				JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs");
				
				return false;
				
			}
			else if(age<18) {
				JOptionPane.showMessageDialog(this, "La personne doit être majeure");
				return false;
			}
			else {
				//On récupère l'Id
				int numLigne=this.tablePersonnes.getSelectedRow();
				int idPersonne= (int) unTableau.getValueAt(numLigne, 0);
				//On update la personne dans la Bdd
				Personne updatePersonne= new Personne(idPersonne, nom, prenom, tel, adresse, email, numSecu, age);
				C_Personne.updatePersonne(updatePersonne);
				
				//On update le tableau
				Object[] ligne= {idPersonne, prenom, nom, tel, adresse, email, age, numSecu};
				unTableau.modifierLigne(numLigne, ligne);
				JOptionPane.showMessageDialog(this, "Modification réussie !");
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
			boolean result=this.traitement("Ajout");
			if(result==true) {
				this.newFrame.setVisible(false);
				this.nouvelleFrame=false;
				this.viderChamps();
			}
			

		}
		else if(e.getSource()==this.btAjout && this.btAjout.getText()=="Modifier") {
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
