package fr.labo.bll;

import fr.labo.bo.ArticleVendu;
import fr.labo.dal.vente.VenteDAO;

public class VenteManager {
	
	VenteDAO venteDAO;
	public void ajuterVente(ArticleVendu article) {
		venteDAO.insert(article);
	}
}
