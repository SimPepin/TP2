import java.rmi.UnexpectedException;

public class Calendrier {

	public ListePlageHoraire listePlageHoraire = new ListePlageHoraire();

	public void setListePlageHoraire(ListePlageHoraire listePlageHoraire) {
		this.listePlageHoraire = listePlageHoraire;
	}

	/*
	 * À compléter
	 */
	public boolean ajouterRendezVous(RendezVous rdvAjout) {

		return false;
	}

	/*
	 * À compléter
	 */
	private PlageHoraire obtenirPlageHoraire(RendezVous rdvAjout) {

		// Pas trop certain PAS BON !

		Maillon plageAChercher = listePlageHoraire.getTete();
		// PlageHoraire plageAChercher = plageAChercher.
		while (plageAChercher != null) {
			for (int i = 0; i < plageAChercher.getUneDate().listeRendezVous.size(); i++) {
				if (plageAChercher.getUneDate().listeRendezVous.get(i) == rdvAjout) {
					return plageAChercher.getUneDate();
				}

			}
			plageAChercher = plageAChercher.getNext();
		}
		// retourne null, car cette plage horaire n'est pas dans la liste.
		return null;

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
	public PlageHoraire obtenirPLageHoraire() {
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

}
