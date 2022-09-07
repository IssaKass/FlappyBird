package com.issakass.flappyBird.entities;

import com.issakass.flappyBird.main.Game;
import com.issakass.flappyBird.utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.issakass.flappyBird.utils.Constants.EntityConstants.GroundConstants.*;

public class Ground extends Entity {
    private BufferedImage groundImage;
    private float x1, x2;

    public Ground(Game game) {
        super(GROUND_X, GROUND_Y, GROUND_WIDTH, GROUND_HEIGHT, game);
        initVariables();
        createHitBox(x, y, width, 30);
        loadImages();
    }

    @Override
    public void initVariables() {
        this.speedY = 0;
        this.speedX = 0.7f;

        this.x1 = 0;
        this.x2 = width;
    }

    @Override
    public void loadImages() {
        groundImage = LoadSave.GetImage(GROUND_IMAGE);
    }

    @Override
    public void update() {
        x1 -= speedX;
        x2 -= speedX;

        if (x1 + width <= 0) x1 = width;
        if (x2 + width <= 0) x2 = width;
    }

    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(groundImage, (int) x1, (int) y, width, height, null);
        g2.drawImage(groundImage, (int) x2, (int) y, width, height, null);
    }
}
