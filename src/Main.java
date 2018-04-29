import enums.*;
import display.*;
import fields.Field;
import fields.Wall;
import game.*;
import things.Player;


public class Main {

    public static void main(String[] args) {
        Field f1 = new Field();
        Wall f2 = new Wall();
        f1.SetNeighbour(Direction.Right, f2);
        Player p = new Player();
        f1.Add(p);

        p.StartMove(Direction.Right);
        /*
        Warehouse w = new Warehouse();
        Prototype.getInstance().Start();
        */

    }
}
