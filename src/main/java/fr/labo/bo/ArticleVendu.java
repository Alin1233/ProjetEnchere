package fr.labo.bo;

import java.io.Serializable;

public class ArticleVendu implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int noArticle;
	private String nomArticle;
	private String description;
	private String dateDebutEncheres;
	private String dateFinEncheres;
	private Integer miseAPrix;
	private Integer prixVente;
	private String etatVente;
	
	private Categorie categorie;
	private Utilisateur vendeur;
	private Adresse retrait;
	
	public ArticleVendu() {
		
	}
	public ArticleVendu(String nomArticle, String description, String dateDebutEncheres,
			String dateFinEncheres, Integer miseAPrix, Integer prixVente, String etatVente, Categorie categorie,
			Utilisateur vendeur, Adresse retrait) {
		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorie = categorie;
		this.vendeur = vendeur;
		this.retrait = retrait;
	}
	public ArticleVendu(int noArticle, String nomArticle, String description, String dateDebutEncheres,
			String dateFinEncheres, Integer miseAPrix, Integer prixVente, String etatVente, Categorie categorie,
			Utilisateur vendeur, Adresse retrait) {
		super();
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.dateDebutEncheres = dateDebutEncheres;
		this.dateFinEncheres = dateFinEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorie = categorie;
		this.vendeur = vendeur;
		this.retrait = retrait;
	}
	public int getNoArticle() {
		return noArticle;
	}
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDateDebutEncheres() {
		return dateDebutEncheres;
	}
	public void setDateDebutEncheres(String dateDebutEncheres) {
		this.dateDebutEncheres = dateDebutEncheres;
	}
	public String getDateFinEncheres() {
		return dateFinEncheres;
	}
	public void setDateFinEncheres(String dateFinEncheres) {
		this.dateFinEncheres = dateFinEncheres;
	}
	public Integer getMiseAPrix() {
		return miseAPrix;
	}
	public void setMiseAPrix(Integer miseAPrix) {
		this.miseAPrix = miseAPrix;
	}
	public Integer getPrixVente() {
		return prixVente;
	}
	public void setPrixVente(Integer prixVente) {
		this.prixVente = prixVente;
	}
	public String getEtatVente() {
		return etatVente;
	}
	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Utilisateur getVendeur() {
		return vendeur;
	}
	public void setVendeur(Utilisateur vendeur) {
		this.vendeur = vendeur;
	}
	public Adresse getRetrait() {
		return retrait;
	}
	public void setRetrait(Adresse retrait) {
		this.retrait = retrait;
	}
	@Override
	public String toString() {
		return "ArticleVendu [noArticle=" + noArticle + ", nomArticle=" + nomArticle + ", description=" + description
				+ ", dateDebutEncheres=" + dateDebutEncheres + ", dateFinEncheres=" + dateFinEncheres + ", miseAPrix="
				+ miseAPrix + ", prixVente=" + prixVente + ", etatVente=" + etatVente + ", categorie=" + categorie
				+ ", vendeur=" + vendeur + ", retrait=" + retrait + "]";
	}
	
	
}
