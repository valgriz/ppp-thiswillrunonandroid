package com.valgriz.screen;

import com.twopercent.render.BackgroundA;

import javafx.scene.Group;
import javafx.scene.layout.Background;

public class PlayGame {

	private BackgroundA backgroundA;

	public PlayGame(Group root) {
		backgroundA = new BackgroundA();
		// ////////// Render Order
		root.getChildren().add(backgroundA.getImageView());
		root.getChildren().add(backgroundA.getImageView2());

	}

	public void update() {
		backgroundA.update();
	}
}
