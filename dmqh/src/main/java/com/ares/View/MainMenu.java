package com.ares.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * Cette classe crée le menu principal
 */
public class MainMenu extends JFrame {
    JButton playButton;
    JButton rulesButton;
    JButton quitButton;
    JButton scoreButton;
    JLabel title;


    /**
     * Constructeur du menu principal
     */
    public MainMenu() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500,100,500, 500);
        setLayout(null);

        title = new JLabel("2048", JLabel.CENTER);
        title.setBounds(120, 100, 250, 50);
        title.setFont(new Font("Verdana", Font.PLAIN, 30));
        this.add(title);

        playButton = new JButton("Jouer");
        playButton.setBounds(200,200,100,45);
        this.add(playButton);
        //playButton.addActionListener(event -> cl.show(cardPanel, "PlayMenu"));
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {allerMenuPlay(); }
        });

        rulesButton = new JButton("Règles");
        rulesButton.setBounds(200,300,100,45);
        this.add(rulesButton);
        rulesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                allerMenuRegles();
            }
        });

        scoreButton = new JButton("Scores");
        scoreButton.setBounds(200,250,100,45);
        this.add(scoreButton);
        scoreButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        allerMenuScore();
                    }
                });

        quitButton = new JButton("Quitter");
        quitButton.setBounds(200,350,100,45);
        this.add(quitButton);
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quitterApp();
            }
        });
    }


    /**
     * Va au menu pour lancer une partie
     */
    public void allerMenuPlay()
    {
        PlayMenu frame = new PlayMenu();
        frame.setVisible(true);
        this.dispose();
    }


    /**
     * Va au menu des règles
     */
    public void allerMenuRegles()
    {
        RulesMenu frame = new RulesMenu();
        frame.setVisible(true);
        this.dispose();
    }


    /**
     * Va au menu des scores
     */
    public void allerMenuScore()
    {
        scoreMenu frame = new scoreMenu();
        frame.setVisible(true);
        this.dispose();
    }


    /**
     * Ferme le jeu
     */
    public void quitterApp() {System.exit(1);}
}
