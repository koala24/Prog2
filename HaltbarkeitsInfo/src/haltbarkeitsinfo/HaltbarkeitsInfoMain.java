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
public class HaltbarkeitsInfoMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HaltbarkeitsInfo[] testInfo = new HaltbarkeitsInfo[4];
        HaltbarkeitsInfo initialInfo = new HaltbarkeitsInfo(123456, new MeinDatum());

        for (int i = 0; i < testInfo.length; i++)
        {
            testInfo[i] = (HaltbarkeitsInfo) initialInfo.clone();
        }
        for (HaltbarkeitsInfo info : testInfo)
        {
            System.out.println(info);
        }
        testInfo[2].setzeTag(1);        // ändert eine der Kopien
        testInfo[2].setzeMonat(11);     // ändert eine der Kopien
        System.out.println("\nEine Kopie wird verändert:\n");
        for (HaltbarkeitsInfo info : testInfo)
        {
            System.out.println(info);
        }
    }
    
}
