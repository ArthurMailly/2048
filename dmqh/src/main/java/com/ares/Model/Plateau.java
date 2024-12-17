package com.ares.Model;

import java.util.Random;

public class Plateau
{
    private int score;
    private int cote_x;
    private int cote_y;
    private Case tableau_case[][];

    public Plateau(int x, int y)
    {
        this.score = 0;
        this.cote_x = x;
        this.cote_y = y;

        this.tableau_case = new Case[this.cote_x][this.cote_y];
        for (int i = 0; i < this.cote_x; i++)
        {
            for (int j = 0; j < this.cote_y; j++)
            {
                CreerCase(i, j, true);
            }
        }

        // Initialisation des deux premières cases différentes de 0

        PlaceCaseAleatoire();
        PlaceCaseAleatoire();

    }

    public void AfficherPlateau()
    {
        for (int j = 0; j < this.cote_y; j++)
        {
            for (int i = 0; i < this.cote_x; i++)
            {
                this.tableau_case[i][j].print();
                System.out.print("\t");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

    }

    public void CreerCase(int x, int y, boolean b) { this.tableau_case[x][y] = new Case(b);}

    public void CreerCaseNum(int x, int y, int n) { this.tableau_case[x][y] = new Case(n, false);}

    public void PlaceCaseAleatoire()
    {
        Random randomCase = new Random();
        int case_x = randomCase.nextInt(this.cote_x);
        int case_y = randomCase.nextInt(this.cote_y);

        while(this.tableau_case[case_x][case_y].getNombre() != 0)
        {
            case_x = randomCase.nextInt(this.cote_x);
            case_y = randomCase.nextInt(this.cote_y);
        }

        CreerCase(case_x, case_y, false);

    }

    public Boolean DeplacementGauche() {
        Boolean deplacement_fait = false;

        // Réinitialise l'état de fusion pour toutes les cases au début
        ToutesCasesPasFusionnees();

        for (int j = 0; j < this.cote_y; j++) {
            for (int i = 1; i < this.cote_x; i++) { // On commence à la deuxième colonne
                int new_I = i;

                // Déplacement des cases vers la gauche
                while (new_I > 0 && this.tableau_case[new_I - 1][j].getNombre() == 0) {
                    if (this.tableau_case[new_I][j].getNombre() != 0) {
                        deplacement_fait = true;
                    }

                    // Déplace la case
                    this.tableau_case[new_I - 1][j] = this.tableau_case[new_I][j];
                    CreerCase(new_I, j, true); // Vide l'ancienne position
                    new_I--;
                }

                // Vérifie si une fusion est possible
                if (new_I > 0 &&
                        !this.tableau_case[new_I - 1][j].getDeja_fusionne() &&
                        this.tableau_case[new_I - 1][j].getNombre() == this.tableau_case[new_I][j].getNombre()) {

                    // Fusionne les cases
                    deplacement_fait = true;
                    int num_case = this.tableau_case[new_I - 1][j].getNombre() * 2;
                    CreerCaseNum(new_I - 1, j, num_case); // Crée la case fusionnée
                    CreerCase(new_I, j, true); // Vide l'ancienne case
                    score += num_case;

                    // Marque la case comme fusionnée
                    this.tableau_case[new_I - 1][j].setDeja_fusionne(true);
                }
            }
        }

        // Place une nouvelle case aléatoire si un déplacement a été effectué
        if (deplacement_fait) {
            PlaceCaseAleatoire();
        }
        System.out.println("Deplacement fait gauche: "+deplacement_fait);
        return deplacement_fait;
    }

    public Boolean DeplacementDroite() {
        Boolean deplacement_fait = false;

        // Réinitialise l'état de fusion pour toutes les cases au début
        ToutesCasesPasFusionnees();

        for (int j = 0; j < this.cote_y; j++) {
            for (int i = this.cote_x - 2; i >= 0; i--) { // On commence à l'avant-dernière colonne
                int new_I = i;

                // Déplacement des cases vers la droite
                while (new_I < this.cote_x - 1 && this.tableau_case[new_I + 1][j].getNombre() == 0) {
                    if (this.tableau_case[new_I][j].getNombre() != 0) {
                        deplacement_fait = true;
                    }

                    // Déplace la case
                    this.tableau_case[new_I + 1][j] = this.tableau_case[new_I][j];
                    CreerCase(new_I, j, true); // Vide l'ancienne position
                    new_I++;
                }

                // Vérifie si une fusion est possible
                if (new_I < this.cote_x - 1 &&
                        !this.tableau_case[new_I + 1][j].getDeja_fusionne() &&
                        this.tableau_case[new_I + 1][j].getNombre() == this.tableau_case[new_I][j].getNombre()) {

                    // Fusionne les cases
                    deplacement_fait = true;
                    int num_case = this.tableau_case[new_I + 1][j].getNombre() * 2;
                    CreerCaseNum(new_I + 1, j, num_case); // Crée la case fusionnée
                    CreerCase(new_I, j, true); // Vide l'ancienne case
                    score += num_case;

                    // Marque la case comme fusionnée
                    this.tableau_case[new_I + 1][j].setDeja_fusionne(true);
                }
            }
        }

        // Place une nouvelle case aléatoire si un déplacement a été effectué
        if (deplacement_fait) {
            PlaceCaseAleatoire();
        }

        System.out.println("Deplacement fait droite: "+deplacement_fait);

        return deplacement_fait;
    }

    public Boolean DeplacementHaut() {
        Boolean deplacement_fait = false;

        // Réinitialise l'état de fusion pour toutes les cases au début
        ToutesCasesPasFusionnees();

        for (int i = 0; i < this.cote_x; i++) {
            for (int j = 1; j < this.cote_y; j++) { // On commence à la deuxième ligne
                int new_J = j;

                // Déplacement des cases vers le haut
                while (new_J > 0 && this.tableau_case[i][new_J - 1].getNombre() == 0) {
                    if (this.tableau_case[i][new_J].getNombre() != 0) {
                        deplacement_fait = true;
                    }

                    // Déplace la case
                    this.tableau_case[i][new_J - 1] = this.tableau_case[i][new_J];
                    CreerCase(i, new_J, true); // Vide l'ancienne position
                    new_J--;
                }

                // Vérifie si une fusion est possible
                if (new_J > 0 &&
                        !this.tableau_case[i][new_J - 1].getDeja_fusionne() &&
                        this.tableau_case[i][new_J - 1].getNombre() == this.tableau_case[i][new_J].getNombre()) {

                    // Fusionne les cases
                    deplacement_fait = true;
                    int num_case = this.tableau_case[i][new_J - 1].getNombre() * 2;
                    CreerCaseNum(i, new_J - 1, num_case); // Crée la case fusionnée
                    CreerCase(i, new_J, true); // Vide l'ancienne case
                    score += num_case;

                    // Marque la case comme fusionnée
                    this.tableau_case[i][new_J - 1].setDeja_fusionne(true);
                }
            }
        }

        // Place une nouvelle case aléatoire si un déplacement a été effectué
        if (deplacement_fait) {
            PlaceCaseAleatoire();
        }

        System.out.println("Deplacement fait haut: "+deplacement_fait);
        return deplacement_fait;
    }


    public Boolean DeplacementBas() {
        Boolean deplacement_fait = false;

        // Réinitialise l'état de fusion pour toutes les cases au début
        ToutesCasesPasFusionnees();

        for (int i = 0; i < this.cote_x; i++) {
            for (int j = this.cote_y - 2; j >= 0; j--) { // On part de l'avant-dernière ligne
                int new_J = j;

                // Déplacement des cases vers le bas
                while (new_J < this.cote_y - 1 && this.tableau_case[i][new_J + 1].getNombre() == 0) {
                    if (this.tableau_case[i][new_J].getNombre() != 0) {
                        deplacement_fait = true;
                    }

                    // Déplace la case
                    this.tableau_case[i][new_J + 1] = this.tableau_case[i][new_J];
                    CreerCase(i, new_J, true); // Vide l'ancienne position
                    new_J++;
                }

                // Vérifie si une fusion est possible
                if (new_J < this.cote_y - 1 &&
                        !this.tableau_case[i][new_J + 1].getDeja_fusionne() &&
                        this.tableau_case[i][new_J + 1].getNombre() == this.tableau_case[i][new_J].getNombre()) {

                    // Fusionne les cases
                    deplacement_fait = true;
                    int num_case = this.tableau_case[i][new_J + 1].getNombre() * 2;
                    CreerCaseNum(i, new_J + 1, num_case); // Crée la case fusionnée
                    CreerCase(i, new_J, true); // Vide l'ancienne case
                    score += num_case;

                    // Marque la case comme fusionnée
                    this.tableau_case[i][new_J + 1].setDeja_fusionne(true);
                }
            }
        }

        // Place une nouvelle case aléatoire si un déplacement a été effectué
        if (deplacement_fait) {
            PlaceCaseAleatoire();
        }

        System.out.println("Deplacement fait bas: "+deplacement_fait);
        return deplacement_fait;
    }


    public void ToutesCasesPasFusionnees()
    {
        for (int i = 0; i < this.cote_x; i++)
        {
            for (int j = 0; j < this.cote_y; j++)
            {
                this.tableau_case[i][j].setDeja_fusionne(false);
            }
        }
    }

    public int getScore()
    {
        return this.score;
    }

    public Case getCase(int i,int j)
    {
        return this.tableau_case[i][j];
    }

    public Case[][] getTableau()
    {
        return this.tableau_case;
    }

    public void copyPlateau(Plateau plateau2)
    {
        this.score = plateau2.score;
        this.cote_x = plateau2.cote_x;
        this.cote_y = plateau2.cote_y;

        for (int i = 0; i < cote_x; i++)
        {
            for (int j = 0; j < cote_y; j++)
            {
                this.tableau_case[i][j].copyCase(plateau2.tableau_case[i][j]);
            }
        }
    }

}
