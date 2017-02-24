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
     * @param game Main metodin luoma game olio
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
     * Lisää parametrina saadun Ship alkion koordinaatteja vastaaviin
     * JButtoneihin ActionListener tapahtumankuuntelijat joiden avulla GameField
     * huomaa kun joku laiva tai sen osa tuhoutuu.
     *
     * @see laivanupotus.gui.Game#getComponentByName(java.lang.String)
     *
     * @param ship Main metodin antama parametri
     */
//    public void addShipToGui(Ship ship) {
//        
//        shipList.add(ship);
//        
//        for (Object ship1Cordinate : ship.getCordinates()) {
//            //System.out.println("Found correct JButton element called: " + gui.getComponentByName(ship1Cordinate.toString()).getName());
//            JButton targetButton = gui.getComponentByName(ship1Cordinate.toString());
//            for (ActionListener listener : targetButton.getActionListeners()) {
//                targetButton.removeActionListener(listener);
//            }
//            targetButton.setBackground(Color.yellow); //Testausta varten
//
//            ActionListener shipListener = new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent ae) {
//                    turnsUsed++;
//                    //System.out.println(turnsUsed);
//                    targetButton.setBackground(Color.black);
//                    targetButton.setEnabled(false);
//                    ship.destroyPart();
//                    if (ship.isDestroyed()) {
//                        shipsLeft -= 1;
//                    }
//                }
//            };
//            targetButton.addActionListener(shipListener);
//        }
//        
//    }
    /**
     * Lisää jokaiseen JButton elementtiin tapahtumankuuntelijan jonka
     * toteutuessa turnsUsed arvoa kasvatetaan yhdellä.
     *
     */
    /**
     * Tarkistaa joka sekunti kuinka monta laivaa on jäljellä. Kun laivonjen
     * määrä on viimein 0 suljetaan peli ja päivitetään huipputulokset.
     */
    /**
     * Palauttaa true jos peli on käynnissä ja false jos peli ei ole käynnissä.
     *
     * @return boolean
     */
    public boolean isRunning() {
        return this.running;
    }
}
