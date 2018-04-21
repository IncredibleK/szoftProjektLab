package fields;

import display.Colours;
import things.ColouredBox;

public class ColouredField extends Field {

    /** A színe */
    private Colours colour;

    /** A hozzá tartozó doboz */
    private ColouredBox box;

    public void SetBox(ColouredBox cb){ box=cb; }
    private void SetColour(Colours c){ this.colour = c; }

    public ColouredField()
    {
        colour = new Colours();
    }

    /**
     * Beállítja a saját és a hozzá tartozó színes doboz színét.
     */
    public void InitColour(){
        // Skeleton.getInstance.Call(this, box,"SetColour");
        box.SetColour(colour);
    }

    /**
     * Ha színes láda kerül rá, ellenőrzi, hogy a hozzá tartozó áll e rajta,
     * ha igen, pontot ad és kitörli.
     * @param cb Rajta álló színes láda
     * @return pont
     */
    public int Interact(ColouredBox cb){
        int tmp=0;
        if (thing==box){
            tmp=1;

            thing.Die();
        }

        return tmp;
    }
}
