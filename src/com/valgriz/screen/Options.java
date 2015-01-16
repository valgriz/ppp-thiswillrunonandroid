package com.valgriz.screen;

import java.util.ArrayList;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.effect.Bloom;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import com.twopercent.main.Penguin;
import com.twopercent.render.BackgroundD;
import com.twopercent.render.UI;
import com.twopercent.render.UserInterfaceCreator;

public class Options {

	public static BackgroundD backgroundD;
	private Group root, subGroup;
	private Text title;
	private static Text penguinName;
	private static Text penguinPrice;
	private Image dockImage;
	private ImageView dockImageView;
	private Image sideImage;
	private ImageView sideLeftImageView;
	private ImageView sideRightImageView;
	private Image centerDockImage;
	private ImageView centerDockImageView;
	private Image shadowImage;
	private ImageView shadowImageView;
	private Image penguinSpriteSheet;
	private Image starImage;
	private static ImageView starImageView;
	private static ImageView birdA;
	private static ImageView birdB;
	private static ImageView birdC;
	private Image vcFrameImage;
	private ImageView vcFrameImageView;

	private final static int TOTAL_NUMBER_OF_PENGUINS = 7;
	private final static int PENGUIN_WIDTH = 66;
	private final static int PENGUIN_HEIGHT = 40;

	private static int currentPenguinSelection;

	private static ArrayList penguinArrayList;

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

		penguinName = new Text("A PENGUIN");
		penguinName.setFill(new javafx.scene.paint.Color(1, 1, 1, 1));
		penguinName.setFont(new Font("Arial", 24));
		penguinName.setEffect(dropShadow);
		penguinName.setX((720 / 2) - (penguinName.getBoundsInLocal().getWidth() / 2));
		penguinName.setY(287);
		dropShadow.setOffsetX(3);
		dropShadow.setOffsetY(3);

		penguinPrice = new Text("000");
		penguinPrice.setFill(new javafx.scene.paint.Color(1, 1, 1, 1));
		penguinPrice.setFont(new Font("Arial", 24));
		penguinPrice.setEffect(dropShadow);
		penguinPrice.setX(340);
		penguinPrice.setY(317);
		dropShadow.setOffsetX(3);
		dropShadow.setOffsetY(3);

		penguinArrayList = new ArrayList<>();
		definePenguins();

		currentPenguinSelection = 0;

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

		penguinSpriteSheet = new Image(Options.class.getResource("/res/images/bird.png").toString());
		birdA = new ImageView(penguinSpriteSheet);
		birdB = new ImageView(penguinSpriteSheet);
		birdC = new ImageView(penguinSpriteSheet);

		birdA.setViewport(new Rectangle2D((TOTAL_NUMBER_OF_PENGUINS - currentPenguinSelection - 1) * PENGUIN_WIDTH, 0,
				PENGUIN_WIDTH, PENGUIN_HEIGHT));
		birdA.setX(183);
		birdA.setY(180);

		birdB.setViewport(new Rectangle2D((currentPenguinSelection * PENGUIN_WIDTH), 0, PENGUIN_WIDTH, PENGUIN_HEIGHT));
		birdB.setScaleX(2);
		birdB.setScaleY(2);
		birdB.setX(325);
		birdB.setY(180);

		birdC.setViewport(new Rectangle2D((currentPenguinSelection + 1) * PENGUIN_WIDTH, 0, PENGUIN_WIDTH,
				PENGUIN_HEIGHT));
		birdC.setX(465);
		birdC.setY(180);
		BoxBlur bb = new BoxBlur();
		bb.setWidth(2);
		bb.setHeight(2);
		bb.setIterations(3);
		birdA.setEffect(bb);
		birdC.setEffect(bb);

		starImage = new Image(Options.class.getResource("/res/images/star.png").toString());
		starImageView = new ImageView(starImage);
		starImageView.setX(310);
		starImageView.setY(291);
		starImageView.setScaleX(.5);
		starImageView.setScaleY(.5);

		vcFrameImage = new Image(Options.class.getResource("/res/images/dockVolumeControl.png").toString());
		vcFrameImageView = new ImageView(vcFrameImage);
		vcFrameImageView.setX(334);
		vcFrameImageView.setY(91);

		root.getChildren().add(title);
		root.getChildren().add(centerDockImageView);
		root.getChildren().add(birdB);

		subGroup.getChildren().add(dockImageView);
		subGroup.getChildren().add(sideLeftImageView);
		subGroup.getChildren().add(sideRightImageView);

		// Penguins

		subGroup.getChildren().add(birdA);

		subGroup.getChildren().add(birdC);

		subGroup.getChildren().add(shadowImageView);

		subGroup.getChildren().add(penguinName);
		subGroup.getChildren().add(starImageView);
		subGroup.getChildren().add(penguinPrice);
		subGroup.getChildren().add(vcFrameImageView);

		updatePenguinPositions();
	}

	private void definePenguins() {
		penguinArrayList.add(new Penguin(0, 300, true, "A PENGUIN"));
		penguinArrayList.add(new Penguin(1, 350, false, "BLUE BEAK"));
		penguinArrayList.add(new Penguin(2, 420, false, "WU-TANG-PENG"));
		penguinArrayList.add(new Penguin(3, 500, false, "SASSY"));
		penguinArrayList.add(new Penguin(4, 600, false, "GREEN PENGUIN WITH A MOHAWK"));
		penguinArrayList.add(new Penguin(5, 1337, false, "BALLIN"));
		penguinArrayList.add(new Penguin(6, 80085, false, "GABEN"));

	}

	public static void selectionRight() {
		currentPenguinSelection++;

		updatePenguinPositions();
	}

	public static void selectionLeft() {
		currentPenguinSelection--;
		updatePenguinPositions();
	}

	public static void updatePenguinPositions() {
		if (currentPenguinSelection > TOTAL_NUMBER_OF_PENGUINS - 1)
			currentPenguinSelection = 0;
		if (currentPenguinSelection < 0)
			currentPenguinSelection = TOTAL_NUMBER_OF_PENGUINS - 1;

		if (currentPenguinSelection == 0) {
			birdA.setViewport(new Rectangle2D(Math.abs(TOTAL_NUMBER_OF_PENGUINS - 1) * PENGUIN_WIDTH, 0, PENGUIN_WIDTH,
					PENGUIN_HEIGHT));
		} else {
			birdA.setViewport(new Rectangle2D(Math.abs(currentPenguinSelection - 1) * PENGUIN_WIDTH, 0, PENGUIN_WIDTH,
					PENGUIN_HEIGHT));
		}
		birdB.setViewport(new Rectangle2D(Math.abs(currentPenguinSelection) * PENGUIN_WIDTH, 0, PENGUIN_WIDTH,
				PENGUIN_HEIGHT));

		if (currentPenguinSelection == TOTAL_NUMBER_OF_PENGUINS - 1) {
			birdC.setViewport(new Rectangle2D(Math.abs(0) * PENGUIN_WIDTH, 0, PENGUIN_WIDTH, PENGUIN_HEIGHT));
		} else {
			birdC.setViewport(new Rectangle2D(Math.abs(currentPenguinSelection + 1) * PENGUIN_WIDTH, 0, PENGUIN_WIDTH,
					PENGUIN_HEIGHT));
		}

		System.out.println("currentPenguinSelection: " + currentPenguinSelection);
		Penguin p = (Penguin) penguinArrayList.get(currentPenguinSelection);
		penguinName.setText(p.getName());
		penguinName.setX((720 / 2) - (penguinName.getBoundsInLocal().getWidth() / 2));

		penguinPrice.setText("" + p.getStarsRequired());

		if (UserInterfaceCreator.getButtonArrayList() != null) {
			if (p.isUnlocked()) {
				UI.getButton("omUnlock").setVisible(false);
			} else {
				UI.getButton("omUnlock").setVisible(true);
			}
		}
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
