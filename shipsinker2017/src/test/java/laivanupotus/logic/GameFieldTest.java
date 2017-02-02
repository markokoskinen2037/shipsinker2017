package laivanupotus.logic;

import laivanupotus.logic.GameField;
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

    @Before
    public void setUp() {
        Gui gui = new Gui();
        gameField = new GameField(gui);
    }

    @Test
    public void shipListIsEmptyByDefault() { //Shiplist should be empty if nothing has been added
        Assert.assertEquals(0, this.gameField.getShipList().size());
    }

    @Test
    public void createdShipsAreAddedtoShipList() { //Once createTestShips method has been run the shipList should contain 2 ships
        this.gameField.createTestShips();
        assertEquals(gameField.getShipList().size(), 2);
    }

    @Test
    public void victoryIsFalseByDefault(){ //Boolean victory should ofcourse be false in the beginning
        assertEquals(gameField.hasEnded(), false);
    }
    
    @Test
    public void GameIsRunning(){ //Checks if the method checkForShipsEverySecond is being started
        assertEquals(gameField.isRunning(), true);
    }
    
}
