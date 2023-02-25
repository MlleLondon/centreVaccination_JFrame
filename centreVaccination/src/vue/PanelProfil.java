package vue;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controleur.C_User;
import controleur.User;

public class PanelProfil extends PanelPrincipal implements ActionListener{
	private JTextArea txtProfil= new JTextArea();
	private JPanel panelUpdate= new JPanel();
	private JButton btAnnuler= new JButton("Annuler");
	private JButton btModifier= new JButton("Modifier");
	private JTextField txtNom= new JTextField();
	private JTextField txtPrenom= new JTextField();
	private JTextField txtEmail= new JTextField();
	private JPasswordField txtMdp= new JPasswordField();
	
	private JButton btModifierProfil= new JButton("Modifier Profil");
	private boolean visible;
	private int iduser;
	
	
	public PanelProfil(User unUser) {
		super(new Color(224, 240, 227));
		this.iduser=unUser.getIduser();
		Font unePolice= new Font("Arial", Font.BOLD, 14);
		this.txtProfil.setFont(unePolice);
		//Positionnement de la vue profil
		String detail="\tInformations Utilisateur: ";
		detail=detail+"\n\n\nPrénom: "+unUser.getPrenom();
		detail=detail+"\nNom: "+unUser.getNom();
		detail=detail+"\nEmail: "+unUser.getEmail();
		
		this.txtProfil.setBounds(40, 40, 350, 300);
		this.txtProfil.setBackground(new Color(224, 240, 0));
		this.txtProfil.setText(detail);
		
		//Construction du panel de modification du profil
		this.panelUpdate.setBounds(420, 40, 400, 300);
		this.panelUpdate.setLayout(new GridLayout(5,2));
		//1ere ligne
		JLabel prenom= new JLabel("Prenom: ");
		prenom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelUpdate.add(prenom);
		this.panelUpdate.add(this.txtPrenom);
		//2eme ligne
		JLabel nom= new JLabel("Nom: ");
		nom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelUpdate.add(nom);
		this.panelUpdate.add(this.txtNom);
		//3eme ligne
		JLabel email= new JLabel("Email: ");
		email.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelUpdate.add(email);
		this.panelUpdate.add(this.txtEmail);
		//4eme ligne
		JLabel mdp= new JLabel("Mdp: ");
		mdp.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelUpdate.add(mdp);
		this.panelUpdate.add(this.txtMdp);
		//5eme Ligne Ajout des boutons modifier et annuler
		this.panelUpdate.add(this.btAnnuler);
		this.panelUpdate.add(this.btModifier);
		this.panelUpdate.setBackground(new Color(224, 0, 227));
		
		this.add(this.panelUpdate);
		this.panelUpdate.setVisible(false);
		this.visible=false;
		
		//Ajout du bouton Modifier profil
		this.btModifierProfil.setBounds(150,  340,  150,  30);
		this.add(this.btModifierProfil);
		this.add(this.txtProfil);
		
		//Rendre les boutons cliquables
		this.btAnnuler.addActionListener(this);
		this.btModifier.addActionListener(this);
		this.btModifierProfil.addActionListener(this);
		
		//Remplir les champs avec les informations de l'User
		this.txtNom.setText(unUser.getNom());
		this.txtPrenom.setText(unUser.getPrenom());
		this.txtEmail.setText(unUser.getEmail());
		this.txtMdp.setText(unUser.getMdp());
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==this.btModifierProfil) {
			if(this.visible==false) {
				this.panelUpdate.setVisible(true);
				this.visible=true;
			}
			else {
				this.panelUpdate.setVisible(false);
				this.visible=false;
			}
		}
		else if(e.getSource()==this.btAnnuler) {
			this.panelUpdate.setVisible(false);
			this.visible=false;
		}
		else if(e.getSource()==this.btModifier) {
			String nom= this.txtNom.getText();
			String prenom= this.txtPrenom.getText();
			String email= this.txtEmail.getText();
			String mdp= new String( this.txtMdp.getPassword());
			
			User updateUser= new User(this.iduser, nom, prenom, email, mdp);
			C_User.updateUser(updateUser);
			JOptionPane.showMessageDialog(this, "Modification réussie !");
			this.panelUpdate.setVisible(false);
			this.visible=false;
			
			//Modification des infos dans la visualisation de l'User
			String message="\tInformations Utilisateur";
			message= message+"\n\n\nPrenom: "+prenom;
			message= message+"\nNom: "+nom;
			message= message+"\nEmail: "+email;
			this.txtProfil.setText(message);
		}
		
	}

}
