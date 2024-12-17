package com.ares.View.assets;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Case extends JPanel {
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
        addLabels();
        
    }
    public void addLabels()
    {
        switch(valeur)
        {
            case 0 :
                mettre_image("src/main/resources/0 Tile.png");
                break;
            case 2 :
                mettre_image("src/main/resources/2 Tile.png");
                break;
            case 4 :
                mettre_image("src/main/resources/4 Tile.png");
                break;
            case 8 :
                mettre_image("src/main/resources/8 Tile.png");
                break;
            case 16 :
                mettre_image("src/main/resources/16 Tile.png");
                break;
            case 32 :
                mettre_image("src/main/resources/32 Tile.png");
                break;
            case 64 :
                mettre_image("src/main/resources/64 Tile.png");
                break;
            case 128 :
                mettre_image("src/main/resources/128 Tile.png");
                break;
            case 256 :
                mettre_image("src/main/resources/256 Tile.png");
                break;  
            case 512 :
                mettre_image("src/main/resources/512 Tile.png");
                break;
            case 1024 :
                mettre_image("src/main/resources/1024 Tile.png");
                break;
            case 2048 :
                mettre_image("src/main/resources/2048 Tile.png");
                break;
            default :
        }
        
        this.add(picLabel, BorderLayout.CENTER);

    }

    public void mettre_image(String path)
    {
        try {
            img = ImageIO.read(new File(path));
            Image scaledImg = img.getScaledInstance(80, 80, Image.SCALE_SMOOTH);

            picLabel = new JLabel(new ImageIcon(scaledImg));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateCase()
    {
        

    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        // g.setColor(couleur);
        // g.fillRect(p.x, p.y, cote, cote);
    }
    
}
