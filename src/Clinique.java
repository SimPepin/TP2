
import java.util.Vector;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Clinique implements Serializable{

	private Vector<Docteur> docteurs;
	private Vector<Infirmier> infirmiers;
	private Vector<Patient> patients;
	private Calendrier calendrier;

	public Clinique() {

		this.docteurs = new Vector<Docteur>();
		this.infirmiers = new Vector<Infirmier>();
		this.patients = new Vector<Patient>();
		this.calendrier = new Calendrier();
	}

	// private Date date = new Date(117, 05, 03, 8, 00);

	public boolean ajouterDocteur(Docteur d) {
		boolean contain = docteurs.contains(d); // Retourne vrai si "d" dans vecteur
		boolean ajoute = false;

		if (contain == false) { // Si pas dans vecteur, ajoute "d"
			docteurs.add(d);
			ajoute = true;
		}

		return ajoute;
	}

	public boolean ajouterInfirmier(Infirmier i) {
		boolean contain = infirmiers.contains(i);
		boolean ajoute = false;

		if (contain == false) {
			infirmiers.add(i);
			ajoute = true;
		}

		return ajoute;
	}

	public boolean ajouterPatient(Patient p) {
		boolean contain = patients.contains(p);
		boolean ajoute = false;

		if (contain == false) {
			patients.add(p);
			ajoute = true;
		}

		return ajoute;
	}

	public Docteur getDocteur(int indice) {
		return docteurs.get(indice);
	}

	public Infirmier getInfirmier(int indice) {
		return infirmiers.get(indice);
	}

	public Patient getPatient(int indice) {
		return patients.get(indice);
	}

	public Calendrier getCalendrier() {

		return this.calendrier;
	}

	public int getNbDocteurs() {
		return docteurs.size();
	}

	public int getNbInfirmiers() {
		return infirmiers.size();
	}

	public int getNbPatients() {
		return patients.size();
	}

	public boolean verifierRendezVousAPlageHoraire(Date date) {
		return this.calendrier.plageHoraireExiste(date);

	}

	public RendezVous rendezVousPatient(Patient p) throws Exception {

		Date dateDepart = new Date();
		// la journée commence a 8h.
		dateDepart.setMinutes(0);
		dateDepart.setHours(8);
		boolean journeeParcourue = false;

		for (int i = 0; i < docteurs.size(); i++) {
			for (int j = 0; j < infirmiers.size(); j++) {
				RendezVous rdv = new RendezVous(p, docteurs.get(i), infirmiers.get(j));

				while (!journeeParcourue) {
					if (calendrier.ajouterRendezVous(rdv, dateDepart)) {
						return rdv;
					}
					if (dateDepart.getMinutes() == 30) {
						if (dateDepart.getHours() == 19) {
							journeeParcourue = true;
							throw new Exception("Il n'y a pas de rendez-vous disponible");
						} else {
							dateDepart.setHours(dateDepart.getHours() + 1);
							dateDepart.setMinutes(0);
						}

					} else {
						dateDepart.setMinutes(30);
					}

				}

			}
		}
		throw new Exception("Il n'y a pas de rendez-vous disponible aujourd'hui");
	}
}
