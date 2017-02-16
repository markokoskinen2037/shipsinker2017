package laivanupotus.logic;

import java.util.ArrayList;
import laivanupotus.gui.GameGui;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class GameFieldTest {

    private GameField gameField;
    private GameGui gui;
    private HighScores hs;

    @Before
    public void setUp() {
        HighScores hs = new HighScores();
        this.hs = hs;
        GameGui testGui = new GameGui();
        this.gui = testGui;
        gameField = new GameField(testGui, 2,hs);
        
        
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
        
    }

    @Test
    public void shipListContainsTestShips() { //Shiplist should be empty if nothing has been added
        Assert.assertEquals(2, this.gameField.getShipList().size());
    }

//    @Test
//    public void createdShipsAreAddedtoShipList() { //Once createTestShips method has been run the shipList should contain 2 ships
//        this.gameField.createTestShips();
//        assertEquals(gameField.getShipList().size(), 2);
//    }
    @Test
    public void GameIsRunning() { //Checks if the method checkForShipsEverySecond is being started
        assertEquals(gameField.isRunning(), true);
    }

    @Test
    public void shipsLeftIsCorrect() {
        assertEquals(this.gameField.getShipsLeft(), 2);
    }

    @Test
    public void guiRemainsUnchanged() {
        assertEquals(this.gui, this.gameField.getGui());
    }

    @Test
    public void setShipsLeftIsWorking() {
        gameField.setShipsLeft(2);
        assertEquals(gameField.getShipsLeft(), 2);
    }
    
    @Test
    public void playerNameIsCorrect(){
        gameField.setPlayerName("Reiska");
        assertEquals(gameField.getPlayerName(), "Reiska");
    }
    
     @Test
     public void desroyingShipWorks(){
         gameField.getShipList().get(0).destroyShip();
         gameField.setShipsLeft(gameField.getShipsLeft()-1);
         assertEquals(gameField.getShipsLeft(), 1);
     }

}
