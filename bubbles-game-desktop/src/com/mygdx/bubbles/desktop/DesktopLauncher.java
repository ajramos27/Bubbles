package com.mygdx.bubbles.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.bubbles.Bubbles;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 768/2;
		config.height = 1024/2;
		new LwjglApplication(new Bubbles(), config);
	}
}
