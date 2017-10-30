
public class Patient {
	int numAssuranceSocial;
	Identification ID;

	public Patient(int numAssuranceSocial, Identification ID) {

		this.numAssuranceSocial = numAssuranceSocial;
		this.ID = ID;
	}

	/*
	 * Constructeur Par copie ** À vérifier **
	 */
	public Patient(Identification ID) {
		this.ID = clonePatient();
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

	public void setID(Identification iD) {
		ID = iD;
	}

	/*
	 * On clone le patient actuel
	 */
	public Identification clonePatient() {
		return this.ID = new Identification(ID.getNom(), ID.getPrenom());
	}

	@Override
	public String toString() {
		return "numéro d'assurance sociale" + numAssuranceSocial;
	}

}
