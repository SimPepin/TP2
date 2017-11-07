
import java.util.Scanner;

public class Main {
	public static Calendrier leCalendrier = new Calendrier();

	public static Scanner entrerUsager = new Scanner(System.in);

	public static void main(String[] args) {
		int valeurEntre = 0;
		menu(valeurEntre);
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
		System.out.println("Bienvenue à la clinique \r\n" + "Que voulez-vous faire ? \r\n"+ "1 - Ajouter un docteur\r\n" + "2 - Ajouter un infirmier\r\n"
				+ "3 - Ajouter un patient\r\n" + "4 - Ajouter un rendez-vous\r\n"
				+ "5 - Trouver un rendez-vous pour un patient\r\n"
				+ "6 - Afficher le prochain rendez-vous d'un docteur\r\n"
				+ "7 - Afficher le prochain rendez-vous d'un infirmier\r\n"
				+ "8 - Afficher le prochain rendez-vous d'un patient\r\n" + "9 - Passer à la prochaine plage horaire\r\n"
				+ "10- Afficher le calendrier complet\r\n" + "11- Afficher le calendrier complet d'un docteur\r\n"
				+ "12- Afficher le calendrier complet d'un infirmier\r\n" + "13- Annuler un rendez-vous\r\n"
				+ "14- Quitter");

		while (valeurEntre != 14) {
			System.out.println("-->");
			valeurEntre = entrerUsager.nextInt();
			choixUsager(valeurEntre);
		}
	}
	
	public static void trouverRDVPatient() {
		
	}
	
	//public static void

	public static void sortirPremierePlage() {
		try {
			leCalendrier.listePlageHoraire.SortirPremierePlage();
		} catch (Exception e) {
			System.out.println("Le calendrier ne contient pas encore de plage horaire");
		} finally {
			menu(0);
		}
	}

	public static void quitter() {
		System.out.println("bye bye");
		System.exit(0);
	}

	/*
	 * Identification i = new Identification("un", "Docteur"); Identification j =
	 * new Identification("un", "Infirmier"); Identification k = new
	 * Identification("un", "patient"); Identification l = new Identification("le ",
	 * "gars"); Identification id4 = new Identification("jean ", "leduc"); Docteur
	 * doc = new Docteur(i, 1); Docteur doc1 = new Docteur(i, 1); Infirmier inf =
	 * new Infirmier(j, true); Patient pat = new Patient(13456, k); Patient pat2 =
	 * new Patient(54646, l); Patient pat3 = new Patient(54646, j); Patient pat4 =
	 * new Patient(54646, id4); // System.out.println(doc.toString()); RendezVous
	 * unRDV = new RendezVous(pat, doc, inf); RendezVous unRDV2 = new
	 * RendezVous(pat, doc, inf); RendezVous unRDV3 = new RendezVous(pat2, doc,
	 * inf); PlageHoraire unePlage = new PlageHoraire(new Date(116, 10, 05, 8, 15));
	 * PlageHoraire unePlage2 = new PlageHoraire(new Date(117, 10, 05, 8, 15));
	 * PlageHoraire unePlage3 = new PlageHoraire(new Date(118, 10, 05, 8, 15));
	 * unePlage.add(unRDV); unePlage.add(unRDV3); unePlage3.add(unRDV2);
	 * unePlage2.add(unRDV3); // System.out.println(unePlage);
	 * 
	 * ListePlageHoraire laListe = new ListePlageHoraire();
	 * 
	 * laListe.ajoutDansListe(unePlage);
	 * 
	 * laListe.ajoutDansListe(unePlage3); laListe.ajoutDansListe(unePlage2);
	 * 
	 * Calendrier cal = new Calendrier(); cal.setListePlageHoraire(laListe);
	 * System.out.println(cal.obtenirProchainRendezVousPatient(pat2));
	 * System.out.println(cal.obtenirProchainRendezVousInfirmier(inf));
	 * System.out.println(cal.obtenirProchainRendezVousDocteur(doc1));
	 * 
	 * System.out.println(cal.obtenirPLageHoraire());
	 * System.out.println(laListe.toString());
	 */
	// System.out.println( laListe.toString());
}
