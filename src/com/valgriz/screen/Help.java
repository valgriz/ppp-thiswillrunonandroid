package com.valgriz.screen;

import com.twopercent.render.BackgroundD;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Help {

	private Group root;
	private static Image helpImage;
	private static ImageView helpImageView;
	private static BackgroundD backgroundD;

	public Help() {
		helpImage = new Image(Help.class.getResource("/res/images/helpScreen.png").toString());
		helpImageView = new ImageView(helpImage);
		helpImageView.setX(0);
		helpImageView.setY(0);

		backgroundD = new BackgroundD();

		root = new Group();
		root.getChildren().add(backgroundD.getGroup());
		root.getChildren().add(helpImageView);

	}

	public static Image getHelpImage() {
		return helpImage;
	}

	public static void setHelpImage(Image helpImage) {
		Help.helpImage = helpImage;
	}

	public static ImageView getHelpImageView() {
		return helpImageView;
	}

	public static void setHelpImageView(ImageView helpImageView) {
		Help.helpImageView = helpImageView;
	}

	public Group getGroup() {
		return root;
	}

	public void setRoot(Group root) {
		this.root = root;
	}

}
