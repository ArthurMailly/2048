package com.ares.View;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Cette classe crée le page des règles
 */
public class RulesMenu extends JFrame
{
    JButton retourMenuButton;
    JButton afficherScores;
    JLabel title;


    /**
     * Constructeur de la page des règles
     */
    public RulesMenu()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500,100,500, 500);
        setLayout(null);

        title = new JLabel("Règles", JLabel.CENTER);
        title.setBounds(120, 100, 250, 50);
        title.setFont(new Font("Verdana", Font.PLAIN, 20));
        this.add(title);

        retourMenuButton = new JButton("Retour");
        retourMenuButton.setBounds(200,400,100,45);
        this.add(retourMenuButton);
        retourMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retourMainMenu(e);
            }
        });
    }

    /**
     * Retourner au menu principal
     * @param e
     */
    public void retourMainMenu(ActionEvent e)
    {
        MainMenu frame = new MainMenu();
        frame.setVisible(true);
        this.dispose();
    }

}
