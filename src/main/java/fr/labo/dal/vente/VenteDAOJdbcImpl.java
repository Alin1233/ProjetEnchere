package fr.labo.dal.vente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.labo.bo.Adresse;
import fr.labo.bo.ArticleVendu;
import fr.labo.bo.Categorie;
import fr.labo.bo.Enchere;
import fr.labo.bo.Utilisateur;
import fr.labo.dal.ConnectionProvider;
import fr.labo.dal.utilisateur.HelperClassUtilisateur;

public class VenteDAOJdbcImpl implements VenteDAO {

	@Override
	public void insertArticle(ArticleVendu vente) {
		String insertArticleQuery = "INSERT INTO ARTICLES_VENDUS (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial,"
				+ "prix_vente, no_utilisateur, no_categorie) VALUES("
				+ "?,?,?,?,?,?,?,?)";
		String insertRetraitQuery = "INSERT INTO RETRAITS (no_article, rue, code_postal, ville) VALUES"
				+ "(?,?,?,?)";
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmtArticle = cnx.prepareStatement(insertArticleQuery,Statement.RETURN_GENERATED_KEYS);
			
			PreparedStatement pstmtRetrait = cnx.prepareStatement(insertRetraitQuery);
			
			pstmtArticle = HelperClassVente.setPreparedStatementParameters(pstmtArticle, vente);
			pstmtArticle.executeUpdate();
			
			ResultSet rs = pstmtArticle.getGeneratedKeys();
			if(rs.next()) {
				vente.setNoArticle(rs.getInt(1));
			}
			//insérer dans la table retrait après avoir obtenu id de l'article
			pstmtRetrait.setInt(1, vente.getNoArticle());
			pstmtRetrait.setString(2, vente.getRetrait().getRue());
			pstmtRetrait.setString(3, vente.getRetrait().getCodePostal());
			pstmtRetrait.setString(4, vente.getRetrait().getVille());
			pstmtRetrait.execute();
			
			
			rs.close();
			pstmtArticle.close();
			pstmtRetrait.close();
			cnx.close();
			
		} catch (SQLException e) {
			 System.out.println("Erreur d'insertion de l'ArticleVendu " + e.getMessage());
		}
		
	}

	@Override
	public List<ArticleVendu> selectAllArticles() {
		String selectAllQuery = "SELECT * FROM ARTICLES_VENDUS JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur "
				+ "JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie "
				+ "JOIN RETRAITS ON ARTICLES_VENDUS.no_article = RETRAITS.no_article";
		
		ArrayList<ArticleVendu> allArticles = new ArrayList<ArticleVendu>();
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt =cnx.prepareStatement(selectAllQuery);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Utilisateur user = new Utilisateur();
				user = HelperClassUtilisateur.createUserFromRs(rs);
				ArticleVendu article = new ArticleVendu();
				article = HelperClassVente.createArticleFromRS(rs);
				article.setVendeur(user);
				allArticles.add(article);
			}
			cnx.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Erreur List<ArticleVendu> selectAll() " + e.getMessage());
		}
		return allArticles;
	}

	@Override
	public List<ArticleVendu> selectAllArticlesCategorie(Categorie categorie) {
		List<ArticleVendu> articles = new ArrayList<ArticleVendu>();
		
		String selectAllArtByCatQuery = "SELECT * FROM ARTICLES_VENDUS "
				+ "JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur "
				+ "JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie "
				+ "JOIN RETRAITS ON ARTICLES_VENDUS.no_article = RETRAITS.no_article "
				+ "WHERE ARTICLES_VENDUS.no_categorie = ?";
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt =cnx.prepareStatement(selectAllArtByCatQuery);
			pstmt.setInt(1, categorie.getNoCategorie());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Utilisateur user = new Utilisateur();
				user = HelperClassUtilisateur.createUserFromRs(rs);
				ArticleVendu article = new ArticleVendu();
				article = HelperClassVente.createArticleFromRS(rs);
				article.setVendeur(user);
				articles.add(article);
			}
			cnx.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("List<ArticleVendu> selectAllArticlesCategorie(Categorie categorie) " + e.getMessage());
		}
		return articles;
	}

	@Override
	public List<String> selectCategorieLibelles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleVendu selectArticleById(int id) {
		ArticleVendu article = null;
		String selectByIdQuery = "SELECT * FROM ARTICLES_VENDUS "
			    + "JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie "
			    + "JOIN RETRAITS ON ARTICLES_VENDUS.no_article = RETRAITS.no_article "
			    + "JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur "
			    + "WHERE ARTICLES_VENDUS.no_article = ?";
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt =cnx.prepareStatement(selectByIdQuery);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Utilisateur user = new Utilisateur();
				user = HelperClassUtilisateur.createUserFromRs(rs);
				article = HelperClassVente.createArticleFromRS(rs);
				article.setVendeur(user);
			}
			cnx.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			 System.out.println("Erreur ArticleVendu selectArticleById(int id) " + e.getMessage());
		}
		return article;
	}

	@Override
	public void insertEnchere(Enchere enchere) {
		String insertEnchereQuery ="INSERT INTO ENCHERES (no_utilisateur, no_article, date_enchere, montant_enchere) "
				+ "VALUES (?, ?, ?, ?)";
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(insertEnchereQuery);
			
			pstmt.setInt(1, enchere.getUtilisateur().getNoUtilisateur());
			pstmt.setInt(2, enchere.getArticleVendu().getNoArticle());
			pstmt.setString(3,enchere.getDateEnchere());
			pstmt.setInt(4, enchere.getMontant_enchere());
			
			pstmt.execute();
			
			pstmt.close();
			cnx.close();
		} catch (SQLException e) {
			 System.out.println("Erreur d'insertion de insertEnchere " + e.getMessage());
		}
		
	}

	@Override
	public List<Enchere> selectAllEncheres() {
		List<Enchere> allEncheres = new ArrayList<Enchere>();
		String selectAllQuery = "SELECT * FROM ENCHERES JOIN UTILISATEURS ON ENCHERES.no_utilisateur = UTILISATEURS.no_utilisateur "
				+ "JOIN ARTICLES_VENDUS ON ENCHERES.no_article = ARTICLES_VENDUS.no_article "
				+ "JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie "
				+ "JOIN RETRAITS ON ARTICLES_VENDUS.no_article = RETRAITS.no_article";
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(selectAllQuery);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Utilisateur user = new Utilisateur();
				user = HelperClassUtilisateur.createUserFromRs(rs);
				ArticleVendu article = new ArticleVendu();
				article = HelperClassVente.createArticleFromRS(rs);
				
				Enchere enchere = new Enchere();
				
				enchere.setArticleVendu(article);
				enchere.setUtilisateur(user);
				enchere.setMontant_enchere(rs.getInt("montant_enchere"));
				enchere.setDateEnchere(rs.getString("date_enchere"));
				
				allEncheres.add(enchere);
				
			}
			cnx.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Erreur List<Enchere> selectAllEncheres() " + e.getMessage());
		}
		
		
		return allEncheres;
	}

	@Override
	public List<Enchere> selectEnchereByUserId(int id) {
		List<Enchere> allEnchereByUser = new ArrayList<Enchere>();
		String selectEnchereQuery = "SELECT * FROM ENCHERES JOIN UTILISATEURS ON ENCHERES.no_utilisateur = UTILISATEURS.no_utilisateur "
				+ "JOIN ARTICLES_VENDUS ON ENCHERES.no_article = ARTICLES_VENDUS.no_article "
				+ "JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie "
				+ "JOIN RETRAITS ON ARTICLES_VENDUS.no_article = RETRAITS.no_article "
				+ "WHERE ENCHERES.no_utilisateur = ?";
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(selectEnchereQuery);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Utilisateur user = new Utilisateur();
				user = HelperClassUtilisateur.createUserFromRs(rs);
				ArticleVendu article = new ArticleVendu();
				article = HelperClassVente.createArticleFromRS(rs);
				
				//pas sûr que ce soit bon, bugs possibles, à vérifier plus tard
				article.setVendeur(user);
				
				Enchere enchere = new Enchere();
				
				enchere.setArticleVendu(article);
				enchere.setUtilisateur(user);
				enchere.setMontant_enchere(rs.getInt("montant_enchere"));
				enchere.setDateEnchere(rs.getString("date_enchere"));
				
				allEnchereByUser.add(enchere);
				
			}
		} catch (SQLException e) {
			System.out.println("Erreur List<Enchere> selectEnchereByUserId(int id) " + e.getMessage());
		}
		
		return allEnchereByUser;
	}

}
