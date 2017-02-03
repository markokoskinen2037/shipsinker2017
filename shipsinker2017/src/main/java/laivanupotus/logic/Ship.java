/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logic;

import java.util.ArrayList;

/**
 *
 * @author Marko
 */
public class Ship {

    private final ArrayList<String> cordinates;
    private int size, originalLength;
    private boolean destroyed = false;

    public Ship(ArrayList<String> list, int size) {

        this.originalLength = list.size();
        this.size = size;
        this.cordinates = list;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void printShipDetails() {
        System.out.println("Shipsize: " + cordinates.size());
        for (String cordinate : cordinates) {
            System.out.print(cordinate + " | ");
        }
    }

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
