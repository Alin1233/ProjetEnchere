package fr.labo.bo;

import java.io.Serializable;

public class User implements Serializable {

	private String idUser;
	private String passwordUser;
	/**
	 * @return the idUser
	 */
	public String getIdUser() {
		return idUser;
	}
	/**
	 * @param idUser the idUser to set
	 */
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	/**
	 * @return the passwordUser
	 */
	public String getPasswordUser() {
		return passwordUser;
	}
	/**
	 * @param passwordUser the passwordUser to set
	 */
	public void setPasswordUser(String passwordUser) {
		this.passwordUser = passwordUser;
	}
	public User() {
		super();
	}
	public User(String idUser, String passwordUser) {
		super();
		this.idUser = idUser;
		this.passwordUser = passwordUser;
	}


}
