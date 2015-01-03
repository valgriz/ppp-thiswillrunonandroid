package com.twopercent.main;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.TouchEvent;

public class TapListener extends InputController {

	public TapListener(Scene scene) {

		scene.setOnTouchPressed(new EventHandler<TouchEvent>() {

			public void handle(TouchEvent event) {
				if (event.getTouchPoint().getX() > 0 && event.getTouchPoint().getX() < (scene.getWidth() / 2)) {
					onLeft(1);
				}
				if (event.getTouchPoint().getX() > (scene.getWidth() / 2)
						&& event.getTouchPoint().getX() < scene.getWidth()) {
					onRight(1);
				}
			}
		});

		scene.setOnTouchMoved(new EventHandler<TouchEvent>() {

			public void handle(TouchEvent event) {
				onLeft(0);
				onRight(0);
			}
		});
	}
}
