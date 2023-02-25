package modele;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import controleur.User;

public class ModeleUser {
	private static Bdd uneBdd= new Bdd("localhost", "vaccin_2022_CL", "root" ,"");
	
	public static void insertUser(User unUser) {
		String requete="insert into user values(null, '"+unUser.getNom()+"', '"+unUser.getPrenom()+"', '"+unUser.getEmail()+
				"', '"+unUser.getMdp()+"');";
		try {
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+requete);
		}
		
	}
	
	public static ArrayList<User> selectAllUsers(){
		String requete="select * from user;";
		ArrayList<User> lesUsers= new ArrayList<User>();
		try {
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats=unStat.executeQuery(requete);
			//Parcourir les résultats et construire des objets
			while(desResultats.next() ) {
				User unUser=new User(
						desResultats.getInt("iduser"), desResultats.getString("nom"),
						desResultats.getString("prenom"), desResultats.getString("email"),
						desResultats.getString("mdp"));
				lesUsers.add(unUser);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+requete);
		}
		return lesUsers;
		
	}
	
	public static void deleteUser(int iduser) {
		String requete="delete from user where iduser="+iduser+";";
		try {
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+requete);
		}
	}
	
	public static void updateUser(User unUser) {
		String requete="update user set nom='"+unUser.getNom()+"', prenom='"+unUser.getPrenom()+"', email='"+unUser.getEmail()+
				"', mdp='"+unUser.getMdp()+"' where iduser="+unUser.getIduser()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat=uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+requete);
		}
	}
	
	public static User selectWhereUser(int iduser) {
		String requete="select * from user where iduser="+iduser+";";
		User unUser=null;
		try {
			uneBdd.seConnecter();
			Statement unStat=uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat=unStat.executeQuery(requete);
			if(unResultat.next()) {
				unUser=new User(
						unResultat.getInt("iduser"), unResultat.getString("nom"), unResultat.getString("prenom"),
						unResultat.getString("email"), unResultat.getString("mdp")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+requete);
		}
		return unUser;
	}
	public static User selectWhereUser(String email, String mdp) {
		String requete="select * from user where email='"+email+"' and mdp='"+mdp+"';";
		User unUser=null;
		try {
			uneBdd.seConnecter();
			Statement unStat=uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat=unStat.executeQuery(requete);
			if(unResultat.next()) {
				unUser=new User(
						unResultat.getInt("iduser"), unResultat.getString("nom"), unResultat.getString("prenom"),
						unResultat.getString("email"), unResultat.getString("mdp")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+requete);
		}
		return unUser;
	}
}
