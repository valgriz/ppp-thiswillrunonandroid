package com.twopercent.render;

import java.util.ArrayList;

import com.twopercent.main.Global;
import com.valgriz.screen.PlayGame;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class Bird extends VisibleObject {

	private ArrayList<CollisionObject> collisionObjectArrayList;
	private boolean hit;
	private static boolean onLeft, onRight;

	private static ScaleTransition scaleTransition;
	private static RotateTransition rt1;
	private static RotateTransition rt2;

	public Bird() {
		super(new Group());
		setImageViewToImage(new Image(Bird.class.getResource("/res/images/bird.png").toString()));
		getGroup().getChildren().add(getImageView());
		getImageView().setViewport(new Rectangle2D(0, 0, 56, 40));
		setWidth(57);
		setHeight(40);
		setX(200);
		setY(-200);

		collisionObjectArrayList = new ArrayList<>();
		hit = false;

		onLeft = onRight = false;

		setVerticalGravity(getY(), 0, .9, 2);

		scaleTransition = new ScaleTransition(Duration.millis(200), getImageView());

		rt1 = new RotateTransition(Duration.millis(500), getGroup());
		rt1.setToAngle(30);

		rt2 = new RotateTransition(Duration.millis(500), getGroup());
		rt2.setToAngle(-30);

		Global.inPlayGame = true;

		syncCoords();

	}

	public void reset() {
		setX(200);
		setY(-200);

		scaleTransition.setToX(1);
		scaleTransition.play();
		onLeft = onLeft = false;
		setDx(0);
		setDy(0);

		hit = false;
		Global.inPlayGame = true;
		collisionObjectArrayList.clear();
		addCollisionDetection();
		syncCoords();
	}

	public static void offLeft() {
		onLeft = false;
	}

	public static void offRight() {
		onRight = false;
	}

	public static void onLeft() {
		onLeft = true;
		scaleTransition.setToX(-1);
		scaleTransition.play();
	}

	public static void onRight() {
		onRight = true;
		scaleTransition.setToX(1);
		scaleTransition.play();
	}

	public void addCollisionDetection() {
		for (int i = 0; i < PlayGame.platformSys.platformArrayList.size(); i++) {
			collisionObjectArrayList.add(new CollisionObject(this, PlayGame.platformSys.platformArrayList.get(i)));
		}
	}

	private void reverseAnimation() {
		if (getDy() < 0) {
			if (rt2.getStatus() != Animation.Status.RUNNING) {
				rt2.play();
			}
		} else if (getDy() > 0) {
			if (rt1.getStatus() != Animation.Status.RUNNING) {
				rt1.play();
			}
		}

	}

	public static void dontDoIt() {
		scaleTransition.setToX(-1);
		scaleTransition.play();
		onLeft = true;
		onRight = false;
	}

	public void birdFell() {
		if (Global.inPlayGame && !Global.inHighScores && !Global.inStats && !Global.inOptions && !Global.inHelp
				&& !Global.inPaused && !Global.inGameOver) {
			Global.inGameOver = true;
			Global.gameStateChanged = true;
		}
	}

	public static void pauseAllAnimation() {
		if (Global.gameStateChanged && Global.inPlayGame && Global.inPaused && !Global.inGameOver) {
			rt1.pause();
			rt2.pause();
			scaleTransition.stop();
		}
	}

	public void update() {

		if (onLeft) {
			if (getDx() < 0)
				setDx(getDx() - 1.5);
			else
				setDx(-5);
		}
		if (onRight) {
			if (getDx() > 0)
				setDx(getDx() + 1.5);
			else
				setDx(5);
		}

		if (!onLeft && !onRight) {
			setDx(0);
		}

		for (int i = 0; i < PlayGame.platformSys.platformArrayList.size(); i++) {
			if (collisionObjectArrayList.get(i).checkCollision() && getDy() > 0) {
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

		if (getY() > 600) {
			birdFell();
		}
		reverseAnimation();
		updateX();
		syncCoords();
	}

}
