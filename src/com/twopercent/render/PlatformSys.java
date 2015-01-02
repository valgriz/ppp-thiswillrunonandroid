package com.twopercent.render;

import java.util.ArrayList;

import com.valgriz.screen.PlayGame;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class PlatformSys extends VisibleObject {

	public static ArrayList<Platform> platformArrayList;
	private int n;

	public PlatformSys() {
		super(new Group());

		n = 100;

		platformArrayList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			platformArrayList.add(new Platform(i, platformArrayList.size()));
			getGroup().getChildren().add(platformArrayList.get(i).getImageView());
		}

	}

	public void update() {
		for (int i = 0; i < n; i++) {
			platformArrayList.get(i).update();
		}
	}

}

class Platform extends VisibleObject {
	private int i, n, f;

	public Platform(int i, int n) {
		this.i = i;
		this.n = n;
		f = 0;
		setImageViewToImage(new Image(Platform.class.getResource("/res/images/platform.png").toString()));
		getImageView().setViewport(new Rectangle2D(0, 0, 180, 45));
		setWidth(180);
		setHeight(45);
		setX(i * getWidth());
		setY(300);
		setDx(-1 * 2);

		ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(1000), getImageView());
		scaleTransition.setToY(.5);
		scaleTransition.setCycleCount(10);
		scaleTransition.setAutoReverse(true);

		TranslateTransition bounceTranslateTransition = new TranslateTransition(Duration.millis(175), getImageView());
		bounceTranslateTransition.setByY(20);
		bounceTranslateTransition.setCycleCount(2);
		bounceTranslateTransition.setAutoReverse(true);

		syncCoords();

	}

	public void update() {

		updateX();
		syncCoords();

	}

	public void playAnimation() {
		getImageView().setViewport(new Rectangle2D(f * 180, 0, 180, 45));
		if (f > 3) {
			f = 0;
		} else {
			f++;
		}
	}
}
