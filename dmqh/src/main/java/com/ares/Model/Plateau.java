package com.ares.Model;

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
        this.tableau_case = new Case[cote_x][cote_y];
    }
}
