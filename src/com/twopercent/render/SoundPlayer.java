
package com.twopercent.render;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
        
public class SoundPlayer {
    private static Media bounce = new Media(SoundPlayer.class.getResource("/res/sounds/BounceEffect.mp3").toString());
    private static Media button = new Media(SoundPlayer.class.getResource("/res/sounds/ButtonSound.mp3").toString());
    private static Media fallingPlatform = new Media(SoundPlayer.class.getResource("/res/sounds/FallingPlatform.mp3").toString());
   // private static Media 
    
    public static void playBounce(){
        new MediaPlayer(bounce).play();
    }

    public static void playButton(){
        MediaPlayer buttonPlay = new MediaPlayer(button);
        buttonPlay.setVolume(0.2); buttonPlay.play();
    }
    
    public static void playFallingPlatform(){
        MediaPlayer fallingPlat = new MediaPlayer(fallingPlatform);
        fallingPlat.setVolume(0.1); fallingPlat.play();
    }
    
}
