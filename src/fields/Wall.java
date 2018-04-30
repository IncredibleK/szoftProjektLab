package fields;

import things.Box;
import things.Player;
import things.Thing;

public class Wall extends Field {

    public void Remove(Thing t){ }

    public int Add(Player t){
        this.thing = t;
        t.SetField(this);
        int tmp = Interact(t);
        return tmp;
    }

    public int Add(Box t){ return 0;}


}
