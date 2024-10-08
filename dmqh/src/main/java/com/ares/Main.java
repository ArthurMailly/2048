package com.ares;
import com.ares.Model.Case;
import com.ares.Model.Plateau;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        /*

        Case lacase = new Case(1,0);
        lacase.printCase();
        lacase.DeplacerCase(1,-1);
        lacase.printCase();
        */
        Plateau plateau = new Plateau(4, 4);
        plateau.AfficherPlateau();
        System.out.print("\n");
        plateau.DeplacementGauche();
        plateau.AfficherPlateau();
    }
}