package com.valgriz.screen;

import com.twopercent.main.Global;
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
	private MainMenu mainMenu;
	private UI userInterface;

	public Screen(Group root) {
		this.root = root;
		playGame = new PlayGame(root);
		mainMenu = new MainMenu(root);
		userInterface = new UI();
		// Can use some optimization
		root.getChildren().add(userInterface.getGroup());

		Global.inMainMenu = true;
		Global.inGameOver = false;
		Global.inHelp = false;
		Global.inHighScores = false;
		Global.inOptions = false;
		Global.inPaused = false;
		Global.inPlayGame = false;
		Global.inStats = false;

		startTimeline();
	}

	@SuppressWarnings("deprecati" + "on")
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
		if (Global.inMainMenu) {
			mainMenu.update();
		}
		if (Global.inPlayGame) {
			playGame.update();
		}
		userInterface.update();

	}
}
