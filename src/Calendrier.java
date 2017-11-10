import java.rmi.UnexpectedException;
import java.util.Date;

public class Calendrier {

	public ListePlageHoraire listePlageHoraire = new ListePlageHoraire();

	public void setListePlageHoraire(ListePlageHoraire listePlageHoraire) {
		this.listePlageHoraire = listePlageHoraire;
	}

	public boolean ajouterRendezVous(RendezVous rdvAjout, Date date) {

		if (date.getHours() < 8 || date.getHours() > 20) {

			return false;
		}
		if (date.getMinutes() % 30 != 0) {
			return false;
		}

		for (int i = 0; i < obtenirPlageHoraire(date).listeRendezVous.size(); i++) {
			if (obtenirPlageHoraire(date).listeRendezVous.get(i).getDocteur() != rdvAjout.getDocteur()
					&& obtenirPlageHoraire(date).listeRendezVous.get(i).getInfirmier() != rdvAjout.getInfirmier()) {

				obtenirPlageHoraire(date).listeRendezVous.add(rdvAjout);
				return true;
			} else {
				return false;
			}
		}

		PlageHoraire plageExistPas = new PlageHoraire(date);

		plageExistPas.add(rdvAjout);
		listePlageHoraire.ajoutDansListe(plageExistPas);
		return true;

	}

	/*
	 * À compléter
	 */
	private PlageHoraire obtenirPlageHoraire(Date date) {

		Maillon unePlageHoraire = listePlageHoraire.getTete();
		while (unePlageHoraire != null) {
			if (unePlageHoraire.getUneDate().getDate().equals(date)) {
				PlageHoraire plage = unePlageHoraire.getUneDate();
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

			for (int i = 0; i < unePlageHoraire.getUneDate().listeRendezVous.size(); i++) {
				if (unePlageHoraire.getUneDate().listeRendezVous.get(i).getPatient() == unPatient) {
					trouve = true;
					return unePlageHoraire.getUneDate().listeRendezVous.get(i);
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

			for (int i = 0; i < unePlageHoraire.getUneDate().listeRendezVous.size(); i++) {
				if (unePlageHoraire.getUneDate().listeRendezVous.get(i).getInfirmier() == unInfirmier) {
					trouve = true;
					return unePlageHoraire.getUneDate().listeRendezVous.get(i);
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

			for (int i = 0; i < unePlageHoraire.getUneDate().listeRendezVous.size(); i++) {
				if (unePlageHoraire.getUneDate().listeRendezVous.get(i).getDocteur() == unDocteur) {
					trouve = true;
					return unePlageHoraire.getUneDate().listeRendezVous.get(i);
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
			return listePlageHoraire.SortirPremierePlage();
		} catch (Exception e) {
			System.out.println("Le calendrier ne contient pas encore de plage horaire");
		}
		return null;
	}

	public boolean annulerRendezVous(RendezVous rdvAnnule) {

		Maillon unePlageHoraire = listePlageHoraire.getTete();

		while (unePlageHoraire != null) {

			for (int i = 0; i < unePlageHoraire.getUneDate().listeRendezVous.size(); i++) {
				if (unePlageHoraire.getUneDate().listeRendezVous.get(i).getDocteur() == rdvAnnule.getDocteur()
						&& unePlageHoraire.getUneDate().listeRendezVous.get(i).getPatient() == rdvAnnule.getPatient()
						&& unePlageHoraire.getUneDate().listeRendezVous.get(i).getInfirmier() == rdvAnnule
								.getInfirmier()) {
					unePlageHoraire.getUneDate().listeRendezVous.remove(i);
					if (unePlageHoraire.getUneDate().listeRendezVous.isEmpty()) {
						try {
							listePlageHoraire.retirerDeLaListe(unePlageHoraire.getUneDate());
						} catch (Exception e) {
							System.out.println("Le calendrier ne contient pas encore de plage horaire");
						}

					}
					return true;
				}
			}

			unePlageHoraire = unePlageHoraire.getNext();

		}
		System.out.println("Ce rendez-vous ne peut pas être annulé, car il n'existe pas");
		return false;
	}

	public ListePlageHoraire obtenirCalendirerDocteur(Docteur Docteur) {

		Calendrier calendrierDuDocteur = new Calendrier();
		ListePlageHoraire nouvelleListe = calendrierDuDocteur.listePlageHoraire;

		Maillon unePlageHoraire = listePlageHoraire.getTete();

		while (unePlageHoraire != null) {

			for (int i = 0; i < unePlageHoraire.getUneDate().listeRendezVous.size(); i++) {
				if (unePlageHoraire.getUneDate().listeRendezVous.get(i).getDocteur() == Docteur) {

					PlageHoraire nvPlageHoraire = new PlageHoraire(unePlageHoraire.getUneDate().dateRendezVous);
					RendezVous rdvNvCalendrier = unePlageHoraire.getUneDate().listeRendezVous.get(i);

					nvPlageHoraire.add(rdvNvCalendrier);
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

			for (int i = 0; i < unePlageHoraire.getUneDate().listeRendezVous.size(); i++) {
				if (unePlageHoraire.getUneDate().listeRendezVous.get(i).getInfirmier() == Infirmier) {

					PlageHoraire nvPlageHoraire = new PlageHoraire(unePlageHoraire.getUneDate().dateRendezVous);
					RendezVous rdvNvCalendrier = unePlageHoraire.getUneDate().listeRendezVous.get(i);

					nvPlageHoraire.add(rdvNvCalendrier);
					nouvelleListe.ajoutDansListe(nvPlageHoraire);

				}
			}

			unePlageHoraire = unePlageHoraire.getNext();

		}
		calendrierInfirmier.listePlageHoraire = nouvelleListe;

		return calendrierInfirmier.listePlageHoraire;

	}

}
