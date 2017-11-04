
public class Liste {

	private Maillon tete;

	public boolean listeVide() {
		return tete == null;
	}

	/**
	 * Ajoute un �l�ment dans la liste, si la liste est vide, le premier �l�ment
	 * devient la t�te. Si la liste est pleine,
	 * 
	 * @param nouvelleDate
	 */
	public void ajoutDansListe(PlageHoraire nouvelleDate) {

		if (listeVide()) {
			tete = new Maillon(nouvelleDate);
		}
		// � v�rifier, vraiment pas certain de mon affaire.
		else if (tete.getUneDate().dateRendezVous.after(nouvelleDate.getDate())) {
			tete = new Maillon(nouvelleDate, tete);
		} else {
			Maillon tmpPrecedent = tete;
			Maillon tmpSuivant = tmpPrecedent.getNext();

			while (tmpSuivant != null && tmpSuivant.getUneDate().dateRendezVous.before(nouvelleDate.getDate())) {
				tmpPrecedent = tmpSuivant;
				tmpSuivant = tmpSuivant.getNext();
			}
			tmpPrecedent.setNext(new Maillon(nouvelleDate, tmpSuivant));
		}

	}

	public void retirerDeLaListe(PlageHoraire dateARetirer) {
		// V�rifie que la liste n'est pas vide.
		if (listeVide()) {
			return;
		}
		// Dans le cas ou la date � retirer serait la premi�re date, dans la liste.
		else if (tete.getUneDate().dateRendezVous == dateARetirer.getDate()) {
			tete = tete.getNext();
		}

		else {
			Maillon maillonPr�c�dent = null;
			Maillon tmpPrecendent = tete;
			Maillon tmpSuivant = tmpPrecendent.getNext();
			
			if()
		}
	}

	// Affiche la premi�re plage horaire dans la liste.
	public PlageHoraire AfficherPremierePlage() {
		Maillon premierMaillon = tete;
		tete = tete.getNext();
		return premierMaillon.getUneDate();
	}

}
