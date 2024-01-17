package fr.labo.bo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Utilisateur implements Serializable {



    private int noUtilisateur;
	private String pseudo;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private Adresse adresse;
    private int credit = 0;
    private boolean administrateur = false;
    private String motDePasse;

    private static Set<String> usedPseudos = new HashSet<>();
    private static Set<String> usedEmails = new HashSet<>();

  public Utilisateur(){
  }

	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, Adresse adresse,
			int credit, boolean administrateur, String motDePasse) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.adresse = adresse;
		this.credit = credit;
		this.administrateur = administrateur;
		this.motDePasse = motDePasse;
	}

	public int getNoUtilisateur() {
        return noUtilisateur;
    }


	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
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

    public boolean getAdministrateur() {
        return administrateur;
    }

    public void setAdmnistrateur(boolean admin) {
        administrateur = admin;
    }

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public boolean pseudoUnique(String pseudo) {
        if (usedPseudos.contains(pseudo)) {
            throw new IllegalArgumentException("Le pseudo est déjà utilisé");
        }
		return true;

	}

	public boolean emailUnique(String email) {
        if (usedEmails.contains(email)) {
            throw new IllegalArgumentException("L'Email est déjà utilisé");
        }
        return true;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "User [noUtilisateur=" + noUtilisateur + ", pseudo=" + pseudo + ", nom=" + nom + ", prenom=" + prenom
				+ ", email=" + email + ", telephone=" + telephone + ", adresse=" + adresse + ", credit=" + credit
				+ ", administrateur=" + administrateur + ", motDePasse=" + motDePasse + "]";
	}

}
