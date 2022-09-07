package com.issakass.flappyBird.gameStates;

import com.issakass.flappyBird.main.Game;
import com.issakass.flappyBird.ui.UI_Button;
import com.issakass.flappyBird.ui.UI_Element;
import com.issakass.flappyBird.ui.UI_Label;
import com.issakass.flappyBird.ui.UI_LeaderboardPanel;
import com.issakass.flappyBird.utils.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

import static com.issakass.flappyBird.main.Game.GAME_WIDTH;
import static com.issakass.flappyBird.utils.Constants.UI_Constants.GameOverLabelConstants.*;
import static com.issakass.flappyBird.utils.Constants.UI_Constants.LeaderboardPanelConstants.*;
import static com.issakass.flappyBird.utils.Constants.UI_Constants.PlayButtonConstants.*;

public class Restart extends State {
    private UI_Label gameOverLabel;
    private UI_LeaderboardPanel leaderBoardPanel;
    private UI_Button playButton;

    private final LinkedList<UI_Element> uiElements = new LinkedList<>();

    public Restart(Game game) {
        super(game);
        createUI();
    }

    @Override
    public void createUI() {
        gameOverLabel = new UI_Label((GAME_WIDTH - GAME_OVER_LABEL_WIDTH) / 2, 120, GAME_OVER_LABEL_WIDTH, GAME_OVER_LABEL_HEIGHT, LoadSave.GetImage(GAME_OVER_LABEL_IMAGE));
        leaderBoardPanel = new UI_LeaderboardPanel((GAME_WIDTH - LEADERBOARD_PANEL_WIDTH) / 2, 210, game);
        playButton = new UI_Button((GAME_WIDTH - PLAY_BUTTON_WIDTH) / 2, 400, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT, LoadSave.GetImage(PLAY_BUTTON_IMAGE));

        uiElements.addAll(List.of(gameOverLabel, leaderBoardPanel, playButton));
    }

    @Override
    public void update() {
        for (UI_Element e : uiElements) e.update();
    }

    @Override
    public void render(Graphics2D g2) {
        for (UI_Element e : uiElements) e.render(g2);
    }


    // Key Listener
    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {

    }


    @Override
    public void keyReleased(KeyEvent e) {

    }


    // Mouse Listener
    @Override
    public void mouseClicked(MouseEvent e) {
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if (playButton.insideBounds(e)) {
            resetAll();
            game.getPlaying().resetAll();
            GameState.state = GameState.PLAYING;
        }
    }

    private void resetAll() {
        for (UI_Element e : uiElements) {
            e.reset();
        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }


    @Override
    public void mouseExited(MouseEvent e) {

    }

    // Mouse Motion Listener
    @Override
    public void mouseDragged(MouseEvent e) {

    }


    @Override
    public void mouseMoved(MouseEvent e) {
    }
}
