package game;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Prototype {

    private Map<Object, String> fields;
    private Map<Object, String> things;
    private Warehouse ware;
    private static Prototype prototype = new Prototype();


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
        }catch(IOException e){
            System.out.println(e.getStackTrace());
        }
    }

    private void movePlayer(String playername, String direction) {

    }

    private void createEffect(String playername, String effect) {

    }

    private void checkDifference(String filePath1, String filePath2) {

    }

    private void loadMap(String filePath) {

    }

    private void exit() {
        Clear();
    }

}

