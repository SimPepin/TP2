import java.util.Date;
import java.util.ArrayList;

public class PlageHoraire {

	Date dateRendezVous;
	ArrayList<RendezVous> listeRendezVous;

	public PlageHoraire(Date dateRendezVous) {
		this.dateRendezVous = dateRendezVous;
		this.listeRendezVous = new ArrayList<RendezVous>();
	}

	/**
	 * @return Retourne la date de cette plage horaire.
	 */
	public Date getDate() {
		return dateRendezVous;
	}

	/**
	 * @param Reçoit
	 *            une date et l'assigne à cette plage horaire
	 */
	public void setDate(Date dateRendezVous) {
		this.dateRendezVous = dateRendezVous;
	}

	/**
	 * @return Retourne une copie de la liste des rendez-vous
	 */
	public ArrayList getRendezVous() {
		ArrayList copieListeRendezVous = listeRendezVous;
		return copieListeRendezVous;
	}

	/**
	 * Cette méthode publique reçoit un rendez-vous et l’ajoute à cette plage
	 * horaire. Elle retourne true si l'ajout réussit et false si le rendez-vous y
	 * étais déjà présent.
	 * 
	 * @param dateRendezVous
	 * 
	 * @return boolean
	 */
	public boolean add(RendezVous unRendezVous) {

		if (listeRendezVous.contains(unRendezVous)) {
			return false;
		} else {
			listeRendezVous.add(unRendezVous);
		}
		return false;
	}

	/*
	 * Retourne la date de la plage horaire ainsi que l'information complète de
	 * chaque rendez-vous de la plage dans une même chaine de caractères.
	 */
	@Override
	public String toString() {
		return "Rendez Vous � " + dateRendezVous.getDay() +"/" +dateRendezVous.getMonth() +"/" +dateRendezVous.getYear() + " " +dateRendezVous.getHours() + ":" +dateRendezVous.getMinutes() + "\n" 
		+ listeRendezVous.toString() +"\n";
	};

}
