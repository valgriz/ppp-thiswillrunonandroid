package com.twopercent.render;

import java.awt.Color;

import com.sun.javafx.css.FontFace;
import com.sun.javafx.scene.control.behavior.TextBinding;
import com.twopercent.main.Global;

import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class UI extends UserInterfaceCreator {

	private Text gameMessage;
	private String gameEndMessageString;
	public static int selection = 0;

	public UI() {
		super();
		DropShadow dropShadow = new DropShadow(5, new javafx.scene.paint.Color(0, 0, 0, 1));

		getGroup().getChildren().add(getScoreText());

		getScoreText().setX(15);
		getScoreText().setY(40);
		getScoreText().setText("");
		getScoreText().setFill(new javafx.scene.paint.Color(1, 1, 1, 1));
		getScoreText().setFont(new Font("Arial", 36));
		getScoreText().setEffect(dropShadow);
		dropShadow.setOffsetX(3);
		dropShadow.setOffsetY(3);

		gameMessage = new Text("GAME OVER");
		gameMessage.setFont(new Font("Arial", 60));
		gameMessage.setFill(new javafx.scene.paint.Color(1, 1, 1, 1));
		gameMessage.setEffect(dropShadow);
		gameMessage.setX((720 / 2) - (gameMessage.getLayoutBounds().getWidth() / 2));
		gameMessage.setY(150);
		gameMessage.setVisible(false);

		getGroup().getChildren().add(gameMessage);

		addNullButton(0, 0, 357, 500, "pgLeftTap");
		addNullButton(358, 0, 357, 500, "pgRightTap");
		addNullButton(0, 0, 130, 60, "pgPauseGame");

		addButton(210, 195, 300, 69, "PLAY AGAIN", 0, "goPlayAgain");
		addButton(210, 287, 300, 69, "MAIN MENU", 0, "goMainMenu");
		addButton(210, 195, 300, 69, "RESUME", 0, "gpResume");
		addButton(210, 287, 300, 69, "END GAME", 0, "gpEndGame");

		stateChanged();

	}

	public void showScreenStatus() {
		// Attribs
		System.out.println("inPlayGame:" + Global.inPlayGame);
		System.out.println("inHighScores:" + Global.inHighScores);
		System.out.println("inStats:" + Global.inStats);
		System.out.println("inOptions:" + Global.inOptions);
		System.out.println("inHelp:" + Global.inHelp);
		System.out.println("inPaused:" + Global.inPaused);
		System.out.println("inGameOver:" + Global.inGameOver);
		System.out.println("-----------------------");
	}

	public Button controlButton(String id) {
		return getButton(id);
	}

	public static void unhighlightAllButtons() {
		for (int i = 0; i < getButtonArrayList().size(); i++) {
			getButtonArrayList().get(i).setState(0);
		}
	}

	public static void highlightButton(String id) {
		getButton(id).setState(2);
	}

	public void stateChanged() {
		selection = 0;
		System.out.println("screenStateChanged");
		// Attribs
		if (Global.inPlayGame && !Global.inHighScores && !Global.inStats && !Global.inOptions && !Global.inHelp
				&& !Global.inPaused && Global.inGameOver) {
			gameMessage.setText("GAME OVER");
			gameMessage.setX((720 / 2) - (gameMessage.getLayoutBounds().getWidth() / 2));
			gameMessage.setVisible(true);
			getButton("pgLeftTap").setVisible(false);
			getButton("pgRightTap").setVisible(false);
			getButton("goPlayAgain").setVisible(true);
			getButton("goMainMenu").setVisible(true);
			getButton("pgPauseGame").setVisible(false);
			getButton("gpEndGame").setVisible(false);
			getButton("gpResume").setVisible(false);
		}
		if (Global.inPlayGame && !Global.inHighScores && !Global.inStats && !Global.inOptions && !Global.inHelp
				&& Global.inPaused && !Global.inGameOver) {
			gameMessage.setText("GAME PAUSED");
			gameMessage.setX((720 / 2) - (gameMessage.getLayoutBounds().getWidth() / 2));
			gameMessage.setVisible(true);
			getButton("pgLeftTap").setVisible(false);
			getButton("pgRightTap").setVisible(false);
			getButton("goPlayAgain").setVisible(false);
			getButton("goMainMenu").setVisible(false);
			getButton("pgPauseGame").setVisible(false);
			getButton("gpEndGame").setVisible(true);
			getButton("gpResume").setVisible(true);
		}
		if (Global.inPlayGame && !Global.inHighScores && !Global.inStats && !Global.inOptions && !Global.inHelp
				&& !Global.inPaused && !Global.inGameOver) {
			gameMessage.setVisible(false);
			getButton("pgLeftTap").setVisible(true);
			getButton("pgRightTap").setVisible(true);
			getButton("goPlayAgain").setVisible(false);
			getButton("goMainMenu").setVisible(false);
			getButton("pgPauseGame").setVisible(true);
			getButton("gpEndGame").setVisible(false);
			getButton("gpResume").setVisible(false);
		}

		Global.gameStateChanged = false;
	}

	public void update() {
		super.update();

		showScreenStatus();

		if (Global.gameStateChanged)
			stateChanged();
		// Add Highscore Message

		getScoreText().setText("" + Global.score);
	}
}
