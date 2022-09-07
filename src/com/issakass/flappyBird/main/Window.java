package com.issakass.flappyBird.main;

import com.issakass.flappyBird.utils.LoadSave;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public Window(GamePanel gameCanvas) {
        this.add(gameCanvas);

        this.setTitle(Game.TITLE);
        this.setIconImage(LoadSave.GetImage("logo.png"));
        this.setResizable(false);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
