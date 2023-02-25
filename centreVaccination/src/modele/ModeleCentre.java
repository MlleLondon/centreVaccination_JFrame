package modele;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Centre;

public class ModeleCentre {
	private static Bdd uneBdd= new Bdd("localhost", "vaccin_2022_CL", "root", "");
	
	public static void insertCentre(Centre unCentre) {
		String requete="insert into centre values(null, '"+unCentre.getNom()+"', '"+unCentre.getAdresse()+"', '"+unCentre.getType()+
				"', "+unCentre.getCapacite()+", "+unCentre.getNbIntervenant()+", '"+unCentre.getHoraire()+"');";
		
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
	
	public static ArrayList<Centre> selectAllCentres(){
		String requete="select * from centre;";
		ArrayList<Centre> lesCentres= new ArrayList<Centre>();
		try {
			uneBdd.seConnecter();
			Statement unStat= uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats= unStat.executeQuery(requete);
			while(desResultats.next()) {
				Centre unCentre= new Centre(
						desResultats.getInt("idcentre"), desResultats.getString("nom"), desResultats.getString("adresse"),
						desResultats.getString("type"), desResultats.getInt("capacite"), desResultats.getInt("nbIntervenant"),
						desResultats.getString("horaire")
						);
				lesCentres.add(unCentre);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+exp);
		}
		return lesCentres;
	}
	public static void deleteCentre(int idcentre) {
		String requete="delete from centre where idcentre="+idcentre+";";
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
	
	public static void updateCentre(Centre unCentre) {
		String requete="update centre set nom='"+unCentre.getNom()+"', adresse='"+unCentre.getAdresse()+"', type='"+unCentre.getType()+
				"', capacite="+unCentre.getCapacite()+", nbIntervenant="+unCentre.getNbIntervenant()+", horaire='"+unCentre.getHoraire()+
				"' where idCentre="+unCentre.getIdcentre()+";";
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
	public static Centre selectWhereCentre(int idcentre) {
		String requete="select * from centre where idcentre="+idcentre+";";
		Centre unCentre=null;
		try {
			uneBdd.seConnecter();
			Statement unStat=uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat=unStat.executeQuery(requete);
			if(unResultat.next()) {
				unCentre= new Centre(
						unResultat.getInt("idcentre"), unResultat.getString("nom"), unResultat.getString("adresse"), unResultat.getString("type"),
						unResultat.getInt("capacite"), unResultat.getInt("nbIntervenant"), unResultat.getString("horaire")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+exp);
		}
		return unCentre;
	}
	public static Centre selectWhereCentre(String nom, String adresse, String type, int capacite, int nbIntervenant, String horaire) {
		String requete="select * from centre where nom='"+nom+"' and adresse='"+adresse+"' and type='"+type+"' and capacite="+capacite+
				" and nbIntervenant="+nbIntervenant+" and horaire='"+horaire+"';";
		Centre unCentre=null;
		try {
			uneBdd.seConnecter();
			Statement unStat=uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat=unStat.executeQuery(requete);
			if(unResultat.next()) {
				unCentre= new Centre(
						unResultat.getInt("idcentre"), unResultat.getString("nom"), unResultat.getString("adresse"), unResultat.getString("type"),
						unResultat.getInt("capacite"), unResultat.getInt("nbIntervenant"), unResultat.getString("horaire")
						);
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+exp);
		}
		return unCentre;
	}
	
}
