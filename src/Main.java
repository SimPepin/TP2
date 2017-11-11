
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

	public static Calendrier leCalendrier = new Calendrier();
	public static Clinique laClinique = new Clinique();
	public static Scanner entrerUsager = new Scanner(System.in);

	public static int valeurEntre = 0;
	public static String nom;
	public static String prenom;

	public static void main(String[] args) {

		laClinique.setCalendrier(leCalendrier);
		System.out.println(leCalendrier.toString());
		System.out.println(laClinique.calendrier.toString());
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
		// leCalendrier.ajouterRendezVous(rdv, new Date(117,05,03,7,15,12) );

		boolean result = leCalendrier.ajouterRendezVous(rdv, new Date(117, 05, 03, 7, 15, 12));

		// System.out.println(result);

		result = leCalendrier.ajouterRendezVous(rdv, new Date(117, 05, 03, 8, 00));
		// System.out.println(result);
		result = leCalendrier.ajouterRendezVous(rdv, new Date(117, 05, 03, 8, 00));
		// System.out.println(result);
		result = leCalendrier.ajouterRendezVous(rdv, new Date(117, 05, 03, 9, 30));
		result = leCalendrier.ajouterRendezVous(rdv, new Date(117, 05, 03, 10, 30));
		laClinique.setCalendrier(leCalendrier);

		laClinique.ajouterDocteur(d);
		laClinique.ajouterPatient(o);
		laClinique.ajouterDocteur(k);
		laClinique.ajouterInfirmier(i);
		laClinique.ajouterInfirmier(j);
		laClinique.ajouterPatient(p);
		laClinique.ajouterPatient(n);

		// System.out.print(laClinique.calendrier.listePlageHoraire.toString());
		// System.out.println(leCalendrier.listePlageHoraire.toString());

		// laClinique.rendezVousPatient(o);
		leCalendrier.ajouterRendezVous(rdv3, new Date(117, 05, 03, 11, 00));

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

			break;
		case 11:
			break;
		case 12:
			break;
		case 13:

			break;
		case 14:
			quitter();
			break;

		default:
			break;
		}
	}

	public static void menu() {
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
		while (valeurEntre != 14) {
			System.out.println("-->");
			valeurEntre = entrerUsager.nextInt();
			choixUsager(valeurEntre);
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

		laClinique.ajouterDocteur(nouveauDocteur);
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
		laClinique.ajouterInfirmier(nouvelInfirmier);
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

		laClinique.ajouterPatient(nouveauPatient);
		System.out.println(" Le nouveau patient " + nouveauPatient.toString() + "à été ajouté");

	}

	public static void ajouterRendezVous() {
		Date dateDeRendezVous = null;
		int valEntre;
		int annee;
		int mois;
		int jour;
		int heure;
		int minute;
		afficherListeDocteurs();
		afficherListeInfirmiers();
		afficherListePatient();

		System.out.println("Veuillez sélectionner un docteur, un infirmier et un patient : \n");
		System.out.println("Sélectionner le numéro du docteur souhaité, dans la liste : ");
		valEntre = entrerUsager.nextInt() - 1;
		Docteur docSelect = laClinique.docteur.elementAt(valeurEntre);
		System.out.println("Sélectionner le numéro de l'infirmier souhaité, dans la liste : ");
		valEntre = entrerUsager.nextInt() - 1;
		Infirmier infSelect = laClinique.infirmier.elementAt(valeurEntre);
		System.out.println("Sélectionner le numéro du patient dans la liste : ");
		valeurEntre = entrerUsager.nextInt() - 1;
		Patient patSelect = laClinique.patient.elementAt(valEntre);

		System.out.println("Maintenant entrez la date de votre prochain rendez-vous :\n");
		System.out.println("Veuillez entrer l'année :");
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

		RendezVous nouveauRendezVous = new RendezVous(patSelect, docSelect, infSelect);

		if (leCalendrier.ajouterRendezVous(nouveauRendezVous, dateDeRendezVous)) {
			System.out.println("Votre rendez-vous a été enregsitré avec succès");
			System.out.println("Retour au menu");
			menu();
		} else {
			boolean input = true;
			while (input) {

				System.out.println("Voulez-vous refaire le rendez-vous ? (Y/N)");
				if (entrerUsager.nextLine().equals("Y") || entrerUsager.nextLine().equals("y")) {
					ajouterRendezVous();
					input = false;
					// A vérifier avec bruno demain !!!
				} else if (entrerUsager.nextLine().equals("N") || entrerUsager.nextLine().equals("n")) {
					menu();
					input = false;
				} else {
					System.out.println("Vous n'avez pas dit oui ou non");
				}
			}
		}

	}

	public static void trouverRDVPatient() {

	}

	public static void afficherProchainRdvDoc() {
		afficherListeDocteurs();
		System.out.println("Veuillez sélectionner le numéro associé au docteur dans la liste");
		int valSelect = entrerUsager.nextInt();
		Docteur docselect = laClinique.docteur.elementAt(valSelect - 1);
		System.out.println(leCalendrier.obtenirProchainRendezVousDocteur(docselect));

		menu();
	}

	public static void afficherProchainRdvInf() {
		afficherListeInfirmiers();
		System.out.println("Veuillez sélectionner le numéro associé à l'infirmier dans la liste");
		int valSelect = entrerUsager.nextInt();
		Infirmier infSelect = laClinique.infirmier.elementAt(valSelect - 1);
		System.out.println(leCalendrier.obtenirProchainRendezVousInfirmier(infSelect));

		menu();
	}

	public static void afficherProchainRdvPatient() {
		afficherListePatient();
		System.out.println("Veuillez sélectionner le numéro associé au patient dans la liste");
		int valSelect = entrerUsager.nextInt();
		Patient patSelect = laClinique.patient.elementAt(valSelect - 1);
		System.out.println(leCalendrier.obtenirProchainRendezVousPatient(patSelect));

		menu();
	}

	public static void sortirPremierePlage() {
		try {
			System.out.println("Le prochain rendez-vous est : " + leCalendrier.listePlageHoraire.SortirPremierePlage());
		} catch (Exception e) {
			System.out.println("Le calendrier ne contient pas encore de plage horaire");
		} finally {
			menu();
		}
	}

	public static void afficherCalendrierComplet() {

	}

	public static void afficherCalendrirerCompletDoc() {

	}

	public static void afficherCalendrierCompletInf() {

	}

	public static void annulerRDVPatient() {

		try {
			// RendezVous rdvAnnuler = new RendezVous(p, d, i)
			// leCalendrier.annulerRendezVous();
		} catch (Exception e) {
			System.out.println("Le calendrier ne contient pas encore de plage horaire");
		} finally {
			menu();
		}
	}

	public static void quitter() {
		// À terminer avec Bruno !!!!
		System.out.println("Voulez-vous vraiment quitter ? (Y/N)");
		String entre = entrerUsager.nextLine();

		while (entre != "Y" || entre != "N" || entre != "n" || entre != "y") {
			quitter();
		}
		if (entre == "Y" || entre == "y") {
			System.out.println("bye bye");
			System.exit(0);
		} else {
			menu();
		}

	}

	public static void afficherListeDocteurs() {

		System.out.println("Liste des docteurs de la clinique\n\r");
		for (int i = 0; i < laClinique.docteur.size(); i++) {
			System.out.println(i + 1 + ": " + laClinique.docteur.get(i).toString());
		}
		System.out.println("\n");
	}

	public static void afficherListeInfirmiers() {

		System.out.println("Liste des infirmiers de la clinique\n\r");

		for (int i = 0; i < laClinique.infirmier.size(); i++) {
			System.out.println(i + 1 + ":" + laClinique.infirmier.get(i).toString());
		}
		System.out.println("\n");
	}

	public static void afficherListePatient() {
		System.out.println("Liste des patients de la clinique\n\r");

		for (int i = 0; i < laClinique.patient.size(); i++) {
			System.out.println(i + 1 + ":" + laClinique.patient.get(i).toString());
		}
		System.out.println("\n");
	}
}
