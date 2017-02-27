package laivanupotus.logic;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Beast
 */
public class HighScoresTest {

    private HighScores hs;

    public HighScoresTest() {

    }

    @Before
    public void setUp() {
        hs = new HighScores();
        hs.resetScores();
    }

    @Test
    public void readHighScoresReturnValueIsCorrect() {
        ArrayList<String> expected = new ArrayList<>();

        expected.add("Pekka:50");
       
        this.hs.updateBestPlayer("Pekka", "50");
        
        

        Assert.assertEquals(this.hs.updateScores(), expected);
    }
    
    @Test
    public void addTest(){
        this.hs.updateBestPlayer("Peterson", "2");
        ArrayList<String> readHighScores = this.hs.updateScores();
        
        Assert.assertEquals(this.hs.updateScores().get(0), "Peterson:2");
        
    }

}
