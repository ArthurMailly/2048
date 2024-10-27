package com.ares.View.assets;


import java.awt.GridBagConstraints;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;

import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.*;



public class dmqhBoard extends JPanel
{
    public BufferedImage fond;
    private int taille;
    private ArrayList<Case> Cases = new ArrayList<Case>();

    

    public dmqhBoard(int taille)
    {
    
        // try {
        //     fond=ImageIO.read(new File("C:\\Users\\sfarf\\Bureau\\Repos_Git\\Java_2048\\2048\\dmqh\\src\\main\\resources\\dmqh_arriereplan.png"));
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
        
        // JLabel picLabel = new JLabel(new ImageIcon(fond));
        // this.add(picLabel);
        this.taille = taille;
        this.setBackground(Color.BLACK);
        this.setLayout(new GridLayout(taille, taille));

        Cases=createCaseArray(this);
        for (Case obj : Cases)
        {
            System.out.println("Hello");
            System.out.println(obj.valeur);
            System.out.println(obj.cote);
            System.out.println(obj.p);
        }
        this.addCasesToBoard();
        dessinerCases(getGraphics());
    }

    public ArrayList<Case> createCaseArray(dmqhBoard b)
    {
        for (int i = 0; i < b.taille; i++)
        {
            for (int j = 0; j < b.taille; j++)
            {
                Case caseObj = new Case(150, 2, new java.awt.Point(i , j ), Color.RED);
                Cases.add(caseObj);
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

    


    // @Override
    // protected void paintComponent(Graphics g)
    // {
    //     super.paintComponent(g);
    //     this.setBackground(Color.WHITE);
    //     g.setColor(Color.WHITE);
    //     g.fillRect(0, 0, 100, 100);
    // }
    
	
}