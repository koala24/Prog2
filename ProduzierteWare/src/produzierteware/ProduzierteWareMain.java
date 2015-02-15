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
public class ProduzierteWareMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProduzierteWare[] warenkorb = 
            { new ProduzierteWare(238934, "Max Pro One", 2179.50, "Apple"),
              new ProduzierteWare(new Ware(781503, "LCD-Fernseher", 1789.23), "Panasonic") };
        schreibe(warenkorb);
    }
    
    private static void schreibe(ProduzierteWare[] warenkorb)
    {
        int feldbreite = ermitteleFeldbreite(warenkorb) + 2;
        for (Ware ware : warenkorb)
        {
            System.out.println(ware.liefereWarenInfo(feldbreite));
        }
    }

    private static int ermitteleFeldbreite(ProduzierteWare[] warenkorb)
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
