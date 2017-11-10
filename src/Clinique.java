
import java.util.Vector;
import java.util.Date;

public class Clinique {

	Vector<Docteur> docteur = new Vector<Docteur>();
	Vector<Infirmier> infirmier = new Vector<Infirmier>();
	Vector<Patient> patient = new Vector<Patient>();

	Calendrier calendrier;

	public boolean ajouterDocteur(Docteur d) {
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

	public boolean ajouterPatient(Patient p) {
		boolean contain = patient.contains(p);
		boolean ajoute = false;

		if (contain == false) {
			patient.add(p);
			ajoute = true;
		}

		return ajoute;
	}

	public Docteur getDocteur(int indice) {
		return docteur.get(indice);
	}

	public Infirmier getInfirmier(int indice) {
		return infirmier.get(indice);
	}

	public Patient getPatient(int indice) {
		return patient.get(indice);
	}

	public ListePlageHoraire getCalendrier() {

		return calendrier.listePlageHoraire;
	}

	public void setCalendrier(Calendrier c) {
		this.calendrier = c;
	}

	public void rendezVousPatient(Patient p) {
		int annee = 117;
		int mois = 1;
		int jours = 1;
		int heures = 8;
		int minutes = 0;
		Date date = new Date(annee, mois, jours, heures, minutes); // 2017, 1, 1, 8, 00

		for (int x = 0; x < docteur.size(); x++) { // Parcours tous les docteurs
			for (int y = 0; y < infirmier.size(); y++) { // Parcours tous les infirmiers
				RendezVous itineraire = new RendezVous(p, docteur.get(x), infirmier.get(y)); // Creer un rdv

				while (calendrier.ajouterRendezVous(itineraire, date) == false) { // Tente d'ajouter un rendez vous

					minutes = minutes + 30;
					if (minutes == 60) {
						minutes = 0;
						heures++;
					}

					if (heures == 20) {
						heures = 8;
						jours++;
					}

					if (jours == 30) {
						jours = 0;
						mois++;
					}

				}

			}
		}

	}

}
