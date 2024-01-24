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
	public List<String> selectCategorieByLibelles() {
		
		final String SELECT_ALL_CATEGORIES = "SELECT * FROM CATEGORIES";
		List<String> categories = new ArrayList<String>();

		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement stm = cnx.prepareStatement(SELECT_ALL_CATEGORIES);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				
				String libelleCategorie = rs.getString(2);
				categories.add(libelleCategorie);
				
			}
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("List<String> selectCategorieLibelles() " + e.getMessage());
		}
		
		
		return categories;
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

	@Override
	public void updateArticle(ArticleVendu article) {
		String updateArticleQuery = "UPDATE ARTICLES_VENDUS SET nom_article = ?, description = ?, date_debut_encheres = ?, date_fin_encheres = ?, prix_initial = ?, "
			    + "prix_vente = ?, no_utilisateur = ?, no_categorie = ? WHERE no_article = ?";

		String updateRetraitQuery = "UPDATE RETRAITS SET rue = ?, code_postal = ?, ville = ? WHERE no_article = ?";

		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt =cnx.prepareStatement(updateArticleQuery);
			PreparedStatement pstmtRetrait = cnx.prepareStatement(updateRetraitQuery);
			pstmt = HelperClassVente.setPreparedStatementParameters(pstmt, article);
			pstmt.setInt(9, article.getNoArticle());
			pstmt.executeUpdate();
			
			
			pstmtRetrait.setString(1, article.getRetrait().getRue());
			pstmtRetrait.setString(2, article.getRetrait().getCodePostal());
			pstmtRetrait.setString(3, article.getRetrait().getVille());
			pstmtRetrait.setInt(4, article.getNoArticle());
			pstmtRetrait.executeUpdate();
			
			pstmt.close();
			pstmtRetrait.close();
			cnx.close();
					
		} catch (SQLException e) {
			System.out.println("Erreur updateArticle(int id) " + e.getMessage());
		}
	}

	@Override
	public List<ArticleVendu> selectAllArticlesByUser(Utilisateur user) {
		String selectAllQuery = "SELECT * FROM ARTICLES_VENDUS JOIN UTILISATEURS ON ARTICLES_VENDUS.no_utilisateur = UTILISATEURS.no_utilisateur "
				+ "JOIN CATEGORIES ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie "
				+ "JOIN RETRAITS ON ARTICLES_VENDUS.no_article = RETRAITS.no_article "
				+ "WHERE ARTICLES_VENDUS.no_utilisateur = ?";
		
		ArrayList<ArticleVendu> allArticles = new ArrayList<ArticleVendu>();
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt =cnx.prepareStatement(selectAllQuery);
			pstmt.setInt(1, user.getNoUtilisateur());
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Utilisateur userOg = new Utilisateur();
				userOg = HelperClassUtilisateur.createUserFromRs(rs);
				ArticleVendu article = new ArticleVendu();
				article = HelperClassVente.createArticleFromRS(rs);
				article.setVendeur(userOg);
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
	public List<Categorie> selectAllCategories() {
		final String SELECT_ALL_CATEGORIES = "SELECT * FROM CATEGORIES";
		List<Categorie> categories = new ArrayList<Categorie>();

		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement stm = cnx.prepareStatement(SELECT_ALL_CATEGORIES);
			ResultSet rs = stm.executeQuery();
			
			while(rs.next()) {
				Categorie cat = new Categorie(rs.getInt(1), rs.getString(2));
				categories.add(cat);	
			}
			cnx.close();
			stm.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("List<Categorie> selectAllCategories()" + e.getMessage());
		}
		return categories;
	}

	@Override
	public void insertCategorie(Categorie categorie) {
		String insertQuery = "INSERT INTO CATEGORIES (libelle) VALUES (?)";
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt =cnx.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, categorie.getLibelle());
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if(rs.next()) {
				categorie.setNoCategorie(rs.getInt(1));
			}
			pstmt.close();
			rs.close();
			cnx.close();
		} catch (SQLException e) {
			System.out.println("insertCategorie(Categorie categorie)" + e.getMessage());
		}
		
	}

	@Override
	public void deleteCategorie(int id) {
		String deleteQuery = "DELETE FROM CATEGORIES WHERE no_categorie = ?";
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt =cnx.prepareStatement(deleteQuery);
			pstmt.setInt(1, id);
			pstmt.execute();
			
			cnx.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("deleteCategorie(int id)" + e.getMessage());
		}
		
	}

	@Override
	public void updateCategorie(Categorie categorie) {
		String updateQuery = "UPDATE CATEGORIES SET libelle = ? WHERE no_categorie = ?";

		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(updateQuery);
			pstmt.setString(1, categorie.getLibelle());
			pstmt.setInt(2, categorie.getNoCategorie());
			pstmt.executeUpdate();
			
			cnx.close();
			pstmt.close();
		} catch (SQLException e) {
			System.out.println("updateCategorie(Categorie categorie)" + e.getMessage());
		}
		
	}

}
