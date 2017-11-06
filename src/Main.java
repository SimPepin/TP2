import java.util.Date;

public class Main {

	public static void main(String[] args) {
		/*//Test pour les classes à ne pas prendre en considération et supprimer après.
		//System.out.println("test");
		//System.out.println("test");
		//System.out.println("testSami");
		System.out.println("testSami");
		System.out.println("testSami"); */
		
		Identification i = new Identification("un", "Docteur");
		Identification j = new Identification("un", "Infirmier");
		Identification k = new Identification("un", "patient");
		Identification l = new Identification("le ", "gars");
		Identification id4 = new Identification("jean ", "leduc");
		Docteur doc = new Docteur(i, 1);
		Docteur doc1 = new Docteur(i, 1);
		Infirmier inf = new Infirmier(j, true);
		Patient pat = new Patient(13456,k);
		Patient pat2 = new Patient(54646, l);
		Patient pat3 = new Patient(54646, j);
		Patient pat4 = new Patient(54646, id4);
		//System.out.println(doc.toString());
		RendezVous unRDV = new RendezVous(pat, doc, inf);
		RendezVous unRDV2 = new RendezVous(pat, doc, inf);
		RendezVous unRDV3 = new RendezVous(pat2, doc, inf);
		PlageHoraire unePlage = new PlageHoraire(new Date(116, 10, 05, 8, 15));
		PlageHoraire unePlage2 = new PlageHoraire(new Date(117, 10, 05, 8, 15));
		PlageHoraire unePlage3 = new PlageHoraire(new Date(118, 10, 05, 8, 15));
		unePlage.add(unRDV);
		unePlage.add(unRDV3);
		unePlage3.add(unRDV2);
		unePlage2.add(unRDV3);
		//System.out.println(unePlage);
		
		ListePlageHoraire laListe = new ListePlageHoraire();
		
		laListe.ajoutDansListe(unePlage);
		
		laListe.ajoutDansListe(unePlage3);
		laListe.ajoutDansListe(unePlage2);
		
	Calendrier cal = new Calendrier();
	cal.setListePlageHoraire(laListe);
		System.out.println(cal.obtenirProchainRendezVousPatient(pat2));
		System.out.println(cal.obtenirProchainRendezVousInfirmier(inf));
		System.out.println(cal.obtenirProchainRendezVousDocteur(doc1));
		
		System.out.println(cal.obtenirPLageHoraire());
		System.out.println(laListe.toString());
		
		//System.out.println(	laListe.toString());
		
	}

}
