package controleur;

public class Vaccin {
	private int idvaccin;
	private String nom, laboratoire, pays, conservation;
	
	//Constructeurs
	public Vaccin(int idvaccin, String nom, String laboratoire, String pays, String conservation) {
		this.idvaccin = idvaccin;
		this.nom = nom;
		this.laboratoire = laboratoire;
		this.pays = pays;
		this.conservation = conservation;
	}
	
	public Vaccin(String nom, String laboratoire, String pays, String conservation) {
		this.idvaccin = 0;
		this.nom = nom;
		this.laboratoire = laboratoire;
		this.pays = pays;
		this.conservation = conservation;
	}
	
	public Vaccin() {
		this.idvaccin = 0;
		this.nom = "";
		this.laboratoire = "";
		this.pays = "";
		this.conservation = "";
	}

	
	//Getters & Setters
	public int getIdvaccin() {
		return idvaccin;
	}

	public void setIdvaccin(int idvaccin) {
		this.idvaccin = idvaccin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getLaboratoire() {
		return laboratoire;
	}

	public void setLaboratoire(String laboratoire) {
		this.laboratoire = laboratoire;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getConservation() {
		return conservation;
	}

	public void setConservation(String conservation) {
		this.conservation = conservation;
	}
	
	
	
	
}
