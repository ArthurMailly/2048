package com.ares.Model;

/**
 * Cette classe crée le modèle des cases.
 */

public class Case {

    private int nombre;
    private boolean deja_fusionne;


    /**
     * Constructeur d'une nouvelle case.
     * Si ce n'est pas le cas, alors il s'agit d'une nouvelle case et l'on doit
     * y mettre un 2 ou un 4 que l'on détermine aléatoirement.
     * @param vide est égal à true s'il s'agit d'une case vide dans le tableau.
     */
    public Case(boolean vide)
    {
        if (!vide) // Si la case n'est pas vide, alors elle doit contenir un nombre qui est 2 ou 4.
        {
            double proba = Math.random();
            if (proba < 0.9) {this.nombre = 2;}
            else{this.nombre = 4;}
        }
        else {this.nombre = 0;}

        this.deja_fusionne = false;
    }


    /**
     * Constructeur d'une case en lui donnant le nombre
     * @param nombre nombre que contient la case
     */
    public Case(int nombre)
    {
        this.nombre = nombre;
        this.deja_fusionne = false;
    }


    /**
     * Affiche le nombre de la case, sert pour le débug
     */
    public void print()
    {
        System.out.print(nombre);
    }


    /**
     * Return le numéro qui se trouve dans la case
     * @return nombre
     */
    public int getNombre()
    {
        return nombre;
    }


    /**
     * Change le paramètre deja_fusionne
     * @param deja_fusionne est égal à true si la case à déjà été fusionné pendant se tour
     */
    public void setDeja_fusionne(boolean deja_fusionne) { this.deja_fusionne = deja_fusionne; }


    /**
     * Retourne le booléen deja_fusionne
     * @return deja_fusionne
     */
    public boolean getDeja_fusionne() {return this.deja_fusionne;}


    /**
     * Copie une case
     * @param case2 case à recopier
     */
    public void copyCase(Case case2)
    {
        this.nombre = case2.nombre;
        this.deja_fusionne = case2.deja_fusionne;
    }
}
