package com.twopercent.render;

import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public class BackgroundB extends VisibleObject {

	private ArrayList<Cloud> cloudArrayList;

	public BackgroundB() {
		super(new Group());
		cloudArrayList = new ArrayList<>();

		for (int i = 0; i < 4; i++) {
			cloudArrayList.add(new Cloud(i + 1, cloudArrayList.size()));
			getGroup().getChildren().add(cloudArrayList.get(i).getImageView());

		}
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
	private int i;

	public Cloud(int i, int n) {
		this.i = i;

		setWidth(420);
		setHeight(250);

		randomizeCloud();

		setX(r.nextInt(720));
		setY(r.nextInt(200));

	}

	@Override
	public void update() {
		updateX();
		if (getX() + getImageView().getFitWidth() < 0) {
			randomizeCloud();
			setX(720);
			setY(r.nextInt(300 - (i * 50)));
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
		setFitScale(50 * (i + 1), getFitAspectHeight(50 * (i + 1)));

		setDx(-.2 * i);
		getImageView().setOpacity(i * .2);
		getImageView().setViewport(new Rectangle2D(0, 0, getWidth(), getHeight()));

	}
}
