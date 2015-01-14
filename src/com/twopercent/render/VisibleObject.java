package com.twopercent.render;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class VisibleObject extends CollisionObject {
	private Image image;
	private Group group;
	protected ImageView imageView;
	private double x, y, dy, dx, dt, scale, gravity;
	private int height, width, frame;
	private boolean visible;
	private String type;

	public VisibleObject() {

	}

	public VisibleObject(Group group) {
		this.group = group;

	}

	public VisibleObject(Image image, ImageView imageView, Group group) {
		this.image = image;
		this.imageView = imageView;
		this.group = group;
		scale = 1;
	}

	public void setImageViewToImage(Image image) {
		this.image = image;
		if (imageView == null) {
			imageView = new ImageView(image);
		} else if (imageView != null) {
			imageView.setImage(image);
		}
                
	}

	public void updateX() {
		x += dx;
	}

	public void updateY() {
		y += dy;
	}

	public void syncCoords() {
		imageView.setX(x);
		imageView.setY(y);
	}

	public abstract void update();

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
		if (imageView != null) {
			imageView.setVisible(visible);
		}
	}

	public void setVerticalGravity(double y, double dy, double dt, double gravity) {
		this.y = y;
		this.dy = dy;
		this.dt = dt;
		this.gravity = gravity;
	}

	public void useVerticalGravity() {
		dy += (gravity * dt);
		y += (dy * dt);
	}

	public void verticalBounce() {
		dy = -dy;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public int getFitAspectHeight(int fitWidth) {
		return (int) ((fitWidth * height) / (width));
	}

	public int getFitAspectWidth(int fitHeight) {
		return (int) ((fitHeight * width) / (height));
	}

	public double getAspectRatio() {
		return (width / height);
	}

	public void setFitScale(int fitWidth, int fitHeight) {
		imageView.setFitWidth(fitWidth);
		imageView.setFitHeight(fitHeight);
	}

	public void setScale(double scale) {
		this.scale = scale;
		imageView.setScaleX(scale);
		imageView.setScaleY(scale);
		// Not Recommended to Use
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setHeightToImageDefault() {
		this.height = (int) image.getHeight();
		System.out.println("IM_HEIGHT " + height);
		// Possibly Not Recommended to Use
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setWidthToImageDefault() {
		this.width = (int) image.getWidth();
		System.out.println("IM_WIDTH " + width);
		// Possibly Not Recommended to Use
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

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	public double getGravity() {
		return gravity;
	}

	public void setGravity(double gravity) {
		this.gravity = gravity;
	}

}
