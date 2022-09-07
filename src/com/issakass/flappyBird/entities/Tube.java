package com.issakass.flappyBird.entities;

import com.issakass.flappyBird.main.Game;
import com.issakass.flappyBird.utils.LoadSave;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static com.issakass.flappyBird.entities.TubeHandler.tubeNumber;
import static com.issakass.flappyBird.utils.Constants.EntityConstants.TubeConstants.*;

public class Tube extends Entity {
    public enum TubeType {TOP, BOTTOM}

    private final TubeType tubeType;
    private BufferedImage tubeImage;
    private BufferedImage tubeBlockImage;
    private Rectangle2D.Float tubeBlockHitBox;

    private boolean visible;

    public Tube(float x, float y, int width, int height, TubeType tubeType, Game game) {
        super(x, y, width, height, game);
        this.tubeType = tubeType;
        initVariables();
        createHitBox(x + TUBE_OFFSET, y, width - 2 * TUBE_OFFSET, height);
        createTubeBlockHitBox();
        loadImages();
    }

    private void createTubeBlockHitBox() {
        switch (tubeType) {
            case TOP ->
                    tubeBlockHitBox = new Rectangle2D.Float(x, y + height - TUBE_BLOCK_HEIGHT, TUBE_BLOCK_WIDTH, TUBE_BLOCK_HEIGHT);
            case BOTTOM -> tubeBlockHitBox = new Rectangle2D.Float(x, y, TUBE_BLOCK_WIDTH, TUBE_BLOCK_HEIGHT);
        }
    }

    @Override
    public void initVariables() {
        this.speedX = 1f;
        this.speedY = 0;

        this.visible = true;
    }

    @Override
    public void loadImages() {
        this.tubeImage = LoadSave.GetImage(TUBE_IMAGE).getSubimage(tubeNumber * TUBE_WIDTH, 0, TUBE_WIDTH, height);
        this.tubeBlockImage = LoadSave.GetImage(TUBE_BLOCK_IMAGE).getSubimage(tubeNumber * TUBE_BLOCK_WIDTH, 0, TUBE_BLOCK_WIDTH, TUBE_BLOCK_HEIGHT);
    }

    @Override
    public void update() {
        hitBox.x -= speedX;
        tubeBlockHitBox.x -= speedX;

        if (tubeBlockHitBox.x + width < 0) {
            visible = false;
            game.getPlaying().increaseScore();
        }
    }

    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(tubeImage, (int) hitBox.x, (int) hitBox.y, (int) hitBox.width, (int) hitBox.height, null);
        g2.drawImage(tubeBlockImage, (int) tubeBlockHitBox.x, (int) tubeBlockHitBox.y, (int) tubeBlockHitBox.width, (int) tubeBlockHitBox.height, null);
    }

    // Getters and Setters
    public boolean isVisible() {
        return visible;
    }

    public Rectangle2D.Float getTubeBlockHitBox() {
        return tubeBlockHitBox;
    }
}
