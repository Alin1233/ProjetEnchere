package fr.labo.dal.vente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Categorie;
import fr.labo.dal.ConnectionProvider;

public class VenteDAOJdbcImpl implements VenteDAO {

	@Override
	public void insert(ArticleVendu vente) {
		String insertArticleQuery = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial,"
				+ "prix_vente, no_utilisateur, no_categorie) VALUES("
				+ "?,?,?,?,?,?,?,?,?)";
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(insertArticleQuery,Statement.RETURN_GENERATED_KEYS);
			
			pstmt = HelperClassVente.setPreparedStatementParameters(pstmt, vente);
			pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				vente.setNoArticle(rs.getInt(1));
			}
			rs.close();
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			 System.out.println("Erreur d'insertion de l'ArticleVendu" + e.getMessage());
		}
		
	}

	@Override
	public List<ArticleVendu> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ArticleVendu> selectCategorie(Categorie categorie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> selectCategorieLibelles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleVendu selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
