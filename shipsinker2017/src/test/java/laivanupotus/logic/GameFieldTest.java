package laivanupotus.logic;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import laivanupotus.gui.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GameFieldTest {

    private GameField gameField;
    private Game gui;
    private HighScores hs;

    @Before
    public void setUp() {
        HighScores hs = new HighScores();
        this.hs = hs;

        gameField = new GameField(2, hs);
        Game testGui = new Game(gameField);
        this.gui = testGui;

        ArrayList coordinates = new ArrayList<>(); //Ship1
        coordinates.add("a5");
        coordinates.add("a2");
        coordinates.add("a3");
        coordinates.add("a4");
        Ship ship1 = new Ship(coordinates, coordinates.size());
        testGui.addShipToGui(ship1);

        coordinates.clear(); //Ship 2
        coordinates.add("c1");
        coordinates.add("c2");
        coordinates.add("c3");
        Ship ship2 = new Ship(coordinates, coordinates.size());
        testGui.addShipToGui(ship2);

    }

    @Test
    public void shipListContainsTestShips() { //Shiplist should be empty if nothing has been added
        Assert.assertEquals(2, this.gameField.getShipList().size());
    }

    @Test
    public void GameIsRunning() { //Checks if the method checkForShipsEverySecond is being started
        assertEquals(gameField.isRunning(), false);
    }

    @Test
    public void shipsLeftIsCorrect() {
        assertEquals(this.gameField.getShipsLeft(), 2);
    }

    @Test
    public void setShipsLeftIsWorking() {
        gameField.setShipsLeft(2);
        assertEquals(gameField.getShipsLeft(), 2);
    }

    @Test
    public void playerNameIsCorrect() {
        gameField.setPlayerName("Reiska");
        assertEquals(gameField.getPlayerName(), "Reiska");
    }

    @Test
    public void desroyingShipWorks() {
        gameField.getShipList().get(0).destroyShip();
        gameField.setShipsLeft(gameField.getShipsLeft() - 1);
        assertEquals(gameField.getShipsLeft(), 1);
    }

    @Test
    public void defaultActionListenersAreCreated() {
        ActionListener[] actionListeners = this.gui.getComponentByName("a1").getActionListeners();
        int deleted = 0;
        for (ActionListener actionListener : actionListeners) {
            deleted = 1;
            this.gui.getComponentByName("a1").removeActionListener(actionListener);
        }

        assertEquals(deleted, 1);
    }

    @Test
    public void cheatsAreNotOn() {
        Color background = this.gui.getComponentByName("a2").getBackground();
        assertEquals(background, Color.cyan);
    }

    @Test
    public void otherButtonsAreCyan() {
        assertEquals(this.gui.getComponentByName("a7").getBackground(), Color.cyan);
    }

    @Test
    public void allButtonsHaveListeners() {
        assertEquals(gui.getComponentByName("a1").getActionListeners().length, 1);
    }

}
