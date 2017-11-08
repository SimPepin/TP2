
import java.util.*;

public class Clinique {

	Vector<Docteur> docteur = new Vector<Docteur>();
	Vector<Infirmier> infirmier = new Vector<Infirmier>();
	Vector<Patient> patient = new Vector<Patient>();

	public boolean ajouterDoctuer(Docteur d) {
		boolean contain = docteur.contains(d); // Retourne vrai si "d" dans vecteur
		boolean ajoute = false;

		if (contain == false) { // Si pas dans vecteur, ajoute "d"
			docteur.add(d);
			ajoute = true;
		}

		return ajoute;
	}

	public boolean ajouterInfirmier(Infirmier i) {
		boolean contain = infirmier.contains(i);
		boolean ajoute = false;

		if (contain == false) {
			infirmier.add(i);
			ajoute = true;
		}

		return ajoute;
	}

	public boolean ajouterPatient(Patient p){
			boolean contain = patient.contains(p);
			boolean ajoute = false;
		
			
			return ajoute;
		}
}
