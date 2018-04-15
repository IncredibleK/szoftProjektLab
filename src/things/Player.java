package things;

import enums.Direction;
import fields.Field;
import fields.Wall;

public class Player extends Thing {

    /** A játékos ponjai */
    private int points;

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
     * @return
     */
    public int Collide (Direction d, Player p){
        return 0;
    }

    /**
     * Ütközeti a Player-t és a Box-ot. Box tolja a Playert.
     * @param d A mozgás iránya
     * @param b Az érkező Box
     * @return
     */
    public int Collide (Direction d, Box b){
        //tmp: <return field.TryPlyer(d);> szét kellett választani h jó sorrendben fusson a call és return
        int tmp = field.TryMove(d);
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
        }else{
            tmp.TryMove(d, this);
        }
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

}
