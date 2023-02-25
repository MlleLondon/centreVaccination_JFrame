package controleur;

public class Vaccination {
	private int idVaccination;
	private String description, dateVacc, heure;
	private int nbDose;
	private String temperature, nomMedecin;
	private int idCentre, idPersonne, idVaccin;
	
	//Constructeurs
	public Vaccination(int idVaccination, String description, String dateVacc, String heure, int nbDose,
			String temperature, String nomMedecin, int idCentre, int idPersonne, int idVaccin) {
		this.idVaccination = idVaccination;
		this.description = description;
		this.dateVacc = dateVacc;
		this.heure = heure;
		this.nbDose = nbDose;
		this.temperature = temperature;
		this.nomMedecin = nomMedecin;
		this.idCentre = idCentre;
		this.idPersonne = idPersonne;
		this.idVaccin = idVaccin;
	}
	
	public Vaccination(String description, String dateVacc, String heure, int nbDose,
			String temperature, String nomMedecin, int idCentre, int idPersonne, int idVaccin) {
		this.idVaccination = 0;
		this.description = description;
		this.dateVacc = dateVacc;
		this.heure = heure;
		this.nbDose = nbDose;
		this.temperature = temperature;
		this.nomMedecin = nomMedecin;
		this.idCentre = idCentre;
		this.idPersonne = idPersonne;
		this.idVaccin = idVaccin;
	}
	
	public Vaccination() {
		this.idVaccination = 0;
		this.description = "";
		this.dateVacc = "";
		this.heure = "";
		this.nbDose = 0;
		this.temperature = "";
		this.nomMedecin = "";
		this.idCentre = 0;
		this.idPersonne = 0;
		this.idVaccin = 0;
	}

	
	//Getters & Setters
	public int getIdVaccination() {
		return idVaccination;
	}

	public void setIdVaccination(int idVaccination) {
		this.idVaccination = idVaccination;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateVacc() {
		return dateVacc;
	}

	public void setDateVacc(String dateVacc) {
		this.dateVacc = dateVacc;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}

	public int getNbDose() {
		return nbDose;
	}

	public void setNbDose(int nbDose) {
		this.nbDose = nbDose;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getNomMedecin() {
		return nomMedecin;
	}

	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}

	public int getIdCentre() {
		return idCentre;
	}

	public void setIdCentre(int idCentre) {
		this.idCentre = idCentre;
	}

	public int getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public int getIdVaccin() {
		return idVaccin;
	}

	public void setIdVaccin(int idVaccin) {
		this.idVaccin = idVaccin;
	}
	
	
	
	
}
