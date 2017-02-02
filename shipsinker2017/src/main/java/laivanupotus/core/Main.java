package laivanupotus.core;

import java.util.ArrayList;
import laivanupotus.logic.GameField;
import laivanupotus.gui.Gui;
import laivanupotus.logic.Ship;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Marko
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Gui gui = new Gui();
        GameField gameField = new GameField(gui, 2);

        ArrayList coordinates = new ArrayList<>(); //Ship1
        coordinates.add("a5");
        coordinates.add("a2");
        coordinates.add("a3");
        coordinates.add("a4");
        Ship ship1 = new Ship(coordinates, 4);
        gameField.addShipToGui(ship1);

        coordinates.clear(); //Ship 2
        coordinates.add("c1");
        coordinates.add("c2");
        coordinates.add("c3");
        Ship ship2 = new Ship(coordinates, 3);
        gameField.addShipToGui(ship2);

        gui.setVisible(true);

    }

}
