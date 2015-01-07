package com.twopercent.main;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class KeyboardListener extends InputController {

	public KeyboardListener(Scene scene) {

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) {
					onLeft(1);
				}
				if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) {
					onRight(1);
				}
				if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W) {
					onUp();
				}
				if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S) {
					onDown();
				}
				if (event.getCode() == KeyCode.ESCAPE) {
					onEscape(1);
				}
				if (event.getCode() == KeyCode.ENTER || event.getCode() == KeyCode.SPACE) {
					onSelectionAction();
				}
			}
		});

		scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				if (event.getCode() == KeyCode.LEFT || event.getCode() == KeyCode.A) {
					onLeft(0);
				}
				if (event.getCode() == KeyCode.RIGHT || event.getCode() == KeyCode.D) {
					onRight(0);
				}
				if (event.getCode() == KeyCode.UP || event.getCode() == KeyCode.W) {
				}
				if (event.getCode() == KeyCode.DOWN || event.getCode() == KeyCode.S) {
				}
				if (event.getCode() == KeyCode.ESCAPE) {

				}
			}
		});
	}

}
