package com.ares;

import com.ares.Model.*;
import com.ares.View.*;

import java.lang.ModuleLayer.Controller;
import java.util.Scanner;

import com.ares.Controller.*;

public class Main {

    public static void main(String[] args) {
        controllerDmqh controller = controllerDmqh.getInstance();
        int userInput=4;
        controller.setDifficultePartieFromView(userInput);
        controller.setGameFrame(new gameFrame());
    }
}