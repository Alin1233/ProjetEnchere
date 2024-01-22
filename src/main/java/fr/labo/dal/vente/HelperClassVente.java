package fr.labo.dal.vente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import fr.labo.bo.ArticleVendu;

public class HelperClassVente {
	
	public static PreparedStatement setPreparedStatementParameters(PreparedStatement pstmt, ArticleVendu article) throws SQLException {
		
		pstmt.setString(1,article.getNomArticle());
		pstmt.setString(2,article.getDescription());
		pstmt.setString(3,article.getDateDebutEncheres());
		pstmt.setString(4,article.getDateFinEncheres());
		pstmt.setInt(5,article.getMiseAPrix());
		pstmt.setInt(6,article.getPrixVente());
		pstmt.setInt(7, article.getVendeur().getNoUtilisateur());
		pstmt.setInt(8, article.getCategorie().getNoCategorie());
		
		return pstmt;
		
	}

}
