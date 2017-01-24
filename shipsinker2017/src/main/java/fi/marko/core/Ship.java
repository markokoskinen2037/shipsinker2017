/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.marko.core;

import java.util.ArrayList;

/**
 *
 * @author Beast
 */
public class Ship {
    private final ArrayList<String> cordinates;
    private int size;
    private boolean destroyed = false;

    public Ship(ArrayList<String> list, int size) {
        this.size = size;
        this.cordinates = list;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void printShipDetails(){
        System.out.println("Shipsize: " + cordinates.size());
        for (String cordinate : cordinates) {
            System.out.print(cordinate + " | ");
        }
    }
    
    public void destroyPart(){
        this.size = this.size -1;
        if(this.size == 0){
            System.out.println("You just sank a ship size of " + this.cordinates.size());
            this.destroyed = true;
        }
    }

    public int getSize() {
        return size;
    }

    
    
}
