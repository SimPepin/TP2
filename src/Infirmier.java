import java.io.Serializable;

public class Infirmier implements Serializable {

	private Identification iD;
	private boolean disponible = true;

	public Infirmier(String prenom, String nom) {

		this.iD = new Identification(prenom, nom);
		this.disponible = true;

	}

	public Infirmier(Identification iD, boolean disponibilite) {

		this.iD = iD;
		this.disponible = disponibilite;

	}

	/**
	 * @return the iD
	 */
	public Identification getiD() {
		return iD;
	}

	/**
	 * @param The
	 *            iD to set
	 */
	public void setiD(Identification iD) {
		this.iD = iD;
	}

	/**
	 * @return la disponibilité
	 */
	public boolean isDisponible() {
		return disponible;
	}

	/**
	 * @param Definir
	 *            la disponibilité de l'infirmier
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this == null) {
			return false;
		}
		if (!(obj instanceof Infirmier)) {
			return false;
		}
		Infirmier objInfirmier = (Infirmier) obj;
		
		if(objInfirmier.isDisponible() != this.isDisponible() || !this.iD.equals(objInfirmier.getiD())){
			return false;
		}
		
		if(objInfirmier.getiD() == null || this.iD == null) {
			return false;
		}
		return true;
	}

	public Infirmier clone(Infirmier infirmier) {

		Identification copieID = this.getiD();
		boolean copieDisponibilite = this.isDisponible();
		Infirmier copieInfirmier = new Infirmier(copieID, copieDisponibilite);
		return copieInfirmier;

	}

	@Override

	public String toString() {
		return " [Infirmier " + this.iD.getNom() + " " + this.iD.getPrenom() + ", disponibilite = " + this.disponible
				+ "] ";
	}
}