package things;

import display.Colours;
import fields.*;

public class ColouredBox extends Box{

    private Colours colour;

    /**
     * Ha Hole-ra lép, ez meghívódik és megsemmisül a ColouredBox,
     * meghívja a Warehouse  CBDecrease() metódusát.
     */
    public void Die(){
        warehouse.CBDecrease();
        field.Remove(this);
    }

    public int AcceptMove(Field f){
        System.out.println(this+" "+field+" "+f+"\n");
        field.Remove(this);
        int tmp = f.Add((ColouredBox)this);
        return tmp;
    }
    public void SetColour(Colours c){ colour = c;}

}