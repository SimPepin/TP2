import java.io.Serializable;

public class RendezVous implements Serializable{

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
	
	public void setInfirmier(Infirmier inf) {
		this.i = inf;
	}

	public void setPatient(Patient e) {
		this.p = e;
	}

	public void setDocteur(Docteur e) {
		this.d = e;
	}
	
	public boolean comparerRendezVous(RendezVous rdv) {
		return this.d.equals(rdv.getDocteur()) && this.p.equals(rdv.getPatient()) && this.i.equals(rdv.getInfirmier());
	}

	@Override
	public String toString() {
		return p.toString() + d.toString() + i.toString();
	}

	
	
}