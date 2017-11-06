
public class Docteur {
	
	private int numeroDepartement;
	private Identification iD ;
	

	public  Docteur (Identification id, int numero){
		this.numeroDepartement = numero;
		this.iD = id;
	}
	
	public  Docteur (String nom, String prenom, int numero){
		this.numeroDepartement = numero;
		this.iD.setNom(nom);
		this.iD.setPrenom(prenom);
	}
	
	public  Docteur (){}
	
	public int getNumeroDepartement() {
		return numeroDepartement;
	}

	public void setNumeroDepartement(int numeroDepartement) {
		this.numeroDepartement = numeroDepartement;
	}

	public Identification getid() {
		return iD;
	}

	@Override
	public String toString() {
		return "Docteur [numeroDepartement=" + numeroDepartement + ", iD=" + iD + "]";
	}
	
	
}

