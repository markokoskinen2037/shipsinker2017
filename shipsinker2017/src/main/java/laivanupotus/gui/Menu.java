/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laivanupotus.gui;

import java.net.URL;
import java.util.ArrayList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.swing.JOptionPane;
import laivanupotus.logic.GameField;
import laivanupotus.logic.HighScores;
import laivanupotus.logic.Randomizer;
import laivanupotus.logic.Ship;

/**
 *
 * Käyttöliittymä luokka joka näyttää huipputulokset ja tarjoaa mahdollisuuden
 * aloittaa pelin.
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    private HighScores highscores;
    private Game gui;
    private GameField gameField;
    private MediaPlayer player;

    /**
     * Konstruktori alusta highscores olion, alustaa komponentit ja päivittää
     * highscore tilastot.
     *
     * @param highscores Annetaan parametrina Menu olion luomisen yhteydessä.
     * @param gui Annetaan parametrina Menu olion luomisen yhteydessä.
     * @param gameField Annetaan parametrina Menu olion luomisen yhdeydessä.
     */
    public Menu(HighScores highscores, Game gui, GameField gameField, MediaPlayer player) throws InterruptedException {
        this.player = player;
        this.gameField = gameField;
        this.highscores = highscores;
        this.gui = gui;
        initComponents();
        updateHighScores();
        playThemeSong();
    }

    

    private void playThemeSong() {
        try {
            JFXPanel j = new JFXPanel();
            URL url = this.getClass().getResource("/menu.mp3");
            System.out.println(url);
            //String uri = new File(in+"").toURI().toString();
            player = new MediaPlayer(new Media(url.toString()));
            player.play();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void StopThemeSong(){
        this.player.stop();
    }

    /**
     * Päivittää Menu käyttöliittymän textField elementin 5 parasta aikaa.
     */
    public void updateHighScores() {

        for (String line : this.highscores.updateScores()) {
            this.bestplayer.setText(line);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerHighscoresList = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        headerGamename = new javax.swing.JLabel();
        bestplayer = new javax.swing.JTextField();
        nameField = new javax.swing.JTextField();
        headerHighscoresList1 = new javax.swing.JLabel();
        startRandom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        headerHighscoresList.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        headerHighscoresList.setText("Enter name:");

        startButton.setText("Start default game");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        headerGamename.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        headerGamename.setText("Welcome to ShipSinker2017");

        bestplayer.setEditable(false);

        nameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameFieldActionPerformed(evt);
            }
        });

        headerHighscoresList1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        headerHighscoresList1.setText("Best player is: ");

        startRandom.setText("Start randomly generated game (not 100% working)");
        startRandom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startRandomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(startRandom, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                            .addComponent(startButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(headerHighscoresList, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(headerHighscoresList1))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bestplayer, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(nameField)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(headerGamename, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(headerGamename)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bestplayer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(headerHighscoresList1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(headerHighscoresList, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startRandom, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        if (this.nameField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(gui, "Please enter your name!");
        } else {

            ArrayList coordinates = new ArrayList<>(); //Ship1
            coordinates.add("a5");
            coordinates.add("a2");
            coordinates.add("a3");
            coordinates.add("a4");
            Ship ship1 = new Ship(coordinates, coordinates.size());
            gui.addShipToGui(ship1);

            coordinates.clear(); //Ship 2
            coordinates.add("c1");
            coordinates.add("c2");
            coordinates.add("c3");
            Ship ship2 = new Ship(coordinates, coordinates.size());
            gui.addShipToGui(ship2);

            coordinates.clear(); //Ship 3
            coordinates.add("f3");
            coordinates.add("f4");
            coordinates.add("f5");
            Ship ship3 = new Ship(coordinates, coordinates.size());
            gui.addShipToGui(ship3);

            coordinates.clear(); //Ship 4
            coordinates.add("b10");
            coordinates.add("c10");
            Ship ship4 = new Ship(coordinates, coordinates.size());
            gui.addShipToGui(ship4);

            coordinates.clear(); //Ship 5
            coordinates.add("b8");
            coordinates.add("c8");
            Ship ship5 = new Ship(coordinates, coordinates.size());
            gui.addShipToGui(ship5);

            coordinates.clear(); //Ship 6
            coordinates.add("f8");
            coordinates.add("g8");
            Ship ship6 = new Ship(coordinates, coordinates.size());
            gui.addShipToGui(ship6);

            coordinates.clear(); //Ship 7
            coordinates.add("i4");
            Ship ship7 = new Ship(coordinates, coordinates.size());
            gui.addShipToGui(ship7);

            coordinates.clear(); //Ship 8
            coordinates.add("d5");
            Ship ship8 = new Ship(coordinates, coordinates.size());
            gui.addShipToGui(ship8);

            coordinates.clear(); //Ship 9
            coordinates.add("h2");
            Ship ship9 = new Ship(coordinates, coordinates.size());
            gui.addShipToGui(ship9);

            coordinates.clear(); //Ship 10
            coordinates.add("i9");
            Ship ship10 = new Ship(coordinates, coordinates.size());
            gui.addShipToGui(ship10);
            this.setVisible(false);
            dispose();
            this.gui.setVisible(true);
            this.gameField.setPlayerName(this.nameField.getText());
            //System.out.println("Got playername that is:" + this.gameField.getPlayerName());
            this.gui.checkForShipsEverySecond();
            this.gui.addMediaPlayer(player);

        }

    }//GEN-LAST:event_startButtonActionPerformed

    private void nameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameFieldActionPerformed

    private void startRandomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startRandomActionPerformed
        if (this.nameField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(gui, "Please enter your name!");
        } else {

            Randomizer random = new Randomizer(gui, gameField);
            random.createShip(4);
            random.createShip(3);
            random.createShip(3);
            random.createShip(2);
            random.createShip(2);
            random.createShip(2);
            random.createShip(1);
            random.createShip(1);
            random.createShip(1);
            random.createShip(1);

            ArrayList<Ship> shipList = gameField.getShipList();
            ArrayList<String> allCords = new ArrayList<>();

            for (Ship ship : shipList) {
                ArrayList<String> cordinates = ship.getCordinates();
                for (String cordinate : cordinates) {
                    if (!allCords.contains(cordinate)) {
                        allCords.add(cordinate);
                    }
                }
            }

            this.setVisible(false);
            dispose();
            this.gui.setVisible(true);
            this.gameField.setPlayerName(this.nameField.getText());
            //System.out.println("Got playername that is:" + this.gameField.getPlayerName());
            this.gui.checkForShipsEverySecond();

        }
    }//GEN-LAST:event_startRandomActionPerformed

    /**
     * Käynnistää Menu käyttöliittymän.
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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bestplayer;
    private javax.swing.JLabel headerGamename;
    private javax.swing.JLabel headerHighscoresList;
    private javax.swing.JLabel headerHighscoresList1;
    private javax.swing.JTextField nameField;
    private javax.swing.JButton startButton;
    private javax.swing.JButton startRandom;
    // End of variables declaration//GEN-END:variables
}
