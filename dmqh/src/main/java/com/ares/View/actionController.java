package com.ares.View;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import com.ares.Controller.*;
import com.ares.Model.Partie;

import javax.swing.*;

/**
 * Cette classe permet de gérer les actions du joueur, en fonction des touches du clavier appuyées.
 * Elle implémente l'interface KeyListener, qui permet de gérer les événements liés aux touches du clavier, en utilisant un Switch Case pour déterminer l'action à effectuer.
 */
public class actionController implements KeyListener 
{
    controllerDmqh controller;
    public void keyTyped(KeyEvent e) {}

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
                    Partie.setInstanceToNull();
                    for (Window window : Window.getWindows()) {
                        window.dispose(); // Ferme chaque fenêtre
                    }
                    new Fenetre();
                    break;
            }
    }
    /**
     * Cette méthode est appelée lorsque la touche est relâchée. A chaque fois que le joueur appuie sur une touche, le jeu met à jour l'écran et l'état des cases.
     * Ceci permet d'avoir un affichage en temps réel des actions du joueur.
     */
    public void keyReleased(KeyEvent e) {
        // Invoked when a key has been released.
        controller.getGameFrame().update();
    }
    
}
