package fr.labo.bll;

import java.sql.SQLException;
import java.util.List;

import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Categorie;
import fr.labo.bo.Enchere;
import fr.labo.bo.Utilisateur;
import fr.labo.dal.DAOFactory;
import fr.labo.dal.vente.VenteDAO;

public class VenteManager {
	
	VenteDAO venteDAO;
	
	public VenteManager() {
		this.venteDAO = DAOFactory.getVenteDAO();
	}
	
	//insérer une nouvelle enchère dans la db
	public void ajuterEnchere(Enchere enchere) {
		venteDAO.insertEnchere(enchere);
	}
	
	//insérer l'objet article dans la db
	public void ajuterVente(ArticleVendu article) throws SQLException{
		venteDAO.insertArticle(article);
	}
	//obtenir tous les articles de la db
	public List<ArticleVendu> getAllArticles(){
		return venteDAO.selectAllArticles();
	}
	//obtenir tous les Encheres de la db
	public List<Enchere> getAllEncheres(){
		return venteDAO.selectAllEncheres();
	}
	//obtenir un article par id dans la db
	public ArticleVendu getArticleVendu(int id) {
		return venteDAO.selectArticleById(id);
	}
	//obtenir une liste de tous les Encheres effectués par un utilisateur
	public List<Enchere> getAllEncheresByUser(int no_utilisateur) {
		return venteDAO.selectEnchereByUserId(no_utilisateur);
	}
	//obtenir une liste de tous les articles d'une catégorie précise
	public List<ArticleVendu> getAllArticlesDansCategorie(Categorie categorie){
		return venteDAO.selectAllArticlesCategorie(categorie);
	}
	//mettre à jour un article, utile si vous voulez changer l'adresse d'un retrait
	public void updateArticle(ArticleVendu article) {
		venteDAO.updateArticle(article);
	}
	//obtenir tous les articles créés par un utilisateur
	public List<ArticleVendu> getAllArticlesByUser(Utilisateur user){
		return venteDAO.selectAllArticlesByUser(user);
	}
	
	public List<String> getCategorieByLibelles(){
		return venteDAO.selectCategorieByLibelles();
	}
	public List<Categorie> getAllCategories(){
		return venteDAO.selectAllCategories();
	}
	public void ajuterCategorie(Categorie categorie) {
		venteDAO.insertCategorie(categorie);
	}
	public void deleteCategorie(int id) {
		venteDAO.deleteCategorie(id);
	}
	public void updateCategorie(Categorie categorie) {
		venteDAO.updateCategorie(categorie);
	}
	
	
}