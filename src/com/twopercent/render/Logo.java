package com.twopercent.render;

import java.util.Random;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Logo extends VisibleObject {

	private Random r;
	private ImageView borderOverlay;

	public Logo() {
		r = new Random();
		setX(36);
		setY(36);
		// r will be used to randomly select which advertisement is shown
		setGroup(new Group());
		borderOverlay = new ImageView(new Image(Logo.class.getResource("/res/images/mainMenuAdvertisementBorder.png")
				.toString()));
		int n = 1; // n is the total number of advert images
		String path = ""; // path is the path of a specific advert image
		switch (r.nextInt(n)) {
		case 0:
			path = "/res/images/igAdvertA1.png";
			break;
		}

		setImageViewToImage(new Image(Logo.class.getResource(path).toString()));
		getGroup().getChildren().add(getImageView());
		getGroup().getChildren().add(borderOverlay);
		borderOverlay.setX(-30);
		borderOverlay.setY(-30);
		syncCoords();
	}

	public void update() {

	}

}
