package controleur;

public class Personne {
	private int idpersonne;
	private String nom, prenom, tel, adresse, email, mdp, numeroSecu;
	private int age;
	
	//Constructeurs
	public Personne(int idpersonne, String nom, String prenom, String tel, String adresse, String email, String mdp,
			String numeroSecu, int age) {
		this.idpersonne = idpersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
		this.email = email;
		this.mdp = mdp;
		this.numeroSecu = numeroSecu;
		this.age = age;
	}
	
	public Personne(String nom, String prenom, String tel, String adresse, String email, String mdp,
			String numeroSecu, int age) {
		this.idpersonne = 0;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
		this.email = email;
		this.mdp = mdp;
		this.numeroSecu = numeroSecu;
		this.age = age;
	}
	
	public Personne() {
		this.idpersonne = 0;
		this.nom = "";
		this.prenom = "";
		this.tel = "";
		this.adresse = "";
		this.email = "";
		this.mdp = "";
		this.numeroSecu = "";
		this.age = 0;
	}

	
	//Getters & Setters
	public int getIdpersonne() {
		return idpersonne;
	}

	public void setIdpersonne(int idpersonne) {
		this.idpersonne = idpersonne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getNumeroSecu() {
		return numeroSecu;
	}

	public void setNumeroSecu(String numeroSecu) {
		this.numeroSecu = numeroSecu;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	
	
}
