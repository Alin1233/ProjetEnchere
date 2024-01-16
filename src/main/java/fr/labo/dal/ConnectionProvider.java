package fr.labo.dal;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


abstract class ConnectionProvider {
 
	private static DataSource dataSource;
	
	// Bloc statique qui sera exécuté lors du chargement de la classe
	static 
	{
		Context context;
		try {
		    // Création d'un nouveau contexte initial
			context = new InitialContext();
			// Recherche de la source de données dans le contexte et affectation à la variable dataSource
			ConnectionProvider.dataSource = (DataSource) context.lookup("java:/comp/env/jdbc/pool_cnx");
		} catch (Exception e) {
		    // Impression de la trace de la pile d'exception en cas d'erreur
			e.printStackTrace();
		}
	}
	
	// Méthode statique pour obtenir une connexion à partir de la source de données
	public static Connection getConnection() throws SQLException {
		return ConnectionProvider.dataSource.getConnection();
	}
}
