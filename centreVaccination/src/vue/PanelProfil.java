package vue;

import java.awt.Color;
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
	private JTextField txtRole= new JTextField();
	private JPasswordField txtMdp= new JPasswordField();
	
	private JButton btModifierProfil= new JButton("Modifier Profil");
	private boolean visible;
	private int iduser;
	
	
	public PanelProfil(User unUser) {
		super(new Color(224, 240, 227));
		this.iduser=unUser.getIduser();
		
		//Positionnement de la vue profil
		String detail="\tInformations User: ";
		detail=detail+"\nPrénom: "+unUser.getPrenom();
		detail=detail+"\nNom: "+unUser.getNom();
		detail=detail+"\nEmail: "+unUser.getEmail();
		detail=detail+"\nRole: "+unUser.getRole();
		
		this.txtProfil.setBounds(40, 40, 300, 300);
		this.txtProfil.setBackground(new Color(224, 240, 227));
		this.txtProfil.setText(detail);
		
		//Construction du panel de modification du profil
		this.panelUpdate.setBounds(400, 40, 300, 300);
		this.panelUpdate.setLayout(new GridLayout(6,2));
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
		//5eme Ligne
		JLabel role= new JLabel("Role: ");
		role.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelUpdate.add(role);
		this.panelUpdate.add(this.txtRole);
		//6eme ligne: Ajout des boutons modifier et annuler
		this.panelUpdate.add(this.btAnnuler);
		this.panelUpdate.add(this.btModifier);
		this.panelUpdate.setBackground(new Color(224, 240, 227));
		
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
		this.txtRole.setText(unUser.getRole());
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
			this.txtNom.setText("");
			this.txtPrenom.setText("");
			this.txtEmail.setText("");
			this.txtMdp.setText("");
			this.txtRole.setText("");
		}
		else if(e.getSource()==this.btModifier) {
			String nom= this.txtNom.getText();
			String prenom= this.txtPrenom.getText();
			String email= this.txtEmail.getText();
			String role= this.txtRole.getText();
			String mdp= new String( this.txtMdp.getPassword());
			
			User updateUser= new User(this.iduser, nom, prenom, email, mdp, role);
			C_User.updateUser(updateUser);
			JOptionPane.showMessageDialog(this, "Modification réussie !");
			this.panelUpdate.setVisible(false);
			this.visible=false;
			
			//Modification des infos dans la visualisation de l'User
			String message="\tInformations User";
			message= "Prenom: "+prenom;
			message= message+"\nNom: "+nom;
			message= message+"\nEmail: "+email;
			message=message+"\nRole: "+role;
			this.txtProfil.setText(message);
		}
		
	}

}
