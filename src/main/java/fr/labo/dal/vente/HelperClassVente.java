package fr.labo.dal.vente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.labo.bo.Adresse;
import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Categorie;

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
	public static ArticleVendu createArticleFromRS(ResultSet rs)throws SQLException {
		ArticleVendu article = new ArticleVendu();
		
		
		article.setNoArticle(rs.getInt("no_article"));
		article.setNomArticle(rs.getString("nom_article"));
		article.setDescription(rs.getString("description"));
		article.setDateDebutEncheres(rs.getString("date_debut_encheres"));
		article.setDateFinEncheres(rs.getString("date_fin_encheres"));
		article.setMiseAPrix(rs.getInt("prix_initial"));
		article.setPrixVente(rs.getInt("prix_vente"));
		
		Categorie categorie = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
		article.setCategorie(categorie);
		
		Adresse adresse = new Adresse(rs.getString("rue"),rs.getString("code_postal"),rs.getString("ville"));
		article.setRetrait(adresse);
		
		
		
		
		return article;
	}

}
