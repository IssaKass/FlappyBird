package com.issakass.flappyBird.inputs;

import com.issakass.flappyBird.gameStates.GameState;
import com.issakass.flappyBird.main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener {
    private final GamePanel gamePanel;

    public MouseInput(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (GameState.state) {
            case MENU -> gamePanel.getGame().getMenu().mouseClicked(e);
            case PLAYING -> gamePanel.getGame().getPlaying().mouseClicked(e);
            case RESTART -> gamePanel.getGame().getRestart().mouseClicked(e);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        switch (GameState.state) {
            case MENU -> gamePanel.getGame().getMenu().mousePressed(e);
            case PLAYING -> gamePanel.getGame().getPlaying().mousePressed(e);
            case RESTART -> gamePanel.getGame().getRestart().mousePressed(e);
        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {
        switch (GameState.state) {
            case MENU -> gamePanel.getGame().getMenu().mouseReleased(e);
            case PLAYING -> gamePanel.getGame().getPlaying().mouseReleased(e);
            case RESTART -> gamePanel.getGame().getRestart().mouseReleased(e);
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        switch (GameState.state) {
            case MENU -> gamePanel.getGame().getMenu().mouseEntered(e);
            case PLAYING -> gamePanel.getGame().getPlaying().mouseEntered(e);
            case RESTART -> gamePanel.getGame().getRestart().mouseEntered(e);
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        switch (GameState.state) {
            case MENU -> gamePanel.getGame().getMenu().mouseExited(e);
            case PLAYING -> gamePanel.getGame().getPlaying().mouseExited(e);
            case RESTART -> gamePanel.getGame().getRestart().mouseExited(e);
        }
    }


    @Override
    public void mouseDragged(MouseEvent e) {
        switch (GameState.state) {
            case MENU -> gamePanel.getGame().getMenu().mouseDragged(e);
            case PLAYING -> gamePanel.getGame().getPlaying().mouseDragged(e);
            case RESTART -> gamePanel.getGame().getRestart().mouseDragged(e);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        switch (GameState.state) {
            case MENU -> gamePanel.getGame().getMenu().mouseMoved(e);
            case PLAYING -> gamePanel.getGame().getPlaying().mouseMoved(e);
            case RESTART -> gamePanel.getGame().getRestart().mouseMoved(e);
        }
    }
}
