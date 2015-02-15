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
public class Preis {
    public static final double MEHRWERT_STEUER_SATZ = 0.19;
    private double bruttoPreis;

    public Preis(double derBruttoPreis)
    {
        if (derBruttoPreis >= 0.0)
        {
            bruttoPreis = derBruttoPreis;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public double liefereBruttoPreis()
    {
        return bruttoPreis;
    }
    
    public double liefereNettoPreis()
    {
        return bruttoPreis - MEHRWERT_STEUER_SATZ * bruttoPreis;
    }

    public double liefereMehrwertSteuerAnteil()
    {
        return liefereBruttoPreis() - liefereNettoPreis();
    } 
}
