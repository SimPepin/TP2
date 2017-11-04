
public class Maillon {
	private PlageHoraire uneDate;
	private Maillon next;

	public Maillon(PlageHoraire uneDate) {
		this.uneDate = uneDate;
		this.next = null;
	}

	public Maillon(PlageHoraire uneDate, Maillon next) {

		this.uneDate = uneDate;
		this.next = next;
	}

	public PlageHoraire getUneDate() {
		return uneDate;
	}

	public void setUneDate(PlageHoraire uneDate) {
		this.uneDate = uneDate;
	}

	public Maillon getNext() {
		return next;
	}

	public void setNext(Maillon next) {
		this.next = next;
	}

	// V�rifier si le maillon actuel est �quivalent � la valeur recherch�.
	/*
	 * public boolean comparerMaillon() { if(maillonComparer == this.next) { return
	 * true; } else return false; }
	 */
}
