package fields;

import enums.Direction;
import game.Prototype;
import things.Thing;
import java.util.HashMap;
import java.util.Map;
import things.*;

public class Field extends Steppable {

    private Map<Direction, Field> neighbours;
    protected Thing thing;
    protected double effect;

    /**
     * Konstruktor: neighbours map inicializálása, effect beállítása
     */
    public Field(){
        //Kell konstruktorba? Skeleton.getInstance.Return(this);
        neighbours = new HashMap<Direction, Field>();
        effect = 1;
        thing = null;
    }

    /**
     * Az adott irányba beállítja a szomszédos mezőt.
     * @param d irány
     * @param f szomszédnak szánt Field
     */
    public void SetNeighbour(Direction d, Field f){
        //Kell setterbe? Skeleton.getInstance.Return(this);
        neighbours.put(d, f);
    }

    /**
     * Visszaadja abban az irányban lévő szomszédos mezőt
     * @param d Szomszéd iránya
     * @return
     */
    public Field GetNeighbour(Direction d){
        return neighbours.get(d);
    }

    /**
     * Visszaadja a jelenleg eltárolt, rajta lévő tárgy referenciáját
     * @return
     */
    public Thing getThing()
    {
        return thing;
    }

    /**
     * Egy tárgyat hozzácsatol az aktuális mezőhöz.
     * @param t A csatolandó tárgy
     * @return 0
     */
    /*
    public int Add(Thing t){
        this.thing = t;
        t.SetField(this);
        int tmp = Interact(t); /////////////////////////
        return tmp;
    }*/
    public int Add(Player t){
        this.thing = t;
        t.SetField(this);
        int tmp = Interact(t); /////////////////////////
        return tmp;
    }
    public int Add(Box t){
        this.thing = t;
        t.SetField(this);
        int tmp = Interact(t); /////////////////////////
        return tmp;
    }

    /**
     * Az éppen rajta álló tárgyat eltávolítja a mezőről
     */
    public void Remove(Thing t){
        this.thing = null;

    }

    /**
     * Virtuális függvény, itt nem csinál semmit
     * @param p
     * @return
     */
    public int Interact(Player p){
        System.out.println("player");
        return 0;
    }
    public int Interact(Box b){
        System.out.println("Box");
        return 0;}
    public int Interact(Thing t){
        System.out.println("Thing");
        return 0;}

    /**
     * A mezőn álló játékos ezzel jelzi helyváltoztatási szándékát.
     * @param d A mozgás iránya
     * @param s A játékos maradék ereje
     * @return
     */
    public int TryMove(Direction d, double s){
        //return neighbours.get(d).TryMove(d, this.thing);
        int tmp = neighbours.get(d).TryMove(d, this.thing, effect);
        return tmp;
    }

    /**
     * A szomszédos mező a felőle érkező mozgás igényt ennek meghívásával jelzi.
     * @param d A mozgás iránya
     * @param t Az érkezni kívánó Thing
     * @param s A játékos maradék ereje
     * @return
     */
    public int TryMove(Direction d, Thing t, double s){
        int tmp =0;
        if(s < effect) {
            return 0;
        }
        s-=effect;
        if (this.thing==null){
            tmp = t.AcceptMove(this);
        } else{
            tmp = t.MakeCollision(d, this.thing, s);
            if(this.thing == null)
                tmp = t.AcceptMove(this);
        }
        return tmp;
    }

    public void SetThing(Thing t){ thing = t;}

    public void SetThing(Player t){
        thing = t;
    }
    public void SetThing(Box t){ thing = t;}


    /**
     * Beállítja a mezőn adott effektet
     * @param effect  Effekt
     */
    public void setEffect(double effect) {
        this.effect = effect;
    }

}
