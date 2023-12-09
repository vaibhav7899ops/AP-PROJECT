package com.example.vaibhavap;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class driver extends Application {
    static Parent menuRoot;

    static {
        try {
            menuRoot = new FXMLLoader(driver.class.getResource("menuScreen.fxml")).load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    static Parent playRoot;

    static {
        try {
            playRoot = new FXMLLoader(driver.class.getResource("playScreen.fxml")).load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static Parent getMenuRoot() {
        return menuRoot;
    }

    public static Parent getPlayRoot() {
        return playRoot;
    }
    public static AnchorPane Playscreen(){
        Parent root = getPlayRoot();
        return (AnchorPane) root;
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(driver.class.getResource("menuScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}