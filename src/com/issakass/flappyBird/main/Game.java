package com.issakass.flappyBird.main;

import com.issakass.flappyBird.entities.Ground;
import com.issakass.flappyBird.gameStates.GameState;
import com.issakass.flappyBird.gameStates.Menu;
import com.issakass.flappyBird.gameStates.Playing;
import com.issakass.flappyBird.gameStates.Restart;
import com.issakass.flappyBird.utils.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static com.issakass.flappyBird.utils.Constants.Backgrounds.LANDSCAPE_BACKGROUND;

public class Game implements Runnable {
    // Window
    public static final String TITLE = "Flappy Bird";
    private final GamePanel gamePanel;

    // Size
    public static final int GAME_WIDTH = 432;
    public static final int GAME_HEIGHT = 768;

    // System
    private Thread thread;
    private boolean running = false;

    // FPS and UPS
    public static final int FPS_SET = 120;
    public static final int UPS_SET = 200;

    // State
    private Menu menu;
    private Playing playing;
    private Restart restart;

    // Environment
    private BufferedImage landscapeImage;

    // Ground
    private Ground ground;


    // Constructor
    public Game() {
        init();
        gamePanel = new GamePanel(this);
        new Window(gamePanel);
        start();
    }

    private void init() {
        menu = new Menu(this);
        playing = new Playing(this);
        restart = new Restart(this);

        initBackground();
        ground = new Ground(this);
    }

    public void initBackground() {
        landscapeImage = LoadSave.GetImage(LANDSCAPE_BACKGROUND)
                .getSubimage((int) (Math.random() * 2) * GAME_WIDTH, 0, GAME_WIDTH, GAME_HEIGHT);
    }

    private synchronized void start() {
        if (running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    private synchronized void stop() {
        if (!running) return;
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        long previousTime = System.nanoTime();
        long currentTime;

        double timePerUpdate = 1E9 / UPS_SET;
        double timePerFrame = 1E9 / FPS_SET;

        double deltaU = 0;
        double deltaF = 0;

        int updates = 0;
        int frames = 0;

        long lastCheck = System.currentTimeMillis();

        while (running) {
            currentTime = System.nanoTime();
            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck > 1000) {
                lastCheck += 1000;
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    void update() {
        if (!playing.isPaused()) ground.update();
        switch (GameState.state) {
            case MENU -> menu.update();
            case PLAYING -> playing.update();
            case RESTART -> restart.update();
        }
    }

    void render(Graphics2D g2) {
        g2.drawImage(landscapeImage, 0, 0, null);
        ground.render(g2);

        switch (GameState.state) {
            case MENU -> menu.render(g2);
            case PLAYING -> playing.render(g2);
            case RESTART -> restart.render(g2);
        }
    }

    // Getters and Setters
    public Menu getMenu() {
        return menu;
    }

    public Playing getPlaying() {
        return playing;
    }

    public Restart getRestart() {
        return restart;
    }

    public Ground getGround() {
        return ground;
    }

}
