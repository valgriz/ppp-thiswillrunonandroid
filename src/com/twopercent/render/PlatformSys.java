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

        static ArrayList<Platform> platformArrayList;
	private int n;

	public PlatformSys() {
		super(new Group());

		n = 5; //We have 5 total platforms

		platformArrayList = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			platformArrayList.add(new Platform(i, platformArrayList.size()));
			getGroup().getChildren().add(platformArrayList.get(i).getImageView());
		}

	}

	public void update() {
		for (int i = 0; i < n; i++) {
                    
                    //Checks if platform has scrolled of screen, if so resets some values
                    if(platformArrayList.get(i).getX()<(0-platformArrayList.get(i).getWidth())){
                        if(i==0){ //Set the X value for the platform at the X value of the last spawned platform
                                  // + platform width + random value from 1-150
                            platformArrayList.get(i).setX(
                                    platformArrayList.get(platformArrayList.size()-1).getX()+
                                            platformArrayList.get(platformArrayList.size()-1).getWidth()
                                            + (int)(150*Math.random()));
                        }
                        else{ //Set the X value for hte platform at the X value of the platform spawned right before
                              // + platform width + random value from 1 - 150
                            platformArrayList.get(i).setX(
                                    platformArrayList.get(i-1).getX()+
                                            platformArrayList.get(i-1).getWidth()
                                            + (int)(150*Math.random()));
                        }
                        
                        //Randomize Y value
                        platformArrayList.get(i).setY(300-(int)(150*Math.random())+(int)(150*Math.random()));
                        
                        //Randomize oscillationing platforms
                        platformArrayList.get(i).oscillate=false;
                        platformArrayList.get(i).oscillationTracker=0;
                        if(Math.random()<0.5){
                            platformArrayList.get(i).oscillate=true;
                        }
                        
                    }
                    platformArrayList.get(i).update();
		}
	}

}

class Platform extends VisibleObject {

	private int i, n, f;
	public ScaleTransition scaleTransition;
	public TranslateTransition bounceTranslateTransition;
        protected boolean oscillate = false;
        protected double oscillationTracker=0;

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

		scaleTransition = new ScaleTransition(Duration.millis(1000), getImageView());
		scaleTransition.setToY(.5);
		scaleTransition.setCycleCount(10);
		scaleTransition.setAutoReverse(true);

		bounceTranslateTransition = new TranslateTransition(Duration.millis(125), getImageView());
		bounceTranslateTransition.setByY(15);
		bounceTranslateTransition.setCycleCount(2);
		bounceTranslateTransition.setAutoReverse(true);

		syncCoords();

	}

	public void update() {
                if(oscillate){
                    setDy(Math.sin(oscillationTracker));
                    oscillationTracker+=.03;
                }
                else setDy(0);
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
}
