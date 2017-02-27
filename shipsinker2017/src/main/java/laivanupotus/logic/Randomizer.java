/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logic;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import laivanupotus.gui.Game;

/**
 * Tarjoaa laivojen automaattisen asetteluun liittyviä metodeja.
 */
public class Randomizer {

    private Game gui;
    private GameField gameField;
    private int xStart, xEnd, yStart, yEnd;

    public int spaceLeft = 100;
    public ArrayList<String> inUse = new ArrayList<>();

    /**
     * Luokka tarjoaa automaattiseen laivansijoitteluun tarvittavia metodeja.
     *
     * @param gui Main metodin antama parametri
     * @param gameField Main metodin antama parametri
     */
    public Randomizer(Game gui, GameField gameField) {
        this.gui = gui;
        this.gameField = gameField;
    }

    /**
     * Luo satunnaisesti uuden laivan ja lisää sen käyttöliittymään.
     *
     * @param size Main metodin antama parametri
     */
    public void createShip(int size) { //Size 45

        ArrayList coordinates = new ArrayList<>(); //Ship1

        xStart = 0;
        yStart = 0;
        yEnd = 9 - size;
        xEnd = 9 - size;

        int randomX = ThreadLocalRandom.current().nextInt(xStart, xEnd);
        int randomY = ThreadLocalRandom.current().nextInt(yStart, yEnd);

        String xKirjain = getCoordinateChar(randomX);

        while (inUse.contains(xKirjain + randomY)) {
            randomY = ThreadLocalRandom.current().nextInt(yStart, yEnd);
            randomX = ThreadLocalRandom.current().nextInt(xStart, xEnd);
            xKirjain = getCoordinateChar(randomX);
        }

        String koordinaatti = "";
        for (int i = 0; i < size; i++) {
            spaceLeft--;
            randomY++;
            coordinates.add(xKirjain + randomY);
            inUse.add(xKirjain + randomY);
            lisaaViereisetPoisKaytosta(xKirjain + randomY);
        }

        Ship ship1 = new Ship(coordinates, coordinates.size());
        gui.addShipToGui(ship1);

    }

    /**
     * Muuttaa numeron koordinaattia vastaavaksi kirjaimeksi.
     *
     * @param numero Sovelluksen antama parametri.
     * @return String
     */
    public String getCoordinateChar(int numero) {
        switch (numero) {
            case 0:
                return "a";
            case 1:
                return "b";
            case 2:
                return "c";
            case 3:
                return "d";
            case 4:
                return "e";
            case 5:
                return "f";
            case 6:
                return "g";
            case 7:
                return "h";
            case 8:
                return "i";
            case 9:
                return "j";
        }

        return "bad number";
    }

    /**
     * Pyrkii poistamaan ruudun kaikki viereisetkin ruudut pois käytöstä. (Ei
     * toimi vielä oikein)!
     *
     * @param koordinaatti Sovelluksen antama parametri.
     */
    public void lisaaViereisetPoisKaytosta(String koordinaatti) {
        char[] toCharArray = koordinaatti.toCharArray();
        char x = toCharArray[0];
        String y = toCharArray[1] + "";

        int parseInt = Integer.parseInt(y);

        inUse.add(x + "" + parseInt++);
        parseInt--;
        inUse.add(x + "" + parseInt--);

        char originalX = x;
        x = getRight(x);

        inUse.add(x + y);

        x = getLeft(x);

        inUse.add(x + y);
    }

    /**
     * Hakee kirjaimen perusteella oikeanpuoleisen kirjaimen.
     *
     * @param c Sovelluksen antama parametri.
     * @return char
     */
    public char getRight(char c) {
        switch (c) {
            case 'a':
                return 'b';
            case 'b':
                return 'c';
            case 'c':
                return 'd';
            case 'd':
                return 'e';
            case 'e':
                return 'f';
            case 'f':
                return 'g';
            case 'g':
                return 'h';
            case 'h':
                return 'i';
            case 'i':
                return 'j';
            case 'j':
                return 'j';

        }
        return 'x';
    }

    /**
     * Hakee kirjaimen perusteella vasemmanpuoleisen kirjaimen.
     *
     * @param c Sovelluksen antama parametri.
     * @return char
     */
    public char getLeft(char c) {
        switch (c) {
            case 'a':
                return 'a';
            case 'b':
                return 'a';
            case 'c':
                return 'b';
            case 'd':
                return 'c';
            case 'e':
                return 'd';
            case 'f':
                return 'e';
            case 'g':
                return 'f';
            case 'h':
                return 'g';
            case 'i':
                return 'h';
            case 'j':
                return 'i';

        }
        return 'x';
    }

}
