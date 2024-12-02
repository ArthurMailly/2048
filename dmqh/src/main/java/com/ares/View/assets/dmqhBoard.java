package com.ares.View.assets;


import java.awt.GridBagConstraints;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.*;
import com.ares.Model.Partie;
import com.ares.Controller.controllerDmqh;



public class dmqhBoard extends JPanel
{
    public BufferedImage fond;
    private int taille;
    private ArrayList<Case> Cases = new ArrayList<Case>();
    private static controllerDmqh controller = controllerDmqh.getInstance();

    

    public dmqhBoard()
    {
        
        this.taille = controller.getDifficultePartieFromView();
        this.setBackground(Color.BLACK);
        

        this.setLayout(new GridLayout(taille, taille));
        Cases = createCaseArray();
        
       
        addCasesToBoard();

        
    }

    public ArrayList<com.ares.View.assets.Case> createCaseArray()
    {
        Partie partie=controller.getPartie();
        for (int i = 0; i < this.taille; i++)
        {
            for (int j = 0; j < this.taille; j++)
            {
            
                
                com.ares.View.assets.Case c = new Case(300,partie.getPlateau().getTableau()[j][i].getNombre(),new Point(i,j),partie.getPlateau().getTableau()[i][j].getCouleur());
                Cases.add(c);
            }
        }
        return Cases;
        
    }

    public void addCasesToBoard()
    {
        for (Case obj : Cases)
        {
            this.add(obj);
        }
    }

    public void dessinerCases(Graphics g)
    {
        GridBagConstraints gbc = new GridBagConstraints();
        for (int i=0; i<taille; i++)
        {
            for (int j=0; j<taille; j++)
            {
                gbc.gridx = i;
                gbc.gridy = j;
                this.add(Cases.get(i*taille+j), gbc);
            }
            
        }
    }

    public int getTaille()
    {
        return taille;
    }

    public void updateBoard()
    {
        this.Cases = createCaseArray();
        addCasesToBoard();
        this.revalidate();
        this.dessinerCases(getGraphics());
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