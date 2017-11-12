import java.io.Serializable;

public class Maillon implements Serializable{
	private PlageHoraire plageHoraire;
	private Maillon next;

	public Maillon(PlageHoraire plageHoraire) {
		this.plageHoraire = plageHoraire;
		this.next = null;
	}

	public Maillon(PlageHoraire uneDate, Maillon next) {

		this.plageHoraire = uneDate;
		this.next = next;
	}

	public PlageHoraire getPlageHoraire() {
		return plageHoraire;
	}

	public void setPlageHoraire(PlageHoraire plageHoraire) {
		this.plageHoraire = plageHoraire;
	}

	public Maillon getNext() {
		return next;
	}

	public void setNext(Maillon next) {
		this.next = next;
	}

	@Override

	public String toString() {
		return " " + plageHoraire + next;
	}

}
