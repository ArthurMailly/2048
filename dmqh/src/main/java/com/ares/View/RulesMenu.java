package com.ares.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 * Cette classe crée la page des règles
 */
public class RulesMenu extends JFrame {
    JButton retourMenuButton;
    JLabel title;
    JPanel panel;

    /**
     * Constructeur de la page des règles
     */
    public RulesMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 100, 500, 500);
        setLayout(new BorderLayout());

        // Titre
        title = new JLabel("Règles", JLabel.CENTER);
        title.setFont(new Font("Verdana", Font.PLAIN, 20));
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Ajoute un espace en bas
        add(title, BorderLayout.NORTH);

        // **Panel principal contenant les règles**
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        // **Panel vide pour créer un espace au-dessus des règles**
        JPanel topSpacer = new JPanel();
        topSpacer.setPreferredSize(new Dimension(10, 100)); // Hauteur de l'espace (ajuste si besoin)
        mainPanel.add(topSpacer, BorderLayout.NORTH);

        // **Panel contenant les règles**
        panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Ajout des règles sous forme de labels
        panel.add(createLabel("➜ Déplace les tuiles avec les flèches du clavier."));
        panel.add(createLabel("➜ Deux tuiles identiques fusionnent en une seule."));
        panel.add(createLabel("➜ Obtiens une tuile 2048 pour gagner."));
        panel.add(createLabel("➜ La partie se termine si aucun mouvement n'est possible."));

        // Ajout du panel contenant les règles dans le mainPanel
        mainPanel.add(panel, BorderLayout.CENTER);

        // Ajout du panel principal au centre de la fenêtre
        add(mainPanel, BorderLayout.CENTER);

        // Bouton retour
        retourMenuButton = new JButton("Retour");
        retourMenuButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        retourMenuButton.addActionListener(this::retourMainMenu);

        // Panel pour le bouton
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(retourMenuButton);
        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    /**
     * Retourner au menu principal
     */
    public void retourMainMenu(ActionEvent e) {
        MainMenu frame = new MainMenu();
        frame.setVisible(true);
        this.dispose();
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 17));
        return label;
    }
}