
import java.util.Date;
import java.util.Scanner;

import javax.print.Doc;

public class Main {
	public static Calendrier leCalendrier = new Calendrier();

	public static Scanner entrerUsager = new Scanner(System.in);

	public static int valeurEntre = 0;

	public static void main(String[] args) {
		//menu(valeurEntre);
		
		
		Identification id = new Identification("une", "deux");
		Identification id2 = new Identification("trois","quatre");
		Identification id3 = new Identification("yolo", "swag");
		Patient p = new Patient(123456, id);
		Docteur d = new Docteur(id, 1);
		Infirmier i = new Infirmier(id, true);
		Infirmier  j = new Infirmier(id2, true);
		Docteur  k = new Docteur(id2, 2);
		Patient l = new Patient(89898, id2);
		Patient n = new Patient(90978, id3);
		
		RendezVous rdv = new RendezVous(p, d, i);
		RendezVous rdv2 = new RendezVous(p, d, i);
		RendezVous rdv3	= new RendezVous(l, d, j);
		//leCalendrier.ajouterRendezVous(rdv, new Date(117,05,03,7,15,12) );
		
		boolean result = leCalendrier.ajouterRendezVous(rdv, new Date(117,05,03,7,15,12));
		
		//System.out.println(result);
		
	//	result = leCalendrier.ajouterRendezVous(rdv, new Date(117,05,03,8,00) );
		//System.out.println(result);
		//result = leCalendrier.ajouterRendezVous(rdv, new Date(117,05,03,8,00) );
		//System.out.println(result);
		//result = leCalendrier.ajouterRendezVous(rdv, new Date(117,05,03,9,30) );
		//System.out.println(result);
		//result = leCalendrier.ajouterRendezVous(rdv3, new Date(117,05,03,9,30) );
		//System.out.println(result);
		//System.out.println(leCalendrier.listePlageHoraire.toString());
		
		//leCalendrier.annulerRendezVous(rdv3);
		//leCalendrier.annulerRendezVous(rdv);
		//System.out.println(leCalendrier.listePlageHoraire.toString());
		
		//System.out.println(leCalendrier.obtenirProchainRendezVousPatient(l));
		//System.out.println(leCalendrier.obtenirProchainRendezVousPatient(l));
		//System.out.println(leCalendrier.obtenirProchainePLageHoraire());
		//System.out.println(leCalendrier.listePlageHoraire.toString());
		Clinique laClinique = new Clinique();
		laClinique.setCalendrier(leCalendrier);
		
		laClinique.ajouterDoctuer(d);
		laClinique.ajouterDoctuer(k);
		laClinique.ajouterInfirmier(i);
		laClinique.ajouterPatient(p);
		laClinique.ajouterPatient(n);
		
		
	
		for (int m = 0; m < laClinique.docteur.size(); m++) {
			System.out.println(laClinique.docteur.get(m));
		}
		for (int m = 0; m < laClinique.patient.size(); m++) {
			System.out.println(laClinique.patient.get(m));
		}
		System.out.println(leCalendrier.obtenirCalendirerInfirmier(i));
		
		//laClinique.rendezVousPatient(n);
		
		
		
		
		
	}

	public static void choixUsager(int valeurEntre) {

		switch (valeurEntre) {
		case 1:
			break;
		case 2:
			break;
		case 3:
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
		valeurEntre = entrerUsager.nextInt();
		while (valeurEntre != 14) {
			System.out.println("-->");
			valeurEntre = entrerUsager.nextInt();
			choixUsager(valeurEntre);
		}
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

}
