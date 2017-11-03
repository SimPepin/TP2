
public class maillon {
	private PlageHoraire unePlage;
	private maillon next;
	
	
	public maillon(PlageHoraire unePlage) {
		
		this.unePlage = unePlage;
	}


	public PlageHoraire getUnePlage() {
		return unePlage;
	}


	public void setUnePlage(PlageHoraire unePlage) {
		this.unePlage = unePlage;
	}


	public maillon getNext() {
		return next;
	}


	public void setNext(maillon next) {
		this.next = next;
	}
	
	
	
	
}
