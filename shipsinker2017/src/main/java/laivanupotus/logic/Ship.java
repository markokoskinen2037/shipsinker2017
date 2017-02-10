/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logic;

import java.util.ArrayList;

/**
 * @author Marko
 * Luokka tarjoaa laivojen käsittelyyn käytettäviä metodeja.
 */
public class Ship {

    private final ArrayList<String> cordinates;
    private int size, originalLength;
    private boolean destroyed = false;

    /**
     * Konstruktori luo uuden laiva olion.
     * @param list Laiva oliota luodessa annetaan parametrina lista joka sisältää kyseisen laivan koordinaatit
     * @param size Laiva oliota luodessa annetaan parametrina kokonaislukumuuttuja joka ilmaisee laivan alkuperäiskoon.
     */
    public Ship(ArrayList<String> list, int size) {

        this.originalLength = list.size();
        this.size = size;
        this.cordinates = list;
    }

    /**
     * Palauttaa false jos laiva on hengissä ja true jos laiva on tuhottu.
     * @return
     */
    public boolean isDestroyed() {
        return destroyed;
    }

    /**
     * Metodi tulostaa konsoliin kyseisen laivan koordinaatit ja laivan alkuperäiskoon.
     */
    public void printShipDetails() {
        System.out.println("Shipsize: " + cordinates.size());
        for (String cordinate : cordinates) {
            System.out.print(cordinate + " | ");
        }
    }

    /**
     * Metodi palauttaa merkkijonon joka sisältää laivan koordinaatit ja laivan koon.
     * @return
     */
    @Override
    public String toString() {
        String s = "";
        s += "Shipsize:" + cordinates.size() + " ";
        for (String cordinate : cordinates) {
            s += cordinate + " | ";
        }
        return s;
    }

    public ArrayList<String> getCordinates() {
        return cordinates;
    }

    /**
     * Tuhoaa laivasta yhden osan. Jos laivan koko on tuhoamisen jälkeen 0 palautetaan true. Muutoin palautetaan false.
     * 
     * @return
     */
    public boolean destroyPart() {
        this.size = this.size - 1;
        if (this.size == 0) {
            System.out.println("You just sank a ship size of " + this.originalLength);
            this.destroyed = true;
            return true;
        } else {
            return false;
        }
    }

    public int getSize() {
        return size;
    }

}
