package controleur;

import java.util.ArrayList;

import modele.ModeleVaccination;

public class C_Vaccination {
	public static void insertVaccination(Vaccination uneVaccination) {
		ModeleVaccination.insertVaccination(uneVaccination);
	}
	
	public static ArrayList<Vaccination> selectAllVaccinations(){
		return ModeleVaccination.selectAllVaccinations();
	}
	
	public static void deleteVaccination(int idVaccination) {
		ModeleVaccination.deleteVaccination(idVaccination);
	}
	
	public static void updateVaccination(Vaccination uneVaccination) {
		ModeleVaccination.updateVaccination(uneVaccination);
	}
	
	public static Vaccination selectWhereVaccination(int idVaccination) {
		return ModeleVaccination.selectWhereVaccination(idVaccination);
	}
	
	public static Vaccination selectWhereVaccination(String description, String dateVacc, String heure, int nbDose, String temperature, String nomMedecin, int idCentre, int idPersonne, int idVaccin) {
		return ModeleVaccination.selectWhereVaccination(description, dateVacc, heure, nbDose, temperature, nomMedecin, idCentre, idPersonne, idVaccin);
	}
}
