package com.issakass.flappyBird.ui;

import com.issakass.flappyBird.main.Game;
import com.issakass.flappyBird.utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.issakass.flappyBird.main.Game.GAME_WIDTH;
import static com.issakass.flappyBird.utils.Constants.UI_Constants.ScoreNumbersConstants.*;

public class UI_Score extends UI_Element {
    private final Game game;
    private BufferedImage[] numbersImages;
    private int[] scoreIndex = new int[4];

    public UI_Score(Game game) {
        super(200, 10, SCORE_NUMBER_WIDTH, SCORE_NUMBER_HEIGHT);
        this.game = game;
        loadImages();
    }

    private void loadImages() {
        BufferedImage temp = LoadSave.GetImage(SCORE_NUMBERS_IMAGE);
        numbersImages = new BufferedImage[SCORE_NUMBERS_COUNT];

        for (int i = 0; i < numbersImages.length; i++)
            numbersImages[i] = temp.getSubimage(i * SCORE_NUMBER_WIDTH, 0, SCORE_NUMBER_WIDTH, SCORE_NUMBER_HEIGHT);
    }

    @Override
    public void update() {
        checkScore();
    }

    private void checkScore() {
        int score = (int) game.getPlaying().getScore();
        for (int i = scoreIndex.length - 1; i >= 0; i--) {
            scoreIndex[i] = score % 10;
            score /= 10;
        }
    }

    @Override
    public void render(Graphics2D g2) {
        int startX;
        int scoreWidth = 0;

        for (int i = 0; i < scoreIndex.length; i++) {
            if (i == scoreIndex.length - 1) scoreWidth = 0;
            scoreWidth += SCORE_NUMBER_WIDTH;
            startX = (GAME_WIDTH - scoreWidth) / 2;

            if (scoreIndex[i] == 0 && i == 0) continue;
            if (scoreIndex[i] == 0 && scoreIndex[i - 1] == 0 && i != scoreIndex.length - 1) continue;

            g2.drawImage(
                    numbersImages[scoreIndex[i]],
                    startX,
                    10,
                    SCORE_NUMBER_WIDTH,
                    SCORE_NUMBER_HEIGHT,
                    null
            );
        }
    }

    @Override
    public void reset() {
        scoreIndex = new int[4];
    }
}
