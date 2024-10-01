package com.ares;
import com.ares.Model.Case;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Case lacase = new Case(1,0);
        lacase.printCase();
        lacase.DeplacerCase(1,-1);
        lacase.printCase();
    }
}