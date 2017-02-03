package laivanupotus.logic;

import laivanupotus.gui.Gui;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Marko
 */
public class GameFieldTest {

    private GameField gameField;
    private Gui gui;

    @Before
    public void setUp() {
        Gui testGui = new Gui();
        this.gui = testGui;
        gameField = new GameField(testGui, 2);
    }

    @Test
    public void shipListIsEmptyByDefault() { //Shiplist should be empty if nothing has been added
        Assert.assertEquals(0, this.gameField.getShipList().size());
    }

//    @Test
//    public void createdShipsAreAddedtoShipList() { //Once createTestShips method has been run the shipList should contain 2 ships
//        this.gameField.createTestShips();
//        assertEquals(gameField.getShipList().size(), 2);
//    }
    @Test
    public void victoryIsFalseByDefault() { //Boolean victory should ofcourse be false in the beginning
        assertEquals(gameField.hasEnded(), false);
    }

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
    public void setShipsLeftIsWorking(){
        gameField.setShipsLeft(2);
        assertEquals(gameField.getShipsLeft(), 2);
    }

}
