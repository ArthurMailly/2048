package com.ares;

import com.ares.Model.*;
import com.ares.View.*;

import java.lang.ModuleLayer.Controller;

import com.ares.Controller.*;

public class Main {

    public static void main(String[] args) {

        controllerDmqh controller = controllerDmqh.getInstance();
        // System.out.println(controller.getPartie());

        controller.update_tableau_case();

    }
}