package com.ares.View;
import javax.swing.*;

public class HelpWindow {
    JLabel helpText;
    JPanel helpPanel;
    public HelpWindow() {
        JFrame frame = new JFrame("Help");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 500);

        helpText = new JLabel("This is a 2048 game. The goal is to reach 2048 by combining tiles with the same number. You can move the tiles by using the arrow keys. Good luck!");
        helpPanel = new JPanel();
        helpPanel.add(helpText);
        frame.add(helpPanel);
        
        frame.setVisible(true);
        
    }
}
