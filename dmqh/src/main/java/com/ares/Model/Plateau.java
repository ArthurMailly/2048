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

        int case1_x = randomCase.nextInt(this.cote_x);
        int case1_y = randomCase.nextInt(this.cote_y);
        CreerCase(case1_x, case1_y, false);

        System.out.print(case1_x);
        System.out.println(case1_y);

        int case2_x = randomCase.nextInt(this.cote_x);
        int case2_y = randomCase.nextInt(this.cote_y);

        while ((case1_x == case2_x) && (case1_y == case2_y))
        {
            case2_x = randomCase.nextInt(this.cote_x);
            case2_y = randomCase.nextInt(this.cote_y);
        }

        CreerCase(case2_x, case2_y, false);
        System.out.print(case2_x);
        System.out.println(case2_y);

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

    public void CreerCase(int x, int y, boolean b) { this.tableau_case[x][y] = new Case(x, y, b);}

    public void CreerCaseNum(int x, int y, int n) { this.tableau_case[x][y] = new Case(x, y, n);}

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
                    this.tableau_case[new_I][j].DeplacerCase(-1, 0);
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
    }



}
