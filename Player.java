package com.example.vaibhavap;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import java.util.ArrayList;

public class Player {
    private static ScoreKeeper scoreKeeper= new ScoreKeeper();
    static private int intializeCount=0;
    static MapController mapController=MapController.getInstance();

    public static ImageView getPlayer() {
        return player;
    }

    private static ImageView player = new ImageView();

    public static int getCurrScore() {
        return currScore;
    }


    public static void setCurrScore(int currScore) {
        Player.currScore = currScore;
    }

    private static int currScore=0;
    private static final Line myBridge = new Line();

    public static void setCherrycount(int cherrycount) {
        Player.cherrycount = cherrycount;
    }

    private static int cherrycount=0;
    public static int getCherrycount() {
        return cherrycount;
    }
    private static boolean isDown =false;
    private static boolean isWalking=false;
    static private double imageHeight=30;
    static private double imageWidth=30;
    public static void  loadPlayerImage(AnchorPane anchorPane){
        if(isDown) isDown=false;
        if(isWalking) isWalking=false;
        if(intializeCount==0){
            scoreKeeper.addElements(anchorPane);
            intializeCount++;
        }
        double x_coord=7;
        double y_cord=650-imageHeight;
        Image characterImage = new Image("file:charImage.png");
        player.setLayoutX(x_coord);player.setLayoutY(y_cord);
        player.setFitHeight(imageHeight);player.setFitWidth(imageWidth);
        player.setImage(characterImage);
        anchorPane.getChildren().add(player);
    }
    public static void makeBridge(AnchorPane anchorPane){
        double startX = mapController.getFirstPlatform().getWidth();
        double startY = 650;
        myBridge.setStartX(startX);
        myBridge.setStartY(startY);
        myBridge.setEndX(startX);
        myBridge.setEndY(startY);
        myBridge.setStroke(Color.RED);
        myBridge.setStrokeWidth(5);
        anchorPane.getChildren().add(myBridge);
    }
    public static void enlargeStick(){
        myBridge.setEndY(myBridge.getEndY()-7);
    }
    public static void rotateStick(){
        if(isWalking){return;}
        isWalking=true;
        Timeline timeline = new Timeline();
        double length = myBridge.getStartY()-myBridge.getEndY();
        KeyValue endXvalue = new KeyValue(myBridge.endXProperty(),myBridge.getStartX()+length);
        KeyValue endYvalue = new KeyValue(myBridge.endYProperty(),650);
        KeyFrame keyframe = new KeyFrame(Duration.seconds(0.5),endXvalue,endYvalue);
        timeline.getKeyFrames().add(keyframe);
        timeline.setOnFinished(event -> {Player.walk(driver.Playscreen());});
        timeline.play();
    }
    public static void fall(AnchorPane anchorPane){

        KeyValue fall = new KeyValue(player.layoutYProperty(),650);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5),fall);
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.setOnFinished(event -> {anchorPane.getChildren().remove(player);
            anchorPane.getChildren().remove(myBridge);
            mapController.closemap(anchorPane);
            EndPopUp endLabel = new EndPopUp();
            endLabel.addEndPopUp(anchorPane);});
        timeline.play();
    }
    public static void moveAhead(boolean b,AnchorPane anchorPane){
        isWalking=true;
        if(b){
            KeyValue walk = new KeyValue(player.layoutXProperty(),myBridge.getEndX());
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(2),walk);
            KeyFrame checkForCherry = new KeyFrame(Duration.millis(100),event -> {
                mapController.getCherry(anchorPane);
            });
            Timeline cherryChecker = new Timeline();
            cherryChecker.getKeyFrames().add(checkForCherry);
            cherryChecker.setCycleCount(Animation.INDEFINITE);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(keyFrame);
            cherryChecker.play();
            timeline.setOnFinished(event -> {
                if(isDown){
                    anchorPane.getChildren().remove(player);
                    anchorPane.getChildren().remove(myBridge);
                    Player.isDown=false;
                    mapController.closemap(anchorPane);
                    EndPopUp endPopUp = new EndPopUp();
                    endPopUp.addEndPopUp(anchorPane);
                }else {
                    mapController.furtherMap(anchorPane);
                }
                cherryChecker.stop();
            });
            timeline.play();
        }
        else{
            anchorPane.getChildren().remove(myBridge);
            KeyValue walk = new KeyValue(player.layoutXProperty(),7);
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(2),walk);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(keyFrame);
            timeline.setOnFinished(event -> {
                scoreKeeper.updateScoreCount();
                scoreKeeper.updateCherryCount();
                makeBridge(anchorPane);
            isWalking=false;});
            timeline.play();
        }
    }
    public static void walk(AnchorPane anchorPane){
        ArrayList<Double> lengthBounds = new ArrayList<>();
        lengthBounds.add(mapController.getSecondPlatform().getLayoutX() -5-mapController.getFirstPlatform().getWidth());
        lengthBounds.add(lengthBounds.get(0)+mapController.getSecondPlatform().getWidth());
        double stickLength=-myBridge.getStartX()+myBridge.getEndX();
        if(lengthBounds.get(0)<=stickLength && lengthBounds.get(1)>= stickLength){
            moveAhead(true,anchorPane);
            currScore++;
        }
        else{
            isWalking=true;
            KeyValue walk = new KeyValue(player.layoutXProperty(),myBridge.getEndX());
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(2),walk);
            Timeline timeline = new Timeline();
            timeline.getKeyFrames().add(keyFrame);
            timeline.setOnFinished(event -> {fall(anchorPane);});
            timeline.play();
        }
    }
    public static void invertPLayer(){
        if(!(isWalking)){
            return;
        }
        isDown =true;
        double new_ycord=650;
        player.setLayoutY(new_ycord);
        player.setImage(new Image("file:charImgdown.png"));
    }
    public static void upRightPLayer(){
        if(!(isWalking)){
            return;
        }
        isDown =false;
        double new_ycord=650-imageHeight;
        player.setLayoutY(new_ycord);
        player.setImage(new Image("file:charImage.png"));
    }
    public static void removeAll(AnchorPane anchorPane){
        try{
            anchorPane.getChildren().remove(player);
            anchorPane.getChildren().remove(myBridge);
            mapController.closemap(anchorPane);
        }
        catch(Exception ignored){

        }
    }
    public static boolean isDown() {
        return isDown;
    }
    public static boolean isWalking(){return isWalking;}

    public static ScoreKeeper getScoreKeeper() {
        return scoreKeeper;
    }
}
