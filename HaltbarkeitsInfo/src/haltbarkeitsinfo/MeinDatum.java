/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package haltbarkeitsinfo;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author KOALA
 */
public class MeinDatum implements Cloneable {
    private int tag;
    private int monat;
    private int jahr;

    public MeinDatum()
    {
        GregorianCalendar kalender = new GregorianCalendar();
        tag = kalender.get(Calendar.DAY_OF_MONTH);
        monat = kalender.get(Calendar.MONTH);
        jahr = kalender.get(Calendar.YEAR);
    }

    public MeinDatum(int derTag, int derMonat, int dasJahr)
    {
        tag = derTag;
        monat = derMonat;
        jahr = dasJahr;
    }

    public void setzeTag(int derTag)
    {
        tag = derTag;
    }

    public void setzeMonat(int derMonat)
    {
        monat = derMonat;
    }

    public void setzeJahr(int dasJahr)
    {
        jahr = dasJahr;
    }

    public String toString()
    {
        return tag + ". " + monat + ". " + jahr;
    }

    public int hashCode()
    {
        return (new Long(tag + 1000 * monat + 100000 * jahr)).hashCode();
    }

    public boolean equals(Object einObjekt)
    {
        if (this == einObjekt)    // Objekte identisch?
        {
            return true;
        }
        else
        {
            if (einObjekt == null)    // Input kein Objekt?
            {
                return false;
            }
            else
            {
                if (getClass() != einObjekt.getClass())
                {
                    return false;
                }
                else
                {
                    MeinDatum datum = (MeinDatum) einObjekt;    // Input korrekt!
                    return (tag == datum.tag) &&
                           (monat == datum.monat) &&
                           (jahr == datum.jahr);
                }
            }
        }
    }

    public Object clone()
    {
        try
        {
            return super.clone();
        }
        catch (CloneNotSupportedException cnse)
        {
            return null;
        }
    }
}
