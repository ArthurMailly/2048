package com.ares.View;

import javax.swing.*;

import com.ares.Controller.controllerDmqh;
import com.ares.Model.bdConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UsernameInputFrame extends JFrame {
    private JTextField usernameField;
    private JButton saveButton;
    private controllerDmqh controllerDmqh = com.ares.Controller.controllerDmqh.getInstance();
    
    public UsernameInputFrame() {
        
        setTitle("Save Your Score");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        // Label
        JLabel label = new JLabel("Enter your username:", SwingConstants.CENTER);
        add(label, BorderLayout.NORTH);
        
        // Text Field
        usernameField = new JTextField();
        add(usernameField, BorderLayout.CENTER);
        
        // Button
        saveButton = new JButton("Save Score");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                if (!username.isEmpty()) {
                    saveScore(username,controllerDmqh.getUsernameList());
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Username cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(saveButton, BorderLayout.SOUTH);
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void saveScore(String username,ArrayList<String> usernameList ) {
        bdConnection bdConnection = controllerDmqh.connectToDB();
        int score = controllerDmqh.getPartie().getScore();

        if (usernameList.contains(username)) {
            controllerDmqh.updateScorInDB(controllerDmqh.getUsername(),username, score);
            System.out.println("Score updated for: " + username);
        } else {
            controllerDmqh.insertNewScore(controllerDmqh.getUsername(),username, score);
            System.out.println("Score saved for: " + username);
            
        }
        bdConnection.closeConnection();
    }
    
    public static void main(String[] args) {
        new UsernameInputFrame();
    }
}

