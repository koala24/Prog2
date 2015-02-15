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
public abstract class LieblingsTier extends Tier {
    private String name;

    public LieblingsTier(String dieArt, String derName)
    {
        super(dieArt);
        name = derName;
    }

    public String liefereInfo()
    {
        return super.liefereInfo() + "Ich heisse " + name + ". ";
    }
}
