//2%
package com.twopercent.main;

import com.valgriz.screen.LoadingScreen;
import com.valgriz.screen.Screen;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {
	// Objects
	public static Scene mainScene, loadingScene;
	private Group root, load;
	private Screen screen;
	public static Stage primaryStage;
	private static LoadingScreen loadingScreen;
	DataManager dataManager;

	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		// Defines startup parameters
		primaryStage.setWidth(720);
		primaryStage.setHeight(480);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Penguin Plunge");

		Global.inMainMenu = true;
		Global.inPlayGame = false;
		Global.inPaused = false;
		Global.inGameOver = false;

		// Sets up loading screen before anything else
		load = new Group();
		loadingScreen = new LoadingScreen(load);
		loadingScene = new Scene(load);
		primaryStage.setScene(loadingScene);
		primaryStage.show();
		// Displays the loading screen

		dataManager = new DataManager();
		dataManager.loadFile();
		// Screen takes care of initializing almost every other memory intensive
		// object in the game
		root = new Group();
		screen = new Screen(root);
		mainScene = new Scene(root);

		// Once graphics have been loaded into RAM, listeners are set up
		KeyboardListener keyboardListener = new KeyboardListener(mainScene);
		MouseListener mouseListener = new MouseListener(mainScene);
		TapListener tapListener = new TapListener(mainScene);

		// Once everything in the game has been loaded, scene switches from
		// loadingScene to mainScene
		primaryStage.setScene(mainScene);

	}

	public Main() {

	}

}
