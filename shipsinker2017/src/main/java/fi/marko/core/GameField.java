/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.marko.core;

import fi.marko.gui.GUI;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Beast
 */
public final class GameField {

    private GUI gui;
    private int shipsLeft = 2;
    private ArrayList<Ship> shipList = new ArrayList<>();

    public GameField(GUI gui) { //10 laivaa kartalla

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
        createTestShips();

    }

    public void createTestShips() {

        ArrayList Ship1Cordinates = new ArrayList<>(); //Ship1
        Ship1Cordinates.add("A1");
        Ship1Cordinates.add("A2");
        Ship1Cordinates.add("A3");
        Ship1Cordinates.add("A4");

        Ship Ship1 = new Ship(Ship1Cordinates, 4);
        shipList.add(Ship1);

        //shipList.get(0).printShipDetails();
        for (Object coordinate : Ship1Cordinates) {
            if (coordinate.equals("A1")) {
                ActionListener A1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        gui.getA1().setBackground(Color.black);
                        gui.getA1().setEnabled(false);
                        Ship1.destroyPart();
                        if (Ship1.isDestroyed()) {
                            shipsLeft -= 1;
                        }
                    }
                };
                gui.getA1().addActionListener(A1);

            }

            if (coordinate.equals("A2")) {
                ActionListener A2 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        gui.getA2().setBackground(Color.black);
                        gui.getA2().setEnabled(false);
                        Ship1.destroyPart();
                        if (Ship1.isDestroyed()) {
                            shipsLeft -= 1;
                        }
                    }
                };
                gui.getA2().addActionListener(A2);

            }

            if (coordinate.equals("A3")) {
                ActionListener A3 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        gui.getA3().setBackground(Color.black);
                        gui.getA3().setEnabled(false);
                        Ship1.destroyPart();
                        if (Ship1.isDestroyed()) {
                            shipsLeft -= 1;
                        }
                    }
                };
                gui.getA3().addActionListener(A3);

            }
            if (coordinate.equals("A4")) {
                ActionListener A4 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        gui.getA4().setBackground(Color.black);
                        gui.getA4().setEnabled(false);
                        Ship1.destroyPart();
                        if (Ship1.isDestroyed()) {
                            shipsLeft -= 1;
                        }
                    }
                };
                gui.getA4().addActionListener(A4);

            }
        }

        ArrayList<String> Ship2Cordinates = new ArrayList<>(); //Ship2
        Ship2Cordinates.add("C1");
        Ship2Cordinates.add("D1");
        Ship2Cordinates.add("E1");
        Ship Ship2 = new Ship(Ship2Cordinates, 3);

        for (String Ship2Cordinate : Ship2Cordinates) {
            if (Ship2Cordinate.equals("C1")) {
                ActionListener C1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        gui.getC1().setBackground(Color.black);
                        gui.getC1().setEnabled(false);
                        Ship2.destroyPart();
                        if (Ship2.isDestroyed()) {
                            shipsLeft -= 1;
                        }
                    }
                };
                gui.getC1().addActionListener(C1);
            }
            
            if (Ship2Cordinate.equals("D1")) {
                ActionListener D1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        gui.getD1().setBackground(Color.black);
                        gui.getD1().setEnabled(false);
                        Ship2.destroyPart();
                        if (Ship2.isDestroyed()) {
                            shipsLeft -= 1;
                        }
                    }
                };
                gui.getD1().addActionListener(D1);
            }
            
            if (Ship2Cordinate.equals("E1")) {
                ActionListener E1 = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        gui.getE1().setBackground(Color.black);
                        gui.getE1().setEnabled(false);
                        Ship2.destroyPart();
                        if (Ship2.isDestroyed()) {
                            shipsLeft -= 1;
                        }
                    }
                };
                gui.getE1().addActionListener(E1);
            }

        }
    }
}
