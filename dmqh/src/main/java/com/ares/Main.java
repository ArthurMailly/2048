package com.ares;

import com.ares.View.*;
import com.ares.Controller.controllerDmqh;
import com.ares.Model.*;

public class Main {

    public static void main(String[] args) {
        bdConnection bd = new bdConnection();
        bd.CreateDB();
        // bd.DropTable();

        // bd.insertNewScore("postgres", "ArthurLeNaze", -8000);
        // bd.insertNewScore("postgres", "AudreyLaBG", 456000);
        // bd.insertNewScore("postgres", "AlexisCalvitie", 5689);
        // bd.insertNewScore("postgres", "ManonLeDindon", 5689);
        // bd.insertNewScore("postgres", "TiboTroCho", 80000);
        // bd.insertNewScore("postgres", "FagridLeBolide", 100000000);
        
        
        MainMenu frame = new MainMenu();
        frame.setVisible(true);

        
    }
}