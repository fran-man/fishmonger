package de.bitbrain.fishmonger.desktop;

import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.files.FileHandle;
import de.bitbrain.fishmonger.FishMongerGame;

import javax.swing.*;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = 1600;
		config.height = 900;
		config.title = "Fishmonger";
		setApplicationIcon(config);
		new LwjglApplication(new FishMongerGame(), config);
	}

	private static void setApplicationIcon(LwjglApplicationConfiguration config) {
		try {
			config.addIcon("icon-16.png", Files.FileType.Internal);
			config.addIcon("icon-32.png", Files.FileType.Internal);
			Class<?> cls = Class.forName("com.apple.eawt.Application");
			Object application = cls.newInstance().getClass().getMethod("getApplication").invoke(null);
			FileHandle icon = Gdx.files.internal("icon-128.png");
			application.getClass().getMethod("setDockIconImage", java.awt.Image.class)
					.invoke(application, new ImageIcon(icon.file().getAbsolutePath()).getImage());
		} catch (Exception e) {

		}
	}
}
