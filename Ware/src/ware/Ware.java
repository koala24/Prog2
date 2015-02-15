/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ware;

/**
 *
 * @author KOALA
 */
public class Ware {
    private int warenNummer;
    private String warenName;
    private Preis preis;

    public Ware(int dieWarenNummer, String derWarenName, Preis derPreis)
    {
        boolean inputOk = (0 <= dieWarenNummer &&
                           dieWarenNummer <= Integer.MAX_VALUE) &&
                          (derWarenName != null) &&
                          (derPreis != null);
        if (inputOk)
        {
            warenNummer = dieWarenNummer;
            warenName = derWarenName;
            preis = derPreis;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public Ware(int dieWarenNummer, String derWarenName, double derPreis)
    {
        this(dieWarenNummer, derWarenName, new Preis(derPreis));
    }

    public Ware(Ware eineWare)
    {
        if (eineWare != null)
        {
            warenNummer = eineWare.warenNummer;
            warenName = eineWare.warenName;
            preis = new Preis(eineWare.lieferePreis());
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public int liefereNummer()
    {
        return warenNummer;
    }

    public String liefereNamen()
    {
        return warenName;
    }

    public double lieferePreis()
    {
        return preis.liefereBruttoPreis();
    }

    public double liefereNettoPreis()
    {
        return preis.liefereNettoPreis();
    }

    public double liefereMehrwertSteuerAnteil()
    {
        return preis.liefereMehrwertSteuerAnteil();
    }

    public void aenderePreis(double derNeuePreis)
    {
        if (derNeuePreis >= 0.0)
        {
            preis = new Preis(derNeuePreis);
        }
    }

    public String liefereWarenInfo(int feldbreite)
    {
        String info = String.format("%-10s%2s%" + feldbreite + "s\n",
                                    "Name", ":", warenName);
        info += String.format("%-10s%2s%" + feldbreite + "d\n",
                              "Nummer", ":", warenNummer);
        info += String.format("%-10s%2s%" + feldbreite + ".2f\n",
                              "Preis", ":", lieferePreis());
        return info;
    }

    public int liefereAttributTextLaenge()
    {
        int laenge = Math.max(("" + warenNummer).length(),
                              warenName.length());
        return Math.max(laenge, ("" + lieferePreis()).length());
    }
}
