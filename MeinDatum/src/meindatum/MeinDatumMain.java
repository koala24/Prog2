/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meindatum;

/**
 *
 * @author KOALA
 */
public class MeinDatumMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MeinDatum deinGeburtstag = new MeinDatum(17, 11, 1984);
        MeinDatum meinHochzeitstag = (MeinDatum) deinGeburtstag.clone();
        System.out.println("Dein Geburtstag:    " + deinGeburtstag);
        System.out.println("Mein Hochzeitstag:  " + meinHochzeitstag);
        System.out.println("\nMein Hochzeitstag wird korrigiert.");
        meinHochzeitstag.setzeJahr(2000);
        System.out.println("Mein Hochzeitstag:  " + meinHochzeitstag);
        System.out.println("\nDas hat keine Auswirkung auf Dein Geburtstag.");
        System.out.println("Dein Geburtstag:    " + deinGeburtstag);
    }
    
}
