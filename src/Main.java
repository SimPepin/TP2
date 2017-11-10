
import java.util.Date;
import java.util.Scanner;

import javax.print.Doc;
import javax.sound.midi.SysexMessage;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class Main {
	public static Calendrier leCalendrier = new Calendrier();
	public static Clinique laClinique = new Clinique();
	public static Scanner entrerUsager = new Scanner(System.in);

	public static int valeurEntre = 0;

	public static void main(String[] args) {
		menu(valeurEntre);

		Identification id = new Identification("une", "deux");
		Identification id2 = new Identification("trois", "quatre");
		Identification id3 = new Identification("yolo", "swag");
		Patient p = new Patient(123456, id);
		Docteur d = new Docteur(id, 1);
		Infirmier i = new Infirmier(id, true);
		Infirmier j = new Infirmier(id2, true);
		Docteur k = new Docteur(id2, 2);
		Patient l = new Patient(89898, id2);
		Patient n = new Patient(90978, id3);

		RendezVous rdv = new RendezVous(p, d, i);
		RendezVous rdv2 = new RendezVous(p, d, i);
		RendezVous rdv3 = new RendezVous(l, d, j);
		// leCalendrier.ajouterRendezVous(rdv, new Date(117,05,03,7,15,12) );

		boolean result = leCalendrier.ajouterRendezVous(rdv, new Date(117, 05, 03, 7, 15, 12));

		// System.out.println(result);

		result = leCalendrier.ajouterRendezVous(rdv, new Date(117, 05, 03, 8, 00));
		// System.out.println(result);
		result = leCalendrier.ajouterRendezVous(rdv, new Date(117, 05, 03, 8, 00));
		// System.out.println(result);
		result = leCalendrier.ajouterRendezVous(rdv, new Date(117, 05, 03, 9, 30));
		
		laClinique.setCalendrier(leCalendrier);

		laClinique.ajouterDocteur(d);
		laClinique.ajouterDocteur(k);
		laClinique.ajouterInfirmier(i);
		laClinique.ajouterPatient(p);
		laClinique.ajouterPatient(n);

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
			break;
		case 7:
			break;
		case 8:
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

	public static void menu(int valeurEntre) {
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
		String nom = entrerUsager.next();
		System.out.println("Entrez le prénom du docteur à ajouter :\n");
		String prenom = entrerUsager.next();
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
		String nom = entrerUsager.next();
		System.out.println("Entrez le prénom de l'infirmier à ajouter :\n");
		String prenom = entrerUsager.next();

		Identification id = new Identification(nom, prenom);
		Infirmier nouvelInfirmier = new Infirmier(id, true);
		laClinique.ajouterInfirmier(nouvelInfirmier);
		System.out.println(" Le nouveau patient " + nouvelInfirmier.toString() + "à été ajouté");
	}

	public static void ajouterPatient() {
		System.out.println("Vous avez sélectionné : Ajouter un Patient \n");
		System.out.println("Entrez le nom du patient à ajouter :\n");
		String nom = entrerUsager.next();
		System.out.println("Entrez le prénom du patient à ajouter :\n");
		String prenom = entrerUsager.next();
		System.out.println("Veuillez entrer votre numéro d'assurance sociale : ");
		int numAssuranceSociale = entrerUsager.nextInt();

		Identification id = new Identification(nom, prenom);
		Patient nouveauPatient = new Patient(numAssuranceSociale, id);

		laClinique.ajouterPatient(nouveauPatient);
		System.out.println(" Le nouveau patient " + nouveauPatient.toString() + "à été ajouté");

	}

	public static void ajouterRendezVous() {
		

	}

	public static void trouverRDVPatient() {

	}

	public static void annulerRDVPatient() {

		try {
			// RendezVous rdvAnnuler = new RendezVous(p, d, i)
			// leCalendrier.annulerRendezVous();
		} catch (Exception e) {
			System.out.println("Le calendrier ne contient pas encore de plage horaire");
		} finally {
			menu(valeurEntre);
		}
	}

	public static void sortirPremierePlage() {
		try {
			leCalendrier.listePlageHoraire.SortirPremierePlage();
		} catch (Exception e) {
			System.out.println("Le calendrier ne contient pas encore de plage horaire");
		} finally {
			menu(valeurEntre);
		}
	}

	public static void quitter() {
		System.out.println("Voulez-vous vraiment quitter ? (Y/N)");
		String entre = entrerUsager.nextLine();

		while (entre != "Y" || entre != "N" || entre != "n" || entre != "y") {
			quitter();
		}
		if (entre == "Y" || entre == "y") {
			System.out.println("bye bye");
			System.exit(0);
		} else {
			menu(valeurEntre);
		}

	}

	public static void afficherListeDocteurs() {

		System.out.println("Liste des docteurs de la clinique\n\r");
		for (int i = 0; i < laClinique.docteur.size(); i++) {
			System.out.println(i + 1 + ": " + laClinique.docteur.get(i).toString());
		}
	}

	public static void afficherListeInfirmiers() {

		System.out.println("Liste des infirmiers de la clinique\n\r");

		for (int i = 0; i < laClinique.infirmier.size(); i++) {
			System.out.println(i + 1 + ":" + laClinique.infirmier.get(i).toString());
		}
	}
	
	public static void afficherListePatient() {
		System.out.println("Liste des patients de la clinique\n\r");
		
		for (int i = 0; i < laClinique.patient.size(); i++) {
			System.out.println(i + 1 + ":" + laClinique.patient.get(i).toString());
		}
	}
}
