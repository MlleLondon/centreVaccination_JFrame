package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Personne;

public class ModelePersonne {
	private static Bdd uneBdd= new Bdd("localhost", "vaccin_2022_CL", "root", "");
	
	public static void insertPersonne(Personne unePersonne) {
		String requete="insert into personne values(null, '"+unePersonne.getNom()+
				"', '"+unePersonne.getPrenom()+"', '"+unePersonne.getTel()+
				"', '"+unePersonne.getAdresse()+"', '"+unePersonne.getEmail()+
				"', '"+unePersonne.getMdp()+"', "+unePersonne.getAge()+
				", '"+unePersonne.getNumeroSecu()+"';";
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
	
	public static ArrayList<Personne> selectAllPersonnes(){
		String requete="select * from personne;";
		ArrayList<Personne> lesPersonnes= new ArrayList<Personne>();
		try {
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats= unStat.executeQuery(requete);
			//On parcours les résultats et on construit l'ArrayList<Personne>
			while(desResultats.next()) {
				Personne unePersonne= new Personne(
						desResultats.getInt("idpersonne"), desResultats.getString("nom"),
						desResultats.getString("prenom"), desResultats.getString("tel"),
						desResultats.getString("adresse"), desResultats.getString("email"),
						desResultats.getString("mdp"), desResultats.getString("numeroSecu"),
						desResultats.getInt("age")
						);
				lesPersonnes.add(unePersonne);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+requete);
		}
		return lesPersonnes;
		
	}
	
	public static void deletePersonne(int idpersonne) {
		String requete="delete from personne where idpersonne="+idpersonne;
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
	
	public static void updatePersonne(Personne unePersonne) {
		String requete="update personne set nom='"+unePersonne.getNom()+
				"', prenom='"+unePersonne.getPrenom()+"', tel='"+unePersonne.getTel()+
				"', adresse='"+unePersonne.getAdresse()+"', email='"+unePersonne.getEmail()
				+"', mdp='"+unePersonne.getMdp()+"', age="+unePersonne.getAge()+
				", numeroSecu='"+unePersonne.getNumeroSecu()+"' where idpersonne="+unePersonne.getIdpersonne()+";";
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
	
	public static Personne selectWherePersonne(int idpersonne) {
		String requete="select * from personne where idpersonne="+idpersonne+";";
		Personne unePersonne=null;
		try {
			uneBdd.seConnecter();
			Statement unStat=uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat= unStat.executeQuery(requete);
			if(unResultat.next()) {
				unePersonne= new Personne(
						unResultat.getInt("idpersonne"), unResultat.getString("nom"),
						unResultat.getString("prenom"), unResultat.getString("tel"),
						unResultat.getString("adresse"), unResultat.getString("email"),
						unResultat.getString("mdp"), unResultat.getString("numeroSecu"),
						unResultat.getInt("age")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+requete);
		}
		return unePersonne;
	}
	

}
