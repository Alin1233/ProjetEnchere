package fr.labo.dal.utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.labo.bo.Utilisateur;
import fr.labo.dal.ConnectionProvider;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	@Override
	public void insert(Utilisateur user) {
		String userInsertQuery = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(userInsertQuery,PreparedStatement.RETURN_GENERATED_KEYS);
			
			pstmt.setString(1, user.getPseudo());
			pstmt.setString(2, user.getNom());
			pstmt.setString(3, user.getPrenom());
			pstmt.setString(4, user.getEmail());
			pstmt.setString(5, user.getTelephone());
			pstmt.setString(6, user.getAdresse().getRue());
			pstmt.setString(7, user.getAdresse().getCodePostal());
			pstmt.setString(8, user.getAdresse().getCodePostal());
			pstmt.setString(9, user.getAdresse().getVille());
			pstmt.setString(10, user.getMotDePasse());
			pstmt.setInt(11, user.getCredit());
			pstmt.setBoolean(12, user.isAdmin());
			
			pstmt.executeUpdate();
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				user.setnoUtilisateur(rs.getInt(1));
			}
			rs.close();
			pstmt.close();
			cnx.close();
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
	}

	@Override
	public void update(Utilisateur user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Utilisateur user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Utilisateur selectByPseudoEtPassword(String pseudo, String motDePasse) {
		// TODO Auto-generated method stub
		return null;
	}

}
