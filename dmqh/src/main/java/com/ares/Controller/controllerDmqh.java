package com.ares.Controller;

import com.ares.View.gameFrame;
import com.ares.View.assets.dmqhBoard;
import com.ares.Model.Partie;
import com.ares.Model.Plateau;
import com.ares.Model.Case;

public class controllerDmqh {
    private gameFrame gameFrame;
    private static controllerDmqh instance;

    private controllerDmqh() {

    }
    
    public static controllerDmqh getInstance() {
        if (instance == null) {
            instance = new controllerDmqh();
        }
        return instance;
    }

    public void update_tableau_case() {
        Partie.getInstance().showPlateau();
    }

    // public void AfficherPlateau

    public int getSize(){
        return gameFrame.taille;
    }

    
}
