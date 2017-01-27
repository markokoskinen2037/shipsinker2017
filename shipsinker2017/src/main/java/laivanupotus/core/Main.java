package laivanupotus.core;

import laivanupotus.logic.GameField;
import laivanupotus.gui.Gui;

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
        GameField gameField = new GameField(gui);
        gameField.createTestShips();
        gui.setVisible(true);



    }

}
