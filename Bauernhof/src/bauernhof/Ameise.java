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
public class Ameise extends Tier {
    public Ameise()
    {
        super("Amweise");
    }

    public void sprich()
    {
    }

    public String liefereInfo()
    {
        return "Ich bin eine " + super.liefereInfo();
    }
}
