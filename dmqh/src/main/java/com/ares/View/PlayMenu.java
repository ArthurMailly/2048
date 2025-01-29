package com.ares.View;

import com.ares.Controller.controllerDmqh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Cette classe crée le menu jouer
 */
public class PlayMenu extends JFrame
{
    JLabel label;
    JButton easyMode, classicMode, hardMode, retourMenuButton;


    /**
     * Constructeur de la page
     */
    public PlayMenu()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 100, 500, 500);
        //CardLayout cl = (CardLayout) cardPanel.getLayout();
        setLayout(null);

        label = new JLabel("Allons jouer !", JLabel.CENTER);
        label.setBounds(120, 100, 250, 50);
        label.setFont(new Font("Verdana", Font.PLAIN, 20));
        this.add(label);

        easyMode = new JButton("Facile");
        easyMode.setBounds(200, 150, 100, 45);
        this.add(easyMode);
        easyMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jouerEasyMode(e);
            }
        });

        classicMode = new JButton("Classique");
        classicMode.setBounds(200, 250, 100, 45);
        this.add(classicMode);
        classicMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jouerClassicMode(e);
            }
        });

        hardMode = new JButton("Difficile");
        hardMode.setBounds(200, 350, 100, 45);
        this.add(hardMode);
        hardMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jouerHardMode(e);
            }
        });

        retourMenuButton = new JButton("Retour");
        retourMenuButton.setBounds(200, 400, 100, 45);
        this.add(retourMenuButton);
        retourMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retourMainMenu();
            }
        });
    }


    /**
     * Lancer le mode de jeu classique
     * @param e
     */
    public void jouerClassicMode(ActionEvent e)
    {
        controllerDmqh controller = controllerDmqh.getInstance();
        int userInput=4;
        controller.setDifficultePartieFromView(userInput);
        controller.setGameFrame(new gameFrame());
        this.dispose();
    }


    /**
     * Lancer le mode de jeu facile
     * @param e
     */
    public void jouerEasyMode(ActionEvent e)
    {
        controllerDmqh controller = controllerDmqh.getInstance();
        int userInput=6;
        controller.setDifficultePartieFromView(userInput);
        controller.setGameFrame(new gameFrame());
        this.dispose();
    }


    /**
     * Lancer le mode de jeu difficile
     * @param e
     */
    public void jouerHardMode(ActionEvent e)
    {
        controllerDmqh controller = controllerDmqh.getInstance();
        int userInput=3;
        controller.setDifficultePartieFromView(userInput);
        controller.setGameFrame(new gameFrame());
        this.dispose();
    }


    /**
     * Retourner au menu principal
     */
    public void retourMainMenu()
    {
        MainMenu frame = new MainMenu();
        frame.setVisible(true);
        this.dispose();
    }
}
