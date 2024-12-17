package com.ares.View;

import javax.swing.*;
import java.awt.*;

public class ClassicMode extends JPanel
{
    JButton retourMenuButton;
    JLabel label;

    public ClassicMode(JPanel cardPanel)
    {
        setBounds(500, 100, 500, 500);
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        setLayout(null);

        label = new JLabel("Le classic mode, c'est un mode mais classique", JLabel.LEFT);
        label.setBounds(120, 100, 250, 50);
        label.setFont(new Font("Verdana", Font.PLAIN, 10));
        this.add(label);

        retourMenuButton = new JButton("Retour");
        retourMenuButton.setBounds(200, 400, 100, 45);
        this.add(retourMenuButton);
        retourMenuButton.addActionListener(event -> cl.show(cardPanel, "MainMenu"));
    }
}
