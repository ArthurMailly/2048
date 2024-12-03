package com.ares;

import com.ares.Model.*;
import com.ares.View.*;

import java.lang.ModuleLayer.Controller;

import com.ares.Controller.*;

public class Main {

    public static void main(String[] args) {
        controllerDmqh controller = controllerDmqh.getInstance();

        int userInput=6;
        controller.setDifficultePartieFromView(userInput);
        controller.setGameFrame(new gameFrame());

        

       

        controller.getPartie().Jouer();
        while(controller.getPartie().PeutEncoreJouer() && !controller.getPartie().VerificationGagner())
        {
            
            controller.getGameFrame().update();
            

        }
     


        // Partie partie =new Partie();
        
        // gameFrame gameFrame = new gameFrame();


        // controller.setDifficultePartie(4);
        // controller.setSizeGameFrame(4);





        
        

    }
}