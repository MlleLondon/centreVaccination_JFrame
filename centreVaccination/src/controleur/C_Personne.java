package controleur;

import java.util.ArrayList;

import modele.ModelePersonne;

public class C_Personne {
	public static void insertPersonne(Personne unePersonne) {
		ModelePersonne.insertPersonne(unePersonne);
	}
	public static ArrayList<Personne> selectAllPersonnes(){
		return ModelePersonne.selectAllPersonnes();
	}
	public static void updatePersonne(Personne unePersonne) {
		ModelePersonne.updatePersonne(unePersonne);
	}
	public static void deletePersonne(int idpersonne) {
		ModelePersonne.deletePersonne(idpersonne);
	}
	public static Personne selectWherePersonne(int idpersonne) {
		return ModelePersonne.selectWherePersonne(idpersonne);
	}
	public static Personne selectWherePersonne(String nom, String prenom, String tel, String adresse, String email, String numSecu, int age) {
		return ModelePersonne.selectWherePersonne(nom, prenom, tel, adresse, email, numSecu, age);
	}
}
