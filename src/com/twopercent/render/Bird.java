package com.twopercent.render;

import java.util.ArrayList;

import com.twopercent.main.DataManager;
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
	private static boolean onLeft, onRight, doingIt;

	private static ScaleTransition scaleTransition;
	private static RotateTransition rt1;
	private static RotateTransition rt2;
	private static int birdIndex;
	private int starCounter;

	private static double friction;

	public Bird() {
		super(new Group());

		setImageViewToImage(new Image(Bird.class.getResource("/res/images/bird.png").toString()));
		getGroup().getChildren().add(getImageView());
		birdIndex = 0;
		getImageView().setViewport(new Rectangle2D(66 * Global.penguinInUse, 0, 66, 40));
		setWidth(57);
		setHeight(40);
		setX(200);
		setY(-50);

		collisionObjectArrayList = new ArrayList<>();
		hit = false;

		onLeft = onRight = false;

		setVerticalGravity(getY(), 0, .9, 2);

		// When you let go of left/right, penguin will continue to move for a
		// few frames
		friction = .8;

		scaleTransition = new ScaleTransition(Duration.millis(200), getImageView());

		rt1 = new RotateTransition(Duration.millis(500), getGroup());
		rt1.setToAngle(30);

		rt2 = new RotateTransition(Duration.millis(500), getGroup());
		rt2.setToAngle(-30);

		// Global.inPlayGame = true;

		syncCoords();

	}

	public void reset() {
		getImageView().setViewport(new Rectangle2D(66 * Global.penguinInUse, 0, 66, 40));

		System.out.println("BIIW " + Global.penguinInUse);

		setX(200);
		setY(-50);

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

		doingIt = false;

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
		doingIt = true;
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
			setDx(getDx() * friction);
		}

		for (int i = 0; i < PlayGame.platformSys.platformArrayList.size(); i++) {
			if (collisionObjectArrayList.get(i).checkCollision() && getDy() > 0) {
				SoundPlayer.playBounce(); // MP3 Bounce sound, tested against
											// WAV and MP3 was faster
				// SoundPlayer.playBounce2();
				setDy(-25);
				hit = true;
				Global.bounces++;
				setY(PlayGame.platformSys.platformArrayList.get(i).getY() - getHeight() - 2);
				PlayGame.platformSys.platformArrayList.get(i).bounceTranslateTransition.play();
				if (PlayGame.platformSys.platformArrayList.get(i).falling) {
					PlayGame.platformSys.platformArrayList.get(i).setDy(
							PlayGame.platformSys.platformArrayList.get(i).getDy() + 7);
					SoundPlayer.playFallingPlatform();
					PlayGame.platformSys.platformArrayList.get(i).arrowView.setOpacity(0);
				}
			}
		}
		if (PlayGame.platformSys.stars.size() >= 1) {
			for (int i = PlayGame.platformSys.stars.size() - 1; i >= 0; i--) {

				CollisionObject starCheck = new CollisionObject(this, PlayGame.platformSys.stars.get(i));
				if (starCheck.checkCollision()) {
					PlayGame.platformSys.stars.get(i).removeStar();// Play
																	// Transition
																	// and
																	// remove
																	// from
																	// group
					PlayGame.platformSys.stars.remove(i);// Remove from array
															// list
					starCounter++;
					Global.stars++;
				}

				else if (PlayGame.platformSys.stars.get(i).gone) {
					PlayGame.platformSys.stars.remove(i);
				}

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

		// CODE FOR SWITCHING SIDES WHEN OFFSCREEN
		if (!doingIt) {
			if (getX() < -30) {
				setX(734);
			}

			if (getX() > 744) {
				setX(-20);
			}
		}

		// END CODE FOR SWITCHING SIDES

		reverseAnimation();
		updateX();
		syncCoords();
	}

}
