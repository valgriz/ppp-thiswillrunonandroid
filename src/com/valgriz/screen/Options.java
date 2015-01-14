package com.valgriz.screen;

import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import com.twopercent.render.BackgroundD;

public class Options {

	public static BackgroundD backgroundD;
	private Group root, subGroup;
	private Text title;
	private Image dockImage;
	private ImageView dockImageView;
	private Image sideImage;
	private ImageView sideLeftImageView;
	private ImageView sideRightImageView;
	private Image centerDockImage;
	private ImageView centerDockImageView;
	private Image shadowImage;
	private ImageView shadowImageView;

	public Options() {
		root = new Group();
		subGroup = new Group();
		backgroundD = new BackgroundD();
		root.getChildren().add(backgroundD.getGroup());
		DropShadow dropShadow = new DropShadow(5, new javafx.scene.paint.Color(0, 0, 0, 1));
		title = new Text("OPTIONS");
		title.setFill(new javafx.scene.paint.Color(1, 1, 1, 1));
		title.setFont(new Font("Arial", 42));
		title.setEffect(dropShadow);
		title.setX(265);
		title.setY(60);
		dropShadow.setOffsetX(3);
		dropShadow.setOffsetY(3);

		dockImage = new Image(Options.class.getResource("/res/images/dock.png").toString());
		dockImageView = new ImageView(dockImage);
		dockImageView.setX(90);
		dockImageView.setY(91);

		sideImage = new Image(Options.class.getResource("/res/images/sidePenguinStage.png").toString());
		sideLeftImageView = new ImageView(sideImage);
		sideLeftImageView.setX(176);
		sideLeftImageView.setY(171);

		sideRightImageView = new ImageView(sideImage);
		sideRightImageView.setX(457);
		sideRightImageView.setY(171);

		centerDockImage = new Image(Options.class.getResource("/res/images/centerDock.png").toString());
		centerDockImageView = new ImageView(centerDockImage);
		centerDockImageView.setX(277);
		centerDockImageView.setY(91);

		shadowImage = new Image(Options.class.getResource("/res/images/shadow.png").toString());
		shadowImageView = new ImageView(shadowImage);
		shadowImageView.setX(140);
		shadowImageView.setY(96);

		root.getChildren().add(title);

		subGroup.getChildren().add(dockImageView);
		subGroup.getChildren().add(sideLeftImageView);
		subGroup.getChildren().add(sideRightImageView);
		subGroup.getChildren().add(centerDockImageView);
		// Penguins

		subGroup.getChildren().add(shadowImageView);

	}

	public void update() {

	}

	public Group getGroup() {
		return root;
	}

	public void setGroup(Group root) {
		this.root = root;
	}

	public Group getSubGroup() {
		return subGroup;
	}

	public void setSubGroup(Group subGroup) {
		this.subGroup = subGroup;
	}

}
