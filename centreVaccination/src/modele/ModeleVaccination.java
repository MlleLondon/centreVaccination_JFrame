package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Vaccination;

public class ModeleVaccination {
	private static Bdd uneBdd= new Bdd("localhost", "vaccin_2022_CL", "root", "");
	
	public static void insertVaccination(Vaccination uneVaccination) {
		String requete="insert into vaccination values(null, '"+uneVaccination.getDescription()+"', '"+uneVaccination.getDateVacc()+
				"', '"+uneVaccination.getHeure()+"', "+uneVaccination.getNbDose()+", '"+uneVaccination.getTemperature()+
				"', '"+uneVaccination.getNomMedecin()+"', "+uneVaccination.getIdCentre()+", "+uneVaccination.getIdPersonne()+
				", "+uneVaccination.getIdVaccin()+");";
		try {
			uneBdd.seConnecter();
			Statement unStat=uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+exp);
		}
	}
	
	public static ArrayList<Vaccination> selectAllVaccinations(){
		String requete="select * from vaccination;";
		ArrayList<Vaccination> lesVaccinations= new ArrayList<Vaccination>();
		try {
			uneBdd.seConnecter();
			Statement unStat=uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats= unStat.executeQuery(requete);
			while(desResultats.next()) {
				Vaccination uneVaccination= new Vaccination(
						desResultats.getInt("idvaccination"), desResultats.getString("description"), desResultats.getString("dateVacc"),
						desResultats.getString("heure"), desResultats.getInt("nbDose"), desResultats.getString("temperature"),
						desResultats.getString("nomMedecin"), desResultats.getInt("idCentre"), desResultats.getInt("idPersonne"),
						desResultats.getInt("idVaccin")
						);
				lesVaccinations.add(uneVaccination);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+exp);
		}
		return lesVaccinations;
	}
	
	public static void deleteVaccination(int idVaccination) {
		String requete="delete from vaccination where idvaccination="+idVaccination+";";
		try {
			uneBdd.seConnecter();
			Statement unStat=uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+exp);
		}
	}
	
	public static void updateVaccination(Vaccination uneVaccination) {
		String requete="update vaccination set description='"+uneVaccination.getDescription()+"', dateVacc='"+uneVaccination.getDateVacc()+
				"', heure='"+uneVaccination.getHeure()+"', nbDose="+uneVaccination.getNbDose()+", temperature='"+uneVaccination.getTemperature()+
				"', nomMedecin='"+uneVaccination.getNomMedecin()+"', idCentre="+uneVaccination.getIdCentre()+
				", idPersonne="+uneVaccination.getIdPersonne()+", idVaccin="+uneVaccination.getIdVaccin()+" where idvaccination="+uneVaccination.getIdVaccination()+";";
		try {
			uneBdd.seConnecter();
			Statement unStat=uneBdd.getMaConnexion().createStatement();
			unStat.execute(requete);
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+exp);
		}
	}
	
	public static Vaccination selectWhereVaccination(int idVaccination) {
		String requete="select * from vaccination where idvaccination="+idVaccination+";";
		Vaccination uneVaccination=null;
		try {
			uneBdd.seConnecter();
			Statement unStat=uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat=unStat.executeQuery(requete);
			if(unResultat.next()) {
				uneVaccination= new Vaccination(
						unResultat.getInt("idvaccination"), unResultat.getString("description"), unResultat.getString("dateVacc"),
						unResultat.getString("heure"), unResultat.getInt("nbDose"), unResultat.getString("temperature"),
						unResultat.getString("nomMedecin"), unResultat.getInt("idCentre"), unResultat.getInt("idPersonne"),
						unResultat.getInt("idVaccin")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+exp);
		}
		return uneVaccination;
	}
	
	public static Vaccination selectWhereVaccination(String description, String dateVacc, String heure, int nbDose, String temperature, String nomMedecin, int idCentre, int idPersonne, int idVaccin) {
		String requete="select * from vaccination where description='"+description+"' and dateVacc='"+dateVacc+"' and heure='"+heure+"' and nbDose="+nbDose+" and temperature='"+temperature+"' and nomMedecin='"+nomMedecin+"' and idCentre="+idCentre+" and idPersonne="+idPersonne+" and idVaccin="+idVaccin+";";
		Vaccination uneVaccination=null;
		try {
			uneBdd.seConnecter();
			Statement unStat=uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat=unStat.executeQuery(requete);
			if(unResultat.next()) {
				uneVaccination= new Vaccination(
						unResultat.getInt("idvaccination"), unResultat.getString("description"), unResultat.getString("dateVacc"),
						unResultat.getString("heure"), unResultat.getInt("nbDose"), unResultat.getString("temperature"),
						unResultat.getString("nomMedecin"), unResultat.getInt("idCentre"), unResultat.getInt("idPersonne"),
						unResultat.getInt("idVaccin")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+exp);
		}
		return uneVaccination;
	}
}
