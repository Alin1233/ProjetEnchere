package fr.labo.dal.utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.labo.bo.Adresse;
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
			pstmt.setString(8, user.getAdresse().getVille());
			pstmt.setString(9, user.getMotDePasse());
			pstmt.setInt(10, user.getCredit());
			pstmt.setBoolean(11, user.getAdministrateur());
			
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Utilisateur user) {
		// TODO Auto-generated method stub
		
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
				
				user = createUserFromRs(rs);
				
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
				
				user = createUserFromRs(rs);
				
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
		
		List<Utilisateur> userList = new ArrayList<Utilisateur>();
		String selectAll = "SELECT * FROM UTILISATEURS";
		
		try {
			Connection cnx = ConnectionProvider.getConnection();
			PreparedStatement pstmt = cnx.prepareStatement(selectAll);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				userList.add(createUserFromRs(rs));
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return userList;
	}
	
	//fonction qui prend un rs et renvoie un objet utilisateur basé sur cet result set
	private Utilisateur createUserFromRs(ResultSet rs) {
		Utilisateur user = new Utilisateur();
		
		try {
			user.setNoUtilisateur(rs.getInt("no_utilisateur"));
			user.setPseudo(rs.getString("pseudo"));
			user.setNom(rs.getString("nom"));
			user.setPrenom(rs.getString("prenom"));
			user.setEmail(rs.getString("email"));
			user.setTelephone(rs.getString(rs.getString("telephone")));
			
			Adresse adressee = new Adresse(rs.getString("rue"), rs.getString("ville"), rs.getString("code_postal"));
			user.setAdresse(adressee);
			user.setMotDePasse(rs.getString("mot_de_passe"));
			user.setCredit(rs.getInt("credit"));
			user.setAdmnistrateur(rs.getBoolean("administrateur"));
		} catch (Exception e) {
			System.out.println("Erreur createUserFromRs" + e.getMessage());
		}
	
		return user;
	}

}
