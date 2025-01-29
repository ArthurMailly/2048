package com.ares.View.assets;

import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;
import javax.swing.*;
import com.ares.Controller.controllerDmqh;


/**
 * Classe qui crée l'aspect visuel du plateau de jeu. Elle hérite de la classe JPanel disponible dans la bibliothèque Swing de Java.
 * Cette classe regroupe les cases du jeu, elle agit comme un conteneur pour cet élément.
 * Ici, on peut retrouver une liste de cases de type CaseView, et toutes les méthodes nécessaires pour les manipuler du point de vue graphique.
 */
public class dmqhBoard extends JPanel
{
    public BufferedImage fond;
    private int taille;
    private ArrayList<CaseView> Cases = new ArrayList<CaseView>();
    private static controllerDmqh controller = controllerDmqh.getInstance();

    
    /**
     * Constructeur du plateau de jeu, on définit la taille du plateau (qui correspond à la difficulté de la partie) et on initialise le fond du plateau (noir pour mieux visualiser si on a des erreurs d'affichage).
     * Ce Jpanel dispose d'un layout de type GridLayout, qui permet de disposer les cases du plateau de jeu de manière ordonnée.
     */
    public dmqhBoard()
    {
        this.taille = controller.getDifficultePartieFromView();
        this.setBackground(Color.BLACK);

        this.setLayout(new GridLayout(taille, taille));
        Cases = createCaseArray();
        addCasesToBoard();
    }


    /**
     * Cette méthode crée un tableau de cases, en récupérant les cases du plateau de jeu via le controller.
     * @return ArrayList<CaseView> tableau de cases
     * 
     */
    public ArrayList<CaseView> createCaseArray()
    {
        return controller.getPlateauAsCase();
    }


    /**
     * Cette méthode ajoute les cases au plateau de jeu.
     */
    public void addCasesToBoard()
    {
        for (CaseView obj : Cases)
        {
            this.add(obj);
        }
    }


    /**
     * Cette méthode dessine les cases du plateau de jeu. On utilise un GridBagLayout pour pouvoir utiliser une approche matricielle du plateau de jeu.
     * On peut donc acceder à chaque élément du plateau de jeu via ses coordonnées (i,j).
     * @param g Graphics
     */
    public void dessinerCases(Graphics g)
    {
        GridBagConstraints gbc = new GridBagConstraints();
        for (int i=0; i<taille; i++)
        {
            for (int j=0; j<taille; j++)
            {
                gbc.gridx = i;
                gbc.gridy = j;
                this.add(Cases.get(i*taille+j), gbc);
            }
        }
    }


    /**
     * Cette méthode permet de mettre à jour le plateau de jeu. On commence par supprimer toutes les cases du plateau, afin de s'assurer qu'elles n'interfèrent pas avec les nouvelles cases.
     * On récupère ensuite les cases du plateau de jeu via le controller, et on les ajoute au plateau de jeu. 
     * Via une boucle for, on parcourt chaque case du plateau, et on appelle la méthode removeAll() pour supprimer les éléments de la case, puis on ajoute les labels de la case via la méthode addLabels().
     * L'objet mis à jour est ensuite ajouté au plateau de jeu. Les méthodes revalidate() et repaint() permettent de valider les changements et de les afficher.
     */
    public void updateBoard()
    { 
        this.removeAll(); // Clear the board
        Cases = controller.getPlateauAsCase();
        for (CaseView obj : Cases)
        {
            obj.removeAll();
            obj.addLabels();
            this.add(obj); // Add the updated cases to the board
        } 
        this.revalidate(); // Revalidate the board to apply changes
        this.repaint(); // Repaint the board to reflect changes
    }


    /**
     * Cette méthode permet de dessiner les cases du plateau de jeu.
     * @param g Graphics
     */
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        dessinerCases(g);
    }
}