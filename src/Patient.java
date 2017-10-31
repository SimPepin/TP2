
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
