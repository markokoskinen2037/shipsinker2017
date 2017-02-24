/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import laivanupotus.logic.GameField;
import laivanupotus.logic.Ship;

/**
 * Käyttöliittymäluokka joka sisältää varsinaisen pelialustan jossa peliä
 * pelataan.
 *
 */
public class Game extends javax.swing.JFrame {

    /**
     * Creates new form GUI
     */
    private HashMap buttonMappi;
    private ArrayList<JButton> buttonList;
    private static GameField gameField;

    /**
     * Palauttaa listan joka sisältää kaikki käyttöliittymän JButton
     * komponentit.
     *
     * @return ArrayList
     */
    public ArrayList<JButton> getButtonList() {
        return buttonList;
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
    public void addShipToGui(Ship ship) {

        this.gameField.shipList.add(ship);

        for (Object ship1Cordinate : ship.getCordinates()) {
            //System.out.println("Found correct JButton element called: " + gui.getComponentByName(ship1Cordinate.toString()).getName());
            JButton targetButton = getComponentByName(ship1Cordinate.toString());
            for (ActionListener listener : targetButton.getActionListeners()) {
                targetButton.removeActionListener(listener);
            }
            targetButton.setBackground(Color.yellow); //Testausta varten

            ActionListener shipListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    gameField.turnsUsed++;
                    //System.out.println(turnsUsed);
                    targetButton.setBackground(Color.black);
                    targetButton.setEnabled(false);
                    ship.destroyPart();
                    if (ship.isDestroyed()) {
                        gameField.shipsLeft -= 1;
                    }
                }
            };
            targetButton.addActionListener(shipListener);
        }

    }

    /**
     * Määrittää jokaiselle JButton elementille tapahtumankuuntelijan, joiden
     * avulla pidetään kirjaan vuoroista ja valituista ruuduista.
     */
    public void createDefaultActionListeners() {
        ArrayList<JButton> buttonList = getButtonList();

        for (JButton targetButton : buttonList) {
            targetButton.setBackground(Color.gray);
            ActionListener shipListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    gameField.turnsUsed++;
//                    System.out.println(turnsUsed);
                    targetButton.setBackground(Color.BLUE);
                    targetButton.setEnabled(false);

                }
            };
            targetButton.addActionListener(shipListener);

        };
    }

    /**
     * Tarkistaa sekunnin välein kuinka monta laivaa on jäljellä. Jos laivoja on
     * alle 0 havaitaan, että peli on loppu.
     */
    public void checkForShipsEverySecond() {
        gameField.running = true;

        Runnable checkRemainingShips = new Runnable() {
            int gametime = 0;

            public void run() {

                if (gameField.isRunning() == false) {

                }

                if (gameField.getShipsLeft() >= 1) {
                    System.out.println("ships: " + gameField.getShipsLeft() + " | time:" + gametime + " turns used: " + gameField.turnsUsed);
                    gametime++;
                }

                if (gameField.getShipsLeft() == 0 && gameField.running) {
                    setVisible(false);
                    System.out.println("You beat the game in " + gameField.turnsUsed + " turns!");
                    JOptionPane.showMessageDialog(null, "You beat the game in " + gameField.turnsUsed + " turns!");
                    gameField.running = false;
                    //System.out.println("Updating highscores");
                    gameField.hs.updateBestPlayer(gameField.playername, gameField.turnsUsed + "");

                    dispose();

                }

            }
        };

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(checkRemainingShips, 0, 1, TimeUnit.SECONDS);
    }

    /**
     * Konstruktori alustaa komponentti, asettaa otsikon, määrittää JButtoneiden
     * värit ja luo komponenttimapin.
     *
     * @param gameField
     * @see laivanupotus.gui.Game#createComponentMap()
     */
    public Game(GameField gameField) {
        this.gameField = gameField;
        initComponents();
        super.setTitle("Ship Shinker 2017");
        a1.setBackground(Color.WHITE);
        a2.setBackground(Color.WHITE);
        a3.setBackground(Color.WHITE);
        a4.setBackground(Color.WHITE);
        a5.setBackground(Color.WHITE);
        a6.setBackground(Color.WHITE);
        a7.setBackground(Color.WHITE);
        a8.setBackground(Color.WHITE);
        a9.setBackground(Color.WHITE);
        a10.setBackground(Color.WHITE);

        b1.setBackground(Color.WHITE);
        b2.setBackground(Color.WHITE);
        b3.setBackground(Color.WHITE);
        b4.setBackground(Color.WHITE);
        b5.setBackground(Color.WHITE);
        b6.setBackground(Color.WHITE);
        b7.setBackground(Color.WHITE);
        b8.setBackground(Color.WHITE);
        b9.setBackground(Color.WHITE);
        b10.setBackground(Color.WHITE);

        c1.setBackground(Color.WHITE);
        c2.setBackground(Color.WHITE);
        c3.setBackground(Color.WHITE);
        c4.setBackground(Color.WHITE);
        c5.setBackground(Color.WHITE);
        c6.setBackground(Color.WHITE);
        c7.setBackground(Color.WHITE);
        c8.setBackground(Color.WHITE);
        c9.setBackground(Color.WHITE);
        c10.setBackground(Color.WHITE);

        d1.setBackground(Color.WHITE);
        d2.setBackground(Color.WHITE);
        d3.setBackground(Color.WHITE);
        d4.setBackground(Color.WHITE);
        d5.setBackground(Color.WHITE);
        d6.setBackground(Color.WHITE);
        d7.setBackground(Color.WHITE);
        d8.setBackground(Color.WHITE);
        d9.setBackground(Color.WHITE);
        d10.setBackground(Color.WHITE);

        e1.setBackground(Color.WHITE);
        e2.setBackground(Color.WHITE);
        e3.setBackground(Color.WHITE);
        e4.setBackground(Color.WHITE);
        e5.setBackground(Color.WHITE);
        e6.setBackground(Color.WHITE);
        e7.setBackground(Color.WHITE);
        e8.setBackground(Color.WHITE);
        e9.setBackground(Color.WHITE);
        e10.setBackground(Color.WHITE);

        f1.setBackground(Color.WHITE);
        f2.setBackground(Color.WHITE);
        f3.setBackground(Color.WHITE);
        f4.setBackground(Color.WHITE);
        f5.setBackground(Color.WHITE);
        f6.setBackground(Color.WHITE);
        f7.setBackground(Color.WHITE);
        f8.setBackground(Color.WHITE);
        f9.setBackground(Color.WHITE);
        f10.setBackground(Color.WHITE);

        g1.setBackground(Color.WHITE);
        g2.setBackground(Color.WHITE);
        g3.setBackground(Color.WHITE);
        g4.setBackground(Color.WHITE);
        g5.setBackground(Color.WHITE);
        g6.setBackground(Color.WHITE);
        g7.setBackground(Color.WHITE);
        g8.setBackground(Color.WHITE);
        g9.setBackground(Color.WHITE);
        g10.setBackground(Color.WHITE);

        h1.setBackground(Color.WHITE);
        h2.setBackground(Color.WHITE);
        h3.setBackground(Color.WHITE);
        h4.setBackground(Color.WHITE);
        h5.setBackground(Color.WHITE);
        h6.setBackground(Color.WHITE);
        h7.setBackground(Color.WHITE);
        h8.setBackground(Color.WHITE);
        h9.setBackground(Color.WHITE);
        h10.setBackground(Color.WHITE);

        i1.setBackground(Color.WHITE);
        i2.setBackground(Color.WHITE);
        i3.setBackground(Color.WHITE);
        i4.setBackground(Color.WHITE);
        i5.setBackground(Color.WHITE);
        i6.setBackground(Color.WHITE);
        i7.setBackground(Color.WHITE);
        i8.setBackground(Color.WHITE);
        i9.setBackground(Color.WHITE);
        i10.setBackground(Color.WHITE);

        j1.setBackground(Color.WHITE);
        j2.setBackground(Color.WHITE);
        j3.setBackground(Color.WHITE);
        j4.setBackground(Color.WHITE);
        j5.setBackground(Color.WHITE);
        j6.setBackground(Color.WHITE);
        j7.setBackground(Color.WHITE);
        j8.setBackground(Color.WHITE);
        j9.setBackground(Color.WHITE);
        j10.setBackground(Color.WHITE);

        createComponentMap();
        createDefaultActionListeners();

    }

    private void createComponentMap() {

        this.buttonList = new ArrayList<>();
        Component[] components = this.getContentPane().getComponents();
        int buttoncounter = 0;
        for (Component component : components) { //Käydään läpi kaikki komponentit ja lisätään listalle vain ne joiden tyyppi on button sitten muunnetaan componentit buttoneiksi
            if (component.toString().contains("JButton")) {
                buttoncounter++;
//                System.out.println(buttoncounter);
                this.buttonList.add((JButton) component);

            }
        }
//        System.out.println("Listan koko: " + buttonList.size());
    }

    /**
     * Etsii aiemmin luoduta buttonLististä nimen perusteella sitä vastaavan
     * JButton elementin.
     *
     * @param name Saa parametrinaan nimen jonka perusteella etsitään
     * buttonLististä nimeä vastaava JButton elementti.
     * @see laivanupotus.gui.Game#createComponentMap()
     * @return JButton
     */
    public JButton getComponentByName(String name) {
        //System.out.println("Seaching for name: " + name);
        for (JButton jButton : buttonList) {
            if (jButton.getName().contains(name)) {
                return jButton;
            }

        }
        return null;
    }

    public JButton getA10() {
        return a10;
    }

    public JButton getA2() {
        return a2;
    }

    public JButton getA3() {
        return a3;
    }

    public JButton getA4() {
        return a4;
    }

    public JButton getA5() {
        return a5;
    }

    public JButton getA6() {
        return a6;
    }

    public JButton getA7() {
        return a7;
    }

    public JButton getA8() {
        return a8;
    }

    public JButton getA9() {
        return a9;
    }

    public JButton getB1() {
        return b1;
    }

    public JButton getB10() {
        return b10;
    }

    public JButton getB2() {
        return b2;
    }

    public JButton getB3() {
        return b3;
    }

    public JButton getB4() {
        return b4;
    }

    public JButton getB5() {
        return b5;
    }

    public JButton getB6() {
        return b6;
    }

    public JButton getB7() {
        return b7;
    }

    public JButton getB8() {
        return b8;
    }

    public JButton getB9() {
        return b9;
    }

    public JButton getC1() {
        return c1;
    }

    public JButton getC10() {
        return c10;
    }

    public JButton getC2() {
        return c2;
    }

    public JButton getC3() {
        return c3;
    }

    public JButton getC4() {
        return c4;
    }

    public JButton getC5() {
        return c5;
    }

    public JButton getC6() {
        return c6;
    }

    public JButton getC7() {
        return c7;
    }

    public JButton getC8() {
        return c8;
    }

    public JButton getC9() {
        return c9;
    }

    public JButton getD1() {
        return d1;
    }

    public JButton getD10() {
        return d10;
    }

    public JButton getD2() {
        return d2;
    }

    public JButton getD3() {
        return d3;
    }

    public JButton getD4() {
        return d4;
    }

    public JButton getD5() {
        return d5;
    }

    public JButton getD6() {
        return d6;
    }

    public JButton getD7() {
        return d7;
    }

    public JButton getD8() {
        return d8;
    }

    public JButton getD9() {
        return d9;
    }

    public JButton getE1() {
        return e1;
    }

    public JButton getE10() {
        return e10;
    }

    public JButton getE2() {
        return e2;
    }

    public JButton getE3() {
        return e3;
    }

    public JButton getE4() {
        return e4;
    }

    public JButton getE5() {
        return e5;
    }

    public JButton getE6() {
        return e6;
    }

    public JButton getE7() {
        return e7;
    }

    public JButton getE8() {
        return e8;
    }

    public JButton getE9() {
        return e9;
    }

    public JButton getF1() {
        return f1;
    }

    public JButton getF10() {
        return f10;
    }

    public JButton getF2() {
        return f2;
    }

    public JButton getF3() {
        return f3;
    }

    public JButton getF4() {
        return f4;
    }

    public JButton getF5() {
        return f5;
    }

    public JButton getF6() {
        return f6;
    }

    public JButton getF7() {
        return f7;
    }

    public JButton getF8() {
        return f8;
    }

    public JButton getF9() {
        return f9;
    }

    public JButton getG1() {
        return g1;
    }

    public JButton getG10() {
        return g10;
    }

    public JButton getG2() {
        return g2;
    }

    public JButton getG3() {
        return g3;
    }

    public JButton getG4() {
        return g4;
    }

    public JButton getG5() {
        return g5;
    }

    public JButton getG6() {
        return g6;
    }

    public JButton getG7() {
        return g7;
    }

    public JButton getG8() {
        return g8;
    }

    public JButton getG9() {
        return g9;
    }

    public JButton getH1() {
        return h1;
    }

    public JButton getH10() {
        return h10;
    }

    public JButton getH2() {
        return h2;
    }

    public JButton getH3() {
        return h3;
    }

    public JButton getH4() {
        return h4;
    }

    public JButton getH5() {
        return h5;
    }

    public JButton getH6() {
        return h6;
    }

    public JButton getH7() {
        return h7;
    }

    public JButton getH8() {
        return h8;
    }

    public JButton getH9() {
        return h9;
    }

    public JButton getI1() {
        return i1;
    }

    public JButton getI10() {
        return i10;
    }

    public JButton getI2() {
        return i2;
    }

    public JButton getI3() {
        return i3;
    }

    public JButton getI4() {
        return i4;
    }

    public JButton getI5() {
        return i5;
    }

    public JButton getI6() {
        return i6;
    }

    public JButton getI7() {
        return i7;
    }

    public JButton getI8() {
        return i8;
    }

    public JButton getI9() {
        return i9;
    }

    public JButton getJ1() {
        return j1;
    }

    public JButton getJ10() {
        return j10;
    }

    public JButton getJ2() {
        return j2;
    }

    public JButton getJ3() {
        return j3;
    }

    public JButton getJ4() {
        return j4;
    }

    public JButton getJ5() {
        return j5;
    }

    public JButton getJ6() {
        return j6;
    }

    public JButton getJ7() {
        return j7;
    }

    public JButton getJ8() {
        return j8;
    }

    public JButton getJ9() {
        return j9;
    }

    public JButton getA1() {
        return a1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        a1 = new javax.swing.JButton();
        a2 = new javax.swing.JButton();
        a3 = new javax.swing.JButton();
        a4 = new javax.swing.JButton();
        a5 = new javax.swing.JButton();
        a6 = new javax.swing.JButton();
        a7 = new javax.swing.JButton();
        a8 = new javax.swing.JButton();
        a9 = new javax.swing.JButton();
        a10 = new javax.swing.JButton();
        b1 = new javax.swing.JButton();
        c1 = new javax.swing.JButton();
        d1 = new javax.swing.JButton();
        e1 = new javax.swing.JButton();
        f1 = new javax.swing.JButton();
        g1 = new javax.swing.JButton();
        h1 = new javax.swing.JButton();
        i1 = new javax.swing.JButton();
        j1 = new javax.swing.JButton();
        c2 = new javax.swing.JButton();
        f2 = new javax.swing.JButton();
        d2 = new javax.swing.JButton();
        e2 = new javax.swing.JButton();
        j2 = new javax.swing.JButton();
        g2 = new javax.swing.JButton();
        h2 = new javax.swing.JButton();
        i2 = new javax.swing.JButton();
        b2 = new javax.swing.JButton();
        j3 = new javax.swing.JButton();
        f3 = new javax.swing.JButton();
        e3 = new javax.swing.JButton();
        g3 = new javax.swing.JButton();
        i3 = new javax.swing.JButton();
        h3 = new javax.swing.JButton();
        b3 = new javax.swing.JButton();
        d3 = new javax.swing.JButton();
        c3 = new javax.swing.JButton();
        d4 = new javax.swing.JButton();
        c4 = new javax.swing.JButton();
        g4 = new javax.swing.JButton();
        j4 = new javax.swing.JButton();
        e4 = new javax.swing.JButton();
        b4 = new javax.swing.JButton();
        h4 = new javax.swing.JButton();
        f4 = new javax.swing.JButton();
        i4 = new javax.swing.JButton();
        f5 = new javax.swing.JButton();
        g5 = new javax.swing.JButton();
        i5 = new javax.swing.JButton();
        h5 = new javax.swing.JButton();
        e5 = new javax.swing.JButton();
        d5 = new javax.swing.JButton();
        j5 = new javax.swing.JButton();
        b5 = new javax.swing.JButton();
        c5 = new javax.swing.JButton();
        i6 = new javax.swing.JButton();
        g6 = new javax.swing.JButton();
        f6 = new javax.swing.JButton();
        d6 = new javax.swing.JButton();
        h6 = new javax.swing.JButton();
        b6 = new javax.swing.JButton();
        j6 = new javax.swing.JButton();
        e6 = new javax.swing.JButton();
        c6 = new javax.swing.JButton();
        j7 = new javax.swing.JButton();
        h7 = new javax.swing.JButton();
        g7 = new javax.swing.JButton();
        e7 = new javax.swing.JButton();
        b7 = new javax.swing.JButton();
        i7 = new javax.swing.JButton();
        d7 = new javax.swing.JButton();
        c7 = new javax.swing.JButton();
        f7 = new javax.swing.JButton();
        d8 = new javax.swing.JButton();
        c8 = new javax.swing.JButton();
        f8 = new javax.swing.JButton();
        j8 = new javax.swing.JButton();
        h8 = new javax.swing.JButton();
        g8 = new javax.swing.JButton();
        e8 = new javax.swing.JButton();
        b8 = new javax.swing.JButton();
        i8 = new javax.swing.JButton();
        g9 = new javax.swing.JButton();
        c9 = new javax.swing.JButton();
        f9 = new javax.swing.JButton();
        j9 = new javax.swing.JButton();
        b9 = new javax.swing.JButton();
        h9 = new javax.swing.JButton();
        e9 = new javax.swing.JButton();
        d9 = new javax.swing.JButton();
        i9 = new javax.swing.JButton();
        e10 = new javax.swing.JButton();
        c10 = new javax.swing.JButton();
        d10 = new javax.swing.JButton();
        i10 = new javax.swing.JButton();
        j10 = new javax.swing.JButton();
        b10 = new javax.swing.JButton();
        f10 = new javax.swing.JButton();
        g10 = new javax.swing.JButton();
        h10 = new javax.swing.JButton();
        line1 = new javax.swing.JLabel();
        alphabethLine = new javax.swing.JLabel();
        row3 = new javax.swing.JLabel();
        row4 = new javax.swing.JLabel();
        row5 = new javax.swing.JLabel();
        row6 = new javax.swing.JLabel();
        row7 = new javax.swing.JLabel();
        row1 = new javax.swing.JLabel();
        row8 = new javax.swing.JLabel();
        row9 = new javax.swing.JLabel();
        row10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        a1.setMaximumSize(new java.awt.Dimension(50, 50));
        a1.setMinimumSize(new java.awt.Dimension(50, 50));
        a1.setName("a1"); // NOI18N
        a1.setPreferredSize(new java.awt.Dimension(20, 20));
        a1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        a2.setMaximumSize(new java.awt.Dimension(50, 50));
        a2.setMinimumSize(new java.awt.Dimension(50, 50));
        a2.setName("a2"); // NOI18N
        a2.setPreferredSize(new java.awt.Dimension(20, 20));
        a2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        a3.setMaximumSize(new java.awt.Dimension(50, 50));
        a3.setMinimumSize(new java.awt.Dimension(50, 50));
        a3.setName("a3"); // NOI18N
        a3.setPreferredSize(new java.awt.Dimension(20, 20));
        a3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        a4.setMaximumSize(new java.awt.Dimension(50, 50));
        a4.setMinimumSize(new java.awt.Dimension(50, 50));
        a4.setName("a4"); // NOI18N
        a4.setPreferredSize(new java.awt.Dimension(20, 20));
        a4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        a5.setMaximumSize(new java.awt.Dimension(50, 50));
        a5.setMinimumSize(new java.awt.Dimension(50, 50));
        a5.setName("a5"); // NOI18N
        a5.setPreferredSize(new java.awt.Dimension(20, 20));
        a5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        a6.setMaximumSize(new java.awt.Dimension(50, 50));
        a6.setMinimumSize(new java.awt.Dimension(50, 50));
        a6.setName("a6"); // NOI18N
        a6.setPreferredSize(new java.awt.Dimension(20, 20));
        a6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        a7.setMaximumSize(new java.awt.Dimension(50, 50));
        a7.setMinimumSize(new java.awt.Dimension(50, 50));
        a7.setName("a7"); // NOI18N
        a7.setPreferredSize(new java.awt.Dimension(20, 20));
        a7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        a8.setMaximumSize(new java.awt.Dimension(50, 50));
        a8.setMinimumSize(new java.awt.Dimension(50, 50));
        a8.setName("a8"); // NOI18N
        a8.setPreferredSize(new java.awt.Dimension(20, 20));
        a8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        a9.setMaximumSize(new java.awt.Dimension(50, 50));
        a9.setMinimumSize(new java.awt.Dimension(50, 50));
        a9.setName("a9"); // NOI18N
        a9.setPreferredSize(new java.awt.Dimension(20, 20));
        a9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        a10.setMaximumSize(new java.awt.Dimension(50, 50));
        a10.setMinimumSize(new java.awt.Dimension(50, 50));
        a10.setName("a10"); // NOI18N
        a10.setPreferredSize(new java.awt.Dimension(20, 20));
        a10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        b1.setMaximumSize(new java.awt.Dimension(50, 50));
        b1.setMinimumSize(new java.awt.Dimension(50, 50));
        b1.setName("b1"); // NOI18N
        b1.setPreferredSize(new java.awt.Dimension(20, 20));
        b1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        c1.setMaximumSize(new java.awt.Dimension(50, 50));
        c1.setMinimumSize(new java.awt.Dimension(50, 50));
        c1.setName("c1"); // NOI18N
        c1.setPreferredSize(new java.awt.Dimension(20, 20));
        c1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        d1.setMaximumSize(new java.awt.Dimension(50, 50));
        d1.setMinimumSize(new java.awt.Dimension(50, 50));
        d1.setName("d1"); // NOI18N
        d1.setPreferredSize(new java.awt.Dimension(20, 20));
        d1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        e1.setMaximumSize(new java.awt.Dimension(50, 50));
        e1.setMinimumSize(new java.awt.Dimension(50, 50));
        e1.setName("e1"); // NOI18N
        e1.setPreferredSize(new java.awt.Dimension(20, 20));
        e1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        f1.setMaximumSize(new java.awt.Dimension(50, 50));
        f1.setMinimumSize(new java.awt.Dimension(50, 50));
        f1.setName("f1"); // NOI18N
        f1.setPreferredSize(new java.awt.Dimension(20, 20));
        f1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        g1.setMaximumSize(new java.awt.Dimension(50, 50));
        g1.setMinimumSize(new java.awt.Dimension(50, 50));
        g1.setName("g1"); // NOI18N
        g1.setPreferredSize(new java.awt.Dimension(20, 20));
        g1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        h1.setMaximumSize(new java.awt.Dimension(50, 50));
        h1.setMinimumSize(new java.awt.Dimension(50, 50));
        h1.setName("h1"); // NOI18N
        h1.setPreferredSize(new java.awt.Dimension(20, 20));
        h1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        i1.setMaximumSize(new java.awt.Dimension(50, 50));
        i1.setMinimumSize(new java.awt.Dimension(50, 50));
        i1.setName("i1"); // NOI18N
        i1.setPreferredSize(new java.awt.Dimension(20, 20));
        i1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        j1.setMaximumSize(new java.awt.Dimension(50, 50));
        j1.setMinimumSize(new java.awt.Dimension(50, 50));
        j1.setName("j1"); // NOI18N
        j1.setPreferredSize(new java.awt.Dimension(20, 20));
        j1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        c2.setMaximumSize(new java.awt.Dimension(50, 50));
        c2.setMinimumSize(new java.awt.Dimension(50, 50));
        c2.setName("c2"); // NOI18N
        c2.setPreferredSize(new java.awt.Dimension(20, 20));
        c2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        f2.setMaximumSize(new java.awt.Dimension(50, 50));
        f2.setMinimumSize(new java.awt.Dimension(50, 50));
        f2.setName("f2"); // NOI18N
        f2.setPreferredSize(new java.awt.Dimension(20, 20));
        f2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        d2.setMaximumSize(new java.awt.Dimension(50, 50));
        d2.setMinimumSize(new java.awt.Dimension(50, 50));
        d2.setName("d2"); // NOI18N
        d2.setPreferredSize(new java.awt.Dimension(20, 20));
        d2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        e2.setMaximumSize(new java.awt.Dimension(50, 50));
        e2.setMinimumSize(new java.awt.Dimension(50, 50));
        e2.setName("e2"); // NOI18N
        e2.setPreferredSize(new java.awt.Dimension(20, 20));
        e2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        j2.setMaximumSize(new java.awt.Dimension(50, 50));
        j2.setMinimumSize(new java.awt.Dimension(50, 50));
        j2.setName("j2"); // NOI18N
        j2.setPreferredSize(new java.awt.Dimension(20, 20));
        j2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        g2.setMaximumSize(new java.awt.Dimension(50, 50));
        g2.setMinimumSize(new java.awt.Dimension(50, 50));
        g2.setName("g2"); // NOI18N
        g2.setPreferredSize(new java.awt.Dimension(20, 20));
        g2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        h2.setMaximumSize(new java.awt.Dimension(50, 50));
        h2.setMinimumSize(new java.awt.Dimension(50, 50));
        h2.setName("h2"); // NOI18N
        h2.setPreferredSize(new java.awt.Dimension(20, 20));
        h2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        i2.setMaximumSize(new java.awt.Dimension(50, 50));
        i2.setMinimumSize(new java.awt.Dimension(50, 50));
        i2.setName("i2"); // NOI18N
        i2.setPreferredSize(new java.awt.Dimension(20, 20));
        i2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        b2.setMaximumSize(new java.awt.Dimension(50, 50));
        b2.setMinimumSize(new java.awt.Dimension(50, 50));
        b2.setName("b2"); // NOI18N
        b2.setPreferredSize(new java.awt.Dimension(20, 20));
        b2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        j3.setMaximumSize(new java.awt.Dimension(50, 50));
        j3.setMinimumSize(new java.awt.Dimension(50, 50));
        j3.setName("j3"); // NOI18N
        j3.setPreferredSize(new java.awt.Dimension(20, 20));
        j3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        f3.setMaximumSize(new java.awt.Dimension(50, 50));
        f3.setMinimumSize(new java.awt.Dimension(50, 50));
        f3.setName("f3"); // NOI18N
        f3.setPreferredSize(new java.awt.Dimension(20, 20));
        f3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        e3.setMaximumSize(new java.awt.Dimension(50, 50));
        e3.setMinimumSize(new java.awt.Dimension(50, 50));
        e3.setName("e3"); // NOI18N
        e3.setPreferredSize(new java.awt.Dimension(20, 20));
        e3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        g3.setMaximumSize(new java.awt.Dimension(50, 50));
        g3.setMinimumSize(new java.awt.Dimension(50, 50));
        g3.setName("g3"); // NOI18N
        g3.setPreferredSize(new java.awt.Dimension(20, 20));
        g3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        i3.setMaximumSize(new java.awt.Dimension(50, 50));
        i3.setMinimumSize(new java.awt.Dimension(50, 50));
        i3.setName("i3"); // NOI18N
        i3.setPreferredSize(new java.awt.Dimension(20, 20));
        i3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        h3.setMaximumSize(new java.awt.Dimension(50, 50));
        h3.setMinimumSize(new java.awt.Dimension(50, 50));
        h3.setName("h3"); // NOI18N
        h3.setPreferredSize(new java.awt.Dimension(20, 20));
        h3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        b3.setMaximumSize(new java.awt.Dimension(50, 50));
        b3.setMinimumSize(new java.awt.Dimension(50, 50));
        b3.setName("b3"); // NOI18N
        b3.setPreferredSize(new java.awt.Dimension(20, 20));
        b3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        d3.setMaximumSize(new java.awt.Dimension(50, 50));
        d3.setMinimumSize(new java.awt.Dimension(50, 50));
        d3.setName("d3"); // NOI18N
        d3.setPreferredSize(new java.awt.Dimension(20, 20));
        d3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        c3.setMaximumSize(new java.awt.Dimension(50, 50));
        c3.setMinimumSize(new java.awt.Dimension(50, 50));
        c3.setName("c3"); // NOI18N
        c3.setPreferredSize(new java.awt.Dimension(20, 20));
        c3.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        d4.setMaximumSize(new java.awt.Dimension(50, 50));
        d4.setMinimumSize(new java.awt.Dimension(50, 50));
        d4.setName("d4"); // NOI18N
        d4.setPreferredSize(new java.awt.Dimension(20, 20));
        d4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        c4.setMaximumSize(new java.awt.Dimension(50, 50));
        c4.setMinimumSize(new java.awt.Dimension(50, 50));
        c4.setName("c4"); // NOI18N
        c4.setPreferredSize(new java.awt.Dimension(20, 20));
        c4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        g4.setMaximumSize(new java.awt.Dimension(50, 50));
        g4.setMinimumSize(new java.awt.Dimension(50, 50));
        g4.setName("g4"); // NOI18N
        g4.setPreferredSize(new java.awt.Dimension(20, 20));
        g4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        j4.setMaximumSize(new java.awt.Dimension(50, 50));
        j4.setMinimumSize(new java.awt.Dimension(50, 50));
        j4.setName("j4"); // NOI18N
        j4.setPreferredSize(new java.awt.Dimension(20, 20));
        j4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        e4.setMaximumSize(new java.awt.Dimension(50, 50));
        e4.setMinimumSize(new java.awt.Dimension(50, 50));
        e4.setName("e4"); // NOI18N
        e4.setPreferredSize(new java.awt.Dimension(20, 20));
        e4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        b4.setMaximumSize(new java.awt.Dimension(50, 50));
        b4.setMinimumSize(new java.awt.Dimension(50, 50));
        b4.setName("b4"); // NOI18N
        b4.setPreferredSize(new java.awt.Dimension(20, 20));
        b4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        h4.setMaximumSize(new java.awt.Dimension(50, 50));
        h4.setMinimumSize(new java.awt.Dimension(50, 50));
        h4.setName("h4"); // NOI18N
        h4.setPreferredSize(new java.awt.Dimension(20, 20));
        h4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        f4.setMaximumSize(new java.awt.Dimension(50, 50));
        f4.setMinimumSize(new java.awt.Dimension(50, 50));
        f4.setName("f4"); // NOI18N
        f4.setPreferredSize(new java.awt.Dimension(20, 20));
        f4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        i4.setMaximumSize(new java.awt.Dimension(50, 50));
        i4.setMinimumSize(new java.awt.Dimension(50, 50));
        i4.setName("i4"); // NOI18N
        i4.setPreferredSize(new java.awt.Dimension(20, 20));
        i4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        f5.setMaximumSize(new java.awt.Dimension(50, 50));
        f5.setMinimumSize(new java.awt.Dimension(50, 50));
        f5.setName("f5"); // NOI18N
        f5.setPreferredSize(new java.awt.Dimension(20, 20));
        f5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        g5.setMaximumSize(new java.awt.Dimension(50, 50));
        g5.setMinimumSize(new java.awt.Dimension(50, 50));
        g5.setName("g5"); // NOI18N
        g5.setPreferredSize(new java.awt.Dimension(20, 20));
        g5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        i5.setMaximumSize(new java.awt.Dimension(50, 50));
        i5.setMinimumSize(new java.awt.Dimension(50, 50));
        i5.setName("i5"); // NOI18N
        i5.setPreferredSize(new java.awt.Dimension(20, 20));
        i5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        h5.setMaximumSize(new java.awt.Dimension(50, 50));
        h5.setMinimumSize(new java.awt.Dimension(50, 50));
        h5.setName("h5"); // NOI18N
        h5.setPreferredSize(new java.awt.Dimension(20, 20));
        h5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        e5.setMaximumSize(new java.awt.Dimension(50, 50));
        e5.setMinimumSize(new java.awt.Dimension(50, 50));
        e5.setName("e5"); // NOI18N
        e5.setPreferredSize(new java.awt.Dimension(20, 20));
        e5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        d5.setMaximumSize(new java.awt.Dimension(50, 50));
        d5.setMinimumSize(new java.awt.Dimension(50, 50));
        d5.setName("d5"); // NOI18N
        d5.setPreferredSize(new java.awt.Dimension(20, 20));
        d5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        j5.setMaximumSize(new java.awt.Dimension(50, 50));
        j5.setMinimumSize(new java.awt.Dimension(50, 50));
        j5.setName("j5"); // NOI18N
        j5.setPreferredSize(new java.awt.Dimension(20, 20));
        j5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        b5.setMaximumSize(new java.awt.Dimension(50, 50));
        b5.setMinimumSize(new java.awt.Dimension(50, 50));
        b5.setName("b5"); // NOI18N
        b5.setPreferredSize(new java.awt.Dimension(20, 20));
        b5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        c5.setMaximumSize(new java.awt.Dimension(50, 50));
        c5.setMinimumSize(new java.awt.Dimension(50, 50));
        c5.setName("c5"); // NOI18N
        c5.setPreferredSize(new java.awt.Dimension(20, 20));
        c5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        i6.setMaximumSize(new java.awt.Dimension(50, 50));
        i6.setMinimumSize(new java.awt.Dimension(50, 50));
        i6.setName("i6"); // NOI18N
        i6.setPreferredSize(new java.awt.Dimension(20, 20));
        i6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        g6.setMaximumSize(new java.awt.Dimension(50, 50));
        g6.setMinimumSize(new java.awt.Dimension(50, 50));
        g6.setName("g6"); // NOI18N
        g6.setPreferredSize(new java.awt.Dimension(20, 20));
        g6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        f6.setMaximumSize(new java.awt.Dimension(50, 50));
        f6.setMinimumSize(new java.awt.Dimension(50, 50));
        f6.setName("f6"); // NOI18N
        f6.setPreferredSize(new java.awt.Dimension(20, 20));
        f6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        d6.setMaximumSize(new java.awt.Dimension(50, 50));
        d6.setMinimumSize(new java.awt.Dimension(50, 50));
        d6.setName("d6"); // NOI18N
        d6.setPreferredSize(new java.awt.Dimension(20, 20));
        d6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        h6.setMaximumSize(new java.awt.Dimension(50, 50));
        h6.setMinimumSize(new java.awt.Dimension(50, 50));
        h6.setName("h6"); // NOI18N
        h6.setPreferredSize(new java.awt.Dimension(20, 20));
        h6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        b6.setMaximumSize(new java.awt.Dimension(50, 50));
        b6.setMinimumSize(new java.awt.Dimension(50, 50));
        b6.setName("b6"); // NOI18N
        b6.setPreferredSize(new java.awt.Dimension(20, 20));
        b6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        j6.setMaximumSize(new java.awt.Dimension(50, 50));
        j6.setMinimumSize(new java.awt.Dimension(50, 50));
        j6.setName("j6"); // NOI18N
        j6.setPreferredSize(new java.awt.Dimension(20, 20));
        j6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        e6.setMaximumSize(new java.awt.Dimension(50, 50));
        e6.setMinimumSize(new java.awt.Dimension(50, 50));
        e6.setName("e6"); // NOI18N
        e6.setPreferredSize(new java.awt.Dimension(20, 20));
        e6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        c6.setMaximumSize(new java.awt.Dimension(50, 50));
        c6.setMinimumSize(new java.awt.Dimension(50, 50));
        c6.setName("c6"); // NOI18N
        c6.setPreferredSize(new java.awt.Dimension(20, 20));
        c6.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        j7.setMaximumSize(new java.awt.Dimension(50, 50));
        j7.setMinimumSize(new java.awt.Dimension(50, 50));
        j7.setName("j7"); // NOI18N
        j7.setPreferredSize(new java.awt.Dimension(20, 20));
        j7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        h7.setMaximumSize(new java.awt.Dimension(50, 50));
        h7.setMinimumSize(new java.awt.Dimension(50, 50));
        h7.setName("h7"); // NOI18N
        h7.setPreferredSize(new java.awt.Dimension(20, 20));
        h7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        g7.setMaximumSize(new java.awt.Dimension(50, 50));
        g7.setMinimumSize(new java.awt.Dimension(50, 50));
        g7.setName("g7"); // NOI18N
        g7.setPreferredSize(new java.awt.Dimension(20, 20));
        g7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        e7.setMaximumSize(new java.awt.Dimension(50, 50));
        e7.setMinimumSize(new java.awt.Dimension(50, 50));
        e7.setName("e7"); // NOI18N
        e7.setPreferredSize(new java.awt.Dimension(20, 20));
        e7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        b7.setMaximumSize(new java.awt.Dimension(50, 50));
        b7.setMinimumSize(new java.awt.Dimension(50, 50));
        b7.setName("b7"); // NOI18N
        b7.setPreferredSize(new java.awt.Dimension(20, 20));
        b7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        i7.setMaximumSize(new java.awt.Dimension(50, 50));
        i7.setMinimumSize(new java.awt.Dimension(50, 50));
        i7.setName("i7"); // NOI18N
        i7.setPreferredSize(new java.awt.Dimension(20, 20));
        i7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        d7.setMaximumSize(new java.awt.Dimension(50, 50));
        d7.setMinimumSize(new java.awt.Dimension(50, 50));
        d7.setName("d7"); // NOI18N
        d7.setPreferredSize(new java.awt.Dimension(20, 20));
        d7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        c7.setMaximumSize(new java.awt.Dimension(50, 50));
        c7.setMinimumSize(new java.awt.Dimension(50, 50));
        c7.setName("c7"); // NOI18N
        c7.setPreferredSize(new java.awt.Dimension(20, 20));
        c7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        f7.setMaximumSize(new java.awt.Dimension(50, 50));
        f7.setMinimumSize(new java.awt.Dimension(50, 50));
        f7.setName("f7"); // NOI18N
        f7.setPreferredSize(new java.awt.Dimension(20, 20));
        f7.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        d8.setMaximumSize(new java.awt.Dimension(50, 50));
        d8.setMinimumSize(new java.awt.Dimension(50, 50));
        d8.setName("d8"); // NOI18N
        d8.setPreferredSize(new java.awt.Dimension(20, 20));
        d8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        c8.setMaximumSize(new java.awt.Dimension(50, 50));
        c8.setMinimumSize(new java.awt.Dimension(50, 50));
        c8.setName("c8"); // NOI18N
        c8.setPreferredSize(new java.awt.Dimension(20, 20));
        c8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        f8.setMaximumSize(new java.awt.Dimension(50, 50));
        f8.setMinimumSize(new java.awt.Dimension(50, 50));
        f8.setName("f8"); // NOI18N
        f8.setPreferredSize(new java.awt.Dimension(20, 20));
        f8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        j8.setMaximumSize(new java.awt.Dimension(50, 50));
        j8.setMinimumSize(new java.awt.Dimension(50, 50));
        j8.setName("j8"); // NOI18N
        j8.setPreferredSize(new java.awt.Dimension(20, 20));
        j8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        h8.setMaximumSize(new java.awt.Dimension(50, 50));
        h8.setMinimumSize(new java.awt.Dimension(50, 50));
        h8.setName("h8"); // NOI18N
        h8.setPreferredSize(new java.awt.Dimension(20, 20));
        h8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        g8.setMaximumSize(new java.awt.Dimension(50, 50));
        g8.setMinimumSize(new java.awt.Dimension(50, 50));
        g8.setName("g8"); // NOI18N
        g8.setPreferredSize(new java.awt.Dimension(20, 20));
        g8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        e8.setMaximumSize(new java.awt.Dimension(50, 50));
        e8.setMinimumSize(new java.awt.Dimension(50, 50));
        e8.setName("e8"); // NOI18N
        e8.setPreferredSize(new java.awt.Dimension(20, 20));
        e8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        b8.setMaximumSize(new java.awt.Dimension(50, 50));
        b8.setMinimumSize(new java.awt.Dimension(50, 50));
        b8.setName("b8"); // NOI18N
        b8.setPreferredSize(new java.awt.Dimension(20, 20));
        b8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        i8.setMaximumSize(new java.awt.Dimension(50, 50));
        i8.setMinimumSize(new java.awt.Dimension(50, 50));
        i8.setName("i8"); // NOI18N
        i8.setPreferredSize(new java.awt.Dimension(20, 20));
        i8.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        g9.setMaximumSize(new java.awt.Dimension(50, 50));
        g9.setMinimumSize(new java.awt.Dimension(50, 50));
        g9.setName("g9"); // NOI18N
        g9.setPreferredSize(new java.awt.Dimension(20, 20));
        g9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        c9.setMaximumSize(new java.awt.Dimension(50, 50));
        c9.setMinimumSize(new java.awt.Dimension(50, 50));
        c9.setName("c9"); // NOI18N
        c9.setPreferredSize(new java.awt.Dimension(20, 20));
        c9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        f9.setMaximumSize(new java.awt.Dimension(50, 50));
        f9.setMinimumSize(new java.awt.Dimension(50, 50));
        f9.setName("f9"); // NOI18N
        f9.setPreferredSize(new java.awt.Dimension(20, 20));
        f9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        j9.setMaximumSize(new java.awt.Dimension(50, 50));
        j9.setMinimumSize(new java.awt.Dimension(50, 50));
        j9.setName("j9"); // NOI18N
        j9.setPreferredSize(new java.awt.Dimension(20, 20));
        j9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        b9.setMaximumSize(new java.awt.Dimension(50, 50));
        b9.setMinimumSize(new java.awt.Dimension(50, 50));
        b9.setName("b9"); // NOI18N
        b9.setPreferredSize(new java.awt.Dimension(20, 20));
        b9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        h9.setMaximumSize(new java.awt.Dimension(50, 50));
        h9.setMinimumSize(new java.awt.Dimension(50, 50));
        h9.setName("h9"); // NOI18N
        h9.setPreferredSize(new java.awt.Dimension(20, 20));
        h9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        e9.setMaximumSize(new java.awt.Dimension(50, 50));
        e9.setMinimumSize(new java.awt.Dimension(50, 50));
        e9.setName("e9"); // NOI18N
        e9.setPreferredSize(new java.awt.Dimension(20, 20));
        e9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        d9.setMaximumSize(new java.awt.Dimension(50, 50));
        d9.setMinimumSize(new java.awt.Dimension(50, 50));
        d9.setName("d9"); // NOI18N
        d9.setPreferredSize(new java.awt.Dimension(20, 20));
        d9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        i9.setMaximumSize(new java.awt.Dimension(50, 50));
        i9.setMinimumSize(new java.awt.Dimension(50, 50));
        i9.setName("i9"); // NOI18N
        i9.setPreferredSize(new java.awt.Dimension(20, 20));
        i9.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        e10.setMaximumSize(new java.awt.Dimension(50, 50));
        e10.setMinimumSize(new java.awt.Dimension(50, 50));
        e10.setName("e10"); // NOI18N
        e10.setPreferredSize(new java.awt.Dimension(20, 20));
        e10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        c10.setMaximumSize(new java.awt.Dimension(50, 50));
        c10.setMinimumSize(new java.awt.Dimension(50, 50));
        c10.setName("c10"); // NOI18N
        c10.setPreferredSize(new java.awt.Dimension(20, 20));
        c10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        d10.setMaximumSize(new java.awt.Dimension(50, 50));
        d10.setMinimumSize(new java.awt.Dimension(50, 50));
        d10.setName("d10"); // NOI18N
        d10.setPreferredSize(new java.awt.Dimension(20, 20));
        d10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        i10.setMaximumSize(new java.awt.Dimension(50, 50));
        i10.setMinimumSize(new java.awt.Dimension(50, 50));
        i10.setName("i10"); // NOI18N
        i10.setPreferredSize(new java.awt.Dimension(20, 20));
        i10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        j10.setMaximumSize(new java.awt.Dimension(50, 50));
        j10.setMinimumSize(new java.awt.Dimension(50, 50));
        j10.setName("j10"); // NOI18N
        j10.setPreferredSize(new java.awt.Dimension(20, 20));
        j10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        b10.setMaximumSize(new java.awt.Dimension(50, 50));
        b10.setMinimumSize(new java.awt.Dimension(50, 50));
        b10.setName("b10"); // NOI18N
        b10.setPreferredSize(new java.awt.Dimension(20, 20));
        b10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        f10.setMaximumSize(new java.awt.Dimension(50, 50));
        f10.setMinimumSize(new java.awt.Dimension(50, 50));
        f10.setName("f10"); // NOI18N
        f10.setPreferredSize(new java.awt.Dimension(20, 20));
        f10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        g10.setMaximumSize(new java.awt.Dimension(50, 50));
        g10.setMinimumSize(new java.awt.Dimension(50, 50));
        g10.setName("g10"); // NOI18N
        g10.setPreferredSize(new java.awt.Dimension(20, 20));
        g10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        h10.setMaximumSize(new java.awt.Dimension(50, 50));
        h10.setMinimumSize(new java.awt.Dimension(50, 50));
        h10.setName("h10"); // NOI18N
        h10.setPreferredSize(new java.awt.Dimension(20, 20));
        h10.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        line1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        line1.setText("2");

        alphabethLine.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        alphabethLine.setText(" A    B    C    D    E    F    G   H    I     J ");

        row3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        row3.setText("3");

        row4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        row4.setText("4");

        row5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        row5.setText("5");

        row6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        row6.setText("6");

        row7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        row7.setText("7");

        row1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        row1.setText("1");

        row8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        row8.setText("8");

        row9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        row9.setText("9");

        row10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        row10.setText("10");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(row3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(line1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(row4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(row5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(row6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(row7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(row1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(row8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(row9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(row10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(a10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(b10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(c10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(f1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(f2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(f3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(f4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(d5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(f5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(d6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(f6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(d7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(f7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(d8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(f8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(d9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(f9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(d10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(e10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(f10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(h10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(i10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(j10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13))
                    .addComponent(alphabethLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(row10))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(alphabethLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(i1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(g1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(j1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(h1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(a1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(c1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(b1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(d1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(f1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(e1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(row1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(i2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(g2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(j2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(h2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(a2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(c2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(b2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(d2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(f2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(e2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                            .addComponent(line1))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(i3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(g3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(j3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(h3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(a3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(c3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(b3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(d3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(f3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(e3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                            .addComponent(row3))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(i4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(g4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(j4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(h4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(a4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(c4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(b4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(d4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(f4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(e4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                    .addComponent(row4))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(i5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(g5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(j5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(h5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(a5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(c5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(b5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(d5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(f5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(e5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addComponent(row5))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(i6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(g6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(j6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(h6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(a6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(c6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(b6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(d6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(f6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(e6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addComponent(row6))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(i7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(g7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(j7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(h7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(a7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(c7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(b7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(d7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(f7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(e7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(row7))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(i8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(g8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(j8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(h8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(a8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(c8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(b8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(d8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(f8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(e8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(row8))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(i9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(g9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(j9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(h9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(a9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(c9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(b9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(d9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(f9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(e9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(row9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(i10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(g10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(j10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(h10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(a10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(c10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(d10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(f10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(e10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodi joka käynnistää Game käyttöliittymän.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Game(gameField).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton a1;
    private javax.swing.JButton a10;
    private javax.swing.JButton a2;
    private javax.swing.JButton a3;
    private javax.swing.JButton a4;
    private javax.swing.JButton a5;
    private javax.swing.JButton a6;
    private javax.swing.JButton a7;
    private javax.swing.JButton a8;
    private javax.swing.JButton a9;
    private javax.swing.JLabel alphabethLine;
    private javax.swing.JButton b1;
    private javax.swing.JButton b10;
    private javax.swing.JButton b2;
    private javax.swing.JButton b3;
    private javax.swing.JButton b4;
    private javax.swing.JButton b5;
    private javax.swing.JButton b6;
    private javax.swing.JButton b7;
    private javax.swing.JButton b8;
    private javax.swing.JButton b9;
    private javax.swing.JButton c1;
    private javax.swing.JButton c10;
    private javax.swing.JButton c2;
    private javax.swing.JButton c3;
    private javax.swing.JButton c4;
    private javax.swing.JButton c5;
    private javax.swing.JButton c6;
    private javax.swing.JButton c7;
    private javax.swing.JButton c8;
    private javax.swing.JButton c9;
    private javax.swing.JButton d1;
    private javax.swing.JButton d10;
    private javax.swing.JButton d2;
    private javax.swing.JButton d3;
    private javax.swing.JButton d4;
    private javax.swing.JButton d5;
    private javax.swing.JButton d6;
    private javax.swing.JButton d7;
    private javax.swing.JButton d8;
    private javax.swing.JButton d9;
    private javax.swing.JButton e1;
    private javax.swing.JButton e10;
    private javax.swing.JButton e2;
    private javax.swing.JButton e3;
    private javax.swing.JButton e4;
    private javax.swing.JButton e5;
    private javax.swing.JButton e6;
    private javax.swing.JButton e7;
    private javax.swing.JButton e8;
    private javax.swing.JButton e9;
    private javax.swing.JButton f1;
    private javax.swing.JButton f10;
    private javax.swing.JButton f2;
    private javax.swing.JButton f3;
    private javax.swing.JButton f4;
    private javax.swing.JButton f5;
    private javax.swing.JButton f6;
    private javax.swing.JButton f7;
    private javax.swing.JButton f8;
    private javax.swing.JButton f9;
    private javax.swing.JButton g1;
    private javax.swing.JButton g10;
    private javax.swing.JButton g2;
    private javax.swing.JButton g3;
    private javax.swing.JButton g4;
    private javax.swing.JButton g5;
    private javax.swing.JButton g6;
    private javax.swing.JButton g7;
    private javax.swing.JButton g8;
    private javax.swing.JButton g9;
    private javax.swing.JButton h1;
    private javax.swing.JButton h10;
    private javax.swing.JButton h2;
    private javax.swing.JButton h3;
    private javax.swing.JButton h4;
    private javax.swing.JButton h5;
    private javax.swing.JButton h6;
    private javax.swing.JButton h7;
    private javax.swing.JButton h8;
    private javax.swing.JButton h9;
    private javax.swing.JButton i1;
    private javax.swing.JButton i10;
    private javax.swing.JButton i2;
    private javax.swing.JButton i3;
    private javax.swing.JButton i4;
    private javax.swing.JButton i5;
    private javax.swing.JButton i6;
    private javax.swing.JButton i7;
    private javax.swing.JButton i8;
    private javax.swing.JButton i9;
    private javax.swing.JButton j1;
    private javax.swing.JButton j10;
    private javax.swing.JButton j2;
    private javax.swing.JButton j3;
    private javax.swing.JButton j4;
    private javax.swing.JButton j5;
    private javax.swing.JButton j6;
    private javax.swing.JButton j7;
    private javax.swing.JButton j8;
    private javax.swing.JButton j9;
    private javax.swing.JLabel line1;
    private javax.swing.JLabel row1;
    private javax.swing.JLabel row10;
    private javax.swing.JLabel row3;
    private javax.swing.JLabel row4;
    private javax.swing.JLabel row5;
    private javax.swing.JLabel row6;
    private javax.swing.JLabel row7;
    private javax.swing.JLabel row8;
    private javax.swing.JLabel row9;
    // End of variables declaration//GEN-END:variables

}
