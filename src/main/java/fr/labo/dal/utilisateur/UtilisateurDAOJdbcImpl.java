package fr.labo.dal.utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			PreparedStatement pstmt = cnx.prepareStatement(userInsertQuery,Statement.RETURN_GENERATED_KEYS);

			pstmt = setPreparedStatementParameters(pstmt, user);

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

			pstmt = setPreparedStatementParameters(pstmt, user);
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

		List<Utilisateur> userList = new ArrayList<>();
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
			user.setTelephone(rs.getString("telephone"));


			Adresse adressee = new Adresse(rs.getString("rue"), rs.getString("ville"), rs.getString("code_postal"));
			user.setAdresse(adressee);
			user.setMotDePasse(rs.getString("mot_de_passe"));
			user.setCredit(rs.getInt("credit"));
			user.setAdmnistrateur(rs.getBoolean("administrateur"));
		} catch (Exception e) {
			System.out.println("Erreur createUserFromRs " + e.getMessage());
		}

		return user;
	}
	//fonction qui permet de mettre à jour PreparedStatement sans avoir à copier-coller tous les getters de user
	private PreparedStatement setPreparedStatementParameters(PreparedStatement pstmt, Utilisateur user) throws SQLException {
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

		return pstmt;
	}

}
