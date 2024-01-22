package fr.labo.bll;

import java.util.List;

import fr.labo.bo.Utilisateur;
import fr.labo.dal.DAOFactory;
import fr.labo.dal.utilisateur.UtilisateurDAO;

public class UtilisateurManager {
	private UtilisateurDAO utilisateurDAO;

	public UtilisateurManager() {
		this.utilisateurDAO = DAOFactory.getUtilisateurDAO();
	}

	//ajouter à la db
	public void ajouterUser(Utilisateur user) {
		utilisateurDAO.insert(user);
	}

	/*
	fonction qui vérifie si l'utilisateur qui tente de se connecter existe dans la db
	si le mot de passe et le pseudo sont bons, renvoie un objet utilisateur avec tous les détails 
	si le mot de passe et le pseudo sont faux, renvoie null
	utile pour le login
	*/
	public Utilisateur verifierPseudoEtPassword(String pseudo, String password) {
		return utilisateurDAO.selectByPseudoEtPassword(pseudo, password);
	}
	//supprimer de la db
	public void deleteUser(int id) {
		utilisateurDAO.delete(id);
	}
	//mettre à jour l'utilisateur dans la db
	public void updateUser(Utilisateur user) {
		utilisateurDAO.update(user);
	}
	//renvoie un utilisateur, vérifie par l'id
	public Utilisateur getUser(int id) {
		return utilisateurDAO.selectById(id);
	}
	//renvoie tous les utilisateurs de la db
	public List<Utilisateur> getAll(){
		return utilisateurDAO.selectAll();
	}
	/* si l'email est pris, renvoie "email-pris"
	 * si le pseudo est pris, renvoie "pseudo-pris"
	 * else renvoie "bon"
	*/
	public String checkPseudoEtEmail(String pseudo, String email) {
		return utilisateurDAO.checkPseudoEtEmail(pseudo, email);
	}
	public Utilisateur getUserByPseudo(String pseudo) {
		return utilisateurDAO.selectUserByPseudo(pseudo);
	}
	

}
