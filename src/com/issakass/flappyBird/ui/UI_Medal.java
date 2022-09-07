package com.issakass.flappyBird.ui;

import com.issakass.flappyBird.main.Game;
import com.issakass.flappyBird.utils.Constants;
import com.issakass.flappyBird.utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.issakass.flappyBird.utils.Constants.UI_Constants.MedalConstants.*;

public class UI_Medal extends UI_Element {
    private final Game game;
    private BufferedImage[] medalImages;
    private int medalRank = -1;

    public UI_Medal(int x, int y, Game game) {
        super(x, y, MEDAL_SIZE, MEDAL_SIZE);
        this.game = game;
        loadImages();
    }

    private void loadImages() {
        BufferedImage temp = LoadSave.GetImage(Constants.UI_Constants.MedalConstants.MEDAL_IMAGE);
        medalImages = new BufferedImage[MEDALS_COUNT];

        for (int i = 0; i < medalImages.length; i++)
            medalImages[i] = temp.getSubimage(i * MEDAL_SIZE, 0, MEDAL_SIZE, MEDAL_SIZE);
    }

    @Override
    public void update() {
        medalRank = GetMedalRank(game.getPlaying().getScore());
    }

    @Override
    public void render(Graphics2D g2) {
        if (medalRank < 0) return;
        g2.drawImage(medalImages[medalRank], x, y, width, height, null);
    }

    @Override
    public void reset() {
        medalRank = -1;
    }
}
