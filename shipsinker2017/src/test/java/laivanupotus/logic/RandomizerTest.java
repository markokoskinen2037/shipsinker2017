/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logic;

import java.util.ArrayList;
import static laivanupotus.core.Main.createDefault;
import laivanupotus.gui.Game;
import laivanupotus.gui.Menu;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Beast
 */
public class RandomizerTest {

    private HighScores hs;
    private GameField gameField;
    private Game gui;
    private Randomizer randomizer;

    public RandomizerTest() {
        this.hs = new HighScores();
        this.gameField = new GameField(10, hs);
        this.gui = new Game(gameField);

    }

    @Before
    public void setUp() {

        this.randomizer = new Randomizer(gui, gameField);
        this.randomizer.createShip(4);
        this.randomizer.createShip(3);
        this.randomizer.createShip(3);
        this.randomizer.createShip(2);
        this.randomizer.createShip(2);
        this.randomizer.createShip(2);
        this.randomizer.createShip(1);
        this.randomizer.createShip(1);
        this.randomizer.createShip(1);
        this.randomizer.createShip(1);

        ArrayList<Ship> shipList = gameField.getShipList();
        ArrayList<String> allCords = new ArrayList<>();

        for (Ship ship : shipList) {
            ArrayList<String> cordinates = ship.getCordinates();
            for (String cordinate : cordinates) {
                if (allCords.contains(cordinate)) {
                    //System.out.println("se oli siel jo, uusiks menee");
                } else {
                    allCords.add(cordinate);
                }
            }
        }
    }

    @Test
    public void shipsAreAdded() {
        assertEquals(gameField.shipList.size(), 10);
    }

    @Test
    public void intToCharWorks() {
        assertEquals(this.randomizer.getCoordinateChar(0), "a");
        assertEquals(this.randomizer.getCoordinateChar(7), "h");
        assertEquals(this.randomizer.getCoordinateChar(8), "i");
        assertEquals(this.randomizer.getCoordinateChar(9), "j");
        assertEquals(this.randomizer.getCoordinateChar(29), "bad number");
    }

    @Test
    public void usedCoordsAreAddedToList() {
        assertEquals(randomizer.inUse.size() > 10, true);
    }

    @Test
    public void spaceGetsDecremented() {
        assertEquals(randomizer.spaceLeft < 100, true);
    }

    @Test
    public void getRightWorks() {
        assertEquals(this.randomizer.getRight('a'), 'b');
        assertEquals(this.randomizer.getRight('b'), 'c');
        assertEquals(this.randomizer.getRight('c'), 'd');
        assertEquals(this.randomizer.getRight('d'), 'e');
        assertEquals(this.randomizer.getRight('e'), 'f');
        assertEquals(this.randomizer.getRight('f'), 'g');
        assertEquals(this.randomizer.getRight('g'), 'h');
        assertEquals(this.randomizer.getRight('h'), 'i');
        assertEquals(this.randomizer.getRight('i'), 'j');
        assertEquals(this.randomizer.getRight('j'), 'j');
        assertEquals(this.randomizer.getRight('o'), 'x');
    }

    @Test
    public void getLeftWorks() {
        assertEquals(this.randomizer.getLeft('a'), 'a');
        assertEquals(this.randomizer.getLeft('b'), 'a');
        assertEquals(this.randomizer.getLeft('c'), 'b');
        assertEquals(this.randomizer.getLeft('d'), 'c');
        assertEquals(this.randomizer.getLeft('e'), 'd');
        assertEquals(this.randomizer.getLeft('f'), 'e');
        assertEquals(this.randomizer.getLeft('g'), 'f');
        assertEquals(this.randomizer.getLeft('h'), 'g');
        assertEquals(this.randomizer.getLeft('i'), 'h');
        assertEquals(this.randomizer.getLeft('j'), 'i');
        assertEquals(this.randomizer.getLeft('o'), 'x');
    }

}
