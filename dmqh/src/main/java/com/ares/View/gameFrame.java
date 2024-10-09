package com.ares.View;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class gameFrame extends JFrame {
    BufferedImage Logo;

    public gameFrame()
    {
        this.setTitle("2048!");
        this.setSize(1000, 1000);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        try {
            Logo=ImageIO.read(new File("C:\\Users\\sfarf\\Bureau\\Repos_Git\\Java_2048\\2048\\dmqh\\src\\main\\resources\\Logo_dmqh.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setIconImage(Logo);
}


    
    
}
