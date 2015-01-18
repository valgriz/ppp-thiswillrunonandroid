package com.twopercent.render;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundPlayer {

	private static Media bounce = new Media(SoundPlayer.class.getResource("/res/sounds/BounceEffect.mp3").toString());
	private static Media button = new Media(SoundPlayer.class.getResource("/res/sounds/ButtonSound.mp3").toString());
	private static Media fallingPlatform = new Media(SoundPlayer.class.getResource("/res/sounds/FallingPlatform.mp3")
			.toString());
	private static Media starSound = new Media(SoundPlayer.class.getResource("/res/sounds/StarSound.mp3").toString());
	private static double volume = 1.0;

	// private static Media

	public static void playBounce() {
		MediaPlayer bouncePlay = new MediaPlayer(bounce);
		bouncePlay.setVolume(volume);
		bouncePlay.play();
	}

	public static void playButton() {
		MediaPlayer buttonPlay = new MediaPlayer(button);
		buttonPlay.setVolume(volume / 10);
		buttonPlay.play();
	}

	public static void playFallingPlatform() {
		MediaPlayer fallingPlat = new MediaPlayer(fallingPlatform);
		fallingPlat.setVolume(volume / 10);
		fallingPlat.play();
	}

	public static void playStarSound() {
		MediaPlayer starPlayer = new MediaPlayer(starSound);
		starPlayer.setVolume(volume / 20);
		starPlayer.play();
	}

	public static void volumeControl(int i) {
		if (i == 0) {
			unmute();
		} else {
			mute();
		}
	}

	public static void mute() {
		volume = 0;
	}

	public static void unmute() {
		volume = 1;
	}

}
