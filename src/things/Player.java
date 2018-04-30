package things;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import enums.Direction;
import fields.*;
import game.Prototype;

public class Player extends Thing {

    /** A játékos ponjai */
    private int points;
    private double strength;

    public Player()
    {
        points = 0;
        strength = 3;
    }
    /**
     * A kapott értékkel növeli a Player pontszámának értékét.
     * @param points hozzá adandó pontok száma
     */
    public void AddPoints(int points){
        this.points += points;
    }

    /**
     *
    Ütközeti a Player-t és a Box-ot. Box tolja a Playert.
            * @param d A mozgás iránya
     * @param t Az érkező Box, vagy Player
     * @param s A játékos ereje
     * @return
     */
    public int Collide (Direction d, Thing t, double s){
        int tmp = 0;
        if(t instanceof Player)
            return 0;
        else
            tmp = field.TryMove(d, strength);
        return tmp;
    }
    /**
     * Az egész mozgatást egy irányba elkezdi,
     * majd pontszámát növeli
     * @param d A mozgás iránya
     */
    public void StartMove(Direction d){
        Field tmp = field.GetNeighbour(d);
        /*
        if (tmp instanceof Wall){ //5.3.8
            //fal
        }
        else
        */
            tmp.TryMove(d, this, strength);
    }







    public int AcceptMove(Field f){
        int tmp = 0;

        field.Remove(this);
        tmp = f.Add(this);

        return tmp;
    }

    public int AcceptMove(Hole f){
        int tmp = 0;

        field.Remove(this);
        tmp = f.Add(this);

        return tmp;
    }

    public int AcceptMove(Switch f){
        int tmp = 0;

        field.Remove(this);
        tmp = f.Add(this);

        return tmp;
    }



    /**
     * Nem csinál semmit
     * @param w A kapott fal, amire lépnie kéne.
     * @return 0
     */

    public int AcceptMove(Wall w){
        //System.out.println("player:accetmove W");
        //Die();
        return 0;
    }








    /**
     * Új Fieldre léptető függvény
     * @param f az új mező
     * @return
     */
   /* public int AcceptMove (Steppable f){
        int tmp = 0;
        if(f instanceof Wall)
            Die();
        else
        {
            field.Remove(this);
            tmp = f.Add(this);
        }
        return tmp;
    }*/

    /**
     * Player-t falra toltak meghal
     * @param w A kapott fal ahova lépne
     * @return 0
     */


    /**
     * Lyukba esés, esetleg amikor egy ládát rátolnak,
     * ebben az esetben ez a mezőről törli és
     * a játékosok számát csökkenti eggyel.
     */
    public void Die(){
        warehouse.PDecrease();
        field.Remove(this);
    }

    /**
     * Növeli a Field effect-jének az értékét.
     */
    public void PlaceHoney(){
        field.setEffect(1.5);
        Prototype.getInstance().ReplaceField(field,"H");
    }

    /**
     * Csökkenti a Field effect-jének az értékét.
     */
    public void PlaceOil(){
        field.setEffect(0.5);
        Prototype.getInstance().ReplaceField(field,"O");
    }
}
