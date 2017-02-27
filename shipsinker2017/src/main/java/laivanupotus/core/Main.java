package laivanupotus.core;

import java.util.ArrayList;
import laivanupotus.logic.GameField;
import laivanupotus.gui.Game;
import laivanupotus.gui.Menu;
import laivanupotus.logic.HighScores;
import laivanupotus.logic.Randomizer;
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
     * @throws java.lang.InterruptedException
     *
     */
    public static void main(String[] args) throws InterruptedException {
        HighScores hs = new HighScores();
        GameField gameField = new GameField(10, hs);
        Game gui = new Game(gameField);
        

        Menu menu = new Menu(hs, gui, gameField);
        menu.setVisible(true);

        while (true) {
            Thread.sleep(1000);
            if (gameField.isRunning() == false && menu.isVisible() == false) {
                System.out.println("Thanks for playing!");
                System.exit(0);
            }
        }

//        startGame();
    }

    public static void createDefault(Game gui, GameField gameField) {

        ArrayList coordinates = new ArrayList<>(); //Ship1
        coordinates.add("a5");
        coordinates.add("a2");
        coordinates.add("a3");
        coordinates.add("a4");
        Ship ship1 = new Ship(coordinates, coordinates.size());
        gui.addShipToGui(ship1);

        coordinates.clear(); //Ship 2
        coordinates.add("c1");
        coordinates.add("c2");
        coordinates.add("c3");
        Ship ship2 = new Ship(coordinates, coordinates.size());
        gui.addShipToGui(ship2);

        coordinates.clear(); //Ship 3
        coordinates.add("f3");
        coordinates.add("f4");
        coordinates.add("f5");
        Ship ship3 = new Ship(coordinates, coordinates.size());
        gui.addShipToGui(ship3);

        coordinates.clear(); //Ship 4
        coordinates.add("b10");
        coordinates.add("c10");
        Ship ship4 = new Ship(coordinates, coordinates.size());
        gui.addShipToGui(ship4);

        coordinates.clear(); //Ship 5
        coordinates.add("b8");
        coordinates.add("c8");
        Ship ship5 = new Ship(coordinates, coordinates.size());
        gui.addShipToGui(ship5);

        coordinates.clear(); //Ship 6
        coordinates.add("f8");
        coordinates.add("g8");
        Ship ship6 = new Ship(coordinates, coordinates.size());
        gui.addShipToGui(ship6);

        coordinates.clear(); //Ship 7
        coordinates.add("i4");
        Ship ship7 = new Ship(coordinates, coordinates.size());
        gui.addShipToGui(ship7);

        coordinates.clear(); //Ship 8
        coordinates.add("d5");
        Ship ship8 = new Ship(coordinates, coordinates.size());
        gui.addShipToGui(ship8);

        coordinates.clear(); //Ship 9
        coordinates.add("h2");
        Ship ship9 = new Ship(coordinates, coordinates.size());
        gui.addShipToGui(ship9);

        coordinates.clear(); //Ship 10
        coordinates.add("i9");
        Ship ship10 = new Ship(coordinates, coordinates.size());
        gui.addShipToGui(ship10);
    }

    public static void startGame() throws InterruptedException {

        String path = "/home/markokos/Desktop/shipsinker2017/shipsinker2017/src/main/resources/explosion.mp3";

        HighScores hs = new HighScores();

        GameField gameField = new GameField(10, hs);
        Game gui = new Game(gameField);
        createDefault(gui, gameField);
        Menu menu = new Menu(hs, gui, gameField);
        menu.setVisible(true);

        while (true) {
            Thread.sleep(1000);
            if (gameField.isRunning() == false && menu.isVisible() == false) {
                System.out.println("Thanks for playing!");
                System.exit(0);
            }
        }
    }
    
    public static void createRandom(Game gui, GameField gameField){
        
        Randomizer random = new Randomizer(gui, gameField);
        random.createShip(4);
        random.createShip(3);
        random.createShip(3);
        random.createShip(2);
        random.createShip(2);
        random.createShip(2);
        random.createShip(1);
        random.createShip(1);
        random.createShip(1);
        random.createShip(1);
        
        ArrayList<Ship> shipList = gameField.getShipList();
        ArrayList<String> allCords = new ArrayList<>();

        for (Ship ship : shipList) {
            ArrayList<String> cordinates = ship.getCordinates();
            for (String cordinate : cordinates) {
                if(allCords.contains(cordinate)){
                    //System.out.println("se oli siel jo, uusiks menee");
                } else {
                    allCords.add(cordinate);
                }
            }
        }
        
    }

}
