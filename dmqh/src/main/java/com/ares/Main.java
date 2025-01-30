package com.ares;

import com.ares.View.*;
import com.ares.Model.*;

public class Main {

    public static void main(String[] args) {
        bdConnection bd = new bdConnection();
        bd.CreateDB();
        
        MainMenu frame = new MainMenu();
        frame.setVisible(true);
    }
}