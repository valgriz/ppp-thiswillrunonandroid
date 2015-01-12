package com.twopercent.main;

import java.util.ArrayList;

import com.twopercent.render.Bird;
import com.twopercent.render.Button;
import com.twopercent.render.SoundPlayer;
import com.twopercent.render.UI;
import com.twopercent.render.UserInterfaceCreator;
import com.twopercent.render.VisibleObject;
import com.valgriz.screen.MainMenu;
import com.valgriz.screen.PlayGame;

public class InputController {
	public static ArrayList<ActionZone> actionZoneArrayList = new ArrayList<>();

	public InputController() {

	}

	public static void addActionZone(int x, int y, int width, int height, String id) {
		if (actionZoneArrayList != null)
			actionZoneArrayList.add(new ActionZone(x, y, width, height, id));
	}

	public void coordinatePressed(int x, int y) {
		System.out.println("SIZE: " + actionZoneArrayList.size());
		for (int i = 0; i < actionZoneArrayList.size(); i++) {
			if (x > actionZoneArrayList.get(i).getX()
					&& x < actionZoneArrayList.get(i).getX() + actionZoneArrayList.get(i).getWidth()) {
				if (y > actionZoneArrayList.get(i).getY()
						&& y < actionZoneArrayList.get(i).getY() + actionZoneArrayList.get(i).getHeight()) {
					VisibleObject temp = UserInterfaceCreator.getButton(actionZoneArrayList.get(i).getId());
					Button b = (Button) temp;
					if (temp.isVisible()) {
						action(temp);
					}
				}
			}
		}
	}

	public void coordinateReleased() {
		for (int i = 0; i < actionZoneArrayList.size(); i++) {
			VisibleObject temp = UserInterfaceCreator.getButton(actionZoneArrayList.get(i).getId());
			if (temp.isVisible()) {
				endAction(temp);
			}
		}
	}

	public void coordinateMoved(int x, int y) {
		for (int i = 0; i < actionZoneArrayList.size(); i++) {
			if (x > actionZoneArrayList.get(i).getX()
					&& x < actionZoneArrayList.get(i).getX() + actionZoneArrayList.get(i).getWidth()) {
				if (y > actionZoneArrayList.get(i).getY()
						&& y < actionZoneArrayList.get(i).getY() + actionZoneArrayList.get(i).getHeight()) {
					VisibleObject temp = UserInterfaceCreator.getButton(actionZoneArrayList.get(i).getId());
					if (temp.isVisible()) {
						anticipate(temp);
					}
				} else {
					VisibleObject temp = UserInterfaceCreator.getButton(actionZoneArrayList.get(i).getId());
					idle(temp);
				}
			} else {
				VisibleObject temp = UserInterfaceCreator.getButton(actionZoneArrayList.get(i).getId());
				idle(temp);
			}

		}
	}

	public void idle(VisibleObject temp) {
		if (temp.getType().equals("button")) {
			Button b = (Button) temp;
			b.setState(0);
		}
	}

	public void endAction(VisibleObject temp) {
		if (temp.getType().equals("button") || temp.getType().equals("nullButton")) {
			Button b = (Button) temp;
			b.setState(0);
			switch (b.getId()) {
			case "pgLeftTap":
				onLeft(0);
				break;

			case "pgRightTap":
				onRight(0);
				break;

			case "goPlayAgain":

				break;

			case "goMainMenu":
				break;

			case "pgPauseGame":
				break;

			case "gpResume":
				break;

			case "gpEndGame":
				break;
			}
		}
	}

	public void action(VisibleObject temp) {
		if (temp.getType().equals("button") || temp.getType().equals("nullButton")) {
			SoundPlayer.playButton();
			Button b = (Button) temp;
			b.setState(1);
			switch (b.getId()) {
			case "pgLeftTap":
				onLeft(1);
				break;
			case "pgRightTap":
				onRight(1);
				break;

			case "goPlayAgain":
				PlayGame.resetGame();
				break;
			case "goMainMenu":
				Global.inPlayGame = false;
				Global.inPaused = false;
				Global.inGameOver = false;
				Global.inMainMenu = true;
				PlayGame.translateOut();
				MainMenu.goToMainMenu();
				Global.gameStateChanged = true;
				break;
			case "pgPauseGame":
				Global.inPaused = true;
				Global.gameStateChanged = true;
				break;
			case "gpResume":
				Global.inPaused = false;
				Global.gameStateChanged = true;
				break;
			case "gpEndGame":
				Global.inPaused = false;
				Global.inGameOver = true;
				Global.gameStateChanged = true;
				Bird.dontDoIt();
				break;
			case "mmPlay":
				Global.inMainMenu = false;
				Global.inPlayGame = true;
				Global.inPaused = false;
				Global.inGameOver = false;
				Global.gameStateChanged = true;
				PlayGame.resetGame();
				MainMenu.goToPlayGame();
				PlayGame.goToPlayGame();
				break;
			case "mmScores":
				Global.inPaused = false;
				Global.gameStateChanged = true;
				break;
			case "mmStats":
				Global.inPaused = false;
				Global.gameStateChanged = true;
				break;
			case "mmOptions":
				Global.inPaused = false;
				Global.gameStateChanged = true;
				break;
			case "mmHelp":
				Global.inPaused = false;
				Global.gameStateChanged = true;
				break;

			}
		}
	}

	public void anticipate(VisibleObject temp) {
		if (temp.getType().equals("button")) {
			Button b = (Button) temp;
			b.setState(2);
		}
	}

	public void onSelectionAction() {
		// Performing actions

		if (Global.inMainMenu) {
			SoundPlayer.playButton();
			switch (UI.selection) {
			case -5:
				Global.inMainMenu = false;
				Global.inPlayGame = true;
				Global.inPaused = false;
				Global.inGameOver = false;
				Global.gameStateChanged = true;
				PlayGame.resetGame();
				MainMenu.goToPlayGame();
				PlayGame.goToPlayGame();
				break;
			case -4:
				Global.inPaused = false;
				Global.gameStateChanged = true;
				Bird.offLeft();
				Bird.offRight();
				break;
			case -3:
				Global.inPaused = false;
				Global.gameStateChanged = true;
				Bird.offLeft();
				Bird.offRight();
				break;
			case -2:
				Global.inPaused = false;
				Global.gameStateChanged = true;
				Bird.offLeft();
				Bird.offRight();
				break;
			case -1:
				Global.inPaused = false;
				Global.inGameOver = true;
				Global.gameStateChanged = true;
				Bird.dontDoIt();
				break;
			case 0:

				break;
			case 1:
				Global.inMainMenu = false;
				Global.inPlayGame = true;
				Global.inPaused = false;
				Global.inGameOver = false;
				Global.gameStateChanged = true;
				PlayGame.resetGame();
				MainMenu.goToPlayGame();
				PlayGame.goToPlayGame();

				break;
			case 2:
				Global.inPaused = false;
				Global.inGameOver = true;
				Global.gameStateChanged = true;
				Bird.dontDoIt();
				break;
			case 3:
				Global.inPaused = false;
				Global.inGameOver = true;
				Global.gameStateChanged = true;
				Bird.dontDoIt();
				break;
			case 4:
				Global.inPaused = false;
				Global.inGameOver = true;
				Global.gameStateChanged = true;
				Bird.dontDoIt();
				break;
			case 5:
				Global.inPaused = false;
				Global.inGameOver = true;
				Global.gameStateChanged = true;
				Bird.dontDoIt();
				break;
			}
		}

		if (Global.inPlayGame) {
			if (Global.inPaused && !Global.inGameOver) {

			}

			if (Global.inPaused && !Global.inGameOver) {
				SoundPlayer.playButton();
				switch (UI.selection) {
				case -2:
					Global.inPaused = false;
					Global.gameStateChanged = true;
					Bird.offLeft();
					Bird.offRight();
					break;
				case -1:
					Global.inPaused = false;
					Global.inGameOver = true;
					Global.gameStateChanged = true;
					Bird.dontDoIt();
					break;
				case 0:

					break;
				case 1:
					Global.inPaused = false;
					Global.gameStateChanged = true;
					Bird.offLeft();
					Bird.offRight();
					break;
				case 2:
					Global.inPaused = false;
					Global.inGameOver = true;
					Global.gameStateChanged = true;
					Bird.dontDoIt();
					break;

				}
			} else if (!Global.inPaused && Global.inGameOver) {
				SoundPlayer.playButton();
				switch (UI.selection) {
				case -2:
					Global.inPaused = false;
					Global.inGameOver = false;
					PlayGame.resetGame();
					Global.inPlayGame = true;
					Global.gameStateChanged = true;
					Bird.offLeft();
					Bird.offRight();
					break;
				case -1:
					Global.inPlayGame = false;
					Global.inPaused = false;
					Global.inGameOver = false;
					Global.inMainMenu = true;
					Global.gameStateChanged = true;
					PlayGame.translateOut();
					MainMenu.goToMainMenu();
					break;
				case 0:
					break;
				case 1:
					Global.inPaused = false;
					Global.inGameOver = false;
					PlayGame.resetGame();
					Global.inPlayGame = true;
					Global.gameStateChanged = true;
					Bird.offLeft();
					Bird.offRight();
					break;
				case 2:
					Global.inPlayGame = false;
					Global.inPaused = false;
					Global.inGameOver = false;
					Global.inMainMenu = true;
					Global.gameStateChanged = true;
					PlayGame.translateOut();
					MainMenu.goToMainMenu();

					break;
				}
			}
		}

		if (UI.selection != 0) {
			onMiddle();
		}

	}

	public void onMiddle() {
		UI.selection = 0;
		unhighlightAllButtons();
	}

	public void onUp() {
		// For menu use only
		UI.selection -= 1;
		applySelectionChange();
	}

	public void onDown() {
		// For menu use only
		UI.selection += 1;
		applySelectionChange();
	}

	public void unhighlightAllButtons() {
		UI.unhighlightAllButtons();
	}

	public void applySelectionChange() {
		// Highlighting

		if (Global.inMainMenu) {
			if (UI.selection > 5) {
				UI.selection = 1;
			}
			if (UI.selection < -5) {
				UI.selection = -1;
			}
			switch (UI.selection) {
			case -5:
				UI.unhighlightAllButtons();
				UI.highlightButton("mmPlay");
				break;
			case -4:
				UI.unhighlightAllButtons();
				UI.highlightButton("mmScores");
				break;
			case -3:
				UI.unhighlightAllButtons();
				UI.highlightButton("mmStats");
				break;
			case -2:
				UI.unhighlightAllButtons();
				UI.highlightButton("mmOptions");
				break;
			case -1:
				UI.unhighlightAllButtons();
				UI.highlightButton("mmHelp");
				break;
			case 0:
				UI.unhighlightAllButtons();
				break;
			case 1:
				UI.unhighlightAllButtons();
				UI.highlightButton("mmPlay");
				break;
			case 2:
				UI.unhighlightAllButtons();
				UI.highlightButton("mmScores");
				break;
			case 3:
				UI.unhighlightAllButtons();
				UI.highlightButton("mmStats");
				break;
			case 4:
				UI.unhighlightAllButtons();
				UI.highlightButton("mmOptions");
				break;
			case 5:
				UI.unhighlightAllButtons();
				UI.highlightButton("mmHelp");
				break;
			}

		}

		if (Global.inPlayGame) {
			if (UI.getButton("pgChangePenguin").isVisible()) {
				if (UI.selection > 1) {
					UI.selection = 0;
				}
				if (UI.selection < -1) {
					UI.selection = 0;
				}
				switch (UI.selection) {
				case -1:
					UI.unhighlightAllButtons();
					UI.highlightButton("pgChangePenguin");
					break;
				case 0:
					UI.unhighlightAllButtons();
					break;
				case 1:
					UI.unhighlightAllButtons();
					UI.highlightButton("pgChangePenguin");
					break;
				}
			}

			if (!Global.inPaused && !Global.inGameOver) {
				UI.selection = 0;
			}

			if (Global.inPaused && !Global.inGameOver) {
				if (UI.selection > 2) {
					UI.selection = 1;
				}
				if (UI.selection < -2) {
					UI.selection = -1;
				}
				switch (UI.selection) {
				case -2:
					UI.unhighlightAllButtons();
					UI.highlightButton("gpResume");
					break;
				case -1:
					UI.unhighlightAllButtons();
					UI.highlightButton("gpEndGame");
					break;
				case 0:
					UI.unhighlightAllButtons();
					break;
				case 1:
					UI.unhighlightAllButtons();
					UI.highlightButton("gpResume");
					break;
				case 2:
					UI.unhighlightAllButtons();
					UI.highlightButton("gpEndGame");
					break;

				}
			}

			if (!Global.inPaused && Global.inGameOver) {
				if (UI.selection > 2) {
					UI.selection = 1;
				}
				if (UI.selection < -2) {
					UI.selection = -1;
				}
				switch (UI.selection) {
				case -2:
					UI.unhighlightAllButtons();
					UI.highlightButton("goPlayAgain");
					break;
				case -1:
					UI.unhighlightAllButtons();
					UI.highlightButton("goMainMenu");
					break;
				case 0:
					UI.unhighlightAllButtons();
					break;
				case 1:
					UI.unhighlightAllButtons();
					UI.highlightButton("goPlayAgain");
					break;
				case 2:
					UI.unhighlightAllButtons();
					UI.highlightButton("goMainMenu");
					break;
				}
			}
		}

	}

	public void onLeft(int state) {
		if (Global.inPlayGame && !Global.inGameOver && !Global.inPaused) {
			if (state == 0) {
				Bird.offLeft();
			} else if (state == 1) {
				Bird.onLeft();
			}
		}
	}

	public void onRight(int state) {
		if (Global.inPlayGame && !Global.inGameOver && !Global.inPaused) {
			if (state == 0) {
				Bird.offRight();
			} else if (state == 1) {
				Bird.onRight();
			}
		}
	}

	public void onEscape(int state) {
		if (state == 0) {

		} else if (state == 1) {
			if (Global.inPlayGame && !Global.inPaused && !Global.inGameOver) {
				Global.inPaused = true;
				Global.gameStateChanged = true;
			} else if (Global.inPlayGame && Global.inPaused && !Global.inGameOver) {
				Global.inPaused = false;
				Global.gameStateChanged = true;
			}
		}
		unhighlightAllButtons();
	}
}