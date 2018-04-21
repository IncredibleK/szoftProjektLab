package things;

import enums.Direction;
import fields.Field;
import fields.Wall;
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
     *  Ütközteti a Player-t és a kapott Player-t,
     *  nem léphet tovább a cselekvést indító Player.
     * @param d A mozgás iránya
     * @param p Az érkező Player
     * @param s A játékos ereje
     * @return
     */

  /*  public int Collide (Direction d, Player p, double s){
        System.out.println("Player collide2 override");return 0;
    }

    /**
     * Ütközeti a Player-t és a Box-ot. Box tolja a Playert.
     * @param d A mozgás iránya
     * @param b Az érkező Box
     * @param s A játékos ereje
     * @return

    public int Collide (Direction d, Box b, double s){
        //tmp: <return field.TryPlyer(d);> szét kellett választani h jó sorrendben fusson a call és return
        System.out.println("Player collide override");
        int tmp = field.TryMove(d, strength);
        return tmp;
    }
*/
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
        {        //tmp: <return field.TryPlyer(d);> szét kellett választani h jó sorrendben fusson a call és return
           // System.out.println("Player collide override");
            tmp = field.TryMove(d, strength);
        }
        return tmp;
    }
    /**
     * Az egész mozgatást egy irányba elkezdi,
     * majd pontszámát növeli
     * @param d A mozgás iránya
     */
    public void StartMove(Direction d){
        Field tmp = field.GetNeighbour(d);
        if (tmp instanceof Wall){ //5.3.8
            //fal
        }
        else
            tmp.TryMove(d, this, strength);

    }

    public int AcceptMove (Field f){
        int tmp = 0;
        if(f instanceof Wall)
            Die();
        else
        {
            field.Remove(this);
            tmp = f.Add(this);
        }
        return tmp;
    }

    /**
     * Player-t falra toltak meghal
     * @param w A kapott fal ahova lépne
     * @return 0
     */
    public int AcceptMove (Wall w){
        Die();
        return 0;
    }

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
