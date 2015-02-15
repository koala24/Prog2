/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haltbarkeitsinfo;

/**
 *
 * @author KOALA
 */
public class HaltbarkeitsInfo implements Cloneable {
    private int losNummer;
    private MeinDatum verfallsDatum;

    public HaltbarkeitsInfo(int dieLosNummer, MeinDatum dasVerfallsDatum)
    {
        losNummer = dieLosNummer;
        verfallsDatum = dasVerfallsDatum;
    }

    public void setzeTag(int tag)
    {
        verfallsDatum.setzeTag(tag);
    }

    public void setzeMonat(int monat)
    {
        verfallsDatum.setzeMonat(monat);
    }

    public String toString()
    {
        return "Los Nummer " + losNummer +
               ":  haltbar bis  --->  "  +
               verfallsDatum;
    }

    public Object clone()
    {
        try
        {
            HaltbarkeitsInfo info = (HaltbarkeitsInfo) super.clone();
            info.verfallsDatum = (MeinDatum) verfallsDatum.clone();
            return info;
        }
        catch (CloneNotSupportedException cnse)
        {
            return null;
        }
    } 
}
