package laivanupotus.logic;

import laivanupotus.gui.Game;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 * Luokka tarjoaa laivojen asetteluun ja pelin kirjanpitoon käytettäviä
 * metodeja.
 */
public class GameField {

    private final Game gui;
    private int shipsLeft;
    private ArrayList<Ship> shipList;
    private boolean running;

    /**
     * Konstruktori tallentaa saamansa parametrit omiin private muuttujiinsa,
     * luo tyhjän listan laivoille ja aloittaa pelin tarkkailun.
     *
     * @param game Main metodin luoma game olio
     * @param numberOfShips Main metodin kertoma laivojen määrä kartalla
     * aloitustilanteessa
     */
    public GameField(Game game, int numberOfShips) { //10 laivaa kartalla

        this.shipsLeft = numberOfShips;
        this.gui = game;
        this.shipList = new ArrayList<>();
        checkForShipsEverySecond();

    }

    public Game getGui() {
        return gui;
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
     * @param ship Main metodin antama parametri
     */
    public void addShipToGui(Ship ship) {

        shipList.add(ship);

        for (Object ship1Cordinate : ship.getCordinates()) {
            //System.out.println("Found correct JButton element called: " + gui.getComponentByName(ship1Cordinate.toString()).getName());
            JButton targetButton = gui.getComponentByName(ship1Cordinate.toString());

            ActionListener shipListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    targetButton.setBackground(Color.black);
                    targetButton.setEnabled(false);
                    ship.destroyPart();
                    if (ship.isDestroyed()) {
                        shipsLeft -= 1;
                    }
                }
            };
            targetButton.addActionListener(shipListener);
        }

    }

    private void checkForShipsEverySecond() { //Checks how many ships are still left every second
        this.running = true;

        Runnable checkRemainingShips = new Runnable() {
            int gametime = 0;

            public void run() {

                if (getShipsLeft() >= 1) {
                    System.out.println("ships: " + getShipsLeft() + " | time:" + gametime);
                    gametime++;
                }

                if (getShipsLeft() == 0 && running) {
                    gui.setVisible(false);
                    System.out.println("You beat the game in " + gametime + " seconds!");
                    JOptionPane.showMessageDialog(gui, "You beat the game in " + gametime + " seconds!");
                    running = false;
                }

            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(checkRemainingShips, 0, 1, TimeUnit.SECONDS);
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
