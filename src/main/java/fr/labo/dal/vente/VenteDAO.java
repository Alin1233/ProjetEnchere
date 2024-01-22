package fr.labo.dal.vente;

import java.util.List;

import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Categorie;
import fr.labo.bo.Enchere;

public interface VenteDAO {
	
	public void insertArticle(ArticleVendu vente);
	
	public void insertEnchere(Enchere enchere);
	
	public List<ArticleVendu> selectAllArticles();
	
	public List<Enchere> selectAllEncheres();
	
	public List<ArticleVendu> selectCategorie(Categorie categorie);
	
	public List<String>selectCategorieLibelles();
	
	public ArticleVendu selectById(int id);
}
