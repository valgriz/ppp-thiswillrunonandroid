package com.valgriz.screen;

import com.twopercent.main.Global;
import com.twopercent.render.BackgroundA;
import com.twopercent.render.BackgroundB;
import com.twopercent.render.Bird;
import com.twopercent.render.PlatformSys;

import javafx.scene.Group;
import javafx.scene.layout.Background;

public class PlayGame {

	public static BackgroundA backgroundA;
	public static BackgroundB backgroundB;
	public static PlatformSys platformSys;
	public static Bird bird;

	public PlayGame(Group root) {
		backgroundA = new BackgroundA();
		backgroundB = new BackgroundB();
		platformSys = new PlatformSys();
		bird = new Bird();

		// Render Order
		root.getChildren().add(backgroundA.getGroup());
		root.getChildren().add(backgroundB.getGroup());
		root.getChildren().add(platformSys.getGroup());
		root.getChildren().add(bird.getGroup());

		bird.addCollisionDetection();

		// Bird
		// Any extras
		// UI

	}

	public static void resetGame() {
		platformSys.reset();
		bird.reset();
		// Attribs
		Global.inPlayGame = true;
		Global.inHighScores = false;
		Global.inStats = false;
		Global.inOptions = false;
		Global.inHelp = false;
		Global.inPaused = false;
		Global.inGameOver = false;
		Global.score = 0;
		Global.gameStateChanged = true;
	}

	public void update() {
		if (!Global.inPaused) {
			backgroundA.update();
			backgroundB.update();
			platformSys.update();
			bird.update();

		}

		if (Global.inPlayGame && Global.inPaused && !Global.inGameOver) {
			Bird.pauseAllAnimation();
		}

		if (Global.inPlayGame && !Global.inHighScores && !Global.inStats && !Global.inOptions && !Global.inHelp
				&& !Global.inPaused && !Global.inGameOver) {
			Global.score += 1;

		}
	}
}
