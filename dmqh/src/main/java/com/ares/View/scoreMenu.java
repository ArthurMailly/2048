package com.ares.View;

import javax.swing.*;

import com.ares.Controller.controllerDmqh;
import com.ares.Model.bdConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Cette classe crée le page des règles
 */
public class scoreMenu extends JFrame
{
    JButton retourMenuButton;
    JButton afficherScores;
    JLabel title;
    bdConnection bd;


    /**
     * Constructeur de la page des scores
     */
    public scoreMenu()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bd= controllerDmqh.getInstance().connectToDB();
        setBounds(500,100,500, 500);
        setLayout(null);

        title = new JLabel("Scores", JLabel.CENTER);
        title.setBounds(120, 50, 250, 50);
        title.setFont(new Font("Verdana", Font.BOLD, 24));
        title.setForeground(Color.BLUE);
        title.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        this.add(title);

        retourMenuButton = new JButton("Retour");
        retourMenuButton.setBounds(200,400,100,45);
        this.add(retourMenuButton);
        retourMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                retourMainMenu();
            }
        });
        
        afficherScores = new JButton("Afficher les scores");
        afficherScores.setBounds(150,350,200,45);
        afficherScores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherScores();
            }
        });
        this.add(afficherScores);
    }

    /**
     * Récupère et affiche les scores
     */
    private void afficherScores() {
        ResultSet results = bd.printAllinDB(); // Récupérer les scores

        try {
            int yOffset = 100; // Initial y position for the first score
            while (results.next()) {
                JLabel label = new JLabel();
                label.setText(results.getString("username") + " || " + results.getString("score"));
                label.setBounds(100, yOffset, 300, 30); // Adjusted width and height for better visibility
                label.setFont(new Font("Arial", Font.PLAIN, 18));
                label.setForeground(Color.DARK_GRAY);
                label.setHorizontalAlignment(SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1));
                this.add(label);
                yOffset += 30; // Increment y position for the next score
            }
            this.revalidate();
            this.repaint();
            
        } catch (SQLException e)
         {
            e.printStackTrace();
        }
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