package com.twopercent.render;

import com.twopercent.main.Main;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class BackgroundA extends VisibleObject {
	static Image image = new Image(BackgroundA.class.getResource("/res/images/backgroundA1.png").toString());
	static ImageView imageView = new ImageView(image);
	private ImageView imageView2 = new ImageView(image);
	static Group group;

	public BackgroundA() {
		super(image, imageView, group);
		setX(0);
		setY(0);
		setDx(-1);
		setDy(0);
		setWidth(720);

	}

	public void update() {
		updateX();
		updateY();
		if (getX() + getWidth() < 0)
			setX(0);
		// Set position of the image to the game's x & y vals
		imageView.setX(getX());
		imageView.setY(getY());
		imageView2.setX(getX() + getWidth());
		imageView2.setY(getY());
	}

	public ImageView getImageView2() {
		return imageView2;
	}

}
