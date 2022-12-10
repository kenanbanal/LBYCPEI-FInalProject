package com.example.opencsvdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {
    private static Scene scene;
    private static Stage thisStage;
    @Override
    public void start(Stage stage) throws IOException {
        thisStage=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("login-view.fxml"));
        scene = new Scene(fxmlLoader.load(), 500, 300);
        stage.setTitle("Login-In");
        stage.setScene(scene);
        stage.show();
    }
    public void changeScene(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxml));
        thisStage.getScene().setRoot(fxmlLoader.load());
    }
    public Scene getScene(){
        return scene;
    }

    public static void main(String[] args) {
        launch();
    }
}