package com.ares.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenu extends JPanel {
    JButton playButton;
    JButton optionsButton;
    JButton rulesButton;
    JButton quitButton;
    JLabel title;

    public MainMenu(JPanel cardPanel) {
        setBounds(500,100,500, 500);
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        setLayout(null);

        title = new JLabel("2048", JLabel.CENTER);
        title.setBounds(120, 100, 250, 50);
        title.setFont(new Font("Verdana", Font.PLAIN, 30));
        this.add(title);

        playButton = new JButton("Jouer");
        playButton.setBounds(200,200,100,45);
        this.add(playButton);
        playButton.addActionListener(event -> cl.show(cardPanel, "PlayMenu"));

        optionsButton = new JButton("Options");
        optionsButton.setBounds(200,250,100,45);
        this.add(optionsButton);
        optionsButton.addActionListener(event -> cl.show(cardPanel, "OptionMenu"));

        rulesButton = new JButton("Règles");
        rulesButton.setBounds(200,300,100,45);
        this.add(rulesButton);
        rulesButton.addActionListener(event -> cl.show(cardPanel, "RulesMenu"));

        quitButton = new JButton("Quitter");
        quitButton.setBounds(200,350,100,45);
        this.add(quitButton);
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quitterApp();
            }
        });

    }
    public void quitterApp() {System.exit(1);}

}
