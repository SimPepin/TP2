<<<<<<< HEAD
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
}




=======
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
}




>>>>>>> 65e5f5036e9ebd1f7dd1160017245ffc3304f252
