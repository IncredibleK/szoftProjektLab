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
     *
     */
    private Prototype() {
        fields = new HashMap<Object, String>();
        things = new HashMap<Object, String>();
    }

    public static Prototype getInstance() {
        return prototype;
    }


    public void AddWarehouse(Warehouse a) {
        ware = a;
    }

    public void AddField(Object a, String b){
        fields.put(a,b);
    }

    public void AddThing(Object a, String b){
        things.put(a,b);
    }

    public void AddPlayer(String b, Object a){
        players.put(b,a);
    }


    private String GetThingName(Object a) {
        return things.get(a);
    }

    private String GetFieldName(Object a) {
        return fields.get(a);
    }


    private void Clear() {
        things.clear();
        fields.clear();
        ware = null;
    }

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

    private void movePlayer(String playername, String direction) {
        Player a =(Player)players.get(playername);
        a.StartMove(Direction.valueOf(direction));
    }

    private void createEffect(String playername, String effect) {
        Player a =(Player)players.get(playername);
        if(effect.equals("O")){
            a.PlaceOil();
        }
        else if(effect.equals("H")){
            a.PlaceHoney();
        }
    }

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

    private void loadMap(String filePath) {
        Game a = Game.getInstance();
        a.StartGame(filePath);
    }

    private void exit() {
        Clear();
    }

}

