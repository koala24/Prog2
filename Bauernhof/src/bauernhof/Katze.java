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
public class Katze extends LieblingsTier {
    private String rasse;

    public Katze(String derName, String dieRasse)
    {
        super("Katze", derName);
        rasse = dieRasse;
    }

    public void sprich()
    {
        System.out.print("Miau, Miau!");
    }

    public String liefereInfo()
    {
        return "Ich bin eine " + super.liefereInfo() +
               "Ich bin eine " + rasse + ". ";
    }
}
