import java.io.Serializable;

public class Identification implements Serializable{

	private String nom;
	private String prenom;

	public Identification(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Identification(Identification iD) {
		this.prenom = iD.getPrenom();
		this.nom = iD.getNom();
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	@Override
	public boolean equals(Object obj) {

		if (this == obj) {
			return true;
		}
		if (obj == null || this == null) {
			return false;
		}
		
		if (!(obj instanceof Identification)) {
			 return false;
		}
		Identification objID = (Identification) obj;

		if (objID.getNom() == null || this.nom == null) {
			return false;
		}

		if (objID.getPrenom() == null || this.prenom == null) {

			return false;
		}

		if (objID.getNom() != this.nom || objID.getPrenom() != this.prenom) {
			return false;
		}
		return true;
	}

	public String toString() {
		return "nom=" + nom + ", prenom=" + prenom;
	}

	public Identification clone(Identification ancienID) {
		return new Identification(ancienID.getNom(), ancienID.getPrenom());
	}

}
