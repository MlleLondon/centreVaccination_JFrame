package controleur;

public class Centre {
	
	private int idcentre;
	private String nom, adresse, type;
	private int capacite, nbIntervenant;
	private String horaire;
	
	//Constructeurs
	public Centre(int idcentre, String nom, String adresse, String type, int capacite, int nbIntervenant,
			String horaire) {
		this.idcentre = idcentre;
		this.nom = nom;
		this.adresse = adresse;
		this.type = type;
		this.capacite = capacite;
		this.nbIntervenant = nbIntervenant;
		this.horaire = horaire;
	}
	public Centre(String nom, String adresse, String type, int capacite, int nbIntervenant,
			String horaire) {
		this.idcentre = 0;
		this.nom = nom;
		this.adresse = adresse;
		this.type = type;
		this.capacite = capacite;
		this.nbIntervenant = nbIntervenant;
		this.horaire = horaire;
	}
	public Centre() {
		this.idcentre = 0;
		this.nom = "";
		this.adresse = "";
		this.type = "";
		this.capacite = 0;
		this.nbIntervenant = 0;
		this.horaire = "";
	}
	
	//Getters & Setters
	public int getIdcentre() {
		return idcentre;
	}
	public void setIdcentre(int idcentre) {
		this.idcentre = idcentre;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCapacite() {
		return capacite;
	}
	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}
	public int getNbIntervenant() {
		return nbIntervenant;
	}
	public void setNbIntervenant(int nbIntervenant) {
		this.nbIntervenant = nbIntervenant;
	}
	public String getHoraire() {
		return horaire;
	}
	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}
	
	
	
	
}
