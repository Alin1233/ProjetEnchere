package fr.labo.dal;

import fr.labo.dal.utilisateur.UtilisateurDAO;
import fr.labo.dal.utilisateur.UtilisateurDAOJdbcImpl;

public abstract class DAOFactory {
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}

}
