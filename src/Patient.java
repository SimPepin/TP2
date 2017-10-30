
public class Patient {
	private int numAssuranceSocial;
	private Identification ID;

	public Patient(int numAssuranceSocial, Identification ID) {

		this.numAssuranceSocial = numAssuranceSocial;
		this.ID = ID;
	}

	/*
	 * Constructeur Par copie ** À vérifier **
	 */
	public Patient(Patient patient) {
		this.clonePatient(patient);
	}

	public int getNumAssuranceSocial() {
		return numAssuranceSocial;
	}

	public void setNumAssuranceSocial(int numAssuranceSocial) {
		this.numAssuranceSocial = numAssuranceSocial;
	}

	public Identification getID() {
		return ID;
	}

	public void setID(Identification ID) {
		this.ID = ID;
	}

	/*
	 * On clone le patient actuel
	 */
	public void clonePatient(Patient patient) {
		this.setID(new Identification(patient.getID()));
		this.setNumAssuranceSocial(patient.getNumAssuranceSocial());
	}

	@Override
	public String toString() {
		return " Prenom " + ID.getPrenom() + " Nom " + ID.getNom() + " numéro d'assurance sociale "
				+ numAssuranceSocial;
	}

}
