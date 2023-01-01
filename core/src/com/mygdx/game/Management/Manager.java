package com.mygdx.game.Management;

import com.badlogic.gdx.Game;
import com.mygdx.game.Screens.ScreenTetris;

public class Manager extends Game {
    @Override
    public void create() {
        setScreen(new ScreenTetris(this));
    }

}
