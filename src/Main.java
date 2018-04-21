import enums.*;
import display.*;
import game.*;



public class Main {

    public static void main(String[] args) {
        Warehouse w = new Warehouse();
        Game.getInstance().setRunning(w);
        Prototype.getInstance().AddWarehouse(w);
        Prototype.getInstance().Start();
    }
}
