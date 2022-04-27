package com.example.dz_from_lection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        Scene scene = new Scene(group, 1080, 720);
        stage.setScene(scene);
        stage.setTitle("ДЗ из лекции");
        stage.show();
        Buttons button1 = new Buttons(100,40, "Нажми1");
        button1.SetNewX(100);
        button1.SetNewY(100);
        group.getChildren().add(button1);
        Buttons button2 = new Buttons(100,40,"Нажми 2");
        button2.SetNewX(500);
        button2.SetNewY(500);
        group.getChildren().add(button2);
        button1.setBrother(button2);
        button2.setBrother(button1);
        Text text1=new Text("0.0");
        text1.setX(600);
        text1.setY(600);
        button1.SetField(text1);
        button2.SetField(text1);
        group.getChildren().add(text1);





    }

    public static void main(String[] args) {
        launch();
    }
}