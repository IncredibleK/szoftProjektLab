package fields;

import things.Thing;

public class Hole extends Field {

    /**
     * Ami rálép az meghívja, a Hole azt megsemmisíti.
     * @param t A rálépő Thing
     * @return 0
     */
    public int Interact(Thing t){
        System.out.println("megfog halni!\n");
        t.Die();
        return 0;
    }

}
