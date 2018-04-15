package game;
import java.io.*;

public class Game {

    /**
     * Saját magáról példány <<Singleton>>
     */
    private static Game game = new Game();
    /**
     * Raktárról tárolt referencia
     */
    private Warehouse running;

    /**
     * A magából készült példány elérése.
     * @return A saját magából létrehozott példány.
     */
    public static Game getInstance(){
        return game;
    }

    /**
     * Játék kezdését biztosító folyamat, még nem megvalósított
     */
    public void StartGame(String file){
        String line = null;
        running = new Warehouse();
        try {
            // FileReader reads text files in the default encoding.

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

            int row = Integer.parseInt(bufferedReader.readLine());
            int column = Integer.parseInt(bufferedReader.readLine());

            int curRow = 0, curcolumn = 0;
            //Üres sor átlépése
            line = bufferedReader.readLine();
            line = bufferedReader.readLine();
            while(curRow!=row) {
                String[] sorok = line.split(",");
                for(int i = 0;i<sorok.length;i++)
                {
                    switch(sorok[i])
                    {
                        case "a":
                            break;

                    }
                    //running.setField(curRow,i,field);
                }
                curRow++;
                System.out.println(line);
                line = bufferedReader.readLine();
            }

            // Always close files.
            bufferedReader.close();
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + file + "'");
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + file + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }
        running.StartingProcess();
     }

     /**
     * Jelenlegi raktár referencia beállítása
     * @param r Raktár
     */
    public void setRunning(Warehouse r){running = r; }

    /**
     * Játék befejezését biztosító folyamat
     */
    public void EndGame(){


    }
}
