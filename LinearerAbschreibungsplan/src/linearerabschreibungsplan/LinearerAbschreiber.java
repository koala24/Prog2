/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearerabschreibungsplan;

/**
 *
 * @author KOALA
 */
public class LinearerAbschreiber {
    private double startWert;
    private double endWert;
    private int anzahlJahre;

    public LinearerAbschreiber(double derStartWert,
                               double derEndWert,
                               int dieAnzahlJahre)
    {
        boolean inputOk = (1 <= derStartWert) && (0 <= derEndWert) &&
                          (derEndWert <= derStartWert) &&
                          (1 <= dieAnzahlJahre);
        if (inputOk)
        {
            startWert = derStartWert;
            endWert = derEndWert;
            anzahlJahre = dieAnzahlJahre;
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }

    public double[] lieferePlanDaten()
    {
        double abschreibung = liefereAbschreibung();
        double[] planDaten = new double[anzahlJahre];
        for (int i = 0; i < planDaten.length; i++)
        {
            planDaten[i] = (i == 0) ? startWert : planDaten[i - 1] - abschreibung;
        }
        return planDaten;
    }

    public double liefereAbschreibung()
    {
        return (startWert - endWert) / anzahlJahre;
    }
}
