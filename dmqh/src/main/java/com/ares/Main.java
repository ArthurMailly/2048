package com.ares;


import com.ares.View.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ares.Controller.controllerDmqh;
import com.ares.Model.*;

public class Main {

    public static void main(String[] args) {
        // bdConnection bd = new bdConnection();
        // ResultSet results = bd.printAllinDB();

        new Fenetre();
        // try {
        //     while (results.next()) {
        //         String username = results.getString("username");
        //         int score = results.getInt("score");

        //         System.out.println(username + " : " + score);
                
        //     }
        // } catch (SQLException e) {
        //     e.printStackTrace();
        // }

        // controllerDmqh controller = controllerDmqh.getInstance();
        // controller.updateScore(0);

    }
}