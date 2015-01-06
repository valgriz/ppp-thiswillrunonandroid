package com.valgriz.screen;

import com.twopercent.main.InputController;
import com.twopercent.main.Main;
import com.twopercent.render.UI;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.TimelineBuilder;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Screen {
	private Group root;
	private PlayGame playGame;
	private UI userInterface;

	public Screen(Group root) {
		this.root = root;
		playGame = new PlayGame(root);

		userInterface = new UI();

		root.getChildren().add(userInterface.getGroup());

		startTimeline();
	}

	@SuppressWarnings("deprecation")
	private void startTimeline() {
		TimelineBuilder.create().cycleCount(Animation.INDEFINITE)
				.keyFrames(new KeyFrame(Duration.millis(30), new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						//
						update();
					}
				})).build().play();
	}

	private void update() {

		playGame.update();
		userInterface.update();

	}
}
