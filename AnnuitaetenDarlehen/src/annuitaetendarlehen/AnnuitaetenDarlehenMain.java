/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annuitaetendarlehen;

/**
 *
 * @author KOALA
 */
public class AnnuitaetenDarlehenMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\nKreditrechner\n");
        System.out.println("Bitte geben Sie ein:\n");
        String info = "Hoehe des Kredits [1.00 - 1000000000.00]:    ";
        double kreditHoehe = MeineEingabe.erfasseDouble(info);
        info = "Laufzeit des Kredits in Jahren [1 - 100]:    ";
        int laufzeit = MeineEingabe.erfasseInt(info);
        info = "Effektiver Jahreszins in Prozent [0.1 - 30.0]:    ";
        double zinssatz = MeineEingabe.erfasseDouble(info);
        AnnuitaetenDarlehen kredit = new AnnuitaetenDarlehen(kreditHoehe, laufzeit, zinssatz);
        System.out.println("\nKredit:\n");
        schreibeKreditdaten(kredit);
    }
    
    private static void schreibeKreditdaten(AnnuitaetenDarlehen darlehen)
    {
        System.out.printf("%-40s%10.2f Euro\n", "Kredithoehe:",
                          darlehen.liefereDarlehensBetrag());
        System.out.printf("%-40s%10d Jahre\n", "Laufzeit",
                          darlehen.liefereLaufzeit());
        System.out.printf("%-45s%s\n", "Beginn der Laufzeit:",
                          darlehen.liefereAuszahlungsDatum());
        System.out.printf("%-45s%s\n", "Ende der Laufzeit:",
                          darlehen.liefereTilgungsEnde());
        System.out.printf("%-40s%10.2f %s\n", "Zinssatz:",
                          darlehen.liefereZinssatz(), "%");
        System.out.println();
        System.out.printf("%-40s%10.2f Euro\n", "Jaehrliche Rate:",
                          darlehen.liefereJaehrlicheRate());
        System.out.printf("%-40s%10.2f Euro\n", "Zinsen (jaehrliche Rate):",
                          darlehen.liefereZinsenBeiJaehrlicherRate());
        System.out.printf("%-40s%10.2f Euro\n", "Gesamtaufwand (jaehrliche Rate):",
                          darlehen.liefereGesamtAufwandBeiJaehrlicherRate());
        System.out.println();
        System.out.printf("%-40s%10.2f Euro\n", "Monatliche Rate:",
                          darlehen.liefereMonatlicheRate());
        System.out.printf("%-40s%10.2f Euro\n", "Zinsen (monatliche Rate):",
                          darlehen.liefereZinsenBeiMonatlicherRate());
        System.out.printf("%-40s%10.2f Euro\n", "Gesamtaufwand (monatliche Rate):",
                          darlehen.liefereGesamtAufwandBeiMonatlicherRate());
        System.out.println();
    }    
}
