/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annuitaetendarlehen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 *
 * @author KOALA
 */
public class MeineEingabe {
    private static BufferedReader eingabe =
        new BufferedReader(new InputStreamReader(System.in));

    private MeineEingabe()
    {
    }

    public static String erfasseText()
    {
        return erfasseText("");
    }

    public static String erfasseText(String eingabeAufforderung)
    {
        System.out.print(eingabeAufforderung);
        String text = "";
        boolean eingabeOk = false;
        while (!eingabeOk)
        {
            try
            {
                text = eingabe.readLine();
                eingabeOk = true;
            }
            catch(IOException ioe)
            {
            }
        }
        return text;
    }

    public static String erfasseText(String eingabeAufforderung,
                                     String eingabeFormat)
    {
        String text = "";
        boolean eingabeOk = false;
        while (!eingabeOk)
        {
            text = erfasseText(eingabeAufforderung);
            eingabeOk = text.matches(eingabeFormat);
        }
        return text;
    }

    public static int erfasseInt()
    {
        return erfasseInt("");
    }

    public static int erfasseInt(String eingabeAufforderung)
    {
        int wert = 0;
        boolean eingabeOk = false;
        while (!eingabeOk)
        {
            try
            {
                wert = Integer.parseInt(erfasseText(eingabeAufforderung));
                eingabeOk = true;
            }
            catch (NumberFormatException nfe)
            {
            }
        }
        return wert;
    }

    public static int erfasseInt(String eingabeAufforderung, int min, int max)
    {
        int wert = 0;
        boolean eingabeOk = false;
        while (!eingabeOk)
        {
            wert = erfasseInt(eingabeAufforderung);
            eingabeOk = (min <= wert && wert <= max);
        }
        return wert;
    }

    public static double erfasseDouble() 
    {
        return erfasseDouble("");
    }

    public static double erfasseDouble(String eingabeAufforderung) 
    {
        double wert = 0;
        boolean eingabeOk = false;
        while (!eingabeOk)
        {
            try 
            {
                wert = Double.parseDouble(erfasseText(eingabeAufforderung));
                eingabeOk = true;
            } 
            catch (NumberFormatException nfe) 
            {
            }
        }
        return wert;
    }

    public static double erfasseDouble(String eingabeAufforderung, double min, double max)  
    {
        double wert = 0;
        boolean eingabeOk = false;
        while (!eingabeOk)  
        {
            wert = erfasseInt(eingabeAufforderung);
            eingabeOk = (min <= wert && wert <= max);
        }
        return wert;
    }
}
