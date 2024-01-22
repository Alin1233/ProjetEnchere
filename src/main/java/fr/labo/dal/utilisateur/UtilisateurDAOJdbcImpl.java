package fr.labo.dal.utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import fr.labo.bo.Utilisateur;
import fr.labo.dal.ConnectionProvider;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	@Override
	public void insert(Utilisateur user) {
		String userInsertQuery = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(userInsertQuery,Statement.RETURN_GENERATED_KEYS);

			pstmt = HelperClassUtilisateur.setPreparedStatementParameters(pstmt, user);

			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				user.setNoUtilisateur(rs.getInt(1));
			}
			rs.close();
			pstmt.close();
			cnx.close();

		} catch (SQLException e) {
			 System.out.println("Erreur d'insertion de l'utilisateur" + e.getMessage());
		}
	}

	@Override
	public void update(Utilisateur user) {
		String userUpdateQuery = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ? WHERE no_utilisateur = ?";

		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(userUpdateQuery);

			pstmt = HelperClassUtilisateur.setPreparedStatementParameters(pstmt, user);
			//id
			pstmt.setInt(12, user.getNoUtilisateur());

			pstmt.executeUpdate();
			pstmt.close();
			cnx.close();

		} catch (SQLException e) {
			System.out.println("Erreur mise à jour de l'utilisateur" + e.getMessage());
		}
	}

	@Override
	public void delete(int id) {
		String deleteQuery = "DELETE FROM UTILISATEURS WHERE id = ?";
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(deleteQuery);

			pstmt.setInt(1, id);
			pstmt.executeUpdate();

			pstmt.close();
			cnx.close();

		} catch (SQLException e) {
			 System.out.println("Erreur supprimer de l'utilisateur" + e.getMessage());
		}

	}

	@Override
	public Utilisateur selectByPseudoEtPassword(String pseudo, String motDePasse) {

		Utilisateur user = null;
		String selectByQuery = "SELECT * FROM UTILISATEURS WHERE pseudo = ? AND mot_de_passe = ?";
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(selectByQuery);

			pstmt.setString(1, pseudo);
			pstmt.setString(2, motDePasse);

			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {

				user = HelperClassUtilisateur.createUserFromRs(rs);

			}
			rs.close();
			pstmt.close();
			cnx.close();

		} catch (SQLException e) {
			System.out.println("Erreur selectByPseudoEtPassword" + e.getMessage());
		}
		return user;
	}

	@Override
	public Utilisateur selectById(int id) {
		Utilisateur user = null;
		String selectById = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
		try {

			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(selectById);

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {

				user = HelperClassUtilisateur.createUserFromRs(rs);

			}
			rs.close();
			pstmt.close();
			cnx.close();

		} catch (SQLException e) {
			System.out.println("Erreur selectById" + e.getMessage());
		}
		return user;
	}

	@Override
	public List<Utilisateur> selectAll() {

		List<Utilisateur> userList = new ArrayList<>();
		String selectAll = "SELECT * FROM UTILISATEURS";

		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(selectAll);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				userList.add(HelperClassUtilisateur.createUserFromRs(rs));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}

		return userList;
	}
	@Override
	public String checkPseudoEtEmail(String pseudo, String email) {
		
		String queryPseudo = "SELECT * FROM UTILISATEURS WHERE pseudo = ?";
        String queryEmail = "SELECT * FROM UTILISATEURS WHERE email = ?";
        
        String toReturn = "bon";
        
        try {
        	
        	Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmtPseudo = cnx.prepareStatement(queryPseudo);
			PreparedStatement pstmtEmail= cnx.prepareStatement(queryEmail);
			
			pstmtPseudo.setString(1,pseudo);
			pstmtEmail.setString(1,email);
			
			ResultSet rsPseudo = pstmtPseudo.executeQuery();
			ResultSet rsEmail = pstmtEmail.executeQuery();
			
			if(rsPseudo.next()) {
				toReturn = "pseudo-pris";
			}else if(rsEmail.next()) {
				toReturn = "email-pris";
			}
			
		} catch (SQLException e) {
			System.out.println("Erreur checkPseudoEtEmail " + e.getMessage());
		}
		
		
		return toReturn;
	}

	@Override
	public Utilisateur selectUserByPseudo(String pseudo) {
		String selectQuery = "SELECT * FROM UTILISATEURS WHERE pseudo = ?";
		Utilisateur user = null;
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(selectQuery);
			pstmt.setString(1, pseudo);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				user = HelperClassUtilisateur.createUserFromRs(rs);
			}
			cnx.close();
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Erreur selectUserByPseudo(String pseudo)" + e.getMessage());
		}
		return user;
	}

	


}
