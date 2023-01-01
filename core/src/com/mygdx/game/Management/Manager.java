package com.mygdx.game.Management;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.mygdx.game.Screens.ScreenStart;
import com.mygdx.game.Screens.ScreenTetris;

public class Manager extends Game {
    @Override
    public void create() {
        setScreen(new ScreenStart(this));
    }


}
