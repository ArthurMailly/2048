package com.ares.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionMenu extends JPanel
{
    JButton retourMenuButton;
    JLabel title;

    public OptionMenu(JPanel cardPanel) {
        setBounds(500, 100, 500, 500);
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        setLayout(null);

        title = new JLabel("Options", JLabel.CENTER);
        title.setBounds(120, 100, 250, 50);
        title.setFont(new Font("Verdana", Font.PLAIN, 20));
        this.add(title);

        retourMenuButton = new JButton("Retour");
        retourMenuButton.setBounds(200, 400, 100, 45);
        this.add(retourMenuButton);
        retourMenuButton.addActionListener(event -> cl.show(cardPanel, "MainMenu"));
    }

}
