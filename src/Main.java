
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

import javax.print.Doc;
import javax.sound.midi.SysexMessage;
import javax.swing.Timer;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class Main implements Serializable {

	private static Clinique clinique;
	private static Scanner entrerUsager;

	private static String nom;
	private static String prenom;
	private static UtilitaireFichier fichierSauvegarde;

	public static void main(String[] args) {

		// clinique = new Clinique();
		// UtilitaireFichier.sauvegardeClinique(clinique, "bin.ser");

		clinique = UtilitaireFichier.chargeClinique("bin.ser");

		//fichierSauvegarde = new UtilitaireFichier();
		entrerUsager = new Scanner(System.in);

		// clinique.setCalendrier(leCalendrier);
		// System.out.println(leCalendrier.toString());
		// System.out.println(clinique.calendrier.toString());
		/*
		 * Identification id = new Identification("une", "deux"); Identification id2 =
		 * new Identification("trois", "quatre"); Identification id3 = new
		 * Identification("yolo", "swag"); Patient p = new Patient(123456, id); Patient
		 * o = new Patient(9786676, id3); Docteur d = new Docteur(id, 1); Infirmier i =
		 * new Infirmier(id, true); Infirmier j = new Infirmier(id2, true); Docteur k =
		 * new Docteur(id2, 2); Patient l = new Patient(89898, id2); Patient n = new
		 * Patient(90978, id3);
		 * 
		 * RendezVous rdv = new RendezVous(p, d, i); RendezVous rdv2 = new RendezVous(p,
		 * d, i); RendezVous rdv3 = new RendezVous(l, d, i);
		 */
		// System.out.println(result);

		// System.out.println(result);
		// clinique.getCalendrier().ajouterRendezVous(rdv, new Date(117, 05, 13, 8,
		// 00));
		// System.out.println(result);

		// clinique.setCalendrier(leCalendrier);
		/*
		 * clinique.ajouterDocteur(d); clinique.ajouterPatient(o);
		 * clinique.ajouterDocteur(k); clinique.ajouterInfirmier(i);
		 * clinique.ajouterInfirmier(j); clinique.ajouterPatient(p);
		 * clinique.ajouterPatient(n);
		 */
		// System.out.print(laClinique.calendrier.listePlageHoraire.toString());
		// System.out.println(leCalendrier.listePlageHoraire.toString());

		// laClinique.rendezVousPatient(o);

		// laClinique.rendezVousPatient(o);
		// System.out.print(laClinique.calendrier.listePlageHoraire.toString());
		// System.out.println(leCalendrier.listePlageHoraire.toString());

		// System.out.println(leCalendrier.listePlageHoraire.toString());

		menu();

	}

	public static void choixUsager(int valeurEntre) {

		switch (valeurEntre) {
		case 1:
			ajouterDocteur();
			break;
		case 2:
			ajouterInfirmier();
			break;
		case 3:
			ajouterPatient();
			break;
		case 4:
			ajouterRendezVous();
			break;
		case 5:
			trouverRDVPatient();
			break;
		case 6:
			afficherProchainRdvDoc();
			break;
		case 7:
			afficherProchainRdvInf();
			break;
		case 8:
			afficherProchainRdvPatient();
			break;
		case 9:
			sortirPremierePlage();
			break;
		case 10:
			afficherCalendrierComplet();
			break;
		case 11:
			afficherCalendrirerCompletDoc();
			break;
		case 12:
			afficherCalendrierCompletInf();
			break;
		case 13:
			annulerRDVPatient();
			break;
		case 14:
			quitter();
			break;

		default:
			break;
		}
	}

	public static void menu() {
		int valeurEntreMenu = 0;
		System.out.println("Bienvenue a la clinique \r\n" + "Que voulez-vous faire ? \r\n"
				+ "1 - Ajouter un docteur\r\n" + "2 - Ajouter un infirmier\r\n" + "3 - Ajouter un patient\r\n"
				+ "4 - Ajouter un rendez-vous\r\n" + "5 - Trouver un rendez-vous pour un patient\r\n"
				+ "6 - Afficher le prochain rendez-vous d'un docteur\r\n"
				+ "7 - Afficher le prochain rendez-vous d'un infirmier\r\n"
				+ "8 - Afficher le prochain rendez-vous d'un patient\r\n"
				+ "9 - Passer a la prochaine plage horaire\r\n" + "10- Afficher le calendrier complet\r\n"
				+ "11- Afficher le calendrier complet d'un docteur\r\n"
				+ "12- Afficher le calendrier complet d'un infirmier\r\n" + "13- Annuler un rendez-vous\r\n"
				+ "14- Quitter");
		while (valeurEntreMenu != 14) {
			System.out.println("-->");
			valeurEntreMenu = entrerUsager.nextInt();
			choixUsager(valeurEntreMenu);
		}
	}

	public static void ajouterDocteur() {

		System.out.println("Vous avez selectionne : Ajouter un Docteur \n");
		System.out.println("Entrez le nom du docteur e ajouter :\n");
		nom = entrerUsager.next();
		System.out.println("Entrez le prenom du docteur e ajouter :\n");
		prenom = entrerUsager.next();
		System.out.println("Veuillez selectionner le numero correspondant au departement de ce docteur :\n");
		System.out.println("1 : CHIRURGIE \r" + "2 : URGENCE \r" + "3 : UROLOGIE \r");
		int numDepart = entrerUsager.nextInt();
		Identification id = new Identification(nom, prenom);
		Docteur nouveauDocteur = new Docteur(id, numDepart);

		clinique.ajouterDocteur(nouveauDocteur);
		System.out.println(" Le nouveau Docteur " + nouveauDocteur.toString() + "e ete ajoute");
		menu();
	}

	public static void ajouterInfirmier() {
		System.out.println("Vous avez selectionne : Ajouter un Infirmier \n");
		System.out.println("Entrez le nom de l'infirmier e ajouter :\n");
		nom = entrerUsager.next();
		System.out.println("Entrez le prenom de l'infirmier e ajouter :\n");
		prenom = entrerUsager.next();

		Identification id = new Identification(nom, prenom);
		Infirmier nouvelInfirmier = new Infirmier(id, true);
		clinique.ajouterInfirmier(nouvelInfirmier);
		System.out.println(" Le nouveau patient " + nouvelInfirmier.toString() + "e ete ajoute");
		menu();
	}

	public static void ajouterPatient() {
		System.out.println("Vous avez selectionne : Ajouter un Patient \n");
		System.out.println("Entrez le nom du patient e ajouter :\n");
		nom = entrerUsager.next();
		System.out.println("Entrez le prenom du patient e ajouter :\n");
		prenom = entrerUsager.next();
		System.out.println("Veuillez entrer votre numero d'assurance sociale : ");
		int numAssuranceSociale = entrerUsager.nextInt();

		Identification id = new Identification(nom, prenom);
		Patient nouveauPatient = new Patient(numAssuranceSociale, id);

		clinique.ajouterPatient(nouveauPatient);
		System.out.println(" Le nouveau patient " + nouveauPatient.toString() + "e ete ajoute");
		menu();
	}

	public static void ajouterRendezVous() {

		RendezVous nouveauRendezVous = creationRendezVous();
		Date dateDeRendezVous = selectionDate();

		if (clinique.getCalendrier().ajouterRendezVous(nouveauRendezVous, dateDeRendezVous)) {
			System.out.println("Votre rendez-vous a ete enregsitre avec succes");
			System.out.println("Retour au menu");
			menu();
		} else {
			boolean input = true;
			while (input) {

				System.out.println("Voulez-vous refaire le rendez-vous ? (Y/N)");
				String answer = entrerUsager.next();
				if (answer.compareToIgnoreCase("Y") == 0) {
					ajouterRendezVous();
					input = false;

				} else if (answer.compareTo("N") == 0) {
					menu();
					input = false;
				} else {
					System.out.println("Vous n'avez pas entre (Y/N)");
				}
			}
		}

	}

	public static void trouverRDVPatient() {
		afficherListePatient();
		System.out.println("Selectionner le patient e qui ajouter un rendez-vous : ");
		int valEntre = entrerUsager.nextInt();
		Patient patientSelect = clinique.getPatient(valEntre);
		try {
			System.out.println(clinique.rendezVousPatient(patientSelect));

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		menu();
	}

	public static void afficherProchainRdvDoc() {

		
		afficherListeDocteurs();
		System.out.println("Veuillez selectionner le numero associe au docteur dans la liste");

	
			try {
				int valSelect = entrerUsager.nextInt();
				Docteur docselect = clinique.getDocteur(valSelect);
				System.out.println(clinique.getCalendrier().obtenirProchainRendezVousDocteur(docselect));
				
			} catch (Exception e) {
				System.out.println("Veuillez choisir parmis les options proposee");

			}finally {
				afficherProchainRdvDoc();
			}

		menu();
	}

	public static void afficherProchainRdvInf() {

		
		afficherListeInfirmiers();
		System.out.println("Veuillez selectionner le numero associe e l'infirmier dans la liste");
		
			try {
				int valSelect = entrerUsager.nextInt();
				Infirmier infSelect = clinique.getInfirmier(valSelect);
				System.out.println(clinique.getCalendrier().obtenirProchainRendezVousInfirmier(infSelect));
				
			} catch (Exception e) {
				System.out.println("Veuillez choisir parmis les options proposee");

			}finally {
				afficherProchainRdvInf();
			}

		menu();
	}

	public static void afficherProchainRdvPatient() {

		
		afficherListePatient();
		System.out.println("Veuillez selectionner le numero associe au patient dans la liste");

		try {
			int valSelect = entrerUsager.nextInt();
			Patient patSelect = clinique.getPatient(valSelect);
			System.out.println(clinique.getCalendrier().obtenirProchainRendezVousPatient(patSelect));
			
		} catch (Exception e) {
			System.out.println("Veuillez choisir parmis les options proposee");

		}finally {
			afficherProchainRdvPatient();
		}

		menu();
	}

	public static void sortirPremierePlage() {
		try {
			System.out.println(
					"Le prochain rendez-vous est : " + clinique.getCalendrier().obtenirProchainePLageHoraire());
		} catch (Exception e) {
			System.out.println("Le calendrier ne contient pas encore de plage horaire");
		} finally {
			menu();
		}
	}

	public static void afficherCalendrierComplet() {

		System.out.println(clinique.getCalendrier().getListePlageHoraire().toString());
		menu();

	}

	public static void afficherCalendrirerCompletDoc() {

		afficherListeDocteurs();
		System.out.println("Selectionner le numero du docteur dont vous voulez afficher le calendrier : ");

		try {
			int valSelect = entrerUsager.nextInt();
			Docteur docSelect = clinique.getDocteur(valSelect);
			System.out.println(clinique.getCalendrier().obtenirCalendirerDocteur(docSelect));
		} catch (Exception e) {
			System.out.println("Veuillez choisir parmis les options proposee");

		} finally {
			afficherListeDocteurs();
		}

		menu();
	}

	public static void afficherCalendrierCompletInf() {

		afficherListeInfirmiers();
		System.out.println("Selectionner le numero de l'infirmier dont vous voulez afficher le calendrier : ");
		try {
			int valSelect = entrerUsager.nextInt();
			Infirmier infSelect = clinique.getInfirmier(valSelect);
			System.out.println(clinique.getCalendrier().obtenirCalendirerInfirmier(infSelect));

		} catch (Exception e) {
			System.out.println("Veuillez choisir parmis les options proposee");

		} finally {
			afficherCalendrierCompletInf();
		}

		menu();
	}

	public static void annulerRDVPatient() {

		try {
			RendezVous rdvAnnuler = creationRendezVous();
			Date dateSupprime = selectionDate();
			if (clinique.verifierRendezVousAPlageHoraire(dateSupprime)) {
				if (clinique.getCalendrier().annulerRendezVous(rdvAnnuler)) {
					System.out.println("Le rendez-vous e ete annule avec succes");
				} else {
					System.out.println("Il n'y a pas de rendez-vous e la date entre");
					menu();
				}
			} else {
				System.out.println("Il n'y a pas de rendez-vous e la date entre");
				menu();
			}

		} catch (Exception e) {
			System.out.println("Le calendrier ne contient pas encore de plage horaire");
		} finally {
			menu();
		}
	}

	public static void afficherListeDocteurs() {

		System.out.println("Liste des docteurs de la clinique\n\r");
		for (int i = 0; i < clinique.getNbDocteurs(); i++) {
			System.out.println(i + ": " + clinique.getDocteur(i).toString());
		}
		System.out.println("\n");
	}

	public static void afficherListeInfirmiers() {

		System.out.println("Liste des infirmiers de la clinique\n\r");

		for (int i = 0; i < clinique.getNbInfirmiers(); i++) {
			System.out.println(i + ":" + clinique.getInfirmier(i).toString());
		}
		System.out.println("\n");
	}

	public static void afficherListePatient() {

		System.out.println("Liste des patients de la clinique\n\r");

		for (int i = 0; i < clinique.getNbPatients(); i++) {
			System.out.println(i + ":" + clinique.getPatient(i).toString());
		}
		System.out.println("\n");
	}

	private static RendezVous creationRendezVous() {

		int valEntre;
		afficherListeInfirmiers();
		afficherListePatient();
		valEntre = 0;
		System.out.println("Veuillez selectionner un docteur, un infirmier et un patient : \n");
		System.out.println("Selectionner le numero du docteur souhaite, dans la liste : ");

		try {
			valEntre = entrerUsager.nextInt();
			Docteur docSelect = clinique.getDocteur(valEntre);

		} catch (Exception e) {
			System.out.println("Veuillez choisir parmis les options proposee");
			ajouterRendezVous();
		}

		Docteur docSelect = clinique.getDocteur(valEntre);

		System.out.println("Selectionner le numero de l'infirmier souhaite, dans la liste : ");

		try {
			valEntre = entrerUsager.nextInt();
			Infirmier infSelect = clinique.getInfirmier(valEntre);

		} catch (Exception e) {
			System.out.println("Veuillez choisir parmis les options proposee");
			ajouterRendezVous();
		}

		Infirmier infSelect = clinique.getInfirmier(valEntre);

		System.out.println("Selectionner le numero du patient dans la liste : ");

		try {
			valEntre = entrerUsager.nextInt();
			Patient patSelect = clinique.getPatient(valEntre);

		} catch (Exception e) {
			System.out.println("Veuillez choisir parmis les options proposee");
			ajouterRendezVous();
		}

		Patient patSelect = clinique.getPatient(valEntre);

		RendezVous nouveauRendezVous = new RendezVous(patSelect, docSelect, infSelect);

		return nouveauRendezVous;
	}

	public static void quitter() {

		System.out.println("Voulez-vous vraiment quitter ? (Y/N)");
		String entre = entrerUsager.next();

		if (entre.compareToIgnoreCase("Y") == 0) {
			UtilitaireFichier.sauvegardeClinique(clinique, "bin.ser");
			System.out.println("bye bye");
			System.exit(0);
		} else if (entre.compareToIgnoreCase("N") == 0) {
			menu();
		} else {

			quitter();
		}

	}

	private static Date selectionDate() {

		Date dateDeRendezVous;
		Date dateCourrante = new Date();
		int annee;
		int mois;
		int jour;
		int heure;
		int minute;

		System.out.println("Maintenant entrez la date du rendez-vous souhaite:\n");
		System.out.println("Veuillez entrer l'annee :");
		// On enleve 1900, car l'horloge de java commence le -1900
		annee = entrerUsager.nextInt() - 1900;
		System.out.println("Veuillez entrer le mois :");
		mois = entrerUsager.nextInt();
		System.out.println("Veuillez entrer le jour :");
		jour = entrerUsager.nextInt();
		System.out.println("Veuillez entrer l'heure :");
		heure = entrerUsager.nextInt();
		System.out.println("Veuillez finalement entrer les minutes, soit 30 ou 00 : ");
		minute = entrerUsager.nextInt();

		dateDeRendezVous = new Date(annee, mois, jour, heure, minute);

		if (dateDeRendezVous.before(dateCourrante)) {
			System.out.println("La date que vous tentez d'entre n'est pas une date valide");
			selectionDate();
		}

		return dateDeRendezVous;
	}

}
