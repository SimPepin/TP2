
public class Calendrier {
	
	private PlageHoraire unHoraire;
	private Calendrier next;
	
	
	
	public boolean ajouterRendezVous(RendezVous rdvAjout) {
		return false;
	}

	public RendezVous obtenirProchainRendezVousPatient(Patient unPatient) {
		return null;
	}

	public RendezVous obtenirProchainRendezVousInfirmier(Infirmier unInfirmier) {
		return null;
	}

	public RendezVous obtenirProchainRendezVousDocteur(Docteur unDocteur) {
		return null;
	}

	// Affiche comme la tête d'une file.
	public void obtenirPLageHoraire(RendezVous rdvAfficher) {

	}

	public boolean annulerRendezVous(RendezVous rdvAnnule) {
		return false;
	}

}
