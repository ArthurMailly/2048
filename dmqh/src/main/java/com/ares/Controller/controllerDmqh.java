package com.ares.Controller;

import com.ares.View.gameFrame;
import com.ares.Model.Partie;
import com.ares.Model.Plateau;

public class controllerDmqh {
    private static controllerDmqh instance;
    private Partie partie;
    private controllerDmqh() {

    }
    
    public controllerDmqh getInstance() {
        if (instance == null) {
            instance = new controllerDmqh();
        }
        return instance;
    }

    public Partie getPartie() {
        return partie;
    }

    
}
