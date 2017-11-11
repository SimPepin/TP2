
import java.util.Vector;
import java.util.Date;

public class Clinique {

	Vector<Docteur> docteur = new Vector<Docteur>();
	Vector<Infirmier> infirmier = new Vector<Infirmier>();
	Vector<Patient> patient = new Vector<Patient>();
	Calendrier calendrier;

	public Date date = new Date(117, 05, 03, 8, 00);

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

		int annee = date.getYear();
		int mois = date.getMonth();
		int jours = date.getDay();
		int heures = date.getHours();
		int minutes = date.getMinutes();

		for (int x = 0; x < docteur.size(); x++) { // Parcours tous les docteurs
			for (int y = 0; y < infirmier.size(); y++) { // Parcours tous les infirmiers
				RendezVous itineraire = new RendezVous(p, docteur.get(x), infirmier.get(y)); // Creer un rdv
				// calendrier.ajouterRendezVous(itineraire, date);
				while (calendrier.ajouterRendezVous(itineraire, date)) { // Tente d'ajouter un rendez
																			// vous

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

					if (mois == 12) {
						mois = 0;
						annee++;
					}

				}

			}
		}

	}

}
