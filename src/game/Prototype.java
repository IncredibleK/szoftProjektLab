package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Prototype {
    /**
     * A tarolo tárolja a dolgok referenciáját és a nevűket értékként.
     */
    private Map<Object ,String> tarolo;
    /**
     * Saját magáról példány <<Singleton>>
     */
    private static Prototype prototype = new Prototype();

    /**
     * Konstruktor, HashMap inicializálása.
     */
    private Prototype(){
        tarolo = new HashMap<Object, String>();
    }

    /**
     * A magából készült példány elérése.
     * @return A saját magából létrehozott példány.
     */
    public static Prototype getInstance(){
        return prototype;
    }

    /**
     * tarolo feltöltése egy elemmel.
     * @param a dolog referenciája
     * @param b név
     */
    public void Add(Object a, String b){
        tarolo.put(a,b);
    }

    /**
     * tarolóban tárolt dolog nevét visszaadja
     * @param a dolog referenciája
     * @return
     */
    public String GetName(Object a){ return tarolo.get(a); }

    /**
     * tarolo teljes kiürítése
     */
    public void Clear(){
        tarolo.clear();
    }
}
