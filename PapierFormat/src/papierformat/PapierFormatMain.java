/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package papierformat;

/**
 *
 * @author KOALA
 */
public class PapierFormatMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("\nSie erhalten Informationen zu Papierformaten.\n");
        String eingabe = erfassePapierFormat();
        schreibeFormatInfo(eingabe);
        /* Demonstration of the "foreach" with the implemented method "values()"-(enum class)
        System.out.println("\nInformationen zu Papierformaten:\n");
        PapierFormat[] papierFormat = PapierFormat.values();
        for (PapierFormat format : papierFormat)
        {
            schreibeFormatInfo2(format);
        }  
        */
    }
    
    private static String erfassePapierFormat()
    {
        String info = "Bitte das Papierformat eingeben (Din A0 - Din A10):    ";
        return MeineEingabe.erfasseText(info, "Din A([0-9]|10)");
    }

    private static void schreibeFormatInfo(String papierFormat)
    {
        String ausgabe = "\n\nDas Format " + papierFormat;
        papierFormat = papierFormat.replace("in ", "IN");
        PapierFormat format = PapierFormat.valueOf(papierFormat);
        if (format == PapierFormat.DINA9 || format == PapierFormat.DINA10)
        {
            ausgabe += " hat keine spezielle Bezeichnung.";
        }
        else
        {
            ausgabe += (" wird als " + format.liefereBezeichnung() + " bezeichnet.");
        }
        ausgabe += "\n\nEs hat folgende Groesse:\n\n";
        ausgabe += formatiereZeile("Breite", format.liefereBreite(), "mm");
        ausgabe += formatiereZeile("Hoehe", format.liefereHoehe(), "mm");
        ausgabe += formatiereZeile("Flaeche", format.liefereFlaeche(), "qmm");
        System.out.println(ausgabe);
    }

    private static void schreibeFormatInfo2(PapierFormat format)
    {
        String ausgabe = String.format("%-10s", format.name());
        ausgabe += String.format("%-16s", format.liefereBezeichnung());
        ausgabe += String.format("%5d mm \u00D7 ", format.liefereBreite());
        ausgabe += String.format("%4d mm   =", format.liefereHoehe());
        ausgabe += String.format("%8d qmm", format.liefereFlaeche());
        System.out.println(ausgabe);
    }
/*  Die Experten für PapierFormat sollten selbst wissen, wie sie bezeichnet werden!
    public static String liefereBezeichnung(PapierFormat format)
    {
        String bezeichnung = "";
        switch (format)
        {
            case DINA0 :
                bezeichnung = "Doppelbogen";
                break;
            ...
            default:
                break;
        }
        return bezeichnung;
    }
*/
    private static String formatiereZeile(String name, int wert, String einheit)
    {
        return String.format("%-8s:%12d%4s\n", name, wert, einheit);
    }
}
