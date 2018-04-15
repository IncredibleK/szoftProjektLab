package game;
import fields.Field;
import things.Thing;
import java.util.ArrayList;
import java.util.List;

/**
 * Raktárt viselkedését leíró osztály
 */
public class Warehouse {
    /**
     * Színes dobozok száma
     */
    private int colouredBoxCount;
    /**
     * Játékosok száma
     */
    private int playerCount;

    private Field [][] fields;
    private List<Thing> things;
    /**
     * Kezdési folyamat
     */
    public void StartingProcess(){


    }

    public void setPlayerCount(int szam){
        playerCount = szam;
    }
    public void setColouredBoxCount(int szam){
        colouredBoxCount = szam;
    }



    /**
     * Színes dobozok számát csökkentő függvény, véget vet a játéknak, ha egy feltétel teljesül
     */
    public void CBDecrease() {
        colouredBoxCount--;
        if (true) {
             // Játék referencia lekérdezése
            Game game = Game.getInstance();
             // Véget ér a játék, meghívjuk a singleton Game osztálynak a függvényét
            game.EndGame();
        }
    }
    /**
     *  Játékosok számát csökkentő függvény, véget vet a játéknak, ha egy feltétel teljesül
     */
    public void PDecrease(){
        playerCount--;
        if(true) {
             // Játék referencia lekérdezése
            Game game = Game.getInstance();
             // Véget ér a játék, meghívjuk a singleton Game osztálynak a függvényét
            game.EndGame();
        }
    }
}
