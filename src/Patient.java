

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

	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		Patient objPatient = (Patient) obj;

		if (objPatient.getID().getPrenom() == null) {
			if (this.getID().getPrenom() == null) {
				return false;
			}

		}
		if (objPatient.getID().getNom() == null) {
			if (this.getID().getNom() == null) {
				return false;
			}
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
		return " Prenom " + iD.getPrenom() + " Nom " + iD.getNom() + " numéro d'assurance sociale "
				+ numAssuranceSocial;
	}

}
