package controleur;

import java.util.ArrayList;

import modele.ModeleVaccin;

public class C_Vaccin {
	public static void insertVaccin(Vaccin unVaccin) {
		ModeleVaccin.insertVaccin(unVaccin);
	}
	public static ArrayList<Vaccin> selectAllVaccins(){
		return ModeleVaccin.selectAllVaccins();
	}
	public static void deleteVaccin(int idvaccin) {
		ModeleVaccin.deleteVaccin(idvaccin);
	}
	public static void updateVaccin(Vaccin unVaccin) {
		ModeleVaccin.updateVaccin(unVaccin);
	}
	public static Vaccin selectWhereVaccin(int idvaccin) {
		return ModeleVaccin.selectWhereVaccin(idvaccin);
	}
	public static Vaccin selectWhereVaccin(String nom, String laboratoire, String pays, String conservation) {
		return ModeleVaccin.selectWhereVaccin(nom, laboratoire, pays, conservation);
	}
}
