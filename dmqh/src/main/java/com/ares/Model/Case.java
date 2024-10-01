package com.ares.Model;

import java.awt.Color;

public class Case {

    private int x;
    private int y;
    private Color couleur;
    private int nombre;

    public Case()//int x, int y)
    {
        double proba = Math.random();
        System.out.println(proba);
        if (proba < 0.8)
        {
            System.out.println("On a un deux");
        }
        else
        {
            System.out.println("On a un quatre");
        }
    }

}
