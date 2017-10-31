
public class Infirmier {

	
	
	
	private Identification iD;
	boolean disponible = true;	
		
	public Infirmier(String prenom, String nom) {
		
		this.iD = new Identification (prenom, nom);
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
	 * @param The iD to set
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
	 * @param Definir la disponibilité de l'infirmier
	 */
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Infirmier [iD=" + iD + ", disponible=" + disponible + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Infirmier other = (Infirmier) obj;
		if (disponible != other.disponible)
			return false;
		if (iD == null) {
			if (other.iD != null)
				return false;
		} else if (!iD.equals(other.iD))
			return false;
		return true;
	}

	public Infirmier clone(Infirmier infirmier){
		
		Identification copieID = this.getiD();
		boolean copieDisponibilite = this.isDisponible();
		Infirmier copieInfirmier = new Infirmier(copieID,copieDisponibilite);
		return copieInfirmier;

	}


	



	
	
	
	
	
	
	
}