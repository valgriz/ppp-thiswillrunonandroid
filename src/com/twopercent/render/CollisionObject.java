package com.twopercent.render;

import javafx.geometry.Rectangle2D;

public class CollisionObject {

	VisibleObject a, b;

	public CollisionObject() {

	}

	public CollisionObject(VisibleObject a, VisibleObject b) {
		this.a = a;
		this.b = b;
	}

	public boolean checkCollision() {
		if (a != null && b != null) {
			if ((a.getX() + a.getWidth() >= b.getX()) && (a.getX() < b.getX() + b.getWidth())) {
				if ((a.getY() + a.getHeight() > b.getY()) && (a.getY() < b.getY() + b.getHeight())) {

					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}
}
