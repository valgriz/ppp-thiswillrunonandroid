package com.valgriz.screen;

import com.twopercent.main.Global;
import com.twopercent.render.BackgroundC;
import com.twopercent.render.Logo;
import com.twopercent.render.UI;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.util.Duration;

public class MainMenu {

	public static BackgroundC backgroundC;
	public static Logo logo;
	private static Group root;

	public MainMenu(Group root) {
		backgroundC = new BackgroundC();
		this.root = root;
		// Logo will be used to change what the menu "advertisement" looks like
		logo = new Logo();
		root.getChildren().add(backgroundC.getGroup());
		root.getChildren().add(logo.getGroup());
		setVisible();
	}

	public void setVisible() {
		backgroundC.setVisible(true);
		logo.setVisible(true);

	}

	public static void goToPlayGame() {
		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000), backgroundC.getGroup());
		translateTransition.setCycleCount(1);
		translateTransition.setToY(-500);
		TranslateTransition translateTransition1 = new TranslateTransition(Duration.millis(1000), logo.getGroup());
		translateTransition1.setToY(-500);
		translateTransition.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				backgroundC.setVisible(false);
			}
		});
		translateTransition1.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				logo.setVisible(false);
			}
		});
		translateTransition1.setCycleCount(0);
		translateTransition.play();
		translateTransition1.play();
		translateOutButtons();
	}

	public static void fadeOutButtons() {
		UI.getButton("mmPlay").fadeOut();
		UI.getButton("mmScores").fadeOut();
		UI.getButton("mmStats").fadeOut();
		UI.getButton("mmOptions").fadeOut();
		UI.getButton("mmHelp").fadeOut();
	}

	public static void translateOutButtons() {
		UI.getButton("mmPlay").translateToY(0, -500, true, false);
		UI.getButton("mmScores").translateToY(0, -500, true, false);
		UI.getButton("mmStats").translateToY(0, -500, true, false);
		UI.getButton("mmOptions").translateToY(0, -500, true, false);
		UI.getButton("mmHelp").translateToY(0, -500, true, false);
	}

	public static void translateInButtons() {
		UI.getButton("mmPlay").translateToY(-500, 0, true, true);
		UI.getButton("mmScores").translateToY(-500, 0, true, true);
		UI.getButton("mmStats").translateToY(-500, 0, true, true);
		UI.getButton("mmOptions").translateToY(-500, 0, true, true);
		UI.getButton("mmHelp").translateToY(-500, 0, true, true);
		Global.inMainMenu = true;
		Global.inPlayGame = false;
		Global.inGameOver = false;
		Global.inPaused = false;
	}

	public void update() {
		backgroundC.update();
		logo.update();
	}

	public static void goToMainMenu() {
		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000), backgroundC.getGroup());
		translateTransition.setCycleCount(1);
		translateTransition.setFromY(-500);
		translateTransition.setToY(0);
		TranslateTransition translateTransition1 = new TranslateTransition(Duration.millis(1000), logo.getGroup());
		translateTransition1.setToY(0);
		translateTransition.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

			}
		});
		translateTransition1.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

			}
		});
		translateTransition1.setCycleCount(0);
		backgroundC.setVisible(true);
		logo.setVisible(true);
		translateTransition.play();
		translateTransition1.play();
		translateInButtons();

	}

}
