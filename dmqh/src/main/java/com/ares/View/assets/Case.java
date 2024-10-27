package com.ares.View.assets;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
import javax.swing.*;

public class Case extends PanelObjetGraphique {
    public int cote;
    public int valeur;
    public Color couleur;
    public Point p;



    public Case(int cote, int valeur, Point p, Color couleur)
    {
        this.cote = cote;
        this.valeur = valeur;
        this.p = p;
        this.couleur = couleur;
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(couleur);
        g.fillRect(p.x, p.y, cote, cote);
    }




    

    


    
}
