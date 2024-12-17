package com.ares.View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.ares.Controller.*;


public class actionController implements KeyListener 
{
    controllerDmqh controller;
    public void keyTyped(KeyEvent e) {
        // Invoked when a key has been typed.
        // System.out.println("Key typed: " + e.getKeyChar());
    }

    public void keyPressed(KeyEvent e) {
        // Invoked when a key has been pressed.
        controller= controllerDmqh.getInstance();
        switch (e.getKeyCode())
            {
                case KeyEvent.VK_Q -> controller.getPartie().DeplacementGauche();
                case KeyEvent.VK_D -> controller.getPartie().DeplacementDroite();
                case KeyEvent.VK_Z -> controller.getPartie().DeplacementHaut();
                case KeyEvent.VK_S -> controller.getPartie().DeplacementBas();
                case KeyEvent.VK_R -> controller.getPartie().restart();
                case KeyEvent.VK_ESCAPE -> System.exit(0);
                default -> System.out.println("Key pressed: " + e.getKeyChar());
            }
    }

    public void keyReleased(KeyEvent e) {
        // Invoked when a key has been released.
        controller.getPartie().showPlateau();
        controller.getGameFrame().update();
    }
    
}
