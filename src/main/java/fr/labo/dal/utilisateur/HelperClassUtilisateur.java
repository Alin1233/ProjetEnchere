package fr.labo.dal.utilisateur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fr.labo.bo.Adresse;
import fr.labo.bo.Utilisateur;

public class HelperClassUtilisateur {
	
	//fonction qui prend un rs et renvoie un objet utilisateur basé sur cet result set
		public static Utilisateur createUserFromRs(ResultSet rs) {
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
		public static PreparedStatement setPreparedStatementParameters(PreparedStatement pstmt, Utilisateur user) throws SQLException {
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
