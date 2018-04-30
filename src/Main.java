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
        Field f2 = new Wall();
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

        System.out.println("\n");

        Field f11 = new Field();
        Field f12 = new Wall();
        f1.SetNeighbour(Direction.Right, f2);
        Player p11 = new Player();
        Player p12 = new Player();
        f1.Add(p11); //Interactot hív
        f2.Add(p12);
        p11.StartMove(Direction.Right);

        System.out.println("\n"); //Falra playert tol???


        //Warehouse w = new Warehouse();
       // Prototype.getInstance().Start();


    }
}
