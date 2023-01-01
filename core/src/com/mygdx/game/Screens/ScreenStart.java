package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Data.Data;
import com.mygdx.game.Entities.ComplexShape;
import com.mygdx.game.Entities.SimpleShape;
import com.mygdx.game.Management.Estates;
import com.mygdx.game.Management.Manager;
import com.mygdx.game.Tools.Button;

import java.util.Random;

public class ScreenStart extends InputAdapter implements Screen {
    Manager manager;
    Estates estates;
    Button button;
    int buttonWidth, buttonHeight, borderSize;
    SpriteBatch batch;
    BitmapFont font;
    String text;
    DelayedRemovalArray<SimpleShape> simpleShapes;
    DelayedRemovalArray<SimpleShape> borders;

    public ScreenStart(Manager manager) {
        estates = new Estates();
        batch = new SpriteBatch();
        font = new BitmapFont();
        text = "TETRIS";
        buttonWidth = 200;
        buttonHeight = 100;
        borderSize = 20;
        simpleShapes = new DelayedRemovalArray<>();
        borders = new DelayedRemovalArray<>();
        populateBorders();
        this.manager = manager;
        button = new Button((float)((Gdx.graphics.getWidth()) / 2 - buttonWidth / 2) , (1.5f * Gdx.graphics.getHeight()) / 3, buttonWidth, buttonHeight, Data.RGBWALLS[0], Data.RGBWALLS[1], Data.RGBWALLS[2], "Iniciar");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(Data.RGBBACKGROUND[0], Data.RGBBACKGROUND[1], Data.RGBBACKGROUND[2] ,1);

        renderBorders();
        batch.begin();
        font.getData().setScale(10);
        font.draw(batch, text, 75, Gdx.graphics.getHeight() - (Gdx.graphics.getHeight()/8));
        batch.end();
        button.render();
        if (button.clicked()) {
            manager.setScreen(new ScreenTetris(manager));
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

    public void populateBorders() {
        borders.add(new SimpleShape(0, 0, borderSize, Gdx.graphics.getHeight(), Data.RGBWALLS[0], Data.RGBWALLS[1], Data.RGBWALLS[2]));
        borders.add(new SimpleShape(Gdx.graphics.getWidth() - borderSize, 0, borderSize, Gdx.graphics.getHeight(), Data.RGBWALLS[0], Data.RGBWALLS[1], Data.RGBWALLS[2]));
        borders.add(new SimpleShape(borderSize, 0, Gdx.graphics.getWidth() - borderSize, borderSize, Data.RGBWALLS[0], Data.RGBWALLS[1], Data.RGBWALLS[2]));
        borders.add(new SimpleShape(borderSize, Gdx.graphics.getHeight() - borderSize, Gdx.graphics.getWidth() - borderSize, borderSize, Data.RGBWALLS[0], Data.RGBWALLS[1], Data.RGBWALLS[2]));
    }

    public void renderBorders() {
        for (SimpleShape simpleShape : borders) {
            simpleShape.render(estates);
        }
    }

}
