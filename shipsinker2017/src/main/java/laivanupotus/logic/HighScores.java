/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.logic;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Marko
 */
public class HighScores {

    private static final String FILENAME = "highscores.txt";
    private int worstTime = 0;
    private int bestTime = 9999;

    public HighScores() throws IOException {

    }

    public ArrayList<String> readHighScores() {

        ArrayList<String> topfive = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {

            String sCurrentLine;

            int counter = 0;
            while ((sCurrentLine = br.readLine()) != null) {

                if (counter < 5) {
                    topfive.add(sCurrentLine);
                    counter++;
                }

                System.out.println(sCurrentLine);
                String[] split = sCurrentLine.split(":");

                if (Integer.parseInt(split[1]) > worstTime) {
                    worstTime = Integer.parseInt(split[1]);
                    System.out.println("Updated worst time");
                } else if (Integer.parseInt(split[1]) < bestTime) {
                    bestTime = Integer.parseInt(split[1]);
                    System.out.println("Updated best time");
                }
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return topfive;

    }

    public void addToHighScores(String name, String time) {

        BufferedWriter bw = null;
        FileWriter fw = null;

        try {

            String data = name + ":" + time;

            File file = new File(FILENAME);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // true = append file
            fw = new FileWriter(file.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);

            bw.write(data);
            bw.newLine();

//            System.out.println("Done");
        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (bw != null) {
                    bw.close();
                }

                if (fw != null) {
                    fw.close();
                }

            } catch (IOException ex) {

                ex.printStackTrace();

            }
        }

    }
}
