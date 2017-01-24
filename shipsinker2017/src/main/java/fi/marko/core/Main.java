package fi.marko.core;

import fi.marko.gui.GUI;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Beast
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GUI gui = new GUI();
        GameField gameField = new GameField(gui);
        
        
        gui.setVisible(true);
    }

}
