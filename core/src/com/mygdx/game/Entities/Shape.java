package com.mygdx.game.Entities;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Management.Estates;

public abstract class Shape {
    protected float r, g, b;
    protected ShapeRenderer shapeRenderer;
    protected Vector2 position;
    protected Rectangle shape;

    public Shape(float x, float y, float width, float height, float r, float g, float b) {
        shapeRenderer = new ShapeRenderer();
        shape = new Rectangle();
        position = new Vector2();
        this.position.x = x;
        this.position.y = y;
        this.shape.setPosition(this.position.x, this.position.y);
        this.shape.width = width;
        this.shape.height = height;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Rectangle getShape() {
        return shape;
    }

    public float getR() {
        return r;
    }

    public void setR(float r) {
        this.r = r;
    }

    public float getG() {
        return g;
    }

    public void setG(float g) {
        this.g = g;
    }

    public float getB() {
        return b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public void setShapeRenderer(ShapeRenderer shapeRenderer) {
        this.shapeRenderer = shapeRenderer;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setBloco(Rectangle shape) {
        this.shape = shape;
    }

    public void render(Estates estates) {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(r, g, b, 1);
        shapeRenderer.rect(position.x, position.y, shape.width, shape.height);
        shapeRenderer.end();
    }

}
