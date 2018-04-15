package game;

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

    /**
     * Kezdési folyamat
     */
    public void StartingProcess(){}

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
