package com.valgriz.screen;

import com.twopercent.main.DataManager;
import com.twopercent.render.BackgroundC;
import com.twopercent.render.BackgroundD;

import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class HighScores {

	public static BackgroundD backgroundD;
	private Group root;
	private Text scoreArray[] = new Text[10];
	private Text title;

	public HighScores() {
		DropShadow dropShadow = new DropShadow(5, new javafx.scene.paint.Color(0, 0, 0, 1));
		root = new Group();
		backgroundD = new BackgroundD();

		root.getChildren().add(backgroundD.getGroup());

		for (int i = 0; i < scoreArray.length; i++) {

			if (i < 5) {
				scoreArray[i] = new Text((i + 1) + ". " + "0");
				scoreArray[i].setX(106);
				scoreArray[i].setY(123 + (i * 52));
			} else {
				scoreArray[i] = new Text((i + 1) + ". " + "0");
				scoreArray[i].setX(412);
				scoreArray[i].setY(123 + ((i - 5) * 52));
			}
			scoreArray[i].setFill(new javafx.scene.paint.Color(1, 1, 1, 1));
			scoreArray[i].setFont(new Font("Arial", 42));
			scoreArray[i].setEffect(dropShadow);
			dropShadow.setOffsetX(3);
			dropShadow.setOffsetY(3);

			root.getChildren().add(scoreArray[i]);

		}

		title = new Text("HIGH SCORES");
		title.setFill(new javafx.scene.paint.Color(1, 1, 1, 1));
		title.setFont(new Font("Arial", 42));
		title.setEffect(dropShadow);
		title.setX(213);
		title.setY(60);
		dropShadow.setOffsetX(3);
		dropShadow.setOffsetY(3);
		root.getChildren().add(title);
	}

	public void update() {
		backgroundD.update();
		for (int i = 0; i < scoreArray.length; i++) {
			scoreArray[i].setText((i + 1) + ". " + (DataManager.getHighscore())[i]);
		}
	}

	public Group getGroup() {
		return root;
	}

	public void setGroup(Group root) {
		this.root = root;
	}

}
