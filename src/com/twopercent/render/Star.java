
package com.twopercent.render;

import static javafx.animation.Animation.INDEFINITE;
import javafx.animation.FadeTransition;
import static javafx.animation.Interpolator.LINEAR;
import javafx.animation.RotateTransition;
import javafx.animation.StrokeTransition;
import javafx.scene.Group;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class Star extends VisibleObject{
    
    private RotateTransition rotateTransition;
    private RotateTransition endTransition;
    private FadeTransition fadeTransition;
    
    private boolean oscillating, shooting;
    
    public boolean gone = false;

    
    public Star(int dx, Group group){
        super(group);
        
        setImageViewToImage(new Image(Star.class.getResource("/res/images/star.png").toString()));
        setWidth(35);
        setHeight(35);

        getGroup().getChildren().add(getImageView());

        if(Math.random()>.5){
            setX(800);
            setY(Math.random() * 150 + 50);
            setDx(-4);
            oscillating = true;
        }
        
        else{
            setX(250 + 800 * Math.random());
            setY(-50);
            setDx(-6);
            setDy(5);
            super.imageView.setEffect(new Glow(.3));
            shooting = true;
        }
        
        syncCoords();
        
        endTransition = new RotateTransition(Duration.millis(500), getImageView());
        endTransition.setByAngle(1080);
        
        fadeTransition = new FadeTransition(Duration.millis(500), getImageView());
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0);
        
        rotateTransition = new RotateTransition(Duration.millis(3000),getImageView());
        rotateTransition.setByAngle(360);
        rotateTransition.setCycleCount(INDEFINITE);
        rotateTransition.setInterpolator(LINEAR);
        rotateTransition.play();
    }
    
    public void update(){
        
        setDt(getDt()+6);
        
        if(getX()<0){
            gone();
        }
        
        if(oscillating){
            setDy(4*Math.sin(getDt()*Math.PI/180));
        }
        
        if(shooting){
            //setDy(7);
            //super.imageView.setEffect(new Glow(.3));
        }
        
        updateX();
        updateY();
        
        syncCoords();
    }
    
    public void removeStar(){
        super.imageView.setEffect(new Glow(0.8));
        SoundPlayer.playStarSound();
        endTransition.play();
        fadeTransition.play();
        fadeTransition.setOnFinished(e->{
            getGroup().getChildren().remove(getImageView());
        });
        //getGroup().getChildren().remove(getImageView());
    }
    
    
    public void gone(){
        getGroup().getChildren().remove(getImageView());
        gone = true;
    }
}
