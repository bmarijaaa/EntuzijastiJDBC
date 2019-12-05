package model;

public class Validacija {

    public static boolean daLiJeBroj (String nizkaraktera) {
    	
    	boolean odgovor = true;
    	
    	for (int i = 0; i < nizkaraktera.length(); i++) {
			
    		char karakter = nizkaraktera.charAt(i);
    		
    		if (!(Character.isDigit(karakter))) {
				odgovor = false;
			}
		}
    	return odgovor;

    }
	
	
	
	
	
}
