package com.valgriz.screen;

import javafx.scene.Group;
import javafx.scene.text.Text;

import com.twopercent.render.BackgroundD;

public class Options {

	public static BackgroundD backgroundD;
	private Group root;
	private Text title;

	public Options() {
		root = new Group();
		backgroundD = new BackgroundD();
		root.getChildren().add(backgroundD.getGroup());

	}

	public void update() {

	}

	public Group getGroup() {
		return root;
	}

	public void setGroup(Group root) {
		this.root = root;
	}

}
