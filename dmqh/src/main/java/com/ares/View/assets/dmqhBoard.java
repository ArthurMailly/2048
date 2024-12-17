package com.ares.View.assets;


import java.awt.GridBagConstraints;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Container;

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
        return controller.getPlateauAsCase();
        
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
        this.removeAll(); // Clear the board
        Cases = controller.getPlateauAsCase();
        for (Case obj : Cases)
        {
            obj.removeAll();
            obj.addLabels();
            this.add(obj); // Add the updated cases to the board
        } 
        this.revalidate(); // Revalidate the board to apply changes
        this.repaint(); // Repaint the board to reflect changes
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        dessinerCases(g);
    }

}