package com.issakass.flappyBird.entities;

import com.issakass.flappyBird.main.Game;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public abstract class Entity {
    protected Game game;
    protected float x, y;
    protected int width, height;
    protected Rectangle2D.Float hitBox;
    protected float speedX, speedY;

    public Entity(float x, float y, int width, int height, Game game) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.game = game;
    }

    protected void createHitBox(float x, float y, int width, int height) {
        hitBox = new Rectangle2D.Float(x, y, width, height);
    }

    public abstract void initVariables();

    public abstract void loadImages();

    public abstract void update();

    public abstract void render(Graphics2D g2);

    // Getters and Setters
    public Rectangle2D.Float getHitBox() {
        return hitBox;
    }

}
