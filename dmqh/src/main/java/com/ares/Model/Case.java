package com.ares.Model;

import java.awt.Color;

public class Case {

    private int x;
    private int y;
    private Color couleur;
    private int nombre;

    public Case(int abscisse, int ordonnee, boolean zero)
    {
        this.x = abscisse;
        this.y = ordonnee;

        if ( ! zero)
        {
            double proba = Math.random();
            if (proba < 0.9)
            {
                this.nombre = 2;
            }
            else
            {
                this.nombre = 4;
            }
        }

        else
        {
            this.nombre = 0;
        }

        MajCouleur();
    }

    public void MajCouleur()
    {
        switch (nombre)
        {
            case 0 -> couleur = new Color(255,255,255);
            case 2 -> couleur = new Color(238,228,218);
            case 4 -> couleur = new Color(237,224,200);
            case 8 -> couleur = new Color(242,177,121);
            case 16 -> couleur = new Color(245,149,99);
            case 32 -> couleur = new Color(246,124,95);
            case 64 -> couleur = new Color(246,94,59);
            case 128 -> couleur = new Color(237,207,114);
            case 256 -> couleur = new Color(237,204,97);
            case 512 -> couleur = new Color(237,200,80);
            case 1024 -> couleur = new Color(237,197,63);
            case 2048 -> couleur = new Color(237,194,46);
            case 4096 -> couleur = new Color(193,152,183);
            case 8192 -> couleur = new Color(184,125,176);
        }
    }

    public void DeplacerCase(int DeplacementX, int DeplacementY)
    {
        this.x += DeplacementX;
        this.y += DeplacementY;
    }


    public void printCase()
    {
        System.out.println("Abscisse: "+ x);
        System.out.println("Ordonnée: "+ y);
        System.out.println("Nombre: "+ nombre);
        System.out.println("Couleur: "+ couleur);
    }

    public void print()
    {
        System.out.print(nombre);
    }

    public boolean CaseNulle()
    {
        return nombre == 0;
    }
}
