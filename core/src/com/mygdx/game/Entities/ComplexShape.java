package com.mygdx.game.Entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.mygdx.game.Data;
import com.mygdx.game.Management.Estates;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class ComplexShape extends Shape {
    private final int YSPEED = Data.SHAPESPEED, XSPEED = Data.SHAPESPEED;
    private String[][][] myShape;
    private float[] color;
    private int nextIndex, actualIndex;
    private final DelayedRemovalArray<Rectangle> shapeRects;

    public ComplexShape(float x, float y, float width, float height, float r, float g, float b) {
        super(x, y, width, height, r, g, b);
        this.nextIndex = new Random().nextInt(Data.ALLSHAPES.size());
        this.actualIndex = new Random().nextInt(Data.ALLSHAPES.size());
        this.myShape = Data.ALLSHAPES.get(actualIndex);
        this.color = Data.ALLCOLORS[actualIndex];
        this.r = color[0];
        this.g = color[1];
        this.b = color[2];
        this.shapeRects = new DelayedRemovalArray<>();
        populateShapeRects();
    }

    public int getNextIndex() {
        return nextIndex;
    }

    public void move(Estates estates, float delta) {
        float moveDown = -YSPEED * delta * 4, oldX = shape.x;
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            moveAll(-XSPEED, 0);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            moveAll(XSPEED, 0);
        }
        if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
            nextShape();
            if (shapeCollision(estates) || wallCollision(estates)) {
                for (int i = 0; i < 3; i++) {
                    nextShape();
                }
            }
        }
        moveAll(0, moveDown);
        if (shapeCollision(estates)) {
            if (oldX > shape.x) {
                moveAll(XSPEED, 0);
            } else if (oldX < shape.x) {
                moveAll(-XSPEED, 0);
            } else {
                moveAll(0, 0);
                reset(estates);
            }
        }
        if (wallCollision(estates)) {
            if (oldX > shape.x) moveAll(XSPEED, 0);
            else moveAll(-XSPEED, 0);
        }
        if (floorCollision(estates)) {
            reset(estates);
        }
    }

    public void setRandomShape() {
        actualIndex = nextIndex;
        nextIndex = new Random().nextInt(Data.ALLSHAPES.size());
        myShape = Data.ALLSHAPES.get(actualIndex);
        color = Data.ALLCOLORS[actualIndex];
        r = color[0];
        g = color[1];
        b = color[2];
        shapeRects.clear();
        populateShapeRects();
    }

    public void nextShape() {
        setNewShapeRects();
        shapeRects.clear();
        populateShapeRects();
    }

    public void moveAll(float x, float y) {
        shape.x += x;
        shape.y += y;
        for (Rectangle rect : shapeRects) {
            rect.x += x;
            rect.y += y;
        }
    }


    public boolean floorCollision(Estates estates) {
        for (Rectangle rect : shapeRects) {
            if (rect.overlaps(estates.floor.shape)) {
                return true;
            }
        }
        return false;
    }

    public boolean shapeCollision(Estates estates) {
        for (Rectangle rect : shapeRects) {
            for (Shape shape : estates.shapes) {
                if (rect.overlaps(shape.shape) && !shape.equals(this)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean wallCollision(Estates estates) {
        for (Shape wall : estates.walls) {
            for (Rectangle rect : shapeRects) {
                if (rect.overlaps(wall.shape)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setNewShapeRects() {
        String[][] temp = myShape[0];
        for (int i = 0; i < myShape.length; i++) {
            if (i < myShape.length - 1) {
                myShape[i] = myShape[i + 1];
            } else {
                myShape[i] = temp;
            }
        }
    }

    public void populateShapeRects() {
        for (int line = 0; line < myShape[0].length; line++) {
            for (int item = 0; item < myShape[0][line].length; item++) {
                if (myShape[0][line][item].equals("X")) {
                    shapeRects.add(new Rectangle((int) shape.x + (Data.SHAPESIZE * item), (int) shape.y + (Data.SHAPESIZE * line), Data.SHAPESIZE, Data.SHAPESIZE));
                }
            }
        }
    }

    public void reset(Estates estates) {
        for (Rectangle rect : shapeRects) {
            if (Math.ceil(rect.y) % Data.SHAPESIZE != 0) {
                while (Math.ceil(rect.y) % Data.SHAPESIZE != 0) {
                    rect.y++;
                }
            }
            estates.shapes.add(new SimpleShape(rect.x, (float) Math.ceil(rect.y), rect.width, rect.height, color[0], color[1], color[2]));
        }
        setRandomShape();
        moveAll(((float) (Gdx.graphics.getWidth() / 2) - shape.x), ((Gdx.graphics.getHeight() - shape.y) + Data.SHAPESIZE * 3));
    }

    public void render(Estates estates, float delta) {
        move(estates, delta);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(r, g, b, 1);
        for (Rectangle rectangle : shapeRects) {
            shapeRenderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
        shapeRenderer.end();
    }
}
