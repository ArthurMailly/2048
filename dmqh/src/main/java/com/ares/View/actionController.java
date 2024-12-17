package com.ares.View;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.ares.Controller.*;

import javax.swing.*;


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
                case KeyEvent.VK_Q, KeyEvent.VK_LEFT:
                    controller.getPartie().DeplacementGauche();
                    break;
                case KeyEvent.VK_D, KeyEvent.VK_RIGHT:
                    controller.getPartie().DeplacementDroite();
                    break;
                case KeyEvent.VK_Z, KeyEvent.VK_UP:
                    controller.getPartie().DeplacementHaut();
                    break;
                case KeyEvent.VK_S, KeyEvent.VK_DOWN:
                    controller.getPartie().DeplacementBas();
                    break;
                case KeyEvent.VK_R:
                    controller.getPartie().restart();
                    break;
                case KeyEvent.VK_ESCAPE:
                    for (Window window : Window.getWindows()) {
                        window.dispose(); // Ferme chaque fenêtre
                    }
                    new Fenetre();
                    break;
//                default:
//                    System.out.println("Key pressed: " + e.getKeyChar());
            }
    }

    public void keyReleased(KeyEvent e) {
        // Invoked when a key has been released.
        controller.getGameFrame().update();
    }
    
}
