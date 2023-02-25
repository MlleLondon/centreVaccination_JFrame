package modele;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import controleur.Vaccin;

public class ModeleVaccin {
	private static Bdd uneBdd= new Bdd("localhost", "vaccin_2022_CL", "root", "");
	
	
	public static void insertVaccin(Vaccin unVaccin) {
		String requete="insert into vaccin values(null, '"+unVaccin.getNom()+"', '"+unVaccin.getLaboratoire()+
				"', '"+unVaccin.getPays()+"', '"+unVaccin.getConservation()+"');";
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
	
	public static ArrayList<Vaccin> selectAllVaccins(){
		String requete="select * from vaccin;";
		ArrayList<Vaccin> lesVaccins= new ArrayList<Vaccin>();
		try {
			uneBdd.seConnecter();
			Statement unStat=uneBdd.getMaConnexion().createStatement();
			ResultSet desResultats=unStat.executeQuery(requete);
			while(desResultats.next()) {
				Vaccin unVaccin= new Vaccin(
						desResultats.getInt("idvaccin"), desResultats.getString("nom"), desResultats.getString("laboratoire"),
						desResultats.getString("pays"), desResultats.getString("conservation")
						);
				lesVaccins.add(unVaccin);
			}
			
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+exp);
		}
		
		return lesVaccins;
	}
	
	public static void deleteVaccin(int idvaccin) {
		String requete="delete from vaccin where idvaccin="+idvaccin+";";
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
	
	public static void updateVaccin(Vaccin unVaccin) {
		String requete="update vaccin set nom='"+unVaccin.getNom()+"', laboratoire='"+unVaccin.getLaboratoire()+
				"', pays='"+unVaccin.getPays()+"', conservation='"+unVaccin.getConservation()+"' where idvaccin="+unVaccin.getIdvaccin()+";";
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
	
	public static Vaccin selectWhereVaccin(int idvaccin) {
		String requete="select * from vaccin where idvaccin="+idvaccin+";";
		Vaccin unVaccin=null;
		try {
			uneBdd.seConnecter();
			Statement unStat=uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat=unStat.executeQuery(requete);
			if(unResultat.next()) {
				unVaccin= new Vaccin(
						unResultat.getInt("idvaccin"), unResultat.getString("nom"), unResultat.getString("laboratoire"),
						unResultat.getString("pays"), unResultat.getString("conservation")
						);
				
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+exp);
		}
		return unVaccin;
	}
	
	public static Vaccin selectWhereVaccin(String nom, String laboratoire, String pays, String conservation) {
		String requete="select * from vaccin where nom='"+nom+"' and laboratoire='"+laboratoire+"' and pays='"+pays+"' and conservation='"+conservation+"';";
		Vaccin unVaccin=null;
		try {
			uneBdd.seConnecter();
			Statement unStat=uneBdd.getMaConnexion().createStatement();
			ResultSet unResultat=unStat.executeQuery(requete);
			if(unResultat.next()) {
				unVaccin= new Vaccin(
						unResultat.getInt("idvaccin"), unResultat.getString("nom"), unResultat.getString("laboratoire"),
						unResultat.getString("pays"), unResultat.getString("conservation")
						);
				
			}
			unStat.close();
			uneBdd.seDeconnecter();
		}
		catch(SQLException exp) {
			System.out.println("Erreur d'execution de: "+exp);
		}
		return unVaccin;
	}
}
