package com.twopercent.render;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class VisibleObject {
	private Image image;
	private Group group;
	private ImageView imageView;
	private double x, y, dy, dx, dt, scale;
	private int height, width;

	public VisibleObject(Image image, ImageView imageView, Group group) {
		this.image = image;
		this.imageView = imageView;
		this.group = group;
		scale = 1;
	}

	public void updateX() {
		x += dx;
	}

	public void updateY() {
		y += dy;
	}

	public abstract void update();

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getDy() {
		return dy;
	}

	public void setDy(double dy) {
		this.dy = dy;
	}

	public double getDx() {
		return dx;
	}

	public void setDx(double dx) {
		this.dx = dx;
	}

	public double getDt() {
		return dt;
	}

	public void setDt(double dt) {
		this.dt = dt;
	}

	public double getScale() {
		return scale;
	}

	public void setScale(double scale) {
		this.scale = scale;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public ImageView getImageView() {
		return imageView;
	}

	public void setImageView(ImageView imageView) {
		this.imageView = imageView;
	}

}
