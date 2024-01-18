package fr.labo.bo;

import java.util.Date;

public class Enchere {
	private String dateEnchere;
	private Float montant_enchere;
	private Utilisateur utilisateur;
	private ArticleVendu articleVendu;
	
	public Enchere() {
		
	}
	public Enchere(String dateEnchere, Float montant_enchere, Utilisateur utilisateur, ArticleVendu articleVendu) {
		super();
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.utilisateur = utilisateur;
		this.articleVendu = articleVendu;
	}
	public String getDateEnchere() {
		return dateEnchere;
	}
	public void setDateEnchere(String dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	public Float getMontant_enchere() {
		return montant_enchere;
	}
	public void setMontant_enchere(Float montant_enchere) {
		this.montant_enchere = montant_enchere;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}
	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}
	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montant_enchere=" + montant_enchere + ", utilisateur="
				+ utilisateur + "]";
	}
	
	
}
