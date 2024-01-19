package fr.labo.bo;

import java.io.Serializable;

public class Categorie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int noCategorie;
	private String libelle;
	
	public Categorie() {
	}
	public Categorie(String libelle) {
		
		this.libelle = libelle;
	}
	public Categorie(int noCategorie, String libelle) {
		
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}
	public int getNoCategorie() {
		return noCategorie;
	}
	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}
	public String getLibelle() {
		return libelle;
	}
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + "]";
	}
	
	
	
}
