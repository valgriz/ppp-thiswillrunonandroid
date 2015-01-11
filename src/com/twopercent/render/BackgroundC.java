package com.twopercent.render;

import javafx.animation.TranslateTransition;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class BackgroundC extends VisibleObject {

	public BackgroundC() {
		setImageViewToImage(new Image(BackgroundC.class.getResource("/res/images/mainMenuSky.png").toString()));
		setX(-32);
		setY(-32);
		setWidth(774);
		setHeight(510);
		setGroup(new Group());
		getGroup().getChildren().add(getImageView());

		TranslateTransition translate1 = new TranslateTransition(Duration.millis(500), getGroup());
		translate1.setByY(10);

		translate1.setCycleCount(TranslateTransition.INDEFINITE);

		translate1.setAutoReverse(true);
		translate1.play();

		syncCoords();
	}

	public void update() {
		syncCoords();
	}

}
