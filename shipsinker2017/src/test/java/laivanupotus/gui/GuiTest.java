package laivanupotus.gui;

import java.awt.Color;
import laivanupotus.logic.GameField;
import laivanupotus.logic.HighScores;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Marko
 */
public class GuiTest {

    private Game gui;

    @Before
    public void setUp() {
        HighScores scores = new HighScores();
        GameField gamefield = new GameField(2, scores);
        this.gui = new Game(gamefield);
    }

    @Test
    public void buttonColorIsCorrect() { //By default button backgroundColor should be white
        assertEquals(gui.getA1().getBackground(), Color.gray);

    }

    @Test
    public void buttonIsClickable() { //By default button should be clickable
        assertEquals(gui.getA1().isEnabled(), true);
    }

    @Test
    public void buttonTestIsEmpty() { //By default button should have no text
        assertEquals(gui.getA1().getText(), "");
    }

    @Test
    public void buttonListSizeIsCorrect() {
        assertEquals(this.gui.getButtonList().size(), 100);
    }

}
