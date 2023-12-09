package com.example.vaibhavap;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class EndPopUp {
    private Rectangle base;
    private Label messageLabel;
    private Label yesLabel;
    private Label noLabel;
    private Button yesButton;
    private Button noButton;
    public void setLabel(){
        base =new Rectangle();
        base.setLayoutX(145);
        base.setLayoutY(290);
        base.setFill(Color.rgb(96,196,191));
        base.setWidth(410);
        base.setHeight(265);
        base.setArcHeight(150);
        base.setArcWidth(150);
        messageLabel=new Label();
        messageLabel.setText("          Press yes for revive");
        messageLabel.setFont(javafx.scene.text.Font.font("System", 30));
        messageLabel.setTextFill(Color.WHITE);
        messageLabel.setPrefWidth(400);
        messageLabel.setPrefHeight(65);
        messageLabel.setLayoutX(145);
        messageLabel.setLayoutY(350);
        yesLabel=new Label("Yes");
        yesLabel.setFont(javafx.scene.text.Font.font("System", 20));
        yesLabel.setTextFill(Color.WHITE);
        yesLabel.setPrefWidth(50);
        yesLabel.setPrefHeight(25);
        yesLabel.setLayoutX(215);
        yesLabel.setLayoutY(490);
        noLabel = new Label("No");
        noLabel.setFont(javafx.scene.text.Font.font("System", 20));
        noLabel.setTextFill(Color.WHITE);
        noLabel.setPrefWidth(50);
        noLabel.setPrefHeight(25);
        noLabel.setLayoutX(495);
        noLabel.setLayoutY(490);
        yesButton=new Button();
        yesButton.setOpacity(0.33);
        yesButton.setPrefWidth(50);
        yesButton.setPrefHeight(25);
        yesButton.setLayoutX(210);
        yesButton.setLayoutY(490);
        noButton=new Button();
        noButton.setOpacity(0.33);
        noButton.setPrefWidth(50);
        noButton.setPrefHeight(25);
        noButton.setLayoutX(495);
        noButton.setLayoutY(490);
    }
    public void removeEndPopUp(AnchorPane anchorPane){
        try {
            anchorPane.getChildren().remove(base);
            anchorPane.getChildren().remove(messageLabel);
            anchorPane.getChildren().remove(yesLabel);
            anchorPane.getChildren().remove(noLabel);
            anchorPane.getChildren().remove(yesButton);
            anchorPane.getChildren().remove(noButton);
        }
        catch (Exception e){

        }
    }
    public void reviveFunctionality(AnchorPane anchorPane){
        if(Player.getCherrycount()<2){
            Player.setCurrScore(0);
            System.out.println(Player.getCurrScore());
            Player.getScoreKeeper().updateScoreCount();
        }
        else{
            Player.setCherrycount(Player.getCherrycount()-2);
            Player.getScoreKeeper().updateCherryCount();
        }
        MapController.getInstance().beginMap(anchorPane);
    }
    public void addEndPopUp(AnchorPane anchorPane){
        setLabel();
        anchorPane.getChildren().add(base);
        anchorPane.getChildren().add(messageLabel);
        anchorPane.getChildren().add(yesLabel);
        anchorPane.getChildren().add(noLabel);
        anchorPane.getChildren().add(yesButton);
        yesButton.setOnAction(event -> {
            removeEndPopUp(anchorPane);
            reviveFunctionality(anchorPane);
            });
        anchorPane.getChildren().add(noButton);
        noButton.setOnAction(event -> {
            removeEndPopUp(anchorPane);
            Player.setCherrycount(0);
            Player.setCurrScore(0);
            Player.getScoreKeeper().updateCherryCount();
            Player.getScoreKeeper().updateScoreCount();
            (MapController.getInstance()).beginMap(anchorPane);
        });
    }


}

