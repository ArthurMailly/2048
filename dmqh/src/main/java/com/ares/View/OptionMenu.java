package com.ares.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OptionMenu extends JFrame
{
    JButton retourMenuButton;
    JLabel title;
    JPanel contentPane;

    public OptionMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(500, 100, 500, 500);
        setTitle("2048!");

        contentPane = new JPanel();
        contentPane.setLayout(null);
        setContentPane(contentPane);

        title = new JLabel("Options", JLabel.CENTER);
        title.setBounds(120, 100, 250, 50);
        title.setFont(new Font("Verdana", Font.PLAIN, 20));
        contentPane.add(title);

        retourMenuButton = new JButton("Retour");
        retourMenuButton.setBounds(200, 400, 100, 45);
        contentPane.add(retourMenuButton);
        retourMenuButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pageVersMenu();
            }
        });
    }

        public void pageVersMenu()
        {
            MainMenu menu = new MainMenu();
            menu.setVisible(true);
            this.dispose();
        }
}
