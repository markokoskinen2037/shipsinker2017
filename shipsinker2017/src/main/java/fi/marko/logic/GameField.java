package fi.marko.logic;

import fi.marko.gui.Gui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Marko
 */
public final class GameField {

    private final Gui gui;
    private int shipsLeft = 2;
    private final ArrayList<Ship> shipList = new ArrayList<>();
    private boolean running;
    private final boolean victory = false;

    public GameField(Gui gui) { //10 laivaa kartalla

        //****  Ship    1
        //***   Ship    2
        //***   Ship    3
        //**    Ship    4
        //**    Ship    5
        //**    Ship    6
        //*     Ship    7
        //*     Ship    8
        //*     Ship    9
        //*     Ship    10
        this.gui = gui;
        checkForShipsEverySecond();

    }

    public int getShipsLeft() {
        return shipsLeft;
    }

    public boolean isVictory() {
        return victory;
    }

    public ArrayList<Ship> getShipList() {
        return shipList;
    }

    public void createTestShips() {

        ArrayList ship1Cordinates = new ArrayList<>(); //Ship1
        ship1Cordinates.add("A1");
        ship1Cordinates.add("A2");
        ship1Cordinates.add("A3");
        ship1Cordinates.add("A4");

        Ship ship1 = new Ship(ship1Cordinates, 4);
        shipList.add(ship1);

        for (Object coordinate : ship1Cordinates) {
            if (coordinate.equals("A1")) {
                ActionListener a1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        gui.getA1().setBackground(Color.black);
                        gui.getA1().setEnabled(false);
                        ship1.destroyPart();
                        if (ship1.isDestroyed()) {
                            shipsLeft -= 1;
                        }
                    }
                };
                gui.getA1().addActionListener(a1);

            }

            if (coordinate.equals("A2")) {
                ActionListener a2 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        gui.getA2().setBackground(Color.black);
                        gui.getA2().setEnabled(false);
                        ship1.destroyPart();
                        if (ship1.isDestroyed()) {
                            shipsLeft -= 1;
                        }
                    }
                };
                gui.getA2().addActionListener(a2);

            }

            if (coordinate.equals("A3")) {
                ActionListener a3 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        gui.getA3().setBackground(Color.black);
                        gui.getA3().setEnabled(false);
                        ship1.destroyPart();
                        if (ship1.isDestroyed()) {
                            shipsLeft -= 1;
                        }
                    }
                };
                gui.getA3().addActionListener(a3);
            }
            if (coordinate.equals("A4")) {
                ActionListener a4 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        gui.getA4().setBackground(Color.black);
                        gui.getA4().setEnabled(false);
                        ship1.destroyPart();
                        if (ship1.isDestroyed()) {
                            shipsLeft -= 1;
                        }
                    }
                };
                gui.getA4().addActionListener(a4);
            }
        }

        ArrayList<String> ship2Cordinates = new ArrayList<>(); //Ship2
        ship2Cordinates.add("C1");
        ship2Cordinates.add("D1");
        ship2Cordinates.add("E1");
        Ship ship2 = new Ship(ship2Cordinates, 3);
        shipList.add(ship2);

        for (String ship2Cordinate : ship2Cordinates) {
            if (ship2Cordinate.equals("C1")) {
                ActionListener c1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        gui.getC1().setBackground(Color.black);
                        gui.getC1().setEnabled(false);
                        ship2.destroyPart();
                        if (ship2.isDestroyed()) {
                            shipsLeft -= 1;
                        }
                    }
                };
                gui.getC1().addActionListener(c1);
            }
            if (ship2Cordinate.equals("D1")) {
                ActionListener d1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        gui.getD1().setBackground(Color.black);
                        gui.getD1().setEnabled(false);
                        ship2.destroyPart();
                        if (ship2.isDestroyed()) {
                            shipsLeft -= 1;
                        }
                    }
                };
                gui.getD1().addActionListener(d1);
            }
            if (ship2Cordinate.equals("E1")) {
                ActionListener e1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        gui.getE1().setBackground(Color.black);
                        gui.getE1().setEnabled(false);
                        ship2.destroyPart();
                        if (ship2.isDestroyed()) {
                            shipsLeft -= 1;
                        }
                    }
                };
                gui.getE1().addActionListener(e1);
            }
        }
    }

    private void checkForShipsEverySecond() { //Checks how many ships are still left every second
        this.running = true;
        Runnable checkRemainingShips = new Runnable() {
            public void run() {
                System.out.println("Ships remaining: " + getShipsLeft());
            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(checkRemainingShips, 0, 1, TimeUnit.SECONDS);
    }

    public boolean isRunning() {
        return running;
    }
}
