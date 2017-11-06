
public class Calendrier {

	public ListePlageHoraire listePlageHoraire = new ListePlageHoraire();

	public void setListePlageHoraire(ListePlageHoraire listePlageHoraire) {
		this.listePlageHoraire = listePlageHoraire;
	}

	public boolean ajouterRendezVous(RendezVous rdvAjout) {

		return false;
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
		return false;
	}

}
