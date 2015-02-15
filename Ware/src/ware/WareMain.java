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
public class WareMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ware[] warenkorb = { new Ware(781503, "LCD-Fernseher", 1789.23),
                             new Ware(100212, "Ananas", 2.99) };
        schreibe(warenkorb);
    }
    
    private static void schreibe(Ware[] warenkorb)
    {
        int feldbreite = ermitteleFeldbreite(warenkorb) + 2;
        for (Ware ware : warenkorb)
        {
            System.out.println(ware.liefereWarenInfo(feldbreite));
        }
    }

    private static int ermitteleFeldbreite(Ware[] warenkorb)
    {
        int feldbreite = warenkorb[0].liefereAttributTextLaenge();
        for (Ware ware : warenkorb)
        {
            if (ware.liefereAttributTextLaenge() > feldbreite)
            {
                feldbreite = ware.liefereAttributTextLaenge();
            }
        }
        return feldbreite;
    }
}
