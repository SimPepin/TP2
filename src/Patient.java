
public class Patient {
	private int numAssuranceSocial;
	private Identification iD;

	public Patient(int numAssuranceSocial, Identification iD) {

		this.numAssuranceSocial = numAssuranceSocial;
		this.iD = iD;
	}

	/*
	 * Constructeur Par copie ** À vérifier **
	 */
	public Patient(Patient patient) {
		this.iD = patient.getID();
		this.numAssuranceSocial = patient.getNumAssuranceSocial();
	}

	public Patient() {

	}

	public int getNumAssuranceSocial() {
		return numAssuranceSocial;
	}

	public void setNumAssuranceSocial(int numAssuranceSocial) {
		this.numAssuranceSocial = numAssuranceSocial;
	}

	public Identification getID() {
		return iD;
	}

	public void setID(Identification iD) {
		this.iD = iD;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this == null) {
			return false;
		}

		if (!(obj instanceof Patient)) {
			return false;
		}
		Patient objPatient = (Patient) obj;

		if (objPatient.getID() == null || this.iD == null) {
			return false;
		}
		if (objPatient.getNumAssuranceSocial() != this.numAssuranceSocial || !this.iD.equals(objPatient.getID())) {
			return false;
		}
		return true;
	}

	/*
	 * On clone le patient actuel
	 */
	public Patient clonePatient(Patient patient) {
		return new Patient(patient.getNumAssuranceSocial(), patient.getID());
	}

	@Override
	public String toString() {
		return " [Patient: " + iD.getPrenom() + " " + iD.getNom() + ", " + numAssuranceSocial + "] ";
	}

}
