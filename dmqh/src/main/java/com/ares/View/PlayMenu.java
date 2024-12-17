package com.ares.View;

import javax.swing.*;
import java.awt.*;

public class PlayMenu extends JPanel
{
    JLabel label;
    JButton easyMode, classicMode, retourMenuButton;

    public PlayMenu(JPanel cardPanel)
    {
        setBounds(500, 100, 500, 500);
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        setLayout(null);

        label = new JLabel("Allons jouer !", JLabel.CENTER);
        label.setBounds(120, 100, 250, 50);
        label.setFont(new Font("Verdana", Font.PLAIN, 20));
        this.add(label);

        easyMode = new JButton("Facile");
        easyMode.setBounds(200, 150, 100, 45);
        this.add(easyMode);
        easyMode.addActionListener(event -> cl.show(cardPanel, "EasyMode"));

        classicMode = new JButton("Classique");
        classicMode.setBounds(200, 250, 100, 45);
        this.add(classicMode);
        classicMode.addActionListener(event -> cl.show(cardPanel, "ClassicMode"));

        retourMenuButton = new JButton("Retour");
        retourMenuButton.setBounds(200, 400, 100, 45);
        this.add(retourMenuButton);
        retourMenuButton.addActionListener(event -> cl.show(cardPanel, "MainMenu"));
    }
}
