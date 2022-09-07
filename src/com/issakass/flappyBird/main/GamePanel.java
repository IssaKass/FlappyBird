package com.issakass.flappyBird.main;

import com.issakass.flappyBird.inputs.KeyInput;
import com.issakass.flappyBird.inputs.MouseInput;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private final Game game;

    // Inputs
    private KeyInput keyInput;
    private MouseInput mouseInput;


    public GamePanel(Game game) {
        this.game = game;
        this.setFocusable(true);
        this.requestFocus();
        setDimensions();
        setInputs();
    }

    private void setDimensions() {
        Dimension dimension = new Dimension(Game.GAME_WIDTH, Game.GAME_HEIGHT);
        this.setPreferredSize(dimension);
        this.setMinimumSize(dimension);
        this.setMaximumSize(dimension);
    }

    private void setInputs() {
        keyInput = new KeyInput(this);
        mouseInput = new MouseInput(this);

        this.addKeyListener(keyInput);
        this.addMouseListener(mouseInput);
        this.addMouseMotionListener(mouseInput);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        game.render(g2);

        g.dispose();
    }

    // Getters and Setters
    public Game getGame() {
        return game;
    }
}
