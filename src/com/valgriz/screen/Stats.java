package com.valgriz.screen;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import com.twopercent.render.BackgroundD;

public class Stats {
	private Group root;
	private static BackgroundD backgroundD;

	public Stats() {

		backgroundD = new BackgroundD();

		root = new Group();
		root.getChildren().add(backgroundD.getGroup());

	}

	public Group getGroup() {
		return root;
	}

	public void setRoot(Group root) {
		this.root = root;
	}

}
