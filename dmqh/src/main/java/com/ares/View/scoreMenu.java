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
public class scoreMenu extends JPanel
{
    JButton retourMenuButton;
    JButton afficherScores;
    JLabel title;
    bdConnection bd;


    /**
     * Constructeur de la page des scores
     * @param cardPanel
     */
    public scoreMenu(JPanel cardPanel)
    {
        bd= controllerDmqh.getInstance().connectToDB();
        setBounds(500,100,500, 500);
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        setLayout(null);

        title = new JLabel("Scores", JLabel.CENTER);
        title.setBounds(120, 100, 250, 50);
        title.setFont(new Font("Verdana", Font.PLAIN, 20));
        this.add(title);

        retourMenuButton = new JButton("Retour");
        retourMenuButton.setBounds(200,400,100,45);
        this.add(retourMenuButton);
        retourMenuButton.addActionListener(event -> cl.show(cardPanel, "MainMenu"));
        
        afficherScores = new JButton("Afficher les scores");
        afficherScores.setBounds(200,200,100,45);
        afficherScores.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherScores();

            }
        });
        this.add(afficherScores);

    }
    // Méthode pour récupérer et afficher les scores
    private void afficherScores() {
        ResultSet results = bd.printAllinDB(); // Récupérer les scores

        try {
            while (results.next()) {
                JLabel label = new JLabel();
                label.setText(results.getString("username") + " - " + results.getString("score"));
                label.setBounds(200, 250, 100, 45);
                this.add(label);
            }
            this.revalidate();
            this.repaint();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 500, 500);
    }

    

}
