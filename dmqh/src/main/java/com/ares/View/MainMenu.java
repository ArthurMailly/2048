package com.ares.View;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class MainMenu extends JFrame {
    JButton playButton;
    JButton optionsButton;
    JButton HowToPlay;
    JButton LienRapport;
    JPanel PlayPanel;
    JPanel OptionsPanel;
    JPanel ContactPanel;
    JPanel LogoPanel;
    BufferedImage Logo;

    public MainMenu() {
        this.setTitle("2048!");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            Logo=ImageIO.read(new File("C:\\Users\\sfarf\\Bureau\\Repos_Git\\Java_2048\\2048\\dmqh\\src\\main\\resources\\Logo_dmqh.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setIconImage(Logo);

        playButton = new JButton("Play");
        optionsButton = new JButton("Options");
        LienRapport = new JButton("Lien Rapport");
        HowToPlay = new JButton("How to play");
        JLabel picLabel = new JLabel(new ImageIcon(Logo));

        PlayPanel = new JPanel();
        OptionsPanel = new JPanel();
        ContactPanel = new JPanel();
        LogoPanel = new JPanel();

        LogoPanel.add(picLabel, BorderLayout.NORTH);
        PlayPanel.add(playButton, BorderLayout.CENTER);
        OptionsPanel.add(optionsButton, BorderLayout.CENTER);
        ContactPanel.add(LienRapport, BorderLayout.SOUTH);
        ContactPanel.add(HowToPlay, BorderLayout.WEST);

        
        this.add(LogoPanel, BorderLayout.NORTH);
        this.add(PlayPanel, BorderLayout.CENTER);
        this.add(OptionsPanel, BorderLayout.CENTER);
        this.add(ContactPanel, BorderLayout.SOUTH);

        this.setVisible(true);

        

        
    }



    
}
