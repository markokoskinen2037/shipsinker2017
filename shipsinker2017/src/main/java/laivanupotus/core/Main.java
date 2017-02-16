package laivanupotus.core;

import java.io.IOException;

import java.util.ArrayList;
import laivanupotus.logic.GameField;
import laivanupotus.gui.GameGui;
import laivanupotus.gui.Menu;
import laivanupotus.logic.HighScores;
import laivanupotus.logic.Ship;

/**
 * Luokka sisältää main metodin joka käynnistää pelin.
 *
 */
public class Main {

    /**
     * Käynnistää käyttöliittymän ja lisää GameFieldiin muutaman laivan
     *
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
//
//        ArrayList coordinates = new ArrayList<>(); //Ship1
//        coordinates.add("a5");
//        coordinates.add("a2");
//        coordinates.add("a3");
//        coordinates.add("a4");
//        Ship ship1 = new Ship(coordinates, coordinates.size());
//
//        HighScores hs = new HighScores();
//
//        Game gui = new Game();
//        GameField gameField = new GameField(gui, 10, hs);
//
//        gameField.addShipToGui(ship1);

        HighScores hs = new HighScores();

        GameGui gui = new GameGui();
        GameField gameField = new GameField(gui, 10, hs);
//        
        createTestShips(gui, gameField);
//        
        Menu menu = new Menu(hs, gui, gameField);
        menu.setVisible(true);
//        

//        gui.setVisible(true);
    }

    public static void createTestShips(GameGui gui, GameField gameField) {

        ArrayList coordinates = new ArrayList<>(); //Ship1
        coordinates.add("a5");
        coordinates.add("a2");
        coordinates.add("a3");
        coordinates.add("a4");
        Ship ship1 = new Ship(coordinates, coordinates.size());
        gameField.addShipToGui(ship1);

        coordinates.clear(); //Ship 2
        coordinates.add("c1");
        coordinates.add("c2");
        coordinates.add("c3");
        Ship ship2 = new Ship(coordinates, coordinates.size());
        gameField.addShipToGui(ship2);

        coordinates.clear(); //Ship 3
        coordinates.add("f3");
        coordinates.add("f4");
        coordinates.add("f5");
        Ship ship3 = new Ship(coordinates, coordinates.size());
        gameField.addShipToGui(ship3);

        coordinates.clear(); //Ship 4
        coordinates.add("b10");
        coordinates.add("c10");
        Ship ship4 = new Ship(coordinates, coordinates.size());
        gameField.addShipToGui(ship4);

        coordinates.clear(); //Ship 5
        coordinates.add("b8");
        coordinates.add("c8");
        Ship ship5 = new Ship(coordinates, coordinates.size());
        gameField.addShipToGui(ship5);

        coordinates.clear(); //Ship 6
        coordinates.add("f8");
        coordinates.add("g8");
        Ship ship6 = new Ship(coordinates, coordinates.size());
        gameField.addShipToGui(ship6);

        coordinates.clear(); //Ship 7
        coordinates.add("i4");
        Ship ship7 = new Ship(coordinates, coordinates.size());
        gameField.addShipToGui(ship7);

        coordinates.clear(); //Ship 8
        coordinates.add("d5");
        Ship ship8 = new Ship(coordinates, coordinates.size());
        gameField.addShipToGui(ship8);

        coordinates.clear(); //Ship 9
        coordinates.add("h2");
        Ship ship9 = new Ship(coordinates, coordinates.size());
        gameField.addShipToGui(ship9);

        coordinates.clear(); //Ship 10
        coordinates.add("i9");
        Ship ship10 = new Ship(coordinates, coordinates.size());
        gameField.addShipToGui(ship10);
    }

}
