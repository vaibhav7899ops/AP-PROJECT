package com.example.vaibhavap;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class menuController {
    @FXML
    private Button playScreenSwitcher;
    public void initialize(AnchorPane anchorPane){
        MapController mapController = MapController.getInstance();
        mapController.beginMap(anchorPane);
    }
    public void afterInitialize(){
        Player.rotateStick();
    }
    public void switchToPlayscreen(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene playscene = ((Node) event.getSource()).getScene();
        playscene.setRoot(driver.getPlayRoot());
        playscene.setOnKeyPressed(new KeyBoardControls());
        playscene.setOnKeyReleased(e->{if(e.getCode()== KeyCode.S && !Player.isWalking()){afterInitialize();}});
        stage.setScene(playscene);
        initialize(driver.Playscreen());
        stage.show();
    }
}
