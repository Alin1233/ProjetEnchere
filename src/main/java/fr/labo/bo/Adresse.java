package fr.labo.bo;

public class Adresse {

    private String rue;
    private String ville;
    private String codePostal;
	/**
	 * @param rue
	 * @param ville
	 * @param codePostal
	 */
	public Adresse(String rue, String ville, String codePostal) {
		super();
		this.rue = rue;
		this.ville = ville;
		this.codePostal = codePostal;
	}
	/**
	 * @return the rue
	 */
	public String getRue() {
		return rue;
	}
	/**
	 * @param rue the rue to set
	 */
	public void setRue(String rue) {
		this.rue = rue;
	}
	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}
	/**
	 * @param ville the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}
	/**
	 * @return the codePostal
	 */
	public String getCodePostal() {
		return codePostal;
	}
	/**
	 * @param codePostal the codePostal to set
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", ville=" + ville + ", codePostal=" + codePostal + "]";
	}


}

