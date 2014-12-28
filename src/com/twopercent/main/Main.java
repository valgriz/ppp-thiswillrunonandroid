//2%
package com.twopercent.main;

import com.valgriz.screen.Screen;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Main extends Application {
	// Objects
	private Scene mainScene;
	private Group root;
	private Screen screen;

	public static void main(String args[]) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Defines startup parameters
		primaryStage.setWidth(720);
		primaryStage.setHeight(480);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Flappy Jump - 2%");

		// Initializes base case
		root = new Group();
		screen = new Screen(root);
		mainScene = new Scene(root);

		// Shows Stage & Scene
		primaryStage.setScene(mainScene);
		primaryStage.show();
	}

	public Main() {

	}

}
