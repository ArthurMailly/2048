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

import com.ares.View.assets.dmqhBoard;


public class gameFrame extends JFrame {
    public JPanel mainPanel;
    public dmqhBoard dmqhBoard;
    BufferedImage fond;
    GridLayout layoutDMQH;
    Image Logo;

    public gameFrame()
    {
        this.setTitle("2048!");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(java.awt.Color.WHITE);
        this.setBackground(java.awt.Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();
        int val = 20;
        gbc.insets.set(val, val, val, val);

        ImageIcon Logo = new ImageIcon("C:\\Users\\sfarf\\Bureau\\Repos_Git\\Java_2048\\2048\\dmqh\\src\\main\\resources\\Logo_dmqh.png");
        Image scaleLogo = Logo.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
        

        dmqhBoard = new dmqhBoard();
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel(new ImageIcon(scaleLogo)),gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        mainPanel.add(dmqhBoard, gbc);
        
        


        this.add(mainPanel);

        this.setVisible(true);

        

}


    
    
}
