package com.ares.Model;
import java.util.Scanner;

import com.ares.Controller.controllerDmqh;

public class Partie
{
    public static Partie instance=null;
    public static controllerDmqh controller = controllerDmqh.getInstance();
    private Plateau plateau;
    private int cote;
    private int difficulte=2;

    private Partie()
    {
        this.cote = controller.getDifficultePartieFromView();
        this.plateau = new Plateau(cote, cote);
    }
    public static Partie getInstance()
    {
        if (instance == null)
        {
            instance = new Partie();
        }
        return instance;
    }

    public Plateau getPlateau() {return plateau;}

    public void showPlateau()
    {
        System.out.println("Score:" + this.getScore());
        this.plateau.AfficherPlateau();
    }

    public int getScore() {return this.plateau.getScore();}

    public void DeplacementGauche() {this.plateau.DeplacementGauche();}

    public void DeplacementDroite() {this.plateau.DeplacementDroite();}

    public void DeplacementHaut() {this.plateau.DeplacementHaut();}

    public void DeplacementBas() {this.plateau.DeplacementBas();}

    public Case[][] getTableau() {return this.plateau.getTableau();}   

    public Boolean PeutEncoreJouer()
    {
        Plateau plateau2 = new Plateau(cote, cote);
        plateau2.copyPlateau(plateau);
        if (plateau2.DeplacementGauche() || plateau2.DeplacementDroite() || plateau2.DeplacementHaut() || plateau2.DeplacementBas())
        {
            return true;
        }
        return false;
    }

    public Boolean VerificationGagner()
    {

        for(int i = 0; i < this.cote; i++)
        {
            for (int j = 0; j < this.cote; j++)
            {
                if (this.plateau.getCase(i,j).getNombre() == 2048) { return true;}
            }
        }

        return false;
    }

    public void Jouer()
    {

        Scanner lectureClavier = new Scanner(System.in);
        String direction;

        while(!VerificationGagner() && PeutEncoreJouer())
        {
            this.showPlateau();
            System.out.println("G: gauche, D: droite, H: haut, B: bas");
            direction = lectureClavier.next();
            System.out.println(" ");
            switch (direction)
            {
                case "G" -> DeplacementGauche();
                case "D" -> DeplacementDroite();
                case "H" -> DeplacementHaut();
                case "B" -> DeplacementBas();
            }
            
            


        }
    }
    public void setDifficulte(int difficulte) {this.cote = cote;}
    public int getDifficulte() {return this.cote;}
    
}
