package com.issakass.flappyBird.ui;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class UI_Element {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected Rectangle bounds;

    public UI_Element(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        createBounds();
    }

    public void createBounds() {
        bounds = new Rectangle(x, y, width, height);
    }

    public boolean insideBounds(MouseEvent e) {
        return bounds.contains(e.getPoint());
    }

    public abstract void update();

    public abstract void render(Graphics2D g2);

    public abstract void reset();
}
