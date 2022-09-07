package com.issakass.flappyBird.entities;

import com.issakass.flappyBird.main.Game;
import com.issakass.flappyBird.utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.issakass.flappyBird.utils.Constants.EntityConstants.BirdConstants.*;

public class AnimatedBird extends Entity {
    private BufferedImage[] birdImages;

    // animation
    private int animationTicks = 0;
    private int animationIndex = 0;
    private int animationSpeed;

    public AnimatedBird(float x, float y, Game game) {
        super(x, y, BIRD_WIDTH, BIRD_HEIGHT,game);
        initVariables();
        createHitBox(x, y, width, height);
        loadImages();
    }

    @Override
    public void initVariables() {
        this.animationTicks = 0;
        this.animationIndex = 0;
        this.animationSpeed = BIRD_ANIMATION_SPEED;

        this.speedX = 0;
        this.speedY = 0;
    }

    @Override
    public void loadImages() {
        BufferedImage temp = LoadSave.GetImage(BIRD_SPRITE_SHEET);
        birdImages = new BufferedImage[BIRD_EFFECTS];

        for (int i = 0; i < birdImages.length; i++)
            birdImages[i] = temp.getSubimage(i * BIRD_WIDTH, 0, BIRD_WIDTH, BIRD_HEIGHT);
    }

    @Override
    public void update() {
        updateAnimationTicks();
    }

    private void updateAnimationTicks() {
        animationTicks++;
        if (animationTicks >= animationSpeed) {
            animationTicks = 0;
            animationIndex++;
            if (animationIndex >= birdImages.length) {
                animationIndex = 0;
            }
        }
    }

    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(birdImages[animationIndex], (int) hitBox.x, (int) hitBox.y, width, height, null);
    }
}
