package fr.labo.dal.vente;

import java.util.List;

import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Categorie;
import fr.labo.bo.Enchere;
import fr.labo.bo.Utilisateur;

public interface VenteDAO {
	
	public void insertArticle(ArticleVendu vente);
	
	public void insertEnchere(Enchere enchere);
	
	public List<ArticleVendu> selectAllArticles();
	
	public List<Enchere> selectAllEncheres();
	
	public List<ArticleVendu> selectAllArticlesCategorie(Categorie categorie);
	
	public void updateArticle(ArticleVendu article);
	
	public List<ArticleVendu> selectAllArticlesByUser(Utilisateur user);
	
	public List<String>selectCategorieByLibelles();
	
	public ArticleVendu selectArticleById(int id);
	
	public List<Enchere> selectEnchereByUserId(int id);
	
	public List<Categorie> selectAllCategories();
	
	public void insertCategorie(Categorie categorie);
	
	public void deleteCategorie(int id);
	
	public void updateCategorie(Categorie categorie);
}