package com.valgriz.screen;

import com.twopercent.render.BackgroundA;
import com.twopercent.render.BackgroundB;

import javafx.scene.Group;
import javafx.scene.layout.Background;

public class PlayGame {

	private BackgroundA backgroundA;

	private BackgroundB backgroundB;

	public PlayGame(Group root) {
		backgroundA = new BackgroundA();
		backgroundB = new BackgroundB();
		// Render Order
		root.getChildren().add(backgroundA.getGroup());
		root.getChildren().add(backgroundB.getGroup());

		// PlatSys
		// Bird
		// Any extras
		// UI

	}

	public void update() {
		backgroundA.update();
		backgroundB.update();
	}
}
