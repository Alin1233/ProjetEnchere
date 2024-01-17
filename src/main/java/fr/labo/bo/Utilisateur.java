package fr.labo.bo;

import java.util.HashSet;
import java.util.Set;

public class Utilisateur {

    private static int nextNoUtilisateur = 1;

    private int noUtilisateur;
    private String pseudo;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private Adresse adresse;
    private int credit;
    private boolean isAdmin;
    private String motDePasse;

    private static Set<String> usedPseudos = new HashSet<>();
    private static Set<String> usedEmails = new HashSet<>();

    public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, Adresse adresse, boolean isAdmin, String motDePasse) {
        this.noUtilisateur = nextNoUtilisateur++;
        setPseudo(pseudo);
        this.nom = nom;
        this.prenom = prenom;
        setEmail(email);
        setTelephone(telephone);
        this.adresse = adresse;
        this.credit = 0;
        this.isAdmin = isAdmin;
        this.motDePasse = motDePasse;
    }

    public int getNoUtilisateur() {
        return noUtilisateur;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        if (usedPseudos.contains(pseudo)) {
            throw new IllegalArgumentException("Le pseudo est déjà utilisé");
        }
        this.pseudo = pseudo;
        usedPseudos.add(pseudo);
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (usedEmails.contains(email)) {
            throw new IllegalArgumentException("L'Email est déjà utilisé");
        }
        this.email = email;
        usedEmails.add(email);
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        if (telephone.length() != 10 || !telephone.matches("\\d+")) {
            throw new IllegalArgumentException("Le numéro de téléphone doit comporter 10 chiffres");
        }
        this.telephone = telephone;
    }

    public Adresse getAdresse() {
        return adresse;
    }
    
    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public String toString() {
		return "User [noUtilisateur=" + noUtilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", telephone=" + telephone + ", adresse=" + adresse + ", credit=" + credit
				+ ", isAdmin=" + isAdmin + ", motDePasse=" + motDePasse + "]";
	}
    
}
