package com.twopercent.main;

import com.twopercent.render.Bird;

public class InputController {

	public InputController() {

	}

	public void onLeft(int state) {
		if (Global.inPlayGame) {
			if (state == 0) {
				Bird.offLeft();
			} else if (state == 1) {
				Bird.onLeft();
			}
		}
	}

	public void onRight(int state) {
		if (Global.inPlayGame) {
			if (state == 0) {
				Bird.offRight();
			} else if (state == 1) {
				Bird.onRight();
			}
		}

	}

	public void onZero(int state) {

	}

	public void onOne(int state) {

	}

	public void onTwo(int state) {

	}

	public void onThree(int state) {

	}

	public void onFour(int state) {

	}

}
