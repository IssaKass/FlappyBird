package com.issakass.flappyBird.ui;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UI_Button extends UI_Element {
    protected BufferedImage buttonImage;
    protected boolean mousePressed;

    public UI_Button(int x, int y, int width, int height, BufferedImage buttonImage) {
        super(x, y, width, height);
        this.buttonImage = buttonImage;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(buttonImage, x, y, width, height, null);
    }

    @Override
    public void reset() {
        mousePressed = false;
    }

    // Getters and Setters
    public void setButtonImage(BufferedImage buttonImage) {
        this.buttonImage = buttonImage;
    }
}
