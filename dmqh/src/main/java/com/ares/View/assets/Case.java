package com.ares.View.assets;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Case extends PanelObjetGraphique {
    public int cote;
    public int valeur;
    public Color couleur;
    public Point p;
    public BufferedImage img;
    public JLabel picLabel;



    public Case(int cote, int valeur, Point p, Color couleur)
    {
        this.cote = cote;
        this.valeur = valeur;
        this.p = p;
        this.couleur = couleur;
        this.img = null;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setLayout(new BorderLayout());
        switch(valeur)
        {
            case 2 : 
                try {
                    img = ImageIO.read(new File("C:\\Users\\sfarf\\Bureau\\Repos_Git\\Java_2048\\2048\\dmqh\\src\\main\\resources\\2 Tile.png"));
                    picLabel = new JLabel(new ImageIcon(img));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 4 :
                try {
                    img = ImageIO.read(new File("C:\\Users\\sfarf\\Bureau\\Repos_Git\\Java_2048\\2048\\dmqh\\src\\main\\resources\\4 Tile.png"));
                    picLabel = new JLabel(new ImageIcon(img));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 8 :
                try {
                    img = ImageIO.read(new File("C:\\Users\\sfarf\\Bureau\\Repos_Git\\Java_2048\\2048\\dmqh\\src\\main\\resources\\8 Tile.png"));
                    picLabel = new JLabel(new ImageIcon(img));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 16 :
                try {
                    img = ImageIO.read(new File("C:\\Users\\sfarf\\Bureau\\Repos_Git\\Java_2048\\2048\\dmqh\\src\\main\\resources\\16 Tile.png"));
                    picLabel = new JLabel(new ImageIcon(img));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 32 :
                try {
                    img = ImageIO.read(new File("C:\\Users\\sfarf\\Bureau\\Repos_Git\\Java_2048\\2048\\dmqh\\src\\main\\resources\\32 Tile.png"));
                    picLabel = new JLabel(new ImageIcon(img));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 64 :
                try {
                    img = ImageIO.read(new File("C:\\Users\\sfarf\\Bureau\\Repos_Git\\Java_2048\\2048\\dmqh\\src\\main\\resources\\64 Tile.png"));
                    picLabel = new JLabel(new ImageIcon(img));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 128 :
                try {
                    img = ImageIO.read(new File("C:\\Users\\sfarf\\Bureau\\Repos_Git\\Java_2048\\2048\\dmqh\\src\\main\\resources\\128 Tile.png"));
                    picLabel = new JLabel(new ImageIcon(img));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 256 :
                try {
                    img = ImageIO.read(new File("C:\\Users\\sfarf\\Bureau\\Repos_Git\\Java_2048\\2048\\dmqh\\src\\main\\resources\\256 Tile.png"));
                    picLabel = new JLabel(new ImageIcon(img));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;  
            case 512 :
                try {
                    img = ImageIO.read(new File("C:\\Users\\sfarf\\Bureau\\Repos_Git\\Java_2048\\2048\\dmqh\\src\\main\\resources\\512 Tile.png"));
                    picLabel = new JLabel(new ImageIcon(img));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 1024 :
                try {
                    img = ImageIO.read(new File("C:\\Users\\sfarf\\Bureau\\Repos_Git\\Java_2048\\2048\\dmqh\\src\\main\\resources\\1024 Tile.png"));
                    picLabel = new JLabel(new ImageIcon(img));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 2048 :
                try {
                    img = ImageIO.read(new File("C:\\Users\\sfarf\\Bureau\\Repos_Git\\Java_2048\\2048\\dmqh\\src\\main\\resources\\2048 Tile.png"));
                    picLabel = new JLabel(new ImageIcon(img));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default :
        }
        this.add(picLabel, BorderLayout.CENTER);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(couleur);
        g.fillRect(p.x, p.y, cote, cote);
    }

    




    

    


    
}
