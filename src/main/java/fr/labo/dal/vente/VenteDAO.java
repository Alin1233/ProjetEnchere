package fr.labo.dal.vente;

import java.util.List;

import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Categorie;

public interface VenteDAO {
	
	public void insert(ArticleVendu vente);
	
	public List<ArticleVendu> selectAll();
	
	public List<ArticleVendu> selectCategorie(Categorie categorie);
}
