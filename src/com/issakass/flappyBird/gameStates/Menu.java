package com.issakass.flappyBird.gameStates;

import com.issakass.flappyBird.entities.AnimatedBird;
import com.issakass.flappyBird.main.Game;
import com.issakass.flappyBird.ui.UI_Button;
import com.issakass.flappyBird.ui.UI_Label;
import com.issakass.flappyBird.utils.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static com.issakass.flappyBird.main.Game.GAME_WIDTH;
import static com.issakass.flappyBird.utils.Constants.EntityConstants.BirdConstants.BIRD_WIDTH;
import static com.issakass.flappyBird.utils.Constants.UI_Constants.PlayButtonConstants.*;
import static com.issakass.flappyBird.utils.Constants.UI_Constants.TitleLabelConstants.*;

public class Menu extends State {
    private UI_Label titleLabel;
    private AnimatedBird animatedBird;
    private UI_Button playButton;

    public Menu(Game game) {
        super(game);
        createUI();
    }

    @Override
    public void createUI() {
        titleLabel = new UI_Label((GAME_WIDTH - TITLE_LABEL_WIDTH) / 2, 120, TITLE_LABEL_WIDTH, TITLE_LABEL_HEIGHT, LoadSave.GetImage(TITLE_LABEL_IMAGE));
        animatedBird = new AnimatedBird((GAME_WIDTH - BIRD_WIDTH) / 2.0f, 230, game);
        playButton = new UI_Button((GAME_WIDTH - PLAY_BUTTON_WIDTH) / 2, 300, PLAY_BUTTON_WIDTH, PLAY_BUTTON_HEIGHT, LoadSave.GetImage(PLAY_BUTTON_IMAGE));
    }

    @Override
    public void update() {
        titleLabel.update();
        animatedBird.update();
        playButton.update();
    }

    @Override
    public void render(Graphics2D g2) {
        titleLabel.render(g2);
        animatedBird.render(g2);
        playButton.render(g2);
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
        if (playButton.insideBounds(e)) {
            GameState.state = GameState.PLAYING;
        }
    }


    @Override
    public void mousePressed(MouseEvent e) {
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
