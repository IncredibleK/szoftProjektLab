package game;

import enums.Direction;
import things.Player;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Prototype {
    /**
     * Field referencia, azonosító párokat tartalmaz.
     */
    private Map<Object, String> fields;
    /**
     * Thing referencia, azonosító párokat tartalmaz.
     */
    private Map<Object, String> things;
    /**
     * Player azonosító, referencia párokat tartalmaz.
     */
    private Map<String, Object > players;
    /**
     * aktuális warehouseról egy példány.
     */
    private Warehouse ware;
    /**
     * Önmagából egy példány.
     */
    private static Prototype prototype = new Prototype();

    /**
     *Konstruktor
     */
    private Prototype() {
        fields = new HashMap<Object, String>();
        things = new HashMap<Object, String>();
    }

    /**
     * @return Önmagából létrehozott példányát visszaadja
     */
    public static Prototype getInstance() {
        return prototype;
    }

    /**
     * Beállítja az aktuális warehoust
     * @param a akt. Warehouse
     */
    public void AddWarehouse(Warehouse a) {
        ware = a;
    }

    /**
     * Field hozzáadása fields listához.
     * @param a Field
     * @param b Azonosító
     */
    public void AddField(Object a, String b){
        fields.put(a,b);
    }

    /**
     * Thing hozzáadása fields listához.
     * @param a Thing
     * @param b Azonosító
     */
    public void AddThing(Object a, String b){
        things.put(a,b);
    }

    /**
     * Field azonosítójának módosítása.
     * @param a Field
     * @param b Azonosító
     */
    public void ModifyField(Object a, String b){
        fields.remove(a);
        things.put(a,b);
    }

    /**
     * Thing azonosítójának módosítása.
     * @param a Thing
     * @param b Azonosító
     */
    public void ModifyThing(Object a, String b){
        fields.remove(a);
        things.put(a,b);
    }

    /**
     * Játékos hozzáadása a listához.
     * @param b Azonosító
     * @param a Player
     */
    public void AddPlayer(String b, Object a){
        players.put(b,a);
    }

    /**
     * Thing azonosítót visszaadja.
     * @param a Thing referencia.
     * @return Thing azonosító
     */
    private String GetThingName(Object a) {
        return things.get(a);
    }

    /**
     * Field azonosítót visszaadja.
     * @param a Field referencia.
     * @return Field azonosító
     */
    private String GetFieldName(Object a) {
        return fields.get(a);
    }


    /**
     * Minden tárolt dolog ürítése.
     */
    private void Clear() {
        things.clear();
        fields.clear();
        ware = null;
    }

    /**
     * A tesztelő Prototype osztállyal való kommunikációjának lebonyolítása.
     */
    public void Start() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String s = br.readLine();
                String[] st = s.split(" ");
                switch (st[0]) {
                    case "loadInput":
                        loadInput(st[1]);
                        break;
                    case "saveOutput":
                        saveOutput(st[1]);
                        break;
                    case "movePlayer":
                        movePlayer(st[1], st[2]);
                        break;
                    case "createEffect":
                        createEffect(st[1], st[2]);
                        break;
                    case "checkDifference":
                        checkDifference(st[1], st[2]);
                        break;
                    case "loadMap":
                        loadMap(st[1]);
                        break;
                    case "exit":
                        exit();
                        break;
                    default:
                        break;
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Input betöltése
     * @param filePath Input file
     */
    private void loadInput(String filePath) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String s;
            while(!((s=br.readLine()).equals("exit"))){
                String[] st = s.split(" ");
                switch (st[0]) {
                    case "saveOutput":
                        saveOutput(st[1]);
                        break;
                    case "movePlayer":
                        movePlayer(st[1], st[2]);
                        break;
                    case "createEffect":
                        createEffect(st[1], st[2]);
                        break;
                    case "checkDifference":
                        checkDifference(st[1], st[2]);
                        break;
                    case "loadMap":
                        loadMap(st[1]);
                        break;
                    default:
                        break;
                }
            }
            exit();
        }catch(IOException e){
            System.out.println(e.getStackTrace());
        }


    }

    /**
     * Output file kimentése
     * @param filePath Output file
     */
    private void saveOutput(String filePath) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            for(int j=0;j<ware.getRow();j++){
                for(int i=0;i<ware.getColumn();i++){
                    bw.write(fields.get(ware.getField(j,i)));
                    if(i!=ware.getColumn()-1)bw.write(",");
                }
                bw.write("\n");
            }
            bw.write("\n");
            for(int j=0;j<ware.getRow();j++){
                for(int i=0;i<ware.getColumn();i++){
                    bw.write(fields.get(ware.getThing(j,i)));
                    if(i!=ware.getColumn()-1)bw.write(",");
                }
                bw.write("\n");
            }
            bw.close();

        }catch(IOException e){
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * Adott player mozog a megfelelő irányba
     * @param playername Player azonosító
     * @param direction irány
     */
    private void movePlayer(String playername, String direction) {
        Player a =(Player)players.get(playername);
        a.StartMove(Direction.valueOf(direction));
    }

    /**
     * Adott Player effectet rak maga alá.
     * @param playername Player azonosító
     * @param effect Effect azonosító
     */
    private void createEffect(String playername, String effect) {
        Player a =(Player)players.get(playername);
        if(effect.equals("O")){
            a.PlaceOil();
        }
        else if(effect.equals("H")){
            a.PlaceHoney();
        }
    }

    /**
     * Különbség detektálása
     * @param filePath1 egyik fájl
     * @param filePath2 másik fájl
     */
    private void checkDifference(String filePath1, String filePath2) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath1));
            BufferedReader br1 = new BufferedReader(new FileReader(filePath1));
            String s1,s2;
            boolean b=true;
            while((s1=br.readLine())!=null && (s2=br1.readLine())!=null){
             if(!(s1.equals(s2))){
                 b=false;
                 System.out.println("Hiba:");
                 System.out.println(s1);
                 System.out.println("");
                 System.out.println(s2);
             }

            }
            if(b)System.out.println("100%-os egyezes");
            br.close();
            br1.close();
        }catch(IOException e){
            System.out.println(e.getStackTrace());
        }

    }

    /**
     *Pálya betöltése
     * @param filePath Pálya fájl
     */
    private void loadMap(String filePath) {
        Game a = Game.getInstance();
        a.StartGame(filePath);
    }

    /**
     * Kilépés a tesztesetből.
     */
    private void exit() {
        Clear();
    }

}

