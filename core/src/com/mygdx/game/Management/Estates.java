package com.mygdx.game.Management;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.mygdx.game.Data.Data;
import com.mygdx.game.Entities.ComplexShape;
import com.mygdx.game.Entities.Shape;
import com.mygdx.game.Entities.SimpleShape;

import java.util.ArrayList;

public class Estates {
    public DelayedRemovalArray<Shape> walls;
    public SimpleShape floor;
    public DelayedRemovalArray<Shape> shapes;
    public ComplexShape mainShape;
    public int maxShapes;

    public Estates() {
        shapes = new DelayedRemovalArray<>();
        walls = new DelayedRemovalArray<>();
        floor = new SimpleShape(0f, 0f, Data.SCREENWIDTH, Data.SHAPESIZE, Data.RGBWALLS[0], Data.RGBWALLS[1], Data.RGBWALLS[2]);
        mainShape = new ComplexShape((float)(Gdx.graphics.getWidth() / 2), Gdx.graphics.getHeight(), Data.SHAPESIZE, Data.SHAPESIZE, 1f, 1f, 1f);
        maxShapes = (Data.SCREENWIDTH - (2 * Data.WALLWIDTH)) / Data.SHAPESIZE;
        this.populateTela();
    }

    public int count(ArrayList<Float> arr, float element) {
        int count = 0;
        for (float el : arr) {
            if (el == element) count++;
        }
        return count;
    }

    public void verifyRow() {
        ArrayList<Float> arrY = new ArrayList<>();
        float yFull = 0;
        int removed = 0;
        for (Shape shape : shapes) {
            arrY.add((float) Math.floor(shape.getShape().y));
        }
        for (float y : arrY) {
            if (count(arrY, y) >= maxShapes) {
                yFull = y;
                break;
            }
        }
        if (yFull != 0) {
            while (removed != maxShapes) {
                for (Shape shape : shapes) {
                    if (shape.getShape().y == yFull) {
                        shapes.removeValue(shape, true);
                        removed++;
                    }
                }
            }
            downShapes(yFull);
        }
    }

    public void downShapes(float andar) {
        for (Shape shape : shapes) {
            if (shape.getShape().y > andar) {
                ((SimpleShape) shape).downAll(-Data.SHAPESIZE);
            }
        }
    }

    public void populateTela() {
        walls.add(new SimpleShape(0f, Data.SHAPESIZE, Data.WALLWIDTH, Data.SCREENHEIGHT, Data.RGBWALLS[0], Data.RGBWALLS[1], Data.RGBWALLS[2]));
        walls.add(new SimpleShape(Data.SCREENWIDTH - Data.WALLWIDTH, Data.SHAPESIZE, Data.SCREENWIDTH, Data.SCREENHEIGHT, Data.RGBWALLS[0], Data.RGBWALLS[1], Data.RGBWALLS[2]));
        walls.add(new SimpleShape(0, (Gdx.graphics.getHeight() - 230), Data.WALLWIDTH, Data.WALLWIDTH, Data.RGBWALLS[0] - 0.1f, Data.RGBWALLS[1] - 0.1f, Data.RGBWALLS[2] - 0.1f));
    }

    public void renderLimits() {
        for (Shape wall : walls) {
            wall.render(this);
        }
        floor.render(this);
    }

    public void renderShapes() {
        for (Shape shape : shapes) {
            shape.render(this);
        }
    }

    public void renderNext() {
        String[][] nextShape = Data.ALLSHAPES.get(mainShape.getNextIndex())[0];
        for (int line = 0; line < nextShape.length; line++) {
            for (int item = 0; item < nextShape[line].length; item++) {
                if (nextShape[line][item].equals("X")) {
                    float[] allcolor = Data.ALLCOLORS[mainShape.getNextIndex()];
                    (new SimpleShape((int) ((Data.WALLWIDTH - nextShape[0].length) / 4) + (Data.LITTLESHAPESIZE * item), (int) (Gdx.graphics.getHeight() - 200) + (Data.LITTLESHAPESIZE * line), Data.LITTLESHAPESIZE, Data.LITTLESHAPESIZE, allcolor[0], allcolor[1], allcolor[2])).render(this);
                }
            }
        }
    }
}
