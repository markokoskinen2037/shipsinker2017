package laivanupotus.logic;

import java.util.ArrayList;

/**
 * Luokka tarjoaa laivojen asetteluun ja pelin kirjanpitoon käytettäviä
 * metodeja.
 */
public class GameField {

    public int shipsLeft, turnsUsed;
    public ArrayList<Ship> shipList;
    public boolean running;
    public HighScores hs;
    public String playername;

    /**
     * Konstruktori tallentaa saamansa parametrit omiin private muuttujiinsa,
     * luo tyhjän listan laivoille ja aloittaa pelin tarkkailun.
     *
     * @param hs Main metodin luoma olio
     * @param numberOfShips Main metodin kertoma laivojen määrä kartalla
     * aloitustilanteessa
     */
    public GameField(int numberOfShips, HighScores hs) { //10 laivaa kartalla
        this.turnsUsed = 0;
        this.hs = hs;
        this.shipsLeft = numberOfShips;
        this.shipList = new ArrayList<>();

    }

    public void setPlayerName(String playername) {
        this.playername = playername;
    }

    public String getPlayerName() {
        return this.playername;
    }

    public int getShipsLeft() {
        return shipsLeft;
    }

    public void setShipsLeft(int amount) {
        this.shipsLeft = amount;
    }

    public ArrayList<Ship> getShipList() {
        return shipList;
    }

    /**
     * Palauttaa true jos peli on käynnissä ja false jos peli ei ole käynnissä.
     *
     * @return boolean
     */
    public boolean isRunning() {
        return this.running;
    }
}
