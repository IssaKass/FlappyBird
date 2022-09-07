package com.issakass.flappyBird.gameStates;

import com.issakass.flappyBird.main.Game;

import java.awt.*;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public abstract class State implements KeyListener, MouseListener, MouseMotionListener {
    protected Game game;

    public State(Game game) {
        this.game = game;
    }

    public abstract void createUI();

    public abstract void update();

    public abstract void render(Graphics2D g2);
}
