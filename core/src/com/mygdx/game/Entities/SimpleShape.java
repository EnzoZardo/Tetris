package com.mygdx.game.Entities;

public class SimpleShape extends Shape {
    public SimpleShape(float x, float y, float width, float height, float r, float g, float b) {
        super(x, y, width, height, r, g, b);
    }

    public void downAll(int y) {
        position.y += y;
        shape.y += y;
    }
}
