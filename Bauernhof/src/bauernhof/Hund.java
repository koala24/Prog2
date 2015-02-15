/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bauernhof;

/**
 *
 * @author KOALA
 */
public class Hund extends LieblingsTier {
    private String rasse;

    public Hund(String derName, String dieRasse)
    {
        super("Hund", derName);
        rasse = dieRasse;
    }

    public void sprich()
    {
        System.out.print("Wau, Wau!");
    }

    public String liefereInfo()
    {
        return "Ich bin ein " + super.liefereInfo() +
               "Ich bin ein " + rasse + ". ";
    } 
}
