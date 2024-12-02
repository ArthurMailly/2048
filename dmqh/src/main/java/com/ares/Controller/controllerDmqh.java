package com.ares.Controller;

import com.ares.View.gameFrame;
import com.ares.View.assets.dmqhBoard;
import com.ares.Model.Partie;
import com.ares.Model.Plateau;
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


    
}
