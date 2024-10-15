package com.ares.Model;
import java.util.Scanner;

public class Partie
{
    private Plateau plateau;
    private int cote_x;
    private int cote_y;

    public Partie(String difficulte)
    {
        switch(difficulte)
        {
            case "Standard":
                cote_x = 4;
                cote_y = 4;
                break;
            case "Grand":
                cote_x = 8;
                cote_y = 8;
                break;
        }

        this.plateau = new Plateau(cote_x, cote_y);
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

    public Boolean PeutEncoreJouer()
    {
        Plateau plateau2 = new Plateau(4, 4);
        plateau2.copyPlateau(plateau);
        if (plateau2.DeplacementGauche() || plateau2.DeplacementDroite() || plateau2.DeplacementHaut() || plateau2.DeplacementBas())
        {
            return true;
        }
        return false;
    }

    public Boolean VerificationGagner()
    {

        for(int i = 0; i < this.cote_x; i++)
        {
            for (int j = 0; j < this.cote_y; j++)
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

}
