package controleur;
import vue.vueAjoutPersonne;
import vue.vueConnexionInscription;
import vue.vueGenerale;

public class centreVaccination {

	private static vueConnexionInscription uneVueConnexion;
	private static vueGenerale uneVueGenerale;
	private static vueAjoutPersonne unAjoutPersonne;
	
	public static void main(String[] args) {
		uneVueConnexion= new vueConnexionInscription();

	}
	
	public static void gererVueConnexionInscription (boolean action) {
		centreVaccination.uneVueConnexion.setVisible(action);
	}
	public static void gererVueGenerale (boolean action, User unUser) {
		uneVueGenerale= new vueGenerale(unUser);
		centreVaccination.uneVueGenerale.setVisible(action);
	}
	
	public static void gererVueAjoutPersonne(boolean action, User unUser) {
		unAjoutPersonne= new vueAjoutPersonne(unUser);
		centreVaccination.unAjoutPersonne.setVisible(true);
	}
}
