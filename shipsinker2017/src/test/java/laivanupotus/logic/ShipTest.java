package laivanupotus.logic;

import laivanupotus.logic.Ship;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marko
 */
public class ShipTest {
    private Ship testShip;
    
    public ShipTest() {
    }

    @Before
    public void setUp() {
        ArrayList testShipCoordinates = new ArrayList<>(); //Creates a testShip
        testShipCoordinates.add("A1");
        testShipCoordinates.add("A2");
        testShipCoordinates.add("A3");
        testShipCoordinates.add("A4");

        testShip = new Ship(testShipCoordinates, 4);
        
    }
    
    @Test
    public void destroyingPartsDecreasesShipSize(){ //Tests that ship size gets decreased by one when a part of it gets hit
        this.testShip.destroyPart();
        assertEquals(this.testShip.getSize(), 3);
    }
    
    @Test
    public void shipGetsDestroyed(){ //Tests that the ship status is changed to destroyed when all of its parts are destroyed
        for (int i = 0; i < 4; i++) {
            this.testShip.destroyPart();
        }
        assertEquals(this.testShip.isDestroyed(), true);
    }
    
    @Test
    public void toStringIsCorrect(){
        assertEquals(testShip.toString(), "Shipsize:4 A1 | A2 | A3 | A4 | ");
    }
}
