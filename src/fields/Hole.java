package fields;

import things.Thing;

public class Hole extends Field {

    /**
     * Ami rálép az meghívja, a Hole azt megsemmisíti.
     * @param t A rálépő Thing
     * @return 0
     */
    public int Interact(Thing t){

        t.Die();

        return 0;
    }

}
