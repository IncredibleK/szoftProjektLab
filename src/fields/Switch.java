package fields;

import things.Box;
import game.Prototype;

public class Switch extends Field {

    private SpecialHole hole;

    public void SetHole( SpecialHole h){ hole = h;}

    /**
     * Ha egy doboz eltávolítódik a kapcsolóról, a hozzá tartozó lyuk becsukódik
     * @param b A róla távozó doboz
     */
    public void Remove(Box b){
        this.thing=null;
        hole.SetOpen(false);
        Prototype.getInstance().ReplaceField(this,"Q");
    }

    /**
     * A kapcsolóra érkező doboz meghívja, kinyitja a hozzá tartozó lyukat
     * @param b
     * @return
     */
    public int Interact(Box b) {
        hole.SetOpen(true);
        System.out.println("bent");
        Prototype.getInstance().ReplaceField(this,"L");
        return 0;
    }

}
