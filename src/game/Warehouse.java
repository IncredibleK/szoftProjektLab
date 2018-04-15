package game;
import enums.Direction;
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

    /**
     * Kezdési folyamat
     */
    public void StartingProcess(){
        SetNeighbours();
    }

    public int getRow()
    {
        return fields.length;
    }
    public int getColumn()
    {
        return fields[0].length;
    }
    public void setAllFields(int row, int column)
    {
        fields = new Field[row][column];
    }
    public void setField(int row, int column, Field field)
    {
        fields[row][column] = field;
    }
    public Field getField(int row, int column)
    {
        return fields[row][column];
    }
    public Thing getThing(int row, int column)
    {
        return fields[row][column].getThing();
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

    /**
     * Beállítja az összes szomszédját a mezőknek
     */
    public void SetNeighbours() {
        //Iteráció sorokra
        for (int curRow = 0; curRow < fields.length; curRow++)
        {
            //Iteráció oszlopokra
            for(int curColumn = 0; curColumn < fields[0].length; curColumn++)
            {
                // Bal oldali szomszéd beállítása
                if(curColumn-1 >= 0)
                    fields[curRow][curColumn].SetNeighbour(
                            Direction.Left,fields[curColumn-1][curRow]);

                // Jobb oldali szomszéd beállítása
                if(curColumn+1 < fields[0].length)
                    fields[curRow][curColumn].SetNeighbour(
                            Direction.Right,fields[curColumn+1][curRow]);

                // Felső szomszéd beállítása
                if(curRow-1 >= 0)
                    fields[curRow][curColumn].SetNeighbour(
                            Direction.Up,fields[curColumn][curRow-1]);

                // Alsó szomszéd beállítása
                if(curRow+1 < fields.length)
                    fields[curRow][curColumn].SetNeighbour(
                            Direction.Down,fields[curColumn][curRow+1]);
            }
        }
    }

}
