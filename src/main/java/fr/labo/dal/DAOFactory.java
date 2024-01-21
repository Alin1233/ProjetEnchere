package fr.labo.dal;

import fr.labo.dal.utilisateur.UtilisateurDAO;
import fr.labo.dal.utilisateur.UtilisateurDAOJdbcImpl;
import fr.labo.dal.vente.VenteDAO;
import fr.labo.dal.vente.VenteDAOJdbcImpl;

public abstract class DAOFactory {
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
	public static VenteDAO getVenteDAO() {
		return new VenteDAOJdbcImpl();
	}

}
