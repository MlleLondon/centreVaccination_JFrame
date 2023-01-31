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

public class vueConnexionInscription extends JFrame implements ActionListener{
	//Partie Connexion
	private JTextField txtEmailCon= new JTextField();
	private JPasswordField txtMdpCon= new JPasswordField();
	private JButton btSeConnecter= new JButton("Connexion");
	private JPanel panelCon=new JPanel();
	//Partie Inscription
	private JTextField txtNomInsc= new JTextField();
	private JTextField txtPrenomInsc= new JTextField();
	private JTextField txtEmailInsc= new JTextField();
	private JPasswordField txtMdpInsc= new JPasswordField();
	private JButton btInscrire= new JButton("Inscription");
	private JPanel PanelInscr=new JPanel();
	//Visibilité Connexion ou Inscription
	private boolean visibleCon, visibleInscr;
	
	public vueConnexionInscription() {
		this.setTitle("Connexion / Inscription");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(224, 240, 227) );
		this.setBounds(200, 200, 700, 450);
		this.setLayout(null);
		
		
		
		//Construction du panel connexion
		this.panelCon.setBounds(70, 150, 200, 125);
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
		JLabel vide= new JLabel("");
		vide.setBackground(new Color(224, 240, 227));
		this.panelCon.add(vide);
		//Premiere grille ligne 2 colonne 2 on met le boutton Se Connecter
		this.panelCon.add(this.btSeConnecter);
		this.add(this.panelCon);
		
		//Construction du panel d'inscription
		this.PanelInscr.setBounds(350, 150, 200, 200);
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
		JLabel vide2= new JLabel("");
		vide2.setBackground(new Color(224, 240, 227));
		this.PanelInscr.add(vide2);
		this.PanelInscr.add(this.btInscrire);
		this.add(this.PanelInscr);
		
		//Rendre les boutons écoutables
		this.btSeConnecter.addActionListener(this);
		this.btInscrire.addActionListener(this);
		
		
		this.setVisible(true);
	}

	public void traitementConnexion() {
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
				this.txtEmailCon.setText("");
				this.txtMdpCon.setText("");
				//Ouverture de session
				centreVaccination.gererVueConnexionInscription(false);
				centreVaccination.gererVueGenerale(true, unUser);
				
			}
		}
	}
	public void traitementInscrire() {
		String nom= this.txtNomInsc.getText();
		String prenom= this.txtPrenomInsc.getText();
		String email= this.txtEmailInsc.getText();
		String mdp = new String(this.txtMdpInsc.getPassword());
		String role= "user";
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
				this.txtEmailCon.setText("");
				this.txtMdpCon.setText("");
				//Ouverture de session
				centreVaccination.gererVueConnexionInscription(false);
				centreVaccination.gererVueGenerale(true, unUser);
				
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btSeConnecter){
			//On traite les données
			this.traitementConnexion();
		}
		else if(e.getSource()==this.btInscrire) {
			this.traitementInscrire();
		}
		
	}
	
}
