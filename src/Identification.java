
public class Identification {

	private String nom;
	private String prenom;

	public Identification(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
	
	public Identification(Identification ID) {
		this.clone(ID);
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

	/*
	 * public boolean equal(){ if }
	 */

	public String toString() {
		return "nom=" + nom + ", prenom=" + prenom;
	}

	public void clone(Identification e) {
		this.nom = e.getNom();
		this.prenom = e.getPrenom();
	}

}
