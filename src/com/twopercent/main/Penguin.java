package com.twopercent.main;

import java.io.Serializable;

public class Penguin implements Serializable {
	private int penguinNumber, starsRequired;
	private boolean unlocked;
	private String name;

	public Penguin(int penguinNumber, int starsRequired, boolean unlocked, String name) {
		this.penguinNumber = penguinNumber;
		this.starsRequired = starsRequired;
		this.unlocked = unlocked;
		this.name = name;
	}

	public int getPenguinNumber() {
		return penguinNumber;
	}

	public void setPenguinNumber(int penguinNumber) {
		this.penguinNumber = penguinNumber;
	}

	public int getStarsRequired() {
		return starsRequired;
	}

	public void setStarsRequired(int starsRequired) {
		this.starsRequired = starsRequired;
	}

	public boolean isUnlocked() {
		return unlocked;
	}

	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
