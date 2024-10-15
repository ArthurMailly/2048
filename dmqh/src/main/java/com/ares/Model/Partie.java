package com.ares.Model;

public class Partie
{
    private Plateau plateau;

    public Partie(String difficulte)
    {
        switch(difficulte)
        {
            case "Standard" -> this.plateau = new Plateau(4, 4);
            case "Grand" -> this.plateau = new Plateau(8,8);
        }

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

    public void PeutEncoreJouer()
    {
        Plateau plateau2 = new Plateau(4, 4);
        plateau2.copyPlateau(plateau);
        if (plateau2.DeplacementGauche() || plateau2.DeplacementDroite() || plateau2.DeplacementHaut() || plateau2.DeplacementBas())
        {
            System.out.println("La partie n'est pas finie.");
        }
        else
        {
            System.out.println("La partie est finie.");
        }
    }


}
