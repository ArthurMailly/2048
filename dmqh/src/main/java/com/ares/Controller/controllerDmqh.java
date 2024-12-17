package com.ares.Controller;

import com.ares.View.gameFrame;
import com.ares.View.assets.dmqhBoard;
import com.ares.Model.Partie;
import com.ares.Model.Plateau;

import java.awt.Point;
import java.util.ArrayList;

import com.ares.Model.Case;

public class controllerDmqh {
    private gameFrame gameFrame;
    private static controllerDmqh instance;
    private int difficultePartie;

    private controllerDmqh() {

    }
    
    public static controllerDmqh getInstance() {
        if (instance == null) {
            instance = new controllerDmqh();
        }
        return instance;
    }

    public Partie getPartie() {
        return Partie.getInstance();
    }
    public void setPartie(Partie partie) {
        Partie.instance = partie;
    }


    // public void AfficherPlateau

    public int getSizeGameFrame(){
        return difficultePartie;
    }
    public void setDifficultePartie(int difficulte){
        Partie.getInstance().setDifficulte(difficulte);
    }
    public void getDifficultePartie(){
        Partie.getInstance().getDifficulte();
    }
    public int getDifficultePartieFromView(){
        return difficultePartie;
    }
    public void setDifficultePartieFromView(int difficulte){
        difficultePartie = difficulte;
    }
    public void updateGameFrame(){
        gameFrame.update();
    }
    public void setGameFrame(gameFrame gameFrame){
        this.gameFrame = gameFrame;
    }
    public gameFrame getGameFrame(){
        return gameFrame;
    }
    public ArrayList<com.ares.View.assets.Case> getPlateauAsCase(){
        ArrayList<com.ares.View.assets.Case> Cases = new ArrayList<com.ares.View.assets.Case>();
        Partie partie = getPartie();
        for (int i = 0; i < partie.getDifficulte(); i++)
        {
            for (int j = 0; j < partie.getDifficulte(); j++)
            {
                com.ares.View.assets.Case c = new com.ares.View.assets.Case(300,partie.getPlateau().getTableau()[j][i].getNombre(),new Point(i,j),partie.getPlateau().getTableau()[i][j].getCouleur());
                Cases.add(c);
            }
        }
        return Cases;
    }

    public void restart(){
        Partie.getInstance().restart();
    }


    
}
