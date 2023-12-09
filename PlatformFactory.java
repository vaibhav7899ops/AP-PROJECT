package com.example.vaibhavap;

import javafx.scene.shape.Rectangle;

import java.util.Random;

public class PlatformFactory {
    public Rectangle getPivotPlatform(){
        Random random = new Random();
        Rectangle rectangle=new Rectangle();
        double width = random.nextDouble(70,120);
        rectangle.setHeight(250);
        rectangle.setLayoutY(650);
        rectangle.setWidth(width);
        return rectangle;
    }
    public Rectangle getTargetPlatform(Rectangle pivotPlatform){
        Rectangle rectangle = new Rectangle();
        Random random = new Random();
        double gap = random.nextDouble(pivotPlatform.getWidth()+60,450);
        rectangle.setLayoutX(gap);
        double width = random.nextDouble(70,150);
        rectangle.setWidth(width);
        rectangle.setHeight(250);
        rectangle.setLayoutY(650);
        return rectangle;
    }

}
