package com.ares.View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.*;

import com.ares.Controller.controllerDmqh;
import com.ares.Model.bdConnection;
import com.ares.View.assets.dmqhBoard;


/**
 * Cette classe centralise les éléments graphiques du jeu, et permet de les afficher à l'écran. Elle agit comme un conteneur pour les éléments graphiques du jeu.
 * Elle hérite de la classe JFrame disponible dans la bibliothèque Swing de Java. Dedans, nous pouvons retrouver les classes principales permettant l'affichage du jeu; 
 *  - actionController, qui permet de gérer les actions du joueur, en fonction des touches du clavier appuyées.
 *  - dmqhBoard, qui crée l'aspect visuel du plateau de jeu.
 * Ainsi que les panels principaux de la fenêtre de jeu:
    * - mainPanel, qui est le panel principal de la fenêtre de jeu.
    * - infoPanel, qui est le panel d'information de la fenêtre de jeu.
    * - scorePanel, qui est le panel de score de la fenêtre de jeu.
 */
public class gameFrame extends JFrame {

    public actionController actionController;
    public JPanel mainPanel,infoPanel, scorePanel;
    public dmqhBoard dmqhBoard;
    public JLabel exitLabel, restartLabel, scoreLabel;
    public JButton exitButton;
    public bdConnection bd;


    /**
     * Constructeur de la fenêtre de jeu, qui initialise les éléments graphiques du jeu.
     * On définit le titre de la fenêtre, sa taille, sa couleur de fond, et on ajoute les éléments graphiques principaux de la fenêtre de jeu.
     * On ajoute également un KeyListener pour gérer les actions du joueur.
     * 
     */
    public gameFrame()
    {
        controllerDmqh controller = controllerDmqh.getInstance();
        this.setTitle("2048");
        setBounds(500,100,500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBackground(java.awt.Color.WHITE);
        bd = controller.connectToDB();
        
        dmqhBoard = new dmqhBoard();
        mainPanel = new JPanel(new BorderLayout());
        scorePanel = new JPanel();
        infoPanel = new JPanel();
        scoreLabel = new JLabel();

        actionController = new actionController();
        this.addKeyListener(actionController);

        scoreLabel.setText("Score : "+controller.getPartie().getScore());
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scoreLabel.setFont(scoreLabel.getFont().deriveFont(20.0f));
        scoreLabel.setSize(100, 100);
        scorePanel.add(scoreLabel);

        exitLabel = new JLabel("ECHAP: quitter");
        exitLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        exitLabel.setFont(exitLabel.getFont().deriveFont(20.0f));

        restartLabel = new JLabel("R: recommencer");
        restartLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        restartLabel.setFont(restartLabel.getFont().deriveFont(20.0f));

        infoPanel.add(exitLabel, BorderLayout.WEST);
        infoPanel.add(restartLabel, BorderLayout.EAST);
        
        mainPanel.add(scorePanel, BorderLayout.NORTH);
        mainPanel.add(dmqhBoard, BorderLayout.CENTER);
        mainPanel.add(infoPanel, BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setVisible(true);
    }


    /**
     * Cette méthode permet de mettre à jour l'écran de jeu, en fonction de l'état de la partie.
     * Si la partie est finie, un écran de fin de partie s'affiche, avec le score du joueur.
     * Sinon, l'écran de jeu est mis à jour, et le score du joueur est affiché.
     * Afin de mettre à jour, on appelle la méthode updateBoard() de la classe dmqhBoard, qui permet de mettre à jour le plateau de jeu.
     * 
     */
    public void update()
    {
        
        controllerDmqh controller= controllerDmqh.getInstance();
        if (controller.getPartie().getPartie_finie())
        {
            ResultSet results = bd.printAllinDB();
            ArrayList<String> usernameList = new ArrayList<String>();
            
            int score = controllerDmqh.getInstance().getPartie().getScore();
            dmqhBoard.updateBoard();
            updateScore();
            if (controllerDmqh.getInstance().getPartie().getPartieGagnee())
            {
                this.scoreLabel.setText("Vous avez gagné ! Votre score est "+score+" !");
            }
            else
            {
                this.scoreLabel.setText("Vous avez perdu ! Votre score est "+score+" !");
            }

            try {
                while (results.next()) {
                    usernameList.add(results.getString("username"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(usernameList);

            if(usernameList.contains(controller.getUsername())) {controller.updateScorInDB(score);}
            else {controller.insertNewScore(score);}
        }
        else
        {
            dmqhBoard.updateBoard();
            updateScore();
        }
    }


    /**
     * Cette méthode permet de mettre à jour le score du joueur, en fonction de son score actuel.
     * Pour un ajout visuel, chaque mise à jour du score change la couleur du texte du score de facon aléatoire.
     */
    public void updateScore()
    {
        Color randColor = new Color((int)(Math.random() * 256), (int)(Math.random() * 256), (int)(Math.random() * 256));
        int score = controllerDmqh.getInstance().getPartie().getScore();
        scorePanel.removeAll();
        String gagneLabel = "";

        if (controllerDmqh.getInstance().getPartie().getPartieGagnee()) {gagneLabel = "Bravo ! Vous avez gagné ! ";}
        
        if (0 < score && score < 100)
        {
            scoreLabel.setText(gagneLabel+"Score du débutant : "+score);
        }
        else if (500<=score && score <1000)
        {
            scoreLabel.setText(gagneLabel+"Score du joueur expérimenté : "+score);
        }
        else if (3000<=score && score <7000)
        {
            scoreLabel.setText(gagneLabel+"Score du pro : "+score);
        }
        else if (score >= 7000)
        {
            scoreLabel.setText(gagneLabel+"Score du GOAT : "+score);
        }
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        scoreLabel.setFont(scoreLabel.getFont().deriveFont(20.0f));
        scoreLabel.setSize(100, 100);
        scoreLabel.setForeground(randColor);
        scorePanel.add(scoreLabel);
        scorePanel.repaint();
    }
}