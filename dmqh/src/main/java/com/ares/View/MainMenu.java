package com.ares.View;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainMenu extends JFrame {
    JButton playButton;
    JButton optionsButton;
    JButton rulesButton;
    JButton quitButton;
    JPanel contentPane;
    JLabel title;

    public MainMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500,100,500, 500);
        setTitle("2048!");

        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        title = new JLabel("2048", JLabel.CENTER);
        title.setBounds(120, 100, 250, 50);
        title.setFont(new Font("Verdana", Font.PLAIN, 30));
        contentPane.add(title);

        playButton = new JButton("Jouer");
        playButton.setBounds(200,200,100,45);
        contentPane.add(playButton);

        optionsButton = new JButton("Options");
        optionsButton.setBounds(200,250,100,45);
        contentPane.add(optionsButton);
        optionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pageVersOptions();
            }
        });

        rulesButton = new JButton("Règles");
        rulesButton.setBounds(200,300,100,45);
        contentPane.add(rulesButton);
        rulesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pageVersRegles();
            }
        });

        quitButton = new JButton("Quitter");
        quitButton.setBounds(200,350,100,45);
        contentPane.add(quitButton);
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quitterApp();
            }
        });

    }

    public void pageVersRegles()
    {
        RulesMenu rules = new RulesMenu();
        rules.setVisible(true);
        this.dispose();
    }

    public void pageVersOptions()
    {
        OptionMenu options = new OptionMenu();
        options.setVisible(true);
        this.dispose();
    }

    public void quitterApp() {System.exit(1);}

}
