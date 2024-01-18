package fr.labo.dal.utilisateur;

import java.util.List;

import fr.labo.bo.Utilisateur;

public interface UtilisateurDAO {

	//crée l'utilisateur dans la db
	public void insert(Utilisateur user);
	//modifier l'utilisateur dans la db
	public void update(Utilisateur user);
	//supprime l'utilisateur dans la db
	public void delete(int id);

	//retourne un utilisateur si le pseudo et le mot de passe sont trouvés dans la db
	public Utilisateur selectByPseudoEtPassword(String pseudo, String motDePasse);

	public Utilisateur selectById(int id);

	public List<Utilisateur> selectAll();
	
	public String checkPseudoEtEmail(String pseudo, String email);
}
