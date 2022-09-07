package com.issakass.flappyBird.ui;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.issakass.flappyBird.main.Game.FPS_SET;

public class UI_Label extends UI_Element {
    protected BufferedImage labelImage;
    protected float alpha = 0.0f;

    public UI_Label(int x, int y, int width, int height, BufferedImage labelImage) {
        super(x, y, width, height);
        this.labelImage = labelImage;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(Graphics2D g2) {
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
        g2.drawImage(labelImage, x, y, width, height, null);

        // increase alpha
        alpha += 1.5 / FPS_SET;
        if (alpha >= 1f) alpha = 1f;
    }

    @Override
    public void reset() {
        alpha = 0.0f;
    }
}
