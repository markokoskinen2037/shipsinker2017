package laivanupotus.core;

import java.io.IOException;

import java.util.ArrayList;
import laivanupotus.logic.GameField;
import laivanupotus.gui.Game;
import laivanupotus.gui.Menu;
import laivanupotus.logic.HighScores;
import laivanupotus.logic.Ship;

public class Main {

    /**
     * Käynnistää käyttöliittymän ja lisää GameFieldiin muutaman laivan
     *
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        HighScores hs = new HighScores();

        Menu menu = new Menu(hs);
        menu.setVisible(true);

        Game gui = new Game();
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
