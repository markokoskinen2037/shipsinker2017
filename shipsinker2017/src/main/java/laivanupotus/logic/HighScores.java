package laivanupotus.logic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Luokka tarjoaa toiminnallisuuden highscores.txt tiedoston luontiin ja
 * lukemiseen.
 *
 */
public class HighScores {

    private static final String FILENAME = "highscores.txt";
    private int worstTime;
    private int bestScore;

    /**
     * Konstruktori alustaa huonoimman ja parhaan ajan.
     */
    public HighScores() {
        worstTime = 0;
        bestScore = 9999;
        updateScores(); //Päivittää huonoimman ja perhaan ajan
        System.out.println("Updating best score. Best score is: " + bestScore);
    }

    /**
     * Metodi lukee highscores.txt tiedostosta 5 riviä ja palauttaa ne
     * ArrayListinä.
     *
     * @return ArrayList
     */
    public ArrayList<String> updateScores() {

        ArrayList<String> topfive = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String sCurrentLine;

            int counter = 0;
            while ((sCurrentLine = br.readLine()) != null) {

                if (counter < 5) {
                    topfive.add(sCurrentLine);
                    counter++;
                }

                String[] split = sCurrentLine.split(":");

                if (Integer.parseInt(split[1]) > worstTime) {
                    worstTime = Integer.parseInt(split[1]);
                } else if (Integer.parseInt(split[1]) < bestScore) {
                    bestScore = Integer.parseInt(split[1]);
                }
            }

            br.close();

        } catch (IOException e) {
//            e.printStackTrace();
        }
        return topfive;

    }

    /**
     * Metodi lisää highscores.txt tiedostoon parametrina saadut tulokset.
     *
     * @param name Käyttäjä antaa oman nimensä käyttöliittymän kautta.
     * @param time GameField tarjoaa peliajan.
     */
    public void updateBestPlayer(String name, String time) {

        if (Integer.parseInt(time) <= this.bestScore) {
            System.out.println("Updating best player");

            BufferedWriter bw = null;
            FileWriter fw = null;

            try {

                String data = name + ":" + time;

                File file = new File(FILENAME);
                file.delete();

                // if file doesnt exists, then create it
                if (!file.exists()) {
                    file.createNewFile();
                }

                // true = append file
                fw = new FileWriter(file.getAbsoluteFile(), true);
                bw = new BufferedWriter(fw);

                bw.write(data);
                bw.newLine();

            } catch (IOException e) {

//            e.printStackTrace();
            } finally {

                try {

                    if (bw != null) {
                        bw.close();
                    }

                    if (fw != null) {
                        fw.close();
                    }

                } catch (IOException ex) {
//                ex.printStackTrace();
                }
            }
        } else {
            System.out.println("Too many turns for highscore, sorry!");
        }

    }

    /**
     * Metodi poistaa vanhan highscore.txt tiedoston.
     */
    public void resetScores() {
        File file = new File(FILENAME);
        file.delete();
    }
}
