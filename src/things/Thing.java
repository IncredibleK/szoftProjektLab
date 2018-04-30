package things;

import enums.Direction;
import fields.Field;
import fields.Steppable;
import fields.Wall;
import fields.Hole;
import fields.Switch;
import game.Warehouse;

public abstract class Thing {

    Warehouse warehouse;
    Steppable field;

    public void setWarehouse(Warehouse w){
        warehouse = w;
    }

    /**
     * Ha a helyet változtató Thing új Field-jén áll egy Thing, ez hívja meg,
     * hogy értesítse
     * @param d A mozgás iránya
     * @param t A használni kívánt mezőt elfogaló Thing
     * @return
     */
    public int MakeCollision (Direction d, Thing t, double s){
        int tmp = t.Collide(d, this, s);
        return tmp;
    }

    /**
     * A leszármazottak felüldefiniálják. Az érkező Thing hívja.
     * @param d A mozgás iránya
     * @param t Az érkező Thing
     * @return 0
     */
    public abstract int Collide (Direction d, Thing t, double s);

    /**
     * Végrehajtja a léptetést. A használni kívánt szabad mező hívja
     * @param f az új mező
     * @return
     */
    public abstract int AcceptMove(Field f);
    public abstract int AcceptMove(Hole f);
    public abstract int AcceptMove(Switch f);
    /*{
        int tmp = 0;
        if(!(f instanceof Wall)) {
            field.Remove(this);
            tmp = f.Add(this);
        }
        return tmp;
    }*/



    /**
     * Nem csinál semmit
     * @param w A kapott fal, amire lépnie kéne.
     * @return 0
     */
    public abstract int AcceptMove(Wall w);


    /**
     * A leszármazottak felüldefiniálják
     */
    public abstract void Die();

    /**
     * Beállítja amelyik Field-en áll
     * @param f
     */
    public void SetField(Steppable f)
    {
        field = f;
    }
}
