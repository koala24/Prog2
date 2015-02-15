/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package annuitaetendarlehen;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author KOALA
 */
public class AnnuitaetenDarlehen {
    private double betrag;
    private int laufzeit;
    private double zinssatz;
    private GregorianCalendar startdatum;

    public AnnuitaetenDarlehen(double derBetrag,
                               int dieLaufzeit,
                               double derZinssatz)
    {
        boolean inputOk = (1.0 <= derBetrag && derBetrag <= 1000000000.0) &&
                          (1 <= dieLaufzeit && dieLaufzeit <= 100) &&
                          (0.1 <= derZinssatz && derZinssatz <= 30.0);
        if (inputOk)
        {
            betrag = derBetrag;
            laufzeit = dieLaufzeit;
            zinssatz = derZinssatz;
            startdatum = new GregorianCalendar();    // heutiges Datum
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public AnnuitaetenDarlehen(double derBetrag,
                               int dieLaufzeit,
                               double derZinssatz,
                               final GregorianCalendar dasStartdatum)
    {
        boolean inputOk = (1.0 <= derBetrag && derBetrag <= 1000000000.0) &&
                          (1 <= dieLaufzeit && dieLaufzeit <= 100) &&
                          (0.1 <= derZinssatz && derZinssatz <= 30.0) &&
                          (dasStartdatum != null);
        if (inputOk)
        {
            betrag = derBetrag;
            laufzeit = dieLaufzeit;
            zinssatz = derZinssatz;
            startdatum = new GregorianCalendar();    // heutiges Datum
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }


    public double liefereDarlehensBetrag()
    {
        return betrag;
    }

    public int liefereLaufzeit()
    {
        return laufzeit;
    }

    public double liefereZinssatz()
    {
        return zinssatz;
    }

    public String liefereAuszahlungsDatum()
    {
        // startdatum wird nicht zurückgegeben, da es eine Referenz ist
        // und die Datenkapselung wäre damit aufgehoben (von außen änderbar)
        // Folie: Klassen1 Seite: 24 => nochmal gucken..
        return String.format("%1$td.%1$tm.%1$tY", startdatum);
    }

    public String liefereTilgungsEnde()
    {
        GregorianCalendar termin =    // lokale Kopie (soll auch einfacher gehen!)
            new GregorianCalendar(startdatum.get(Calendar.YEAR),
                                  startdatum.get(Calendar.MONTH),
                                  startdatum.get(Calendar.DAY_OF_MONTH));
        termin.add(Calendar.YEAR, laufzeit);
        return String.format("%1$td.%1$tm.%1$tY", termin);
    }

    public double liefereJaehrlicheRate()
    {
        return liefereAnnuitaet();
    }

    private double liefereAnnuitaet()
    {
        double q = 1 + (zinssatz / 100.0);
        double qHochLaufzeit = Math.pow(q, laufzeit);
        return betrag * qHochLaufzeit * ((q - 1) / (qHochLaufzeit - 1));
    }

    public double liefereZinsenBeiJaehrlicherRate()
    {
        return liefereGesamtAufwandBeiJaehrlicherRate() - betrag;
    }

    public double liefereGesamtAufwandBeiJaehrlicherRate()
    {
        return laufzeit * liefereAnnuitaet();
    }

    public double liefereMonatlicheRate()
    {
        int ratenProJahr = 12;
        double zinsfaktor = zinssatz / 100;
        double nenner = ratenProJahr + ((zinsfaktor / 2.0) * (ratenProJahr - 1));
        return liefereAnnuitaet() / nenner;
    }

    public double liefereZinsenBeiMonatlicherRate()
    {
        double zinsenGesamt = 0;
        double zinsenImMonat = 0;
        double zinsenImJahr = 0;
        double monatlicheRate = liefereMonatlicheRate();
        double restschuld = betrag;
        for (int jahr = 1; jahr <= laufzeit; jahr++)
        {
            for (int monat = 1; monat <= 12; monat++)
            {
                zinsenImMonat = (restschuld / 100 * zinssatz) / 12;
                zinsenImJahr += zinsenImMonat;
                if (monat != 12)
                {
                    restschuld -= monatlicheRate;
                }
                else
                {
                    if (zinsenImJahr >= monatlicheRate)
                    {
                        restschuld += (zinsenImJahr - monatlicheRate);
                    }
                    else
                    {
                        restschuld -= (monatlicheRate - zinsenImJahr);
                    }
                }
            }
            zinsenGesamt += zinsenImJahr;
            zinsenImJahr = 0;
        }
        return zinsenGesamt;
    }

    public double liefereGesamtAufwandBeiMonatlicherRate()
    {
        return laufzeit * 12 * liefereMonatlicheRate();
    }
}
