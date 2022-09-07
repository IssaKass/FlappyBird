package com.issakass.flappyBird.inputs;

import com.issakass.flappyBird.gameStates.GameState;
import com.issakass.flappyBird.main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener {
    private final GamePanel gamePanel;

    public KeyInput(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }


    @Override
    public void keyTyped(KeyEvent e) {
        switch (GameState.state) {
            case MENU -> gamePanel.getGame().getMenu().keyTyped(e);
            case PLAYING -> gamePanel.getGame().getPlaying().keyTyped(e);
            case RESTART -> gamePanel.getGame().getRestart().keyTyped(e);
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        switch (GameState.state) {
            case MENU -> gamePanel.getGame().getMenu().keyPressed(e);
            case PLAYING -> gamePanel.getGame().getPlaying().keyPressed(e);
            case RESTART -> gamePanel.getGame().getRestart().keyPressed(e);
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        switch (GameState.state) {
            case MENU -> gamePanel.getGame().getMenu().keyReleased(e);
            case PLAYING -> gamePanel.getGame().getPlaying().keyReleased(e);
            case RESTART -> gamePanel.getGame().getRestart().keyReleased(e);
        }
    }
}
