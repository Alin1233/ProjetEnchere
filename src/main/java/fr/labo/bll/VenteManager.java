package fr.labo.bll;

import java.util.List;

import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Categorie;
import fr.labo.dal.vente.VenteDAO;

public class VenteManager {
	
	VenteDAO venteDAO;
	
	//Rien ne fonctionne ici pour l'instant!!!!!!!!
	
	public void ajuterVente(ArticleVendu article) {
		venteDAO.insert(article);
	}
	
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
