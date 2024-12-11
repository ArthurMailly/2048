package com.ares;

import com.ares.Model.*;
import com.ares.View.*;

import java.lang.ModuleLayer.Controller;
import java.util.Scanner;

import com.ares.Controller.*;

public class Main {

    public static void main(String[] args) {
        controllerDmqh controller = controllerDmqh.getInstance();
        int i=0;

        int userInput=4;
        Scanner lectureClavier = new Scanner(System.in);
        String direction;

        controller.setDifficultePartieFromView(userInput);
        controller.setGameFrame(new gameFrame());

        

        

        // controller.getPartie().Jouer();
        while(controller.getPartie().PeutEncoreJouer() && !controller.getPartie().VerificationGagner() && i < 10)
        {
            controller.getPartie().showPlateau();
            System.out.println("G: gauche, D: droite, H: haut, B: bas");
            direction = lectureClavier.next();
            System.out.println(" ");
            switch (direction)
            {
                case "G" -> controller.getPartie().DeplacementGauche();
                case "D" -> controller.getPartie().DeplacementDroite();
                case "H" -> controller.getPartie().DeplacementHaut();
                case "B" -> controller.getPartie().DeplacementBas();
            }
            i++;
            System.out.println("i : "+i);
            controller.getGameFrame().update();
            
            


        }
        
    
     


        // Partie partie =new Partie();
        
        // gameFrame gameFrame = new gameFrame();


        // controller.setDifficultePartie(4);
        // controller.setSizeGameFrame(4);





        
        

    }
}