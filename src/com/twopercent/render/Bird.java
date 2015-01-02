package com.twopercent.render;

import java.util.ArrayList;

import com.valgriz.screen.PlayGame;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;

public class Bird extends VisibleObject {

	private ArrayList<CollisionObject> collisionObjectArrayList;
	private boolean hit;

	public Bird() {
		super(new Group());
		setImageViewToImage(new Image(Bird.class.getResource("/res/images/bird.png").toString()));
		getGroup().getChildren().add(getImageView());
		getImageView().setViewport(new Rectangle2D(0, 0, 57, 40));
		setWidth(57);
		setHeight(40);
		setX(100);
		setY(30);

		collisionObjectArrayList = new ArrayList<>();
		hit = false;

		setVerticalGravity(getY(), 0, .9, 2);
		syncCoords();
	}

	public void addCollisionDetection() {
		for (int i = 0; i < PlayGame.platformSys.platformArrayList.size(); i++) {
			collisionObjectArrayList.add(new CollisionObject(this, PlayGame.platformSys.platformArrayList.get(i)));
		}
	}

	public void update() {

		for (int i = 0; i < PlayGame.platformSys.platformArrayList.size(); i++) {
			if (collisionObjectArrayList.get(i).checkCollision()) {
				setDy(-25);
				hit = true;
				setY(PlayGame.platformSys.platformArrayList.get(i).getY() - getHeight() - 2);
				PlayGame.platformSys.platformArrayList.get(i).bounceTranslateTransition.play();
			}
		}

		if (!hit) {
			useVerticalGravity();
		} else {
			hit = false;
		}

		syncCoords();
	}
}
