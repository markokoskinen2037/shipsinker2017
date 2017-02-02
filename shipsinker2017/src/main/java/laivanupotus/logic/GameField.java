package laivanupotus.logic;

import laivanupotus.gui.Gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author Marko
 */
public final class GameField {

    private final Gui gui;
    private int shipsLeft;
    private ArrayList<Ship> shipList;
    private boolean running;
    private final boolean victory = false;

    public GameField(Gui gui, int numberOfShips) { //10 laivaa kartalla

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
        this.shipsLeft = numberOfShips;
        this.gui = gui;
        this.shipList = new ArrayList<>();
        checkForShipsEverySecond();


    }

    public int getShipsLeft() {
        return shipsLeft;
    }

    public boolean hasEnded() {
        return victory;
    }

    public ArrayList<Ship> getShipList() {
        return shipList;
    }

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

    public void createTestShips() {

        ArrayList ship1Cordinates = new ArrayList<>(); //Ship1
        ship1Cordinates.add("a1");
        ship1Cordinates.add("a2");
        ship1Cordinates.add("a3");
        ship1Cordinates.add("a4");

        Ship ship1 = new Ship(ship1Cordinates, 4);
        shipList.add(ship1);

        for (Object coordinate : ship1Cordinates) {
            if (coordinate.equals("a1")) {
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

            if (coordinate.equals("a2")) {
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

            if (coordinate.equals("a3")) {
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
            if (coordinate.equals("a4")) {
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
        ship2Cordinates.add("c1");
        ship2Cordinates.add("d1");
        ship2Cordinates.add("e1");
        Ship ship2 = new Ship(ship2Cordinates, 3);
        shipList.add(ship2);

        for (String ship2Cordinate : ship2Cordinates) {
            if (ship2Cordinate.equals("c1")) {
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
            if (ship2Cordinate.equals("d1")) {
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
            if (ship2Cordinate.equals("e1")) {
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

    public boolean isRunning() {
        return running;
    }
}
