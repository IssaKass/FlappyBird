package com.issakass.flappyBird.entities;


import com.issakass.flappyBird.main.Game;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import static com.issakass.flappyBird.entities.Tube.TubeType.BOTTOM;
import static com.issakass.flappyBird.entities.Tube.TubeType.TOP;
import static com.issakass.flappyBird.main.Game.GAME_HEIGHT;
import static com.issakass.flappyBird.main.Game.UPS_SET;
import static com.issakass.flappyBird.utils.Constants.EntityConstants.GroundConstants.GROUND_HEIGHT;
import static com.issakass.flappyBird.utils.Constants.EntityConstants.TubeConstants.TUBE_BLOCK_WIDTH;

public class TubeHandler {
    public static LinkedList<Tube> tubes = new LinkedList<>();
    public static int tubeNumber = (int) (Math.random() * 2);

    private final Random random = new Random();
    private final int spawnArea = GAME_HEIGHT - GROUND_HEIGHT;
    private final int spacing = 140;
    private final int minTubeHeight = 40;
    private final int maxTubeHeight = spawnArea - spacing - minTubeHeight;

    // spawn time
    private int start = 0;
    private final int delay = UPS_SET * 3;

    public static void clear() {
        tubes.clear();
    }

    public void spawnTube(Game game) {
        int heightTop = random.nextInt(maxTubeHeight - minTubeHeight) + minTubeHeight;
        int heightBottom = spawnArea - spacing - heightTop;

        Tube tubeTop = new Tube(500, 0, TUBE_BLOCK_WIDTH, heightTop, TOP, game);
        Tube tubeBottom = new Tube(500, heightTop + spacing, TUBE_BLOCK_WIDTH, heightBottom, BOTTOM, game);

        tubes.addAll(List.of(tubeTop, tubeBottom));
    }

    public void update(Game game) {
        start++;
        if (start >= delay) {
            spawnTube(game);
            start = 0;
        }

        for (int i = 0; i < tubes.size(); i++) {
            Tube t = tubes.get(i);
            if (t.isVisible()) t.update();
            else tubes.remove(t);
        }
    }

    public void render(Graphics2D g2) {
        for (int i = 0; i < tubes.size(); i++) {
            Tube t = tubes.get(i);
            if (t.isVisible()) {
                t.render(g2);
            }
        }
    }
}
