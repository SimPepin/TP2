
public class Main {

	public static void main(String[] args) {

		Identification i = new Identification("Paul", "attend");
		
		Patient p = new Patient(26, i);
		
		System.out.println(p.toString());
		
		Patient f = new Patient(35, i);
		
		System.out.println(f.toString());
	
	}

}
