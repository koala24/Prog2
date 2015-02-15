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
public abstract class Tier {
    private String art;

    public Tier(String dieArt)
    {
        art = dieArt;
    }

    public abstract void sprich();

    public String liefereInfo()
    {
        return art + ". ";
    }
}
