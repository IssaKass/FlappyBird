package com.issakass.flappyBird.gameStates;

import com.issakass.flappyBird.entities.Bird;
import com.issakass.flappyBird.entities.TubeHandler;
import com.issakass.flappyBird.main.Game;
import com.issakass.flappyBird.ui.UI_Button;
import com.issakass.flappyBird.ui.UI_Score;
import com.issakass.flappyBird.utils.LoadSave;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static com.issakass.flappyBird.utils.Constants.UI_Constants.PauseButtonConstants.*;

public class Playing extends State {
    private UI_Button pauseButton;
    private UI_Score uiScore;

    private boolean paused = false;
    private boolean gameOver = false;

    private Bird bird;
    private TubeHandler tubeHandler;

    private float score = 0;

    public Playing(Game game) {
        super(game);
        createUI();
        initClasses();
    }

    @Override
    public void createUI() {
        pauseButton = new UI_Button(10, 10, PAUSE_BUTTON_WIDTH, PAUSE_BUTTON_HEIGHT, LoadSave.GetImage(PAUSE_BUTTON_IMAGE_1));
        uiScore = new UI_Score(game);
    }

    private void initClasses() {
        bird = new Bird(game);
        tubeHandler = new TubeHandler();
    }

    @Override
    public void update() {
        pauseButton.update();
        if (!paused && !gameOver) {
            bird.update();
            tubeHandler.update(getGame());
            uiScore.update();
        }
    }

    @Override
    public void render(Graphics2D g2) {
        bird.render(g2);
        tubeHandler.render(g2);
        pauseButton.render(g2);
        uiScore.render(g2);
    }


    // Key Listener
    @Override
    public void keyTyped(KeyEvent e) {

    }


    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_ESCAPE -> pauseUnpauseGame();
            case KeyEvent.VK_SPACE -> bird.setJump(true);
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            bird.setJump(false);
        }
    }


    // Mouse Listener
    @Override
    public void mouseClicked(MouseEvent e) {
    }


    @Override
    public void mousePressed(MouseEvent e) {
        if (pauseButton.insideBounds(e))
            pauseUnpauseGame();
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


    // Methods
    public void pauseUnpauseGame() {
        paused = !paused;
        pauseButton.setButtonImage(paused ? LoadSave.GetImage(PAUSE_BUTTON_IMAGE_2) : LoadSave.GetImage(PAUSE_BUTTON_IMAGE_1));
    }

    public void resetAll() {
        score = 0;
        paused = false;
        gameOver = false;
        pauseButton.setButtonImage(LoadSave.GetImage(PAUSE_BUTTON_IMAGE_1));
        TubeHandler.clear();
        TubeHandler.tubeNumber = (int) (Math.random() * 2);
        initClasses();
        bird.resetAll();
    }


    // Getters and Setters
    public boolean isPaused() {
        return paused;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public float getScore() {
        return score;
    }

    public Game getGame() {
        return game;
    }

    public void increaseScore() {
        score += 0.5;
    }
}
