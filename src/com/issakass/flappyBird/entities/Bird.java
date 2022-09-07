package com.issakass.flappyBird.entities;

import com.issakass.flappyBird.gameStates.GameState;
import com.issakass.flappyBird.main.Game;
import com.issakass.flappyBird.utils.Constants;
import com.issakass.flappyBird.utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import static com.issakass.flappyBird.utils.Constants.EntityConstants.BirdConstants.*;

public class Bird extends Entity {
    private BufferedImage[] birdImages;
    private int birdNumber;

    // animation
    private int animationTicks = 0;
    private int animationIndex = 0;
    private int animationSpeed;

    // jump - fall
    private float airSpeed = 0;
    private float maxAirSpeed;
    private float gravity;
    private float jumpSpeed;
    private boolean jump;

    public Bird(Game game) {
        super(BIRD_START_X, BIRD_START_Y, BIRD_WIDTH, BIRD_HEIGHT, game);
        initVariables();
        createHitBox(x, y, width, height);
        loadImages();
    }

    @Override
    public void initVariables() {
        this.birdNumber = new Random().nextInt(3);

        this.animationTicks = 0;
        this.animationIndex = 0;
        this.animationSpeed = BIRD_ANIMATION_SPEED;

        this.airSpeed = 0;
        this.maxAirSpeed = Constants.MAX_AIR_SPEED;
        this.gravity = Constants.GRAVITY;
        this.jumpSpeed = Constants.JUMP_SPEED;
        this.jump = false;
    }

    @Override
    public void loadImages() {
        BufferedImage temp = LoadSave.GetImage(BIRD_SPRITE_SHEET);
        birdImages = new BufferedImage[BIRD_EFFECTS];

        for (int i = 0; i < birdImages.length; i++)
            birdImages[i] = temp.getSubimage(i * BIRD_WIDTH, birdNumber * BIRD_HEIGHT, BIRD_WIDTH, BIRD_HEIGHT);
    }

    @Override
    public void update() {
        checkCollisions();
        updateAnimationTicks();
        jump();

        if (game.getPlaying().isGameOver())
            GameState.state = GameState.RESTART;
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

    private void jump() {
        airSpeed += gravity;
        hitBox.y += airSpeed;

        if (jump) airSpeed = jumpSpeed;
        if (airSpeed >= maxAirSpeed) airSpeed = maxAirSpeed;
        if (hitBox.y < 0) y = 0;
    }

    private void checkCollisions() {
        if (hitBox.intersects(game.getGround().getHitBox()))
            game.getPlaying().setGameOver(true);


        for (Tube t : TubeHandler.tubes)
            if (hitBox.intersects(t.getTubeBlockHitBox()) || hitBox.intersects(t.getHitBox()))
                game.getPlaying().setGameOver(true);
    }

    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(birdImages[animationIndex], (int) hitBox.x, (int) hitBox.y, width, height, null);
    }

    public void resetAll() {
        game.initBackground();
        initVariables();
        this.x = BIRD_START_X;
        this.y = BIRD_START_Y;
    }

    // Getters and Setters
    public void setJump(boolean jump) {
        this.jump = jump;
    }

}
