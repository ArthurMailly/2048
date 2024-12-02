package com.ares.View;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import com.ares.Controller.controllerDmqh;
import com.ares.View.assets.dmqhBoard;


public class gameFrame extends JFrame {

    public JPanel mainPanel;
    public dmqhBoard dmqhBoard;
    public JPanel scorePanel;
    BufferedImage fond;
    GridLayout layoutDMQH;
    Image Logo;

    public gameFrame()
    {
        this.setTitle("2048!");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(java.awt.Color.WHITE);
        System.out.println("Avant affectation taille");
        System.out.println("Apres affectation taille");
        // ImageIcon Logo = new ImageIcon("C:\\Users\\sfarf\\Bureau\\Repos_Git\\Java_2048\\2048\\dmqh\\src\\main\\resources\\Logo_dmqh.png");
        // Image scaleLogo = Logo.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        
        dmqhBoard = new dmqhBoard();
        mainPanel = new JPanel(new BorderLayout());
        scorePanel = new JPanel();

        

        
        // mainPanel.add(new JLabel(new ImageIcon(scaleLogo)),gbc);
        mainPanel.add(scorePanel, BorderLayout.NORTH);
        mainPanel.add(dmqhBoard, BorderLayout.CENTER);


        this.add(mainPanel);

        this.setVisible(true);



        

    }
    public void update()
    {
        new gameFrame();
    }

    
    



    
    
}
