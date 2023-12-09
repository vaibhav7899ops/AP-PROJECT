package com.example.vaibhavap;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Random;

public class MapController {
    private static MapController instance;
    private Rectangle firstPlatform;
    private ImageView cherryHolder=new ImageView();
    private Rectangle secondPlatform;
    private double distance=-1;
    static int count=0;

    private MapController() {
        this.firstPlatform = (new PlatformFactory()).getPivotPlatform();
        this.secondPlatform=(new PlatformFactory()).getTargetPlatform(firstPlatform);
    }

    public static MapController getInstance(){
        if(instance == null){
            instance = new MapController();
        }
        return instance;
    }
    public void calculateDistance(){
        distance=this.getSecondPlatform().getLayoutX()-5+this.getFirstPlatform().getWidth();
    }
    public void beginMap(AnchorPane anchorPane){
        if(count != 0) {count =0;}
        firstPlatform=(new PlatformFactory()).getPivotPlatform();
        secondPlatform=(new PlatformFactory()).getTargetPlatform(firstPlatform);
        anchorPane.getChildren().add(firstPlatform);anchorPane.getChildren().add(secondPlatform);
        Player.loadPlayerImage(anchorPane);
        Player.makeBridge(anchorPane);
    }
    private void removePlatform(AnchorPane anchorPane){
        if(count%2 == 0){
            anchorPane.getChildren().remove(firstPlatform);
        }
        else{
            anchorPane.getChildren().remove(secondPlatform);
        }
    }
    private void addPlatform(AnchorPane anchorPane){
        PlatformFactory platformFactory = new PlatformFactory();
        if (count%2 == 0){
            firstPlatform = platformFactory.getTargetPlatform(secondPlatform);
            anchorPane.getChildren().add(firstPlatform);
        }
        else{
            secondPlatform = platformFactory.getTargetPlatform(firstPlatform);
            anchorPane.getChildren().add(secondPlatform);
        }
    }
    public void furtherMap(AnchorPane anchorPane) {
        removeCherry(anchorPane);
        removePlatform(anchorPane);
        Rectangle movingRectangle = (count % 2 == 0) ? secondPlatform : firstPlatform;
        KeyValue keyValue = new KeyValue(movingRectangle.layoutXProperty(), 5);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), keyValue);
        Timeline timeline = new Timeline(keyFrame);
        timeline.setOnFinished(event -> {
            addPlatform(anchorPane);
            count++;
            addCherry(anchorPane);
        });
        timeline.play();
        Player.moveAhead(false,anchorPane);
    }



    public Rectangle getFirstPlatform() {
        if(count%2 == 0){
            return firstPlatform;
        }
        return secondPlatform;
    }

    public Rectangle getSecondPlatform()
    {if(count%2 == 0){
        return secondPlatform;
    }
        return firstPlatform;
    }
    public void addCherry(AnchorPane anchorPane){
        calculateDistance();
        if(distance > 70){
            Random random = new Random();
            int choice = random.nextInt(2);
            if(true){
                double x_cord = 5+getFirstPlatform().getWidth()+ getSecondPlatform().getLayoutX();
                cherryHolder.setLayoutX(x_cord/2);
                cherryHolder.setLayoutY(655);
                cherryHolder.setFitHeight(35);cherryHolder.setPreserveRatio(true);
                cherryHolder.setImage(new Image("file:cherry.png"));
                anchorPane.getChildren().add(cherryHolder);
            }
            else{
                System.out.println("Bye");
            }
        }
    }
    private void removeCherry(AnchorPane anchorPane) {
        try{
            anchorPane.getChildren().remove(cherryHolder);
        }
        catch (Exception ignored){

        }
    }
    public void getCherry(AnchorPane anchorPane){
        double characterX = Player.getPlayer().getLayoutX();
        double decidingDistance = characterX-cherryHolder.getLayoutX();
        if(decidingDistance >-10 && decidingDistance <10 && Player.isDown()){
            removeCherry(anchorPane);
            Player.setCherrycount(Player.getCherrycount()+1);
        }
    }
    public void closemap(AnchorPane anchorPane){
        try{
            anchorPane.getChildren().remove(firstPlatform);
            anchorPane.getChildren().remove(secondPlatform);
            removeCherry(anchorPane);
        }
        catch (Exception ignored){
        }
    }
}
