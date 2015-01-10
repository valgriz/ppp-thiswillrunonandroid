
package com.twopercent.render;

import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
        
public class SoundPlayer {
    private static Media bounce = new Media(SoundPlayer.class.getResource("/res/sounds/BounceEffect.mp3").toString());
    private static Media button = new Media(SoundPlayer.class.getResource("/res/sounds/ButtonSound.mp3").toString());
    private static AudioClip bounce2 = new AudioClip(SoundPlayer.class.getResource("/res/sounds/BounceEffect2.wav").toString());
    
    public static void playBounce(){
        new MediaPlayer(bounce).play();
    }

    public static void playButton(){
        new MediaPlayer(button).play();
    }
    
    public static void playBounce2(){
        bounce2.play();
    }

}
