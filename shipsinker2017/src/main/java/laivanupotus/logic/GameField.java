package laivanupotus.logic;

import laivanupotus.gui.Gui;
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
 *
 * @author Marko
 */
public class GameField {

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

    public Gui getGui() {
        return gui;
    }

    public int getShipsLeft() {
        return shipsLeft;
    }

    public void setShipsLeft(int param) {
        this.shipsLeft = param;
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
