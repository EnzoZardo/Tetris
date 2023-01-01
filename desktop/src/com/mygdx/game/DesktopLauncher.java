package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.mygdx.game.Data.Data;
import com.mygdx.game.Management.Manager;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main (String[] arg) {
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setWindowedMode(Data.SCREENWIDTH, Data.SCREENHEIGHT);
		config.setForegroundFPS(60);
		config.setResizable(false);
		config.setTitle("Tetris");
		new Lwjgl3Application(new Manager(), config);
	}
}
