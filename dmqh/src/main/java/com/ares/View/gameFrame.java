package com.ares.View;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.ares.Controller.controllerDmqh;
import com.ares.View.assets.dmqhBoard;


public class gameFrame extends JFrame {

    public actionController actionController;
    public JPanel mainPanel,infoPanel;
    public dmqhBoard dmqhBoard;
    public JLabel exitLabel, restartLabel;

    public JPanel scorePanel;
    BufferedImage fond;
    GridLayout layoutDMQH;
    Image Logo;

    public gameFrame()
    {
        controllerDmqh controller = controllerDmqh.getInstance();
        this.setTitle("2048!");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(java.awt.Color.WHITE);
        
        dmqhBoard = new dmqhBoard();
        mainPanel = new JPanel(new BorderLayout());
        scorePanel = new JPanel();
        infoPanel = new JPanel();

        actionController = new actionController();
        this.addKeyListener(actionController);

        JLabel scoreLabel = new JLabel("Score : "+controller.getPartie().getScore());
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scoreLabel.setFont(scoreLabel.getFont().deriveFont(20.0f));
        scoreLabel.setSize(100, 100);
        scorePanel.add(scoreLabel);

        exitLabel = new JLabel("ECHAP: quitter");
        exitLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        exitLabel.setFont(exitLabel.getFont().deriveFont(20.0f));

        restartLabel = new JLabel("R: recommencer");
        restartLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        restartLabel.setFont(restartLabel.getFont().deriveFont(20.0f));

        infoPanel.add(exitLabel, BorderLayout.WEST);
        infoPanel.add(restartLabel, BorderLayout.EAST);

        
        mainPanel.add(scorePanel, BorderLayout.NORTH);
        mainPanel.add(dmqhBoard, BorderLayout.CENTER);
        mainPanel.add(infoPanel, BorderLayout.SOUTH);


        this.add(mainPanel);

        this.setVisible(true);

    }

    
    public void update()
    {
        dmqhBoard.updateBoard();
        updateScore();
        
    }

    public void updateScore()
    {
        Color randColor = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
        int score = controllerDmqh.getInstance().getPartie().getScore();
        scorePanel.removeAll();

        JLabel scoreLabel = new JLabel();
        
        if (0 < score && score < 100)
        {
            scoreLabel.setText("Score du bouffon : "+score);
        }
        else if (100<=score && score <250)
        {
            scoreLabel.setText("Score du fdp : "+score);
        }
        else if (250<=score && score <500)
        {
            scoreLabel.setText("Score du BG : "+score);
        }
        else if (500<=score && score <1000)
        {
            scoreLabel.setText("Score du chien de la casse : "+score);
        }
        else if (1000<=score && score <1500)
        {
            scoreLabel.setText("Score de l'Homme respectable : "+score);
        }
        else
        {
            scoreLabel.setText("Score du clochard : "+score);
        }
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scoreLabel.setFont(scoreLabel.getFont().deriveFont(20.0f));
        scoreLabel.setSize(100, 100);
        scoreLabel.setForeground(randColor);
        scorePanel.add(scoreLabel);
        scorePanel.repaint();
    }

}
