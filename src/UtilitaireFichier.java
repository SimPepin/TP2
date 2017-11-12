import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Classe utilitaire qui sauverage et charge des Cliniques 
 * depuis le disque dur
 * 
 * @author Profs
 *
 */
public class UtilitaireFichier implements Serializable{
	
	
	
	
	/**
	 * Sauverage une Clinique dans le ficher bin
	 * @param p
	 * @param bin
	 * @return
	 */
	public static boolean sauvegardeClinique(Clinique p, String bin) {

		try {
			FileOutputStream fileOut = new FileOutputStream(bin);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(p);
			out.close();
			fileOut.close();
			System.out.println("Clinique sauvegardee dans " + bin);
			return true;
		} catch (IOException i) {
			i.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Load une Clinique depuis bin.
	 * Si le ficher n existe pas, retourne null
	 * 
	 * @param bin
	 * @return
	 */
	public static Clinique chargeClinique(String bin) {

		Clinique p = null;
		
		
		try {
			FileInputStream fileIn = new FileInputStream(bin);
			ObjectInputStream in = new ObjectInputStream(fileIn);
			p = (Clinique) in.readObject();
			in.close();
			fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return null;
		} catch (ClassNotFoundException c) {
			System.out.println("Employee class not found");
			c.printStackTrace();
			return null;
		}
		return p;

	}

}

