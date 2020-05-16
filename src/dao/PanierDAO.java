package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Livre;
import beans.Panier;
import utils.DBInteraction;

public class PanierDAO {
	
	public static List<Panier> chercherPanier(int idd) {
		List<Panier> panier = new ArrayList<Panier>();
		int i = 0;
		DBInteraction.connect();    
		ResultSet res = DBInteraction.Select("select * from panier where idd= "+idd+"");
		   try {
			   while(res.next()) {
				panier.add(new Panier(res.getInt("id"),idd,res.getString("nom"),res.getString("auteur"),res.getInt("quantite"),res.getInt("prix"),res.getString("image")));
			   }
			   } catch (SQLException e) {
			   e.printStackTrace();
		   }
		   DBInteraction.disconnect();
		   return panier;
	}
	
	public static void ajouterPanier(Panier panier) {
		int idd = panier.getIdd();
		String nom = panier.getNom();
		String auteur = panier.getAuteur();
		int prix = panier.getPrix();
		String image = panier.getImage();
		DBInteraction.connect();
		DBInteraction.Maj("insert into panier (idd, nom, auteur, prix, image) value ('"+idd+"' , '"+nom+"' ,'"+auteur+"' , '"+prix+"' , '"+image+"')");
		DBInteraction.disconnect();
	}
	
	public static void supprimerPanierIdd(int idd) {
		DBInteraction.connect();
		DBInteraction.Maj("delete from panier where idd = "+idd+"");
		DBInteraction.disconnect();
		
	}
	
	public static void supprimerPanier(int id) {
		DBInteraction.connect();
		DBInteraction.Maj("delete from panier where id = "+id+"");
		DBInteraction.disconnect();
		
	}


}
