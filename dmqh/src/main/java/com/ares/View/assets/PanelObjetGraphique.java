package com.ares.View.assets;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
   
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.*;

public class PanelObjetGraphique extends JPanel {
   private static final int RECT_X = 20;
   private static final int RECT_Y = RECT_X;
   private static final int RECT_WIDTH = 0;
   private static final int RECT_HEIGHT = RECT_WIDTH;

   @Override
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      // draw the rectangle here
      g.drawRect(RECT_X, RECT_Y, RECT_WIDTH, RECT_HEIGHT);
   }
}
