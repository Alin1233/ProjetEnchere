package fr.labo.dal.utilisateur;

public interface UtilisateurDAO {
	
	//crée l'utilisateur dans la db
	public void insert(Utilisateur user);
	//modifier l'utilisateur dans la db
	public void update(Utilisateur user);
	//supprime l'utilisateur dans la db
	public void delete(Utilisateur user);
	//retourne un utilisateur si le pseudo et le mot de passe sont trouvés dans la db
	public Utilisateur selectByPseudoEtPassword(String pseudo, String motDePasse); 
}
