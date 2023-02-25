package controleur;

import java.util.ArrayList;

import modele.*;

public class C_Centre {

	
	public static void insertCentre(Centre unCentre) {
		//On controle les données
		ModeleCentre.insertCentre(unCentre);
	}
	public static ArrayList<Centre> selectAllCentres() {
		//On controle les données
		return ModeleCentre.selectAllCentres();
	}
	public static void deleteCentre(int idcentre) {
		//On controle les données
		ModeleCentre.deleteCentre(idcentre);
	}
	public static void updateCentre(Centre unCentre) {
		//On controle les données
		ModeleCentre.updateCentre(unCentre);
	}
	public static Centre selectWhereCentre(int idclient) {
		//On controle les données
		return ModeleCentre.selectWhereCentre(idclient);
	}
	public static Centre selectWhereCentre(String nom, String adresse, String type, int capacite, int nbIntervenant, String horaire) {
		//On controle les données
		return ModeleCentre.selectWhereCentre(nom, adresse, type, capacite, nbIntervenant, horaire);
	}
}
