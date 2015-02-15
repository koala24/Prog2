/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package produzierteware;

/**
 *
 * @author KOALA
 */
public class ProduzierteWare extends Ware {
    private String herstellerName;

    public ProduzierteWare(Ware dieWare, String derHersteller)
    {
        super(dieWare);
        if (derHersteller != null)
        {
            herstellerName = derHersteller;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public ProduzierteWare(int dieWarenNummer, String derWarenName,
                           double derPreis, String derHersteller)
    {
        super(dieWarenNummer, derWarenName, derPreis);
        if (derHersteller != null)
        {
            herstellerName = derHersteller;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public String liefereHersteller()
    {
        return herstellerName;
    }

    public String liefereWarenInfo(int feldbreite)
    {
        return super.liefereWarenInfo(feldbreite) +
               String.format("%-10s%2s%" + feldbreite + "s\n",
                             "Hersteller", ":", herstellerName);
    }

    public int liefereAttributTextLaenge()
    {
        return Math.max(super.liefereAttributTextLaenge(),
                        herstellerName.length());
    }
}
