package com.issakass.flappyBird.ui;

import com.issakass.flappyBird.main.Game;
import com.issakass.flappyBird.utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.issakass.flappyBird.utils.Constants.UI_Constants.LeaderboardPanelConstants.*;
import static com.issakass.flappyBird.utils.Constants.UI_Constants.MedalConstants.MEDAL_X;
import static com.issakass.flappyBird.utils.Constants.UI_Constants.MedalConstants.MEDAL_Y;

public class UI_LeaderboardPanel extends UI_Element {
    private final Game game;
    private final BufferedImage panelImage;
    private UI_Medal medal;

    public UI_LeaderboardPanel(int x, int y, Game game) {
        super(x, y, LEADERBOARD_PANEL_WIDTH, LEADERBOARD_PANEL_HEIGHT);
        this.game = game;
        this.panelImage = LoadSave.GetImage(LEADERBOARD_PANEL_IMAGE);
        createUI();
    }

    private void createUI() {
        medal = new UI_Medal(x + MEDAL_X, y + MEDAL_Y, game);
    }

    @Override
    public void update() {
        medal.update();
    }

    @Override
    public void render(Graphics2D g2) {
        g2.drawImage(panelImage, x, y, width, height, null);
        medal.render(g2);
    }

    @Override
    public void reset() {

    }
}
