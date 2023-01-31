package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.User;

public class vueAjoutPersonne extends JFrame implements ActionListener{
	private JPanel panelAjout= new JPanel();
	private JButton btAnnuler= new JButton("Annuler");
	private JButton btAjouter= new JButton("Ajouter");
	private JTextField txtNom= new JTextField();
	private JTextField txtPrenom= new JTextField();
	private JTextField txtTel= new JTextField();
	private JTextField txtAdresse= new JTextField();
	private JTextField txtEmail= new JTextField();
	private JTextField txtAge= new JTextField();
	private JTextField txtNumeroSecu= new JTextField();
	
	public vueAjoutPersonne(User unUser) {
		this.setTitle("Ajout d'une personne");
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setBackground(new Color(224, 240, 227));
		this.setBounds(200, 200, 390, 600);
		this.setLayout(null);
		
		//Construction du panelAjout
		this.panelAjout.setBounds(20, 20, 350, 500);
		this.panelAjout.setLayout(new GridLayout(8,2));
		this.panelAjout.setBackground(new Color(224, 240, 227));
		//1ere ligne
		JLabel nom= new JLabel("Nom: ");
		nom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(nom);
		this.panelAjout.add(this.txtNom);
		//2e ligne
		JLabel prenom= new JLabel("Prenom: ");
		prenom.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(prenom);
		this.panelAjout.add(this.txtPrenom);
		//3e ligne
		JLabel tel= new JLabel("Tel: ");
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
		JLabel numSecu= new JLabel("Numero Sécu: ");
		numSecu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
		this.panelAjout.add(numSecu);
		this.panelAjout.add(this.txtNumeroSecu);
		//8e ligne
		this.panelAjout.add(this.btAnnuler);
		this.panelAjout.add(this.btAjouter);
		
		this.add(this.panelAjout);
		this.panelAjout.setVisible(true);
		this.setVisible(false);
		
		
		//Rendre les boutons écoutables
		this.btAjouter.addActionListener(this);
		this.btAnnuler.addActionListener(this);
		
		//Remplir les champs avec les informations connues
		this.txtNom.setText(unUser.getNom());
		this.txtNom.setEditable(false);
		this.txtPrenom.setText(unUser.getPrenom());
		this.txtPrenom.setEditable(false);
		this.txtEmail.setText(unUser.getEmail());
		this.txtEmail.setEditable(false);
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
