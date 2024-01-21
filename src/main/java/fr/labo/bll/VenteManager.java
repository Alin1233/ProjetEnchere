package fr.labo.bll;

import java.util.List;

import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Categorie;
import fr.labo.bo.Enchere;
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
	
	//Insérer l'objet article dans la db
	public void ajuterVente(ArticleVendu article) {
		venteDAO.insertArticle(article);
	}
	
	//rien ne fonctionne sous ce commentaire pour le instant !!!!!
	
	public List<ArticleVendu> getAll(){
		return venteDAO.selectAll();
	}
	
	public List<ArticleVendu> getCategorie(Categorie categorie){
		return venteDAO.selectCategorie(categorie);
	}
	
	public List<String> getCategorieLibelles(){
		return venteDAO.selectCategorieLibelles();
	}
	
	public ArticleVendu getArticleVendu(int id) {
		return venteDAO.selectById(id);
	}
	
}
