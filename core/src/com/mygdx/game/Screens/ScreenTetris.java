package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.Data.Data;
import com.mygdx.game.Management.Estates;
import com.mygdx.game.Management.Manager;

public class ScreenTetris extends InputAdapter implements Screen {
	Estates estates;
	Manager manager;

	public ScreenTetris(Manager manager) {
		this.estates = new Estates();
		this.manager = manager;
	}

	@Override
	public void show() {

	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(Data.RGBBACKGROUND[0], Data.RGBBACKGROUND[1], Data.RGBBACKGROUND[2] ,1);
		estates.verifyRow();
		estates.renderLimits();
		estates.renderShapes();
		estates.renderNext();
		estates.mainShape.render(estates, delta);
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
	public void dispose () {

	}
}
