
public class ListePlageHoraire {

	private Maillon tete;
	private Maillon next;
	public boolean listeVide() {
		return tete == null;
	}
	
	public ListePlageHoraire() {
		this.tete = tete;
		this.next = next;
	}
	

	public Maillon getTete() {
		return tete;
	}

	public void setTete(Maillon tete) {
		this.tete = tete;
	}

	public Maillon getNext() {
		return next;
	}

	public void setNext(Maillon next) {
		this.next = next;
	}

	/**
	 * Ajoute un élément dans la liste, si la liste est vide, le premier élément
	 * devient la tête. Si la liste est pleine,
	 * 
	 * @param nouvelleDate
	 */
	public void ajoutDansListe(PlageHoraire nouvelleDate) {

		if (listeVide()) {
			tete = new Maillon(nouvelleDate);
		}
		// À vérifier, vraiment pas certain de mon affaire.
		else if (tete.getUneDate().dateRendezVous.after(nouvelleDate.getDate())) {
			tete = new Maillon(nouvelleDate, tete);
		} else {
			Maillon tmpPrecedent = tete;
			Maillon tmpSuivant = tete.getNext();

			while (tmpSuivant != null && tmpSuivant.getUneDate().dateRendezVous.before(nouvelleDate.getDate())) {
				tmpPrecedent = tmpSuivant;
				tmpSuivant = tmpSuivant.getNext();
			}
			tmpPrecedent.setNext(new Maillon(nouvelleDate, tmpSuivant));
		}

	}

	public void retirerDeLaListe(PlageHoraire dateARetirer) throws Exception {
		// Vérifie que la liste n'est pas vide.
		if (listeVide()) {
			return;
		}
		// Dans le cas ou la date à retirer serait la première date, dans la liste.
		else if (tete.getUneDate().dateRendezVous == dateARetirer.getDate()) {
			tete = tete.getNext();
		}

		else {
			Maillon maillonPrécédent = null;
			Maillon tmpSuivant = tete;

			while (tmpSuivant != null && tmpSuivant.getUneDate().dateRendezVous.before(dateARetirer.getDate())) {
				maillonPrécédent = tmpSuivant;
				tmpSuivant = tmpSuivant.getNext();
			}
			if (tmpSuivant != null && tmpSuivant.getUneDate().dateRendezVous == dateARetirer.getDate()) {
				maillonPrécédent.setNext(tmpSuivant.getNext());
			}
		}
	}

	// Affiche la première plage horaire dans la liste.
	public PlageHoraire SortirPremierePlage() {
		Maillon premierMaillon = tete;
		tete = tete.getNext();
		return premierMaillon.getUneDate();
	}

	@Override
	public String toString() {
		return "ListePlageHoraire [tete=" + tete + "]";
	}
	
	
}
