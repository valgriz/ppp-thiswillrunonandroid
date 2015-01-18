package com.valgriz.screen;

import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import com.twopercent.main.DataManager;
import com.twopercent.render.BackgroundD;

public class Stats {
	private Group root;
	private static BackgroundD backgroundD;
	private static Text title, tTime, sTime, tBounces, sBounces, tGames, sGames, tStars, sStars;

	public Stats() {

		backgroundD = new BackgroundD();

		DropShadow dropShadow = new DropShadow(5, new Color(0, 0, 0, 1));
		dropShadow.setOffsetX(3);
		dropShadow.setOffsetY(3);

		title = new Text("STATS");
		title.setFill(new javafx.scene.paint.Color(1, 1, 1, 1));
		title.setFont(new Font("Arial", 42));
		title.setEffect(dropShadow);
		title.setX((720 / 2) - (title.getBoundsInLocal().getWidth() / 2));
		title.setY(60);

		tTime = new Text("TOTAL TIME SPENT AS A BOUNCING PENGUIN:");
		tTime.setFill(new Color(1, 1, 1, 1));
		tTime.setFont(new Font("Arial", 24));
		tTime.setEffect(dropShadow);
		tTime.setY(110);
		tTime.setX((720 / 2) - (tTime.getBoundsInLocal().getWidth() / 2));

		sTime = new Text("0 HOURS, 0 MINUTES, 0 SECONDS");
		sTime.setFill(new Color(1, 1, 1, 1));
		sTime.setFont(new Font("Arial", 24));
		sTime.setEffect(dropShadow);
		sTime.setY(140);
		sTime.setX((720 / 2) - (sTime.getBoundsInLocal().getWidth() / 2));

		tBounces = new Text("TOTAL NUMBER OF BOUNCES:");
		tBounces.setFill(new Color(1, 1, 1, 1));
		tBounces.setFont(new Font("Arial", 24));
		tBounces.setEffect(dropShadow);
		tBounces.setY(180);
		tBounces.setX((720 / 2) - (tBounces.getBoundsInLocal().getWidth() / 2));

		sBounces = new Text("0 BOUNCES");
		sBounces.setFill(new Color(1, 1, 1, 1));
		sBounces.setFont(new Font("Arial", 24));
		sBounces.setEffect(dropShadow);
		sBounces.setY(210);
		sBounces.setX((720 / 2) - (sBounces.getBoundsInLocal().getWidth() / 2));

		tGames = new Text("TOTAL NUMBER OF GAMES PLAYED:");
		tGames.setFill(new Color(1, 1, 1, 1));
		tGames.setFont(new Font("Arial", 24));
		tGames.setEffect(dropShadow);
		tGames.setY(250);
		tGames.setX((720 / 2) - (tGames.getBoundsInLocal().getWidth() / 2));

		sGames = new Text("0 GAMES");
		sGames.setFill(new Color(1, 1, 1, 1));
		sGames.setFont(new Font("Arial", 24));
		sGames.setEffect(dropShadow);
		sGames.setY(280);
		sGames.setX((720 / 2) - (sGames.getBoundsInLocal().getWidth() / 2));

		tStars = new Text("TOTAL STARS COLLECTED:");
		tStars.setFill(new Color(1, 1, 1, 1));
		tStars.setFont(new Font("Arial", 24));
		tStars.setEffect(dropShadow);
		tStars.setY(320);
		tStars.setX((720 / 2) - (tStars.getBoundsInLocal().getWidth() / 2));

		sStars = new Text("0 STARS");
		sStars.setFill(new Color(1, 1, 1, 1));
		sStars.setFont(new Font("Arial", 24));
		sStars.setEffect(dropShadow);
		sStars.setY(350);
		sStars.setX((720 / 2) - (sStars.getBoundsInLocal().getWidth() / 2));

		root = new Group();
		root.getChildren().add(backgroundD.getGroup());
		root.getChildren().add(title);
		root.getChildren().add(tTime);
		root.getChildren().add(sTime);
		root.getChildren().add(tBounces);
		root.getChildren().add(sBounces);
		root.getChildren().add(tGames);
		root.getChildren().add(sGames);
		root.getChildren().add(tStars);
		root.getChildren().add(sStars);

	}

	public static String getHMS(int iS) {
		int hours = 0;
		int mins = 0;
		int sec;
		for (sec = iS; sec > 60; sec -= 60) {
			mins++;
		}
		for (hours = 0; mins > 60; mins -= 60) {
			hours++;
		}
		String hs;
		if (hours == 1) {
			hs = " HOUR, ";
		} else {
			hs = " HOURS, ";
		}
		String ms;
		if (mins == 1) {
			ms = " MINUTE, ";
		} else {
			ms = " MINUTES, ";
		}
		String ss;
		if (sec % 10 == 1) {
			ss = " SECOND ";
		} else {
			ss = " SECONDS ";
		}

		return hours + hs + mins + ms + sec + ss;

	}

	public static void refreshStats() {

		sTime.setText(getHMS(DataManager.getStatValue("totalTime")));
		sBounces.setText(DataManager.getStatValue("totalBounces") + " BOUNCES");
		sStars.setText(DataManager.getStatValue("totalStars") + " STARS");
		sGames.setText(DataManager.getStatValue("totalGames") + " GAMES");

	}

	public Group getGroup() {
		return root;
	}

	public void setRoot(Group root) {
		this.root = root;
	}

}
