package com.twopercent.render;

import java.util.ArrayList;
import java.util.Random;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class BackgroundB extends VisibleObject {

	private ArrayList<Cloud> cloudArrayList;

	public BackgroundB() {
		super(new Group());
		randomizeNodes();
		cloudArrayList = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			cloudArrayList.add(new Cloud(i + 1, cloudArrayList.size()));

		}

		for (int i = 0; i < cloudArrayList.size(); i++) {
			getGroup().getChildren().add(cloudArrayList.get(i).getImageView());
		}
	}

	private void randomizeNodes() {
		// Clouds
	}

	@Override
	public void update() {
		for (int i = 0; i < cloudArrayList.size(); i++) {
			cloudArrayList.get(i).update();
		}
	}

}

class Cloud extends VisibleObject {

	private Random r = new Random();
	private Image image1 = new Image(Cloud.class.getResource("/res/images/cloudB1.png").toString());
	private Image image2 = new Image(Cloud.class.getResource("/res/images/cloudB2.png").toString());

	public Cloud(int i, int n) {
		// setScale(((i) / (n)));
		randomizeCloud();
		setX(r.nextInt(720));
		setY(r.nextInt(200));
		setDx(-1 * (r.nextInt(5) + 1));
		setWidth(420);
		setHeight(250);
	}

	@Override
	public void update() {
		updateX();
		if (getX() + getWidth() < 0) {
			randomizeCloud();
			setX(720);
			setY(r.nextInt(200));
			setDx(-1 * (r.nextInt(5) + 1));

		}
		syncCoords();
	}

	public void randomizeCloud() {
		switch (r.nextInt(2)) {
		case 0:
			setImageViewToImage(image1);
			break;
		case 1:
			setImageViewToImage(image2);
			break;
		}
	}
}
