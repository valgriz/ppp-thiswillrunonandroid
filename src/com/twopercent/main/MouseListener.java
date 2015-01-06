package com.twopercent.main;

import com.sun.glass.events.MouseEvent;

import javafx.event.EventHandler;
import javafx.scene.Scene;

public class MouseListener extends InputController {

	public MouseListener(Scene scene) {

		scene.setOnMousePressed(new EventHandler<javafx.scene.input.MouseEvent>() {

			public void handle(javafx.scene.input.MouseEvent event) {
				coordinatePressed((int) event.getX(), (int) event.getY());
			}
		});

		scene.setOnMouseReleased(new EventHandler<javafx.scene.input.MouseEvent>() {

			public void handle(javafx.scene.input.MouseEvent event) {

				coordinateReleased();
			}
		});

		scene.setOnMouseMoved(new EventHandler<javafx.scene.input.MouseEvent>() {

			public void handle(javafx.scene.input.MouseEvent event) {
				coordinateMoved((int) event.getX(), (int) event.getY());
			}
		});
	}
}
