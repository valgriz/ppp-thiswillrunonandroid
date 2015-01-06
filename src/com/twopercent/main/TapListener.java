package com.twopercent.main;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.TouchEvent;

public class TapListener extends InputController {

	public TapListener(Scene scene) {

		scene.setOnTouchPressed(new EventHandler<TouchEvent>() {

			public void handle(TouchEvent event) {
				coordinatePressed((int) event.getTouchPoint().getX(), (int) event.getTouchPoint().getY());
			}
		});

		scene.setOnTouchReleased((new EventHandler<TouchEvent>() {

			@Override
			public void handle(TouchEvent event) {
				coordinateReleased();

			}
		}));

	}
}
