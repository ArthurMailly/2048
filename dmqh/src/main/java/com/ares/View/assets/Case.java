package com.ares.View.assets;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;

public class Case extends CObjetGraphique {
    public int cote;
    public int valeur;
    public Color couleur;
    public Point p;


    public Case(int cote, int valeur, Point p) {
        this.cote = cote;
        this.valeur = valeur;
        this.p= p;
    }

    public void dessiner(Graphics g) {
        g.setColor(getColor());
        g.fillRect(p.x,p.y, cote, cote);
        g.setColor(getColor());
        g.drawString(String.valueOf(valeur), p.x + cote / 2, p.y + cote / 2);
    }

    


    
}
