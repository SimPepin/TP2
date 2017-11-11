
import java.sql.Time;
import java.util.Date;
import java.util.Scanner;

import javax.print.Doc;
import javax.sound.midi.SysexMessage;
import javax.swing.Timer;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import jdk.nashorn.internal.ir.LexicalContext;

public class Main {

	private static Clinique clinique;
	private static Scanner entrerUsager;

	private static String nom;
	private static String prenom;

	public static void main(String[] args) {

		clinique = new Clinique();
		entrerUsager = new Scanner(System.in);

		// clinique.setCalendrier(leCalendrier);
		// System.out.println(leCalendrier.toString());
		// System.out.println(clinique.calendrier.toString());
		Identification id = new Identification("une", "deux");
		Identification id2 = new Identification("trois", "quatre");
		Identification id3 = new Identification("yolo", "swag");
		Patient p = new Patient(123456, id);
		Patient o = new Patient(9786676, id3);
		Docteur d = new Docteur(id, 1);
		Infirmier i = new Infirmier(id, true);
		Infirmier j = new Infirmier(id2, true);
		Docteur k = new Docteur(id2, 2);
		Patient l = new Patient(89898, id2);
		Patient n = new Patient(90978, id3);

		RendezVous rdv = new RendezVous(p, d, i);
		RendezVous rdv2 = new RendezVous(p, d, i);
		RendezVous rdv3 = new RendezVous(l, d, i);

		// System.out.println(result);

		
		// System.out.println(result);
		//clinique.getCalendrier().ajouterRendezVous(rdv, new Date(117, 05, 13, 8, 00));
		// System.out.println(result);
	
		// clinique.setCalendrier(leCalendrier);

		clinique.ajouterDocteur(d);
		clinique.ajouterPatient(o);
		clinique.ajouterDocteur(k);
		clinique.ajouterInfirmier(i);
		clinique.ajouterInfirmier(j);
		clinique.ajouterPatient(p);
		clinique.ajouterPatient(n);

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
		System.out.println("Bienvenue à la clinique \r\n" + "Que voulez-vous faire ? \r\n"
				+ "1 - Ajouter un docteur\r\n" + "2 - Ajouter un infirmier\r\n" + "3 - Ajouter un patient\r\n"
				+ "4 - Ajouter un rendez-vous\r\n" + "5 - Trouver un rendez-vous pour un patient\r\n"
				+ "6 - Afficher le prochain rendez-vous d'un docteur\r\n"
				+ "7 - Afficher le prochain rendez-vous d'un infirmier\r\n"
				+ "8 - Afficher le prochain rendez-vous d'un patient\r\n"
				+ "9 - Passer à la prochaine plage horaire\r\n" + "10- Afficher le calendrier complet\r\n"
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

		System.out.println("Vous avez sélectionné : Ajouter un Docteur \n");
		System.out.println("Entrez le nom du docteur à ajouter :\n");
		nom = entrerUsager.next();
		System.out.println("Entrez le prénom du docteur à ajouter :\n");
		prenom = entrerUsager.next();
		System.out.println("Veuillez sélectionner le numéro correspondant au département de ce docteur :\n");
		System.out.println("1 : CHIRURGIE \r" + "2 : URGENCE \r" + "3 : UROLOGIE \r");
		int numDepart = entrerUsager.nextInt();
		Identification id = new Identification(nom, prenom);
		Docteur nouveauDocteur = new Docteur(id, numDepart);

		clinique.ajouterDocteur(nouveauDocteur);
		System.out.println(" Le nouveau Docteur " + nouveauDocteur.toString() + "à été ajouté");
	}

	public static void ajouterInfirmier() {
		System.out.println("Vous avez sélectionné : Ajouter un Infirmier \n");
		System.out.println("Entrez le nom de l'infirmier à ajouter :\n");
		nom = entrerUsager.next();
		System.out.println("Entrez le prénom de l'infirmier à ajouter :\n");
		prenom = entrerUsager.next();

		Identification id = new Identification(nom, prenom);
		Infirmier nouvelInfirmier = new Infirmier(id, true);
		clinique.ajouterInfirmier(nouvelInfirmier);
		System.out.println(" Le nouveau patient " + nouvelInfirmier.toString() + "à été ajouté");
	}

	public static void ajouterPatient() {
		System.out.println("Vous avez sélectionné : Ajouter un Patient \n");
		System.out.println("Entrez le nom du patient à ajouter :\n");
		nom = entrerUsager.next();
		System.out.println("Entrez le prénom du patient à ajouter :\n");
		prenom = entrerUsager.next();
		System.out.println("Veuillez entrer votre numéro d'assurance sociale : ");
		int numAssuranceSociale = entrerUsager.nextInt();

		Identification id = new Identification(nom, prenom);
		Patient nouveauPatient = new Patient(numAssuranceSociale, id);

		clinique.ajouterPatient(nouveauPatient);
		System.out.println(" Le nouveau patient " + nouveauPatient.toString() + "à été ajouté");
		menu();
	}

	public static void ajouterRendezVous() {

		RendezVous nouveauRendezVous = creationRendezVous();
		Date dateDeRendezVous = selectionDate();

		if (clinique.getCalendrier().ajouterRendezVous(nouveauRendezVous, dateDeRendezVous)) {
			System.out.println("Votre rendez-vous a été enregsitré avec succès");
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
					System.out.println("Vous n'avez pas entré (Y/N)");
				}
			}
		}

	}

	public static void trouverRDVPatient() {
		afficherListePatient();
		System.out.println("Sélectionner le patient à qui ajouter un rendez-vous : ");
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
		System.out.println("Veuillez sélectionner le numéro associé au docteur dans la liste");
		int valSelect = entrerUsager.nextInt();
		Docteur docselect = clinique.getDocteur(valSelect);
		System.out.println(clinique.getCalendrier().obtenirProchainRendezVousDocteur(docselect));

		menu();
	}

	public static void afficherProchainRdvInf() {
		afficherListeInfirmiers();
		System.out.println("Veuillez sélectionner le numéro associé à l'infirmier dans la liste");
		int valSelect = entrerUsager.nextInt();
		Infirmier infSelect = clinique.getInfirmier(valSelect);
		System.out.println(clinique.getCalendrier().obtenirProchainRendezVousInfirmier(infSelect));

		menu();
	}

	public static void afficherProchainRdvPatient() {
		afficherListePatient();
		System.out.println("Veuillez sélectionner le numéro associé au patient dans la liste");
		int valSelect = entrerUsager.nextInt();
		Patient patSelect = clinique.getPatient(valSelect);
		System.out.println(clinique.getCalendrier().obtenirProchainRendezVousPatient(patSelect));

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
		System.out.println("Sélectionner le numéro du docteur dont vous voulez afficher le calendrier : ");
		int valSelect = entrerUsager.nextInt();
		Docteur docSelect = clinique.getDocteur(valSelect);
		System.out.println(clinique.getCalendrier().obtenirCalendirerDocteur(docSelect));
	}

	public static void afficherCalendrierCompletInf() {
		afficherListeInfirmiers();
		System.out.println("Sélectionner le numéro de l'infirmier dont vous voulez afficher le calendrier : ");
		int valSelect = entrerUsager.nextInt();
		Infirmier infSelect = clinique.getInfirmier(valSelect);
		System.out.println(clinique.getCalendrier().obtenirCalendirerInfirmier(infSelect));
	}

	public static void annulerRDVPatient() {

		try {
			RendezVous rdvAnnuler = creationRendezVous();
			Date dateSupprime = selectionDate();
			if (clinique.verifierRendezVousAPlageHoraire(dateSupprime)) {
				if (clinique.getCalendrier().annulerRendezVous(rdvAnnuler)) {
					System.out.println("Le rendez-vous à été annulé avec succès");
				} else {
					System.out.println("Il n'y a pas de rendez-vous à la date entré");
					menu();
				}
			} else {
				System.out.println("Il n'y a pas de rendez-vous à la date entré");
				menu();
			}

		} catch (Exception e) {
			System.out.println("Le calendrier ne contient pas encore de plage horaire");
		} finally {
			menu();
		}
	}

	public static void quitter() {

		System.out.println("Voulez-vous vraiment quitter ? (Y/N)");
		String entre = entrerUsager.next();

		if (entre.compareToIgnoreCase("Y") == 0) {
			System.out.println("bye bye");
			System.exit(0);
		} else if (entre.compareToIgnoreCase("N") == 0) {
			menu();
		} else {
			quitter();
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
		afficherListeDocteurs();
		afficherListeInfirmiers();
		afficherListePatient();

		System.out.println("Veuillez sélectionner un docteur, un infirmier et un patient : \n");
		System.out.println("Sélectionner le numéro du docteur souhaité, dans la liste : ");
		valEntre = entrerUsager.nextInt();
		Docteur docSelect = clinique.getDocteur(valEntre);
		System.out.println("Sélectionner le numéro de l'infirmier souhaité, dans la liste : ");
		valEntre = entrerUsager.nextInt();
		Infirmier infSelect = clinique.getInfirmier(valEntre);
		System.out.println("Sélectionner le numéro du patient dans la liste : ");
		valEntre = entrerUsager.nextInt();
		Patient patSelect = clinique.getPatient(valEntre);

		RendezVous nouveauRendezVous = new RendezVous(patSelect, docSelect, infSelect);

		return nouveauRendezVous;
	}

	private static Date selectionDate() {

		Date dateDeRendezVous;

		int annee;
		int mois;
		int jour;
		int heure;
		int minute;

		System.out.println("Maintenant entrez la date du rendez-vous souhaite:\n");
		System.out.println("Veuillez entrer l'année :");
		// On enleve 1900, car l'horloge de java commence à -1900
		annee = entrerUsager.nextInt() -1900;
		System.out.println("Veuillez entrer le mois :");
		mois = entrerUsager.nextInt();
		System.out.println("Veuillez entrer le jour :");
		jour = entrerUsager.nextInt();
		System.out.println("Veuillez entrer l'heure :");
		heure = entrerUsager.nextInt();
		System.out.println("Veuillez finalement entrer les minutes, soit 30 ou 00 : ");
		minute = entrerUsager.nextInt();

		dateDeRendezVous = new Date(annee, mois, jour, heure, minute);
		return dateDeRendezVous;
	}
}
