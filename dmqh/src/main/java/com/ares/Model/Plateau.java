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
        Random randomCase = new Random();

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
    }

    public void CreerCase(int x, int y, boolean b) { this.tableau_case[x][y] = new Case(b);}

    public void CreerCaseNum(int x, int y, int n) { this.tableau_case[x][y] = new Case(n);}

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

    public void DeplacementGauche()
    {
        for (int j = 0; j < this.cote_y; j++)
        {
            for (int i = 1; i < this.cote_x; i++)
            {

                int new_I = i;

                while ((new_I > 0) && (this.tableau_case[new_I-1][j].getNombre() == 0))
                {
                    this.tableau_case[new_I-1][j] = this.tableau_case[new_I][j];
                    CreerCase(new_I,j,true);

                    new_I = new_I - 1;
                }

                if ((new_I > 0) &&(this.tableau_case[new_I-1][j].getNombre() == this.tableau_case[new_I][j].getNombre()))
                {
                    CreerCaseNum(new_I-1, j, this.tableau_case[new_I-1][j].getNombre() * 2);
                    CreerCase(new_I, j, true);
                }

            }
        }
        PlaceCaseAleatoire();
    }

    public void DeplacementDroite()
    {
        for (int j = 0; j < this.cote_y; j++)
        {
            for (int i = this.cote_x - 1; i >= 0; i--)
            {

                int new_I = i;

                while ((new_I < this.cote_x-1) && (this.tableau_case[new_I+1][j].getNombre() == 0))
                {
                    this.tableau_case[new_I+1][j] = this.tableau_case[new_I][j];
                    CreerCase(new_I,j,true);

                    new_I = new_I + 1;
                }

                if ((new_I < this.cote_x-1) &&(this.tableau_case[new_I+1][j].getNombre() == this.tableau_case[new_I][j].getNombre()))
                {
                    CreerCaseNum(new_I+1, j, this.tableau_case[new_I+1][j].getNombre() * 2);
                    CreerCase(new_I, j, true);
                }

            }
        }
        PlaceCaseAleatoire();
    }

    public void DeplacementHaut()
    {
        for (int i = 0; i < this.cote_x; i++)
        {
            for (int j = 1; j < this.cote_y; j++)
            {

                int new_J = j;

                while ((new_J > 0) && (this.tableau_case[i][new_J-1].getNombre() == 0))
                {
                    this.tableau_case[i][new_J-1] = this.tableau_case[i][new_J];
                    CreerCase(i,new_J,true);

                    new_J = new_J - 1;
                }

                if ((new_J > 0) &&(this.tableau_case[i][new_J-1].getNombre() == this.tableau_case[i][new_J].getNombre()))
                {
                    CreerCaseNum(i, new_J-1, this.tableau_case[i][new_J-1].getNombre() * 2);
                    CreerCase(i, new_J, true);
                }

            }
        }
        PlaceCaseAleatoire();
    }

    public void DeplacementBas()
    {
        for (int i = 0; i < this.cote_x; i++)
        {
            for (int j = this.cote_y - 1; j >= 0; j--)
            {

                int new_J = j;

                while ((new_J < this.cote_y-1) && (this.tableau_case[i][new_J+1].getNombre() == 0))
                {
                    this.tableau_case[i][new_J+1] = this.tableau_case[i][new_J];
                    CreerCase(i,new_J,true);

                    new_J = new_J + 1;
                }

                if ((new_J < this.cote_y-1) &&(this.tableau_case[i][new_J+1].getNombre() == this.tableau_case[i][new_J].getNombre()))
                {
                    CreerCaseNum(i, new_J+1, this.tableau_case[i][new_J+1].getNombre() * 2);
                    CreerCase(i, new_J, true);
                }

            }
        }
        PlaceCaseAleatoire();
    }



}
