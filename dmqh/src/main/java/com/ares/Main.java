package com.ares;
import com.ares.Model.Case;
import com.ares.Model.Plateau;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Plateau plateau = new Plateau(4, 4);
        plateau.AfficherPlateau();
        System.out.print("\n");
        plateau.DeplacementDroite();
        plateau.AfficherPlateau();
    }
}