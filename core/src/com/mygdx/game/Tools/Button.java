package com.mygdx.game.Tools;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Button {
    private ShapeRenderer shapeRenderer;
    private SpriteBatch batch;
    private float x, y, width, height, r, g, b, radius, realR, realG, realB, scaleRGB, widthL, heightL;
    private BitmapFont font;
    private String text;
    private GlyphLayout layout;


    public Button(float x, float y, float width, float height, float r, float g, float b, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.r = r;
        this.g = g;
        this.b = b;
        radius = 20;
        font = new BitmapFont();
        shapeRenderer = new ShapeRenderer();
        batch = new SpriteBatch();
        scaleRGB = 0.9f;
        this.text = text;
        layout = new GlyphLayout();
        layout.setText(font, text);
        widthL = layout.width*1.5f;
        heightL = layout.height*1.5f;
    }

    public void hover() {
        if (Gdx.input.getX() > x && Gdx.input.getX() < x + width && (Gdx.graphics.getHeight() - Gdx.input.getY()) > y && (Gdx.graphics.getHeight() - Gdx.input.getY()) < y + height) {
            realR = r * scaleRGB;
            realG = g * scaleRGB;
            realB = b * scaleRGB;
        } else {
            realR = r / scaleRGB;
            realG = g / scaleRGB;
            realB = b / scaleRGB;
        }
    }

    public boolean clicked() {
        return (Gdx.input.isButtonJustPressed(Input.Buttons.LEFT) && Gdx.input.getX() > x && Gdx.input.getX() < x + width && (Gdx.graphics.getHeight() - Gdx.input.getY()) > y && (Gdx.graphics.getHeight() - Gdx.input.getY()) < y + height);
    }

    public void render() {
        hover();
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(realR, realG, realB, 1);
        shapeRenderer.rect(x + radius, y + radius, width - 2*radius, height - 2*radius);

        // Four side rectangles, in clockwise order
        shapeRenderer.rect(x + radius, y, width - 2*radius, radius);
        shapeRenderer.rect(x + width - radius, y + radius, radius, height - 2*radius);
        shapeRenderer.rect(x + radius, y + height - radius, width - 2*radius, radius);
        shapeRenderer.rect(x, y + radius, radius, height - 2*radius);

        // Four arches, clockwise too
        shapeRenderer.arc(x + radius, y + radius, radius, 180f, 90f);
        shapeRenderer.arc(x + width - radius, y + radius, radius, 270f, 90f);
        shapeRenderer.arc(x + width - radius, y + height - radius, radius, 0f, 90f);
        shapeRenderer.arc(x + radius, y + height - radius, radius, 90f, 90f);
        shapeRenderer.end();
        batch.begin();
        font.getData().setScale(2);
        font.draw(batch, text, (x + width/2)-widthL/2, (y + height/2)+heightL/2);
        batch.end();
    }

}
