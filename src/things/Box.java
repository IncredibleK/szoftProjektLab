package things;

import enums.Direction;
import fields.*;

public class Box extends Thing {

    /**
     * Egy, a doboz által elfoglalt mezőre érkezni kívánó játékos(Player) vagy doboz(Box) hívja meg.
     * További mozgást kezdeményez a megadott irányban. Ha a mozgások során színes láda kerül neki
     * megfelelő helyre, visszaadja / továbbítja a megszerzett pontszámot a hívó felé.

     * @param d A mozgás iránya
     * @param t Az érkező Thing
     * @return
     */
    public int Collide(Direction d, Thing t, double s){
        int tmp = field.TryMove(d,s);
        return tmp;
    }

    /**
     * Hole-ra érkezve meghívódik ez a metódust
     */
    public void Die(){
        field.Remove(this);
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
    public int AcceptMove(Wall w){return 0;}



}
