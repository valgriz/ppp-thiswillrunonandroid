package com.valgriz.screen;

import com.twopercent.main.Global;
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
	private static Group root;
	private static PlayGame playGame;
	private static MainMenu mainMenu;
	private static UI userInterface;
	private static HighScores highScores;
	private LoadingScreen loadingScreen;
	private static Options options;

	public Screen(Group root) {
		this.root = root;

		// loadingScreen = new LoadingScreen(root);

		highScores = new HighScores();
		playGame = new PlayGame();
		mainMenu = new MainMenu();
		options = new Options();

		userInterface = new UI();

		root.getChildren().add(options.getGroup());
		root.getChildren().add(highScores.getGroup());
		root.getChildren().add(playGame.getGroup());
		root.getChildren().add(mainMenu.getGroup());

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

	public static void setVisibleGroup(String s) {

		root.getChildren().clear();
		switch (s) {
		case "MainMenu":
			root.getChildren().add(playGame.getGroup());
			root.getChildren().add(mainMenu.getGroup());
			break;
		case "PlayGame":
			root.getChildren().add(playGame.getGroup());
			root.getChildren().add(mainMenu.getGroup());
			MainMenu.goToPlayGameRightNow();
			MainMenu.translateOutButtonsRightNow();
			PlayGame.resetGame();
			break;
		case "HighScores":
			root.getChildren().add(highScores.getGroup());
			break;
		case "Stats":
			break;
		case "Options":
			root.getChildren().add(options.getGroup());
			break;
		case "Help":
			break;

		}
		root.getChildren().add(userInterface.getGroup());
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
		if (Global.inHighScores) {
			highScores.update();
		}
		if (Global.inOptions) {
			options.update();
		}
		userInterface.update();

	}

	public static Group getGroup() {
		return root;
	}

	public static void setGroup(Group root) {
		Screen.root = root;
	}

}
