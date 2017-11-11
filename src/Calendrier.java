import java.rmi.UnexpectedException;
import java.util.Date;

public class Calendrier {

	private ListePlageHoraire listePlageHoraire = new ListePlageHoraire();

	public ListePlageHoraire getListePlageHoraire() {
		return listePlageHoraire;
	}

	public boolean ajouterRendezVous(RendezVous rdvAjout, Date date) {

		if (date.getHours() < 8 || date.getHours() > 20) {
			System.out.println("Le rendez-vous doit être entre les heures d'ouvertures \n" + "de 8h à 20h");
			return false;
		}
		if (date.getMinutes() % 30 != 0) {
			System.out.println("Les rendez-vous doivent sont aux 30 minutes \n"
					+ "les plages disponibles sont 8:00 , 8:30 , 9:00 , 9:30 , etc..");
			return false;
		}

		for (int i = 0; i < obtenirPlageHoraire(date).obtenirNbRendezVous(); i++) {
			if (obtenirPlageHoraire(date).obtenirDateRdvIndex(i).getDocteur() != rdvAjout.getDocteur()
					&& obtenirPlageHoraire(date).obtenirDateRdvIndex(i).getInfirmier() != rdvAjout.getInfirmier()) {

				obtenirPlageHoraire(date).addRendezVous(rdvAjout);
				return true;
			} else {
				System.out.println(
						"Le rendez-vous n'a pas pu être ajouté, car le médecin ou l'infirmier à déjà un rendez-vous a cette date!");
				return false;
			}
		}

		PlageHoraire plageExistPas = new PlageHoraire(date);

		plageExistPas.addRendezVous(rdvAjout);
		listePlageHoraire.ajoutDansListe(plageExistPas);
		return true;

	}

	private PlageHoraire obtenirPlageHoraire(Date date) {

		Maillon unePlageHoraire = listePlageHoraire.getTete();
		while (unePlageHoraire != null) {
			if (unePlageHoraire.getPlageHoraire().getDate().equals(date)) {
				PlageHoraire plage = unePlageHoraire.getPlageHoraire();
				return plage;
			}
			unePlageHoraire = unePlageHoraire.getNext();
		}
		PlageHoraire nvPlage = new PlageHoraire(date);
		return nvPlage;
	}

	public RendezVous obtenirProchainRendezVousPatient(Patient unPatient) {
		boolean trouve = false;
		Maillon unePlageHoraire = listePlageHoraire.getTete();

		while (unePlageHoraire != null && trouve != true) {

			for (int i = 0; i < unePlageHoraire.getPlageHoraire().obtenirNbRendezVous(); i++) {
				if (unePlageHoraire.getPlageHoraire().obtenirDateRdvIndex(i).getPatient() == unPatient) {
					trouve = true;
					return unePlageHoraire.getPlageHoraire().obtenirDateRdvIndex(i);
				}
			}
			unePlageHoraire = unePlageHoraire.getNext();
		}

		System.out.println("Ce patient n'a pas de rendez-vous");
		return null;
	}

	public RendezVous obtenirProchainRendezVousInfirmier(Infirmier unInfirmier) {
		boolean trouve = false;
		Maillon unePlageHoraire = listePlageHoraire.getTete();

		while (unePlageHoraire != null && trouve != true) {

			for (int i = 0; i < unePlageHoraire.getPlageHoraire().obtenirNbRendezVous(); i++) {
				if (unePlageHoraire.getPlageHoraire().obtenirDateRdvIndex(i).getInfirmier() == unInfirmier) {
					trouve = true;
					return unePlageHoraire.getPlageHoraire().obtenirDateRdvIndex(i);
				}
			}

			unePlageHoraire = unePlageHoraire.getNext();

		}

		System.out.println("Cet infirmier n'a pas de rendez-vous");
		return null;
	}

	public RendezVous obtenirProchainRendezVousDocteur(Docteur unDocteur) {
		boolean trouve = false;
		Maillon unePlageHoraire = listePlageHoraire.getTete();

		while (unePlageHoraire != null && trouve != true) {

			for (int i = 0; i < unePlageHoraire.getPlageHoraire().obtenirNbRendezVous(); i++) {
				if (unePlageHoraire.getPlageHoraire().obtenirDateRdvIndex(i).getDocteur() == unDocteur) {
					trouve = true;
					return unePlageHoraire.getPlageHoraire().obtenirDateRdvIndex(i);
				}
			}

			unePlageHoraire = unePlageHoraire.getNext();

		}

		System.out.println("Ce Docteur n'a pas de rendez-vous");
		return null;
	}

	// Affiche comme la tête d'une file.
	public PlageHoraire obtenirProchainePLageHoraire() {
		try {
			return listePlageHoraire.sortirTeteListe();
		} catch (Exception e) {
			System.out.println("Le calendrier ne contient pas encore de plage horaire");
		}
		return null;
	}

	public Boolean plageHoraireExiste(Date date) {
		Maillon unePlageHoraire = listePlageHoraire.getTete();

		while (unePlageHoraire != null) {
			if (unePlageHoraire.getPlageHoraire().getDate().compareTo(date) == 0) {
				return true;
			}
			unePlageHoraire = unePlageHoraire.getNext();
		}
		return false;
	}

	public boolean annulerRendezVous(RendezVous rdvAnnule) {
		Maillon unePlageHoraire = listePlageHoraire.getTete();

		while (unePlageHoraire != null) {

			for (int i = 0; i < unePlageHoraire.getPlageHoraire().obtenirNbRendezVous(); i++) {
				if (unePlageHoraire.getPlageHoraire().obtenirDateRdvIndex(i).comparerRendezVous(rdvAnnule)) {
					unePlageHoraire.getPlageHoraire().retirerRendezVousAIndex(i);
					if (unePlageHoraire.getPlageHoraire().plageEstVide()) {
						try {
							listePlageHoraire.retirerDeLaListe(unePlageHoraire.getPlageHoraire());
						} catch (Exception e) {
							System.out.println("Le calendrier ne contient pas encore de plage horaire");
						}

					}
					return true;
				}
			}

			unePlageHoraire = unePlageHoraire.getNext();

		}
		
		return false;
	}

	public ListePlageHoraire obtenirCalendirerDocteur(Docteur Docteur) {

		Calendrier calendrierDuDocteur = new Calendrier();
		ListePlageHoraire nouvelleListe = calendrierDuDocteur.listePlageHoraire;

		Maillon unePlageHoraire = listePlageHoraire.getTete();

		while (unePlageHoraire != null) {

			for (int i = 0; i < unePlageHoraire.getPlageHoraire().obtenirNbRendezVous(); i++) {
				if (unePlageHoraire.getPlageHoraire().obtenirDateRdvIndex(i).getDocteur() == Docteur) {

					PlageHoraire nvPlageHoraire = new PlageHoraire(unePlageHoraire.getPlageHoraire().getDate());
					RendezVous rdvNvCalendrier = unePlageHoraire.getPlageHoraire().obtenirDateRdvIndex(i);

					nvPlageHoraire.addRendezVous(rdvNvCalendrier);
					nouvelleListe.ajoutDansListe(nvPlageHoraire);

				}
			}

			unePlageHoraire = unePlageHoraire.getNext();

		}
		calendrierDuDocteur.listePlageHoraire = nouvelleListe;
		return calendrierDuDocteur.listePlageHoraire;
	}

	public ListePlageHoraire obtenirCalendirerInfirmier(Infirmier Infirmier) {

		Calendrier calendrierInfirmier = new Calendrier();
		ListePlageHoraire nouvelleListe = calendrierInfirmier.listePlageHoraire;

		Maillon unePlageHoraire = listePlageHoraire.getTete();

		while (unePlageHoraire != null) {

			for (int i = 0; i < unePlageHoraire.getPlageHoraire().obtenirNbRendezVous(); i++) {
				if (unePlageHoraire.getPlageHoraire().obtenirDateRdvIndex(i).getInfirmier() == Infirmier) {

					PlageHoraire nvPlageHoraire = new PlageHoraire(unePlageHoraire.getPlageHoraire().getDate());
					RendezVous rdvNvCalendrier = unePlageHoraire.getPlageHoraire().obtenirDateRdvIndex(i);

					nvPlageHoraire.addRendezVous(rdvNvCalendrier);
					nouvelleListe.ajoutDansListe(nvPlageHoraire);

				}
			}

			unePlageHoraire = unePlageHoraire.getNext();

		}
		calendrierInfirmier.listePlageHoraire = nouvelleListe;

		return calendrierInfirmier.listePlageHoraire;

	}

}
