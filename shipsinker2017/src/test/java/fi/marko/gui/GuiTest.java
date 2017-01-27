package fi.marko.gui;

import java.awt.Color;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Marko
 */
public class GuiTest {

    private Gui gui;

    @Before
    public void setUp() {
        this.gui = new Gui();
    }

    @Test
    public void buttonColorIsCorrect() { //By default button backgroundColor should be white
        assertEquals(gui.getA1().getBackground(), Color.white);

    }

    @Test
    public void buttonIsClickable() { //By default button should be clickable
        assertEquals(gui.getA1().isEnabled(), true);
    }

    @Test
    public void buttonTestIsEmpty() { //By default button should have no text
        assertEquals(gui.getA1().getText(), "");
    }

}
