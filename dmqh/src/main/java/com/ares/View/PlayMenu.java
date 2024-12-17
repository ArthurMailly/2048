package com.ares.View;

import com.ares.Controller.controllerDmqh;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayMenu extends JPanel
{
    JLabel label;
    JButton easyMode, classicMode, retourMenuButton;

    public PlayMenu(JPanel cardPanel)
    {
        setBounds(500, 100, 500, 500);
        CardLayout cl = (CardLayout) cardPanel.getLayout();
        setLayout(null);

        label = new JLabel("Allons jouer !", JLabel.CENTER);
        label.setBounds(120, 100, 250, 50);
        label.setFont(new Font("Verdana", Font.PLAIN, 20));
        this.add(label);

        easyMode = new JButton("Facile");
        easyMode.setBounds(200, 150, 100, 45);
        this.add(easyMode);
        easyMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jouerEasyMode(e);
            }
        });

        classicMode = new JButton("Classique");
        classicMode.setBounds(200, 250, 100, 45);
        this.add(classicMode);
        classicMode.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jouerClassicMode(e);
            }
        });

        retourMenuButton = new JButton("Retour");
        retourMenuButton.setBounds(200, 400, 100, 45);
        this.add(retourMenuButton);
        retourMenuButton.addActionListener(event -> cl.show(cardPanel, "MainMenu"));
    }

    public void jouerClassicMode(ActionEvent e)
    {
        controllerDmqh controller = controllerDmqh.getInstance();
        int userInput=4;
        controller.setDifficultePartieFromView(userInput);
        controller.setGameFrame(new gameFrame());
        SwingUtilities.getWindowAncestor(this).dispose();
    }

    public void jouerEasyMode(ActionEvent e)
    {
        controllerDmqh controller = controllerDmqh.getInstance();
        int userInput=6;
        controller.setDifficultePartieFromView(userInput);
        controller.setGameFrame(new gameFrame());
        SwingUtilities.getWindowAncestor(this).dispose();
    }
}
