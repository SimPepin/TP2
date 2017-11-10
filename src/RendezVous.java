
public class RendezVous {

	private Patient p;
	private Docteur d;
	private Infirmier i;

	public RendezVous(Patient p, Docteur d, Infirmier i) {
		this.p = p;
		this.d = d;
		this.i = i;
	}

	public Patient getPatient() {
		return this.p;
	}

	public Docteur getDocteur() {
		return this.d;
	}

	public Infirmier getInfirmier() {
		return this.i;
	}

	public void setPatient(Patient e) {
		this.p = e;
	}

	public void setDocteur(Docteur e) {
		this.d = e;
	}

	@Override
	public String toString() {
		return p.toString() + d.toString() + i.toString();
	}

	
	
}