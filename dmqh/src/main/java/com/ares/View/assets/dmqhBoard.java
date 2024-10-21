package com.ares.View.assets;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;
import java.awt.Color;
import javax.imageio.ImageIO;
import javax.swing.*;
import com.ares.View.assets.Case;


public class dmqhBoard extends JPanel
{
    public BufferedImage fond;
    private int taille;

    public dmqhBoard(int taille)
    {
        this.taille = taille;
        this.setLayout(new GridLayout(taille, taille));
    }


    public dmqhBoard()
    {
    
        try {
            fond=ImageIO.read(new File("C:\\Users\\sfarf\\Bureau\\Repos_Git\\Java_2048\\2048\\dmqh\\src\\main\\resources\\dmqh_arriereplan.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        JLabel picLabel = new JLabel(new ImageIcon(fond));
        this.add(picLabel);
    }

    void createCase(Case c, dmqhBoard b, int [][] tab)
    {
        for(int i = 0; i < b.taille; i++)
        {
            for(int j = 0; j < b.taille; j++)
            {
                c = new Case(100, tab[i][j], new java.awt.Point(i*100, j*100));
                //rajouter les cases au plateau de jeu, probleme de type
                //b.add(c);
            }
        }
        
    }

    


    // @Override
    // protected void paintComponent(Graphics g)
    // {
    //     super.paintComponent(g);
    //     this.setBackground(Color.WHITE);
    //     g.setColor(Color.WHITE);
    //     g.fillRect(0, 0, 100, 100);
    // }
    
	
}