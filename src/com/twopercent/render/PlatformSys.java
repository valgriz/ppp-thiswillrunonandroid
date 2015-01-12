package com.twopercent.render;

import java.util.ArrayList;

import com.twopercent.main.Global;
import com.valgriz.screen.PlayGame;

import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class PlatformSys extends VisibleObject {

	static ArrayList<Platform> platformArrayList;
	private int n;
	private double t = 0;

	public PlatformSys() {
		super(new Group());
		super.setDt(.3);

		n = 5; // We have 5 total platforms

		platformArrayList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			platformArrayList.add(new Platform(i, platformArrayList.size()));
			getGroup().getChildren().add(platformArrayList.get(i).getImageView());
		}

	}

	public void update() {
		if (t < 1500) {
			t += getDt();
		}

		for (int i = 0; i < n; i++) {
			// platformArrayList.get(i).setDx(-2-t/750);

			// Checks if platform has scrolled of screen, if so resets some
			// values
			if (platformArrayList.get(i).getX() < (0 - platformArrayList.get(i).getWidth() - 10)) {
				if (i == 0) { // Set the X value for the platform at the X value
								// of the last spawned platform
								// + platform width + random value from 1-150 +
								// random time dependent value
					if (!(platformArrayList.get(platformArrayList.size() - 1).falling)) { // check
																							// if
																							// last
																							// platform
																							// was
																							// falling
						platformArrayList.get(0).setX(
								platformArrayList.get(platformArrayList.size() - 1).getX()
										+ platformArrayList.get(platformArrayList.size() - 1).getWidth()
										+ (int) (200 * Math.random()) + (int) (t * .1 * Math.random()));
					} else { // If last platform was falling, set it close
						platformArrayList.get(0).setX(
								platformArrayList.get(platformArrayList.size() - 1).getX()
										+ platformArrayList.get(platformArrayList.size() - 1).getWidth()
										+ (int) (150 * Math.random()));
					}
				} else { // Set the X value for hte platform at the X value of
							// the platform spawned right before
							// + platform width + random value from 1 - 150 +
							// random time dependent value
					if (!(platformArrayList.get(i - 1).falling)) {
						platformArrayList.get(i).setX(
								platformArrayList.get(i - 1).getX() + platformArrayList.get(i - 1).getWidth()
										+ (int) (200 * Math.random()) + (int) (t * .1 * Math.random()));
					} else {
						platformArrayList.get(i).setX(
								platformArrayList.get(i - 1).getX() + platformArrayList.get(i - 1).getWidth()
										+ (int) (150 * Math.random()));
					}
				}

				// Randomize Y value
				platformArrayList.get(i).setY(300 - (int) (125 * Math.random()) + (int) (125 * Math.random()));

				// Randomize oscillationing platforms
				platformArrayList.get(i).oscillate = false;
				platformArrayList.get(i).falling = false;
				platformArrayList.get(i).getImageViewAndSetViewport(0);
				platformArrayList.get(i).oscillationTracker = 0;
				platformArrayList.get(i).setDy(0);
				if (Math.random() < (double) t / 4000) {
					platformArrayList.get(i).oscillate = true;
					platformArrayList.get(i).getImageViewAndSetViewport(1);
				} else if ((Math.random() + (double) t / 6000) > .92) {
					platformArrayList.get(i).falling = true;
                                        if(!getGroup().getChildren().contains(platformArrayList.get(i).arrowView)){
                                            getGroup().getChildren().add(platformArrayList.get(i).arrowView);
                                        }
					platformArrayList.get(i).getImageViewAndSetViewport(2);
				}

			}
			platformArrayList.get(i).update();
		}
	}

	public void reset() {
		t = 0;
		n = 5;

		getGroup().getChildren().clear();

		platformArrayList.clear();

		for (int i = 0; i < n; i++) {
			platformArrayList.add(new Platform(i, platformArrayList.size()));
			getGroup().getChildren().add(platformArrayList.get(i).getImageView());
		}

	}
}

class Platform extends VisibleObject {

	private int i, n, f;
	public ScaleTransition scaleTransition;
	public TranslateTransition bounceTranslateTransition;
	protected boolean oscillate = false, falling;
	protected double oscillationTracker = 0, oscillationConstant = 0.03, oscillationBuildup = 0;
        
        protected ImageView arrowView = new ImageView(new Image(Platform.class.getResource("/res/images/arrow.png").toString()));
        
	public Platform(int i, int n) {
		this.i = i;
		this.n = n;
		f = 0;

		int whichPlatform = 0;
		setImageViewToImage(new Image(Platform.class.getResource("/res/images/platform.png").toString()));
		getImageViewAndSetViewport(0);
		setWidth(180);
		setHeight(45);
		setX(i * getWidth());
		setY(300);
		setDx(-1 * 2.5);

		scaleTransition = new ScaleTransition(Duration.millis(1000), getImageView());
		scaleTransition.setToY(.5);
		scaleTransition.setCycleCount(10);
		scaleTransition.setAutoReverse(true);

		bounceTranslateTransition = new TranslateTransition(Duration.millis(125), getImageView());
		bounceTranslateTransition.setByY(15);
		bounceTranslateTransition.setCycleCount(2);
		bounceTranslateTransition.setAutoReverse(true);

		DropShadow ds = new DropShadow(15, Color.BLACK);
                arrowView.setOpacity(.5);
		ds.setOffsetX(5);
		ds.setOffsetY(5);
		// getImageView().setEffect(ds);

		syncCoords();
	}

	public void update() {
		if (oscillate) {
			setDy(oscillationBuildup * Math.cos(oscillationTracker));
			oscillationTracker += oscillationConstant;
		}


                else if (falling) {
                        arrowView.setX(getX() + getWidth()/2 - 20);
                        arrowView.setY(getY() + getHeight()*1.5);
			System.out.println("FALLING");
                        if(getDy()==0){
                            arrowView.setOpacity(.5*Math.sin(.05*getX()));
                        }
		} 
                
		else {

			if (oscillationBuildup <= 2.5) {
				oscillationBuildup += .003;
			}
		}
                
                if(getDx()>-5){
                   setDx(getDx() - .002);
                }


		{ // STEVE'S CODE

			if (Global.inPlayGame && !Global.inGameOver && !Global.inPaused) {
				setDx(getDx() - .001);
			}
		}

		updateX();
		updateY();
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

	public void getImageViewAndSetViewport(int whichPlatform) {
		getImageView().setViewport(new Rectangle2D(whichPlatform * 180, 0, 180, 45));
	}

}
