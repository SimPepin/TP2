import java.io.Serializable;

public class Docteur implements Serializable{
	
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
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj == null || this == null) {
			return false;
		}
		if(!(obj instanceof Docteur)) {
			return false;
		}
		Docteur objDocteur = (Docteur) obj;
		
		if(objDocteur.getid() == null || this.iD == null) {
			return false;
		}
		
		if(objDocteur.getNumeroDepartement() != this.numeroDepartement || !this.iD.equals(objDocteur.getid())) {
			return false;
		}
		return true;
	}
	
	public Docteur cloneDocteur(Docteur docteur) {
		return new Docteur(docteur.iD,docteur.numeroDepartement);
	}
	
	@Override
	public String toString() {
		return " [Dr. " +this.iD.getNom() +" " +this.iD.getPrenom() + " du departement " + this.numeroDepartement+"] ";
	}
	
	
}

