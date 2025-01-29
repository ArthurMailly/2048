package com.ares;


import com.ares.View.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.ares.Controller.controllerDmqh;
import com.ares.Model.*;

public class Main {

    public static void main(String[] args) {
        bdConnection bd = new bdConnection();
        bd.CreateDB();
        
        MainMenu frame = new MainMenu();
        frame.setVisible(true);

    }
}