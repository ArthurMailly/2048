package com.ares.View;

import com.ares.Controller.controllerDmqh;

import javax.swing.*;

public class EndGamePage extends JFrame {
    public JLabel endGameLabel;
    public JPanel panel;

    public EndGamePage() {
        // Initialisation du contrôleur
        controllerDmqh controller = controllerDmqh.getInstance();

        // Configuration de la fenêtre
        this.setTitle("C'est fini");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(java.awt.Color.WHITE);

        // Initialisation du JPanel
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); // Optionnel : Choisir un layout
        this.add(panel); // Ajouter le panel à la fenêtre

        // Initialisation du JLabel
        endGameLabel = new JLabel("C'est fini !");
        endGameLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        endGameLabel.setFont(endGameLabel.getFont().deriveFont(20.0f));
        endGameLabel.setSize(100, 100);

        // Ajout du JLabel au JPanel
        panel.add(endGameLabel);

        // Rendre la fenêtre visible
        this.setVisible(true);
    }
}
