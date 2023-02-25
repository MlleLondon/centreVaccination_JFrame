package vue;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controleur.C_User;
import controleur.User;
import controleur.centreVaccination;

public class vueConnexionInscription extends JFrame implements ActionListener, KeyListener{
	//Partie Connexion
	private JButton btAffichCon= new JButton("Se connecter");
	private JTextField txtEmailCon= new JTextField();
	private JPasswordField txtMdpCon= new JPasswordField();
	private JButton btSeConnecter= new JButton("Connexion");
	private JButton btAnnulerCon=new JButton("Annuler");
	private JPanel panelCon=new JPanel();
	
	//Partie Inscription
	private JButton btAffichInsc= new JButton("S'inscrire");
	private JTextField txtNomInsc= new JTextField();
	private JTextField txtPrenomInsc= new JTextField();
	private JTextField txtEmailInsc= new JTextField();
	private JPasswordField txtMdpInsc= new JPasswordField();
	private JButton btInscrire= new JButton("Inscription");
	private JButton btAnnulerInsc=new JButton("Annuler");
	private JPanel PanelInscr=new JPanel();
	//Visibilité Connexion ou Inscription
	private boolean visibleCon=false, visibleInscr=false;
	
	public vueConnexionInscription() {
		this.setTitle("Connexion / Inscription");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(224, 240, 227) );
		this.setBounds(200, 200, 700, 450);
		this.setLayout(null);
		
		//On mets en place les boutons pour savoir si on se connecte ou s'inscrit
		
		this.add(this.btAffichCon);
		this.btAffichCon.setBounds(150, 20, 150, 30);
		this.add(this.btAffichInsc);
		this.btAffichInsc.setBounds(400, 20, 150, 30);
		
		
		//Construction du panel connexion
		this.panelCon.setBounds(200, 100, 200, 125);
		this.panelCon.setBackground(new Color(224, 240, 227));
		//3 lignes sur 2 colonnes
		this.panelCon.setLayout(new GridLayout(3, 2));
		//Premiere grille ligne 1 colonne 1 on met l'email
		JLabel email= new JLabel("Email: ");
		email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelCon.add(email);
		this.panelCon.add(this.txtEmailCon);
		//Premiere grille ligne 1 colonne 2 on met le mdp
		JLabel mdp= new JLabel("Mot de passe: ");
		mdp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelCon.add(mdp);
		this.panelCon.add(this.txtMdpCon);
		//Premiere grille ligne 2 colonne 1 on met le boutton Annuler
		this.panelCon.add(this.btAnnulerCon);
		//Premiere grille ligne 2 colonne 2 on met le boutton Se Connecter
		this.panelCon.add(this.btSeConnecter);
		this.add(this.panelCon);
		//Par défaut il n'est pas visible
		this.panelCon.setVisible(false);
		
		//Construction du panel d'inscription
		this.PanelInscr.setBounds(200, 100, 200, 200);
		this.PanelInscr.setBackground(new Color(224, 240, 227));
		//3 lignes sur 2 colonnes
		this.PanelInscr.setLayout(new GridLayout(5, 2));
		
		//Ligne 1
		JLabel nom= new JLabel("Nom: ");
		nom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.PanelInscr.add(nom);
		this.PanelInscr.add(this.txtNomInsc);
		//Ligne 2
		JLabel prenom= new JLabel("Prénom: ");
		prenom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.PanelInscr.add(prenom);
		this.PanelInscr.add(this.txtPrenomInsc);
		//Ligne 3
		JLabel emailInsc= new JLabel("Email: ");
		emailInsc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.PanelInscr.add(emailInsc);
		this.PanelInscr.add(this.txtEmailInsc);
		//Ligne 4
		JLabel mdpInsc= new JLabel("Mot de passe: ");
		mdpInsc.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.PanelInscr.add(mdpInsc);
		this.PanelInscr.add(this.txtMdpInsc);
		//Ligne 5
		this.PanelInscr.add(this.btAnnulerInsc);
		this.PanelInscr.add(this.btInscrire);
		this.add(this.PanelInscr);
		
		this.PanelInscr.setVisible(false);
		
		//Rendre les boutons écoutables
		this.btSeConnecter.addActionListener(this);
		this.btInscrire.addActionListener(this);
		this.btAffichCon.addActionListener(this);
		this.btAffichInsc.addActionListener(this);
		this.btAnnulerCon.addActionListener(this);
		this.btAnnulerInsc.addActionListener(this);
		
		//Ajout evenements frappe de touche
		this.txtNomInsc.addKeyListener(this);
		this.txtPrenomInsc.addKeyListener(this);
		this.txtEmailInsc.addKeyListener(this);
		this.txtMdpInsc.addKeyListener(this);
		
		this.txtEmailCon.addKeyListener(this);
		this.txtMdpCon.addKeyListener(this);
		
		
		
		this.setVisible(true);
	}

	public void viderChamps() {
		this.txtNomInsc.setText("");
		this.txtPrenomInsc.setText("");
		this.txtEmailInsc.setText("");
		this.txtMdpInsc.setText("");
		this.txtEmailCon.setText("");
		this.txtMdpCon.setText("");
	}
	public void traitement(String mot) {
		if(mot=="Inscrire") {
			String nom= this.txtNomInsc.getText();
			String prenom= this.txtPrenomInsc.getText();
			String email= this.txtEmailInsc.getText();
			String mdp = new String(this.txtMdpInsc.getPassword());
			if(nom.equals("") || prenom.equals("") || email.equals("") || mdp.equals("")) {
				JOptionPane.showMessageDialog(this, "Veuillez remplir tous les champs\n pour s'inscrire");
			}
			else {
				//Création de l'User
				User newUser=new User(nom, prenom, email, mdp);
				C_User.insertUser(newUser);
				newUser = C_User.selectWhereUser(email, mdp);
				if(newUser==null) {
					JOptionPane.showMessageDialog(this, "Veuillez vérifier vos identifiants !");
				}
				else {
					JOptionPane.showMessageDialog(this, "Bienvenue Mr./Mme. "+newUser.getNom());
					this.viderChamps();
					//Ouverture de session
					centreVaccination.gererVueConnexionInscription(false);
					centreVaccination.gererVueGenerale(true, newUser);
					
				}
			}
		}
		//On se connecte
		else {
			String email= this.txtEmailCon.getText();
			String mdp = new String(this.txtMdpCon.getPassword());
			if(email.equals("") || mdp.equals("")) {
				JOptionPane.showMessageDialog(this, "Veuillez remplir vos identifiants !");
			}
			else {
				//Vérification dans la base de données: table technicien
				User unUser = C_User.selectWhereUser(email, mdp);
				if(unUser==null) {
					JOptionPane.showMessageDialog(this, "Veuillez vérifier vos identifiants !");
				}
				else {
					JOptionPane.showMessageDialog(this, "Bienvenue Mr./Mme. "+unUser.getNom());
					this.viderChamps();
					//Ouverture de session
					centreVaccination.gererVueConnexionInscription(false);
					centreVaccination.gererVueGenerale(true, unUser);
					
				}
			}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==this.btAffichCon){
			//On traite les données
			this.panelCon.setVisible(true);
			this.PanelInscr.setVisible(false);
			this.visibleCon=true;
			this.visibleInscr=false;
		}
		else if(e.getSource()==this.btAffichInsc) {
			this.panelCon.setVisible(false);
			this.PanelInscr.setVisible(true);
			this.visibleCon=false;
			this.visibleInscr=true;
		}
		else if(e.getSource()==this.btAnnulerCon || e.getSource()==this.btAnnulerInsc ) {
			this.viderChamps();
		}
		else if(e.getSource()==this.btSeConnecter) {
			this.traitement("Connecter");
		}
		else if(e.getSource()==this.btInscrire) {
			this.traitement("Inscrire");
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		//Si on appuie sur Entre et qu'on est sur une vue de connexion
		if(e.getKeyChar()==KeyEvent.VK_ENTER && this.visibleCon==true) {
			this.traitement("Connecter");
		}
		else if(e.getKeyChar()==KeyEvent.VK_ENTER && this.visibleInscr==true) {
			this.traitement("Inscrire");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
