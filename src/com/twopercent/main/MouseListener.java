package com.twopercent.main;

import com.sun.glass.events.MouseEvent;

import javafx.event.EventHandler;
import javafx.scene.Scene;

public class MouseListener extends InputController {

	public MouseListener(Scene scene) {

		scene.setOnMousePressed(new EventHandler<javafx.scene.input.MouseEvent>() {

			public void handle(javafx.scene.input.MouseEvent event) {
				if (event.getX() > 0 && event.getX() < (scene.getWidth() / 2)) {
					onLeft(1);
				}
				if (event.getX() > (scene.getWidth() / 2) && event.getX() < scene.getWidth()) {
					onRight(1);
				}
			}
		});

		scene.setOnMouseReleased(new EventHandler<javafx.scene.input.MouseEvent>() {

			public void handle(javafx.scene.input.MouseEvent event) {
				onLeft(0);
				onRight(0);
			}
		});
	}
}
