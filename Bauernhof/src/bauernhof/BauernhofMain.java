/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bauernhof;

/**
 *  Abstract:    (1) Es können keine Objecte von einer abstracten Klasse erzeugt werden
 *               (2) Jede Klasse, die von ihr abgeleitet wird, muss ihre als abstract
 *                   deklarierten Methoden implementieren
 *  Erinnerung: Bei "einfacher" Vererbung kann man die Methoden überschreiben
 *              (overriding), aber man wird nicht dazu gezwungen
 * 
 *  Polymorphie: Polymorphie oder Polymorphismus ist ein Konzept in der OOP, 
 *               das ermöglicht, dass ein Bezeichner abhängig von seiner Verwendung 
 *               unterschiedliche Datentypen annimmt.
 */
public class BauernhofMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tier[] viecher = { new Hund("Lumpi", "Dackel"),
                           new Katze("Pussy", "Siamkatze"),
                           new Kuh(),
                           new Ameise(),
                           new Katze("Mieze", "Perserkatze"),
                           new Hund("Tarzan", "Pinscher"),
                           new Hund("Lu", "Wolfsspitz")
                         };
        for (Tier kreatur : viecher)
        {
            schreibeTierInfo(kreatur);
        }
    }
   
    public static void schreibeTierInfo(Tier einTier)
    {
        System.out.print(einTier.liefereInfo());
        einTier.sprich();
        System.out.println();
    }
}
