package com.valgriz.screen;

import javafx.scene.Group;
import javafx.scene.image.Image;

import com.twopercent.render.VisibleObject;

public class LoadingScreen extends VisibleObject {

	public LoadingScreen(Group load) {
		setGroup(load);
		setImageViewToImage(new Image("/res/images/loadingScreen.png"));
		getGroup().getChildren().add(getImageView());
		setX(0);
		setY(0);
		syncCoords();
	}

	public void update() {

	}

}
