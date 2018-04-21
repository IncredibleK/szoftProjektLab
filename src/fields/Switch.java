package fields;

import things.Box;
import things.*;
import game.Prototype;

public class Switch extends Field {

    private SpecialHole hole;

    public void SetHole( SpecialHole h){ hole = h;}

    /**
     * Ha egy doboz eltávolítódik a kapcsolóról, a hozzá tartozó lyuk becsukódik
     * @param t A róla távozó tárgy
     */
    public void Remove(Thing t){
        this.thing=null;
        hole.SetOpen(false);
    }

    /**
     * A kapcsolóra érkező doboz meghívja, kinyitja a hozzá tartozó lyukat
     * @param t Rálépő tárgy
     * @return
     */
    public int Interact(Thing t) {
        if(hole!=null && t instanceof Box) {
            hole.SetOpen(true);
        }
        return 0;
    }
}
