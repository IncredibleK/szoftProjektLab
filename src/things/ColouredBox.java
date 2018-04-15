package things;

import display.Colours;
import game.Skeleton;

public class ColouredBox extends Box{

    Colours colour;

    /**
     * Ha Hole-ra lép, ez meghívódik és megsemmisül a ColouredBox,
     * meghívja a Warehouse  CBDecrease() metódusát.
     */
    public void Die(){
        warehouse.CBDecrease();
        field.Remove(this);
    }
    public void SetColour(Colours c){ colour = c;}
}