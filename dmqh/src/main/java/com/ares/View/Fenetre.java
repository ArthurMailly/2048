package com.ares.View;

import java.awt.*;
import javax.swing.*;


/**
 * Fenêtres fonctionnant avec les CardLayout
 */
public class Fenetre
{
    /**
     * Constructeur des fenêtres fonctionnant avec les CardLayout
     */
    public Fenetre()
    {
        JFrame frame = new JFrame("2048");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        JPanel cardPanel = new JPanel(new CardLayout());

        cardPanel.add(new MainMenu(cardPanel), "MainMenu");
        cardPanel.add(new PlayMenu(cardPanel), "PlayMenu");
        cardPanel.add(new RulesMenu(cardPanel), "RulesMenu");
        cardPanel.add(new OptionMenu(cardPanel), "OptionMenu");

        frame.add(cardPanel);
        frame.setVisible(true);
    }

}
