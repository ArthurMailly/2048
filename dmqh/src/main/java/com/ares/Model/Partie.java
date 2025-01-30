package com.ares.Model;
import java.util.Scanner;
import com.ares.Controller.controllerDmqh;

/**
 * Cette classe crée le modèle de la partie
 */

public class Partie
{
    public static Partie instance=null;
    public static controllerDmqh controller = controllerDmqh.getInstance();
    private Plateau plateau;
    private int cote;
    private int difficulte=2;
    private static Boolean partie_finie = false;


    /**
     * Constructeur d'une partie
     */
    private Partie()
    {
        this.cote = controller.getDifficultePartieFromView();
        this.plateau = new Plateau(cote, cote);
    }


    /**
     * Donne (et créé) l'instance d'une partie
     * @return l'instance de la partie
     */
    public static Partie getInstance()
    {
        if (instance == null) {instance = new Partie();}
        return instance;
    }

    public boolean getPartieGagnee() {return plateau.plateauGagne();}


    /**
     * Remet l'instance à null
     */
    public static void setInstanceToNull() {instance = null;}


    /**
     * Retourne le plateau
     * @return plateau
     */
    public Plateau getPlateau() {return plateau;}


    /**
     * Affiche le plateau dans le terminal (sert au débug)
     */
    public void showPlateau()
    {
        System.out.println("Score:" + this.getScore());
        this.plateau.AfficherPlateau();
    }


    /**
     * Retourne le score du joueur
     * @return le score calculé dans le plateau
     */
    public int getScore() {return this.plateau.getScore();}


    /**
     * Déplace les cases à gauche
     */
    public void DeplacementGauche() {this.plateau.DeplacementGauche();}


    /**
     * Déplace les cases à droite
     */
    public void DeplacementDroite() {this.plateau.DeplacementDroite();}


    /**
     * Déplace les cases en haut
     */
    public void DeplacementHaut() {this.plateau.DeplacementHaut();}


    /**
     * Déplace les cases en bas
     */
    public void DeplacementBas() {this.plateau.DeplacementBas();}


    /**
     * Regarde si le joueur peut encore éxécuter un mouvement
     * @return true si le joueur peut encore jouer et false sinon
     */
    public Boolean PeutEncoreJouer()
    {
        Plateau plateau2 = new Plateau(cote, cote);
        plateau2.copyPlateau(plateau);

        // Si le joueur peut faire au moins un mouvement, la partie n'est pas finie et l'on retourne true
        if (plateau2.DeplacementGauche() || plateau2.DeplacementDroite() || plateau2.DeplacementHaut() || plateau2.DeplacementBas())
        {
            partie_finie = false;
            return true;
        }
        partie_finie = true;
        return false;
    }


    /**
     * Regarde si le joueur a gagné
     * @return true si le joueur a gagné
     */
    public Boolean VerificationGagner()
    {

        for(int i = 0; i < this.cote; i++)
        {
            for (int j = 0; j < this.cote; j++)
            {
                if (this.plateau.getCase(i,j).getNombre() == 2048) {return true;}
            }
        }
        return false;
    }


    /**
     * Retourne partie_finie
     * @return partie_finie
     */
    public Boolean getPartie_finie()
    {
        PeutEncoreJouer();
        return partie_finie;
    }


    /**
     * Fonction qui permet de jouer dans la console (sert au debug)
     */
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


    /**
     * Instancie la difficulté de la partie
     * @param difficulte le coté du carré de la grille
     */
    public void setDifficulte(int difficulte) {this.cote = difficulte;}


    /**
     * Retourne la difficulté
     * @return cote
     */
    public int getDifficulte() {return this.cote;}


    /**
     * Recommence la partie
     */
    public void restart() {this.plateau = new Plateau(cote, cote);}


}