package com.example.vaibhavap;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;

public class KeyBoardControls implements EventHandler<KeyEvent> {
    @Override
    public void handle(KeyEvent event) {
        if (event.getCode()==KeyCode.S){
            if(Player.isWalking()){
                return;
            }
            Player.enlargeStick();
        }
        if(event.getCode()==KeyCode.D){
            Player.invertPLayer();
        }
        if(event.getCode()==KeyCode.U){
            Player.upRightPLayer();
        }
    }
}
