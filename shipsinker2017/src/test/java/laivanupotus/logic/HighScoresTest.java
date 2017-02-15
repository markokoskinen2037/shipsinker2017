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

        expected.add("Pekka:3");
       
        this.hs.updateBestPlayer("Pekka", "3");
        
        

        Assert.assertEquals(this.hs.readHighScores(), expected);
    }
    
    @Test
    public void addTest(){
        this.hs.updateBestPlayer("Peterson", "2");
        ArrayList<String> readHighScores = this.hs.readHighScores();
        
        Assert.assertEquals(this.hs.readHighScores().get(0), "Peterson:2");
        
    }

}
