package com.twopercent.render;

import com.twopercent.main.ActionZone;
import com.twopercent.main.InputController;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Button extends VisibleObject {
	private String text, id;
	private int buttonKey = 0, buttonHoverKey = 1, buttonSpriteKey;
	private int state, subState;
	private Text textView;

	public Button(int x, int y, int width, int height, String text, int buttonSpriteKey, String id) {
		super(new Group());
		this.text = text;
		this.buttonSpriteKey = buttonSpriteKey;
		this.id = id;

		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		//

		//
		// state = 0;
		//
		// setImageViewToImage(new
		// Image(Button.class.getResource("/res/images/buttonA1.png").toString()));
		// getImageView().setViewport(
		// new Rectangle2D(getWidth() * buttonKey, getHeight() *
		// buttonSpriteKey, getWidth(), getHeight()));
		// getImageView().setX(getX());
		// getImageView().setY(getY());
		// getGroup().getChildren().add(getImageView());
		//
		// textView = new Text();
		// textView.setFont(new Font("Arial", 42));
		// textView.setFill(new Color(1, 1, 1, 1));
		// DropShadow dropShadow = new DropShadow();
		// dropShadow.setRadius(5);
		// dropShadow.setOffsetX(2);
		// dropShadow.setOffsetY(2);
		// dropShadow.setColor(new Color(0, 0, 0, 1));
		// textView.setEffect(dropShadow);
		//
		// textView.setText(text);
		//
		// textView.setX(getX() + (getWidth() / 2) -
		// (textView.getLayoutBounds().getWidth() / 2));
		// textView.setY(getY() + 47);
		//
		// setType("button");
		//
		// addActionListener();
		//
		// getGroup().getChildren().add(textView);

	}

	public Button(int x, int y, int width, int height, String text, int textSize, int yOffset, int buttonSpriteKey,
			String id) {
		super(new Group());
		this.text = text;
		this.buttonSpriteKey = buttonSpriteKey;
		this.id = id;

		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);
		//

		//
		// state = 0;
		//
		// setImageViewToImage(new
		// Image(Button.class.getResource("/res/images/buttonA1.png").toString()));
		// getImageView().setViewport(new Rectangle2D(getWidth() * buttonKey,
		// buttonSpriteKey, getWidth(), getHeight()));
		// getImageView().setX(getX());
		// getImageView().setY(getY());
		// getGroup().getChildren().add(getImageView());
		//
		// textView = new Text();
		// textView.setFont(new Font("Arial", textSize));
		// textView.setFill(new Color(1, 1, 1, 1));
		// DropShadow dropShadow = new DropShadow();
		// dropShadow.setRadius(5);
		// dropShadow.setOffsetX(2);
		// dropShadow.setOffsetY(2);
		// dropShadow.setColor(new Color(0, 0, 0, 1));
		// textView.setEffect(dropShadow);
		//
		// textView.setText(text);
		//
		// textView.setX(getX() + (getWidth() / 2) -
		// (textView.getLayoutBounds().getWidth() / 2));
		// textView.setY(getY() + yOffset);
		//
		// setType("button");
		//
		// addActionListener();
		//
		// getGroup().getChildren().add(textView);

	}

	public Button(int x, int y, int width, int height, String id) {
		// this button will NOT be viewable, however is only clickable when
		// setVisible(true);
		super(new Group());

		setX(x);
		setY(y);
		setWidth(width);
		setHeight(height);

		// this.id = id;
		// setType("nullButton");
		//
		// state = 0;
		//
		// addActionListener();

	}

	public Button(int x, int y, int width, int height, int buttonSpriteKey, String sTypeA, String sTypeB, String id) {
		super(new Group());
		// setX(x);
		// setY(y);
		// setWidth(width);
		// setHeight(height);
		// this.id = id;
		// this.buttonSpriteKey = buttonSpriteKey;
		// this.buttonHoverKey = 1;
		// this.buttonKey = 0;
		//
		// setType("switch");
		//
		// state = 0;
		// subState = 0;
		//
		// setImageViewToImage(new
		// Image(Button.class.getResource("/res/images/buttonA1.png").toString()));
		// getImageView().setViewport(new Rectangle2D(getWidth() * buttonKey,
		// buttonSpriteKey, getWidth(), getHeight()));
		// getImageView().setX(getX());
		// getImageView().setY(getY());
		//
		// addActionListener();
		//
		// getGroup().getChildren().add(getImageView());

	}

	public void fadeOut() {
		FadeTransition fadeTransition = new FadeTransition(Duration.millis(1000), getGroup());
		fadeTransition.setFromValue(1);
		fadeTransition.setToValue(0);
		fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				setVisible(false);
				// fadeTransition.stop();
			}
		});
		fadeTransition.play();
	}

	public void fadeIn() {

		FadeTransition fadeTransition = new FadeTransition(Duration.millis(1), getGroup());
		fadeTransition.setFromValue(0);

		fadeTransition.setToValue(1);
		fadeTransition.setOnFinished(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				setVisible(true);
			}
		});
		fadeTransition.play();
		setVisible(true);
	}

	public void translateToYrn(int start, int finish, boolean startVisibility, boolean finishVisibility) {
		setVisible(startVisibility);
		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1), getGroup());
		translateTransition.setCycleCount(1);
		translateTransition.setFromY(start);
		translateTransition.setToY(finish);
		translateTransition.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				setVisible(finishVisibility);
			}
		});
		translateTransition.play();
		translateTransition.setAutoReverse(true);
	}

	public void translateToY(int start, int finish, boolean startVisibility, boolean finishVisibility) {
		setVisible(startVisibility);
		TranslateTransition translateTransition = new TranslateTransition(Duration.millis(1000), getGroup());
		translateTransition.setCycleCount(1);
		translateTransition.setFromY(start);
		translateTransition.setToY(finish);
		translateTransition.setOnFinished(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				setVisible(finishVisibility);
			}
		});
		translateTransition.play();
		translateTransition.setAutoReverse(true);
	}

	public void addActionListener() {
		InputController.addActionZone((int) getX(), (int) getY(), getWidth(), getHeight(), id);

	}

	public void update() {
		if (getImageView() != null && getTextView() != null) {
			if (getImageView().isVisible()) {
				textView.setVisible(true);
			} else if (!getImageView().isVisible()) {
				textView.setVisible(false);
			}
		}
	}

	public int getButtonKey() {
		return buttonKey;
	}

	public void setButtonKey(int buttonKey) {
		this.buttonKey = buttonKey;
	}

	public int getButtonHoverKey() {
		return buttonHoverKey;
	}

	public void setButtonHoverKey(int buttonHoverKey) {
		this.buttonHoverKey = buttonHoverKey;
	}

	public int getState() {
		return state;
	}

	public void swapSubState() {
		if (getType().equals("switch")) {
			if (getSubState() == 0) {
				setSubState(1);
			} else if (getSubState() == 1) {
				setSubState(0);
			}
		}
	}

	public void setState(int state) {
		this.state = state;
		if (getImageView() != null) {

			if (!getType().equals("switch")) {
				if (state == 0) {
					getImageView().setViewport(
							new Rectangle2D(getWidth() * buttonKey, buttonSpriteKey, getWidth(), getHeight()));
				}
				if (state == 1) {
					getImageView().setViewport(
							new Rectangle2D(getWidth() * buttonKey, buttonSpriteKey, getWidth(), getHeight()));
				}
				if (state == 2) {
					getImageView().setViewport(
							new Rectangle2D(getWidth() * buttonHoverKey, buttonSpriteKey, getWidth(), getHeight()));
				}
			} else if (getType().equals("switch")) {
				if (state == 0) {
					getImageView().setViewport(
							new Rectangle2D(getWidth() * buttonKey, buttonSpriteKey + (getSubState() * getHeight()),
									getWidth(), getHeight()));
				}
				if (state == 1) {
					getImageView().setViewport(
							new Rectangle2D(getWidth() * buttonKey, buttonSpriteKey + (getSubState() * getHeight()),
									getWidth(), getHeight()));
				}
				if (state == 2) {
					getImageView().setViewport(
							new Rectangle2D(getWidth() * buttonHoverKey, buttonSpriteKey
									+ (getSubState() * getHeight()), getWidth(), getHeight()));
				}
			}

		}
	}

	public Text getTextView() {
		return textView;
	}

	public void setTextView(Text textView) {
		this.textView = textView;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getButtonSpriteKey() {
		return buttonSpriteKey;
	}

	public void setButtonSpriteKey(int buttonSpriteKey) {
		this.buttonSpriteKey = buttonSpriteKey;
	}

	public int getSubState() {
		return subState;
	}

	public void setSubState(int subState) {
		this.subState = subState;
	}

}
