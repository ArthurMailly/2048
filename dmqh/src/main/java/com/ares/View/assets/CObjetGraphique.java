package com.ares.View.assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
   
public abstract class CObjetGraphique 
{

    private Point coinSuperieurGauche;
    private Color couleur;
    
    public CObjetGraphique() 
    {
        coinSuperieurGauche = new Point(0,0);
    }
    public CObjetGraphique(Point p, Color c) 
    {
        coinSuperieurGauche = p;
        couleur = c;
    } 
    public Point getCointSuperieurGauche() 
    {
        return coinSuperieurGauche;
    } 
    public Color getColor() 
    {
        return couleur;
    } 
    public void deplacer(Point p) 
    {
        coinSuperieurGauche = p;
    } 
    public abstract void dessiner(Graphics g);

}
