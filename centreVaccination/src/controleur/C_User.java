package controleur;

import java.util.ArrayList;
import modele.ModeleUser;

public class C_User {
	public static void insertUser(User unUser) {
		ModeleUser.insertUser(unUser);
	}
	public static ArrayList<User> selectAllUsers(){
		return ModeleUser.selectAllUsers();
	}
	public static void updateUser(User unUser) {
		ModeleUser.updateUser(unUser);
	}
	public static void deleteUser(int iduser) {
		ModeleUser.deleteUser(iduser);
	}
	public static User selectWhereUser(int iduser) {
		return ModeleUser.selectWhereUser(iduser);
	}
	public static User selectWhereUser(String email, String mdp) {
		return ModeleUser.selectWhereUser(email, mdp);
	}
}
