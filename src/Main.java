import enums.*;
import display.*;
import fields.Field;
import fields.Wall;
import fields.Hole;
import game.*;
import things.Player;
import things.Box;



public class Main {

    public static void main(String[] args) {
        Field f1 = new Field();
        Wall f2 = new Wall();
        f1.SetNeighbour(Direction.Right, f2);
        Player p = new Player();
        f1.Add(p);
        p.StartMove(Direction.Right);

        System.out.println("\n");

        Field f3 = new Field();
        Hole h1= new Hole();
        f3.SetNeighbour(Direction.Right, h1);
        Player p2 = new Player();
        f3.Add(p2);
        p2.StartMove(Direction.Right);


        //Warehouse w = new Warehouse();
       // Prototype.getInstance().Start();


    }
}
