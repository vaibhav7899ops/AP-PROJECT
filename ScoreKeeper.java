package com.example.vaibhavap;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class ScoreKeeper {
    private Rectangle scoreBar = new Rectangle();
    private Label scoreNameLabel=new Label();
    private Label scoreValue = new Label();
    private ImageView cherryDisplay=new ImageView();
    private Label cherryCount=new Label();
    public void Initialize(){
        scoreBar.setWidth(372);
        scoreBar.setHeight(37);
        scoreBar.setLayoutX(164);
        scoreBar.setLayoutY(0);
        scoreBar.setFill(Color.web("#99a9b9"));

        // Initialize Score Name Label
        scoreNameLabel.setText("Score");
        scoreNameLabel.setLayoutX(190);
        scoreNameLabel.setLayoutY(8);
        scoreNameLabel.setPrefWidth(40);
        scoreNameLabel.setPrefHeight(20);

        // Initialize Score Value Label
        scoreValue.setText("0");
        scoreValue.setLayoutX(233);
        scoreValue.setLayoutY(8);
        scoreValue.setPrefWidth(9);
        scoreValue.setPrefHeight(21);

        // Initialize Cherry ImageView
        Image cherryImage = new Image("file:cherry.png"); // Replace with the actual path
        cherryDisplay.setImage(cherryImage);
        cherryDisplay.setFitWidth(21);
        cherryDisplay.setFitHeight(24);
        cherryDisplay.setLayoutX(423);
        cherryDisplay.setLayoutY(8);
        //Cherry Count Label
        cherryCount.setText("0");
        cherryCount.setLayoutX(456);
        cherryCount.setLayoutY(8);
        cherryCount.setPrefWidth(9);
        cherryCount.setPrefHeight(21);
    }
    ScoreKeeper(){
        Initialize();
    }
    public void addElements(AnchorPane anchorPane){
        anchorPane.getChildren().add(scoreBar);
        anchorPane.getChildren().add(scoreNameLabel);
        anchorPane.getChildren().add(scoreValue);
        anchorPane.getChildren().add(cherryDisplay);
        anchorPane.getChildren().add(cherryCount);
    }
    public void updateCherryCount(){
        cherryCount.setText(String.valueOf(Player.getCherrycount()));
    }
    public void updateScoreCount(){
        scoreValue.setText(String.valueOf(Player.getCurrScore()));
    }
}
