package com.example.opencsvdemo;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.io.IOException;

public class LoginController {

    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    @FXML
    private Label prompt;

    @FXML
    private void handleLogin(ActionEvent event) throws IOException {
        MainApplication loginApp = new MainApplication();
        if (username.getText().toString().equals("STUDENT") && password.getText().toString().equals("student")) {
            prompt.setText("Login SUCCESS! Student Access Granted ...");
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e -> {
                try { //TODO MAKE FXML FOR STUDENT
                    loginApp.changeScene("Thesis-Database.fxml");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            pause.play();
        } else if (username.getText().toString().equals("ADMIN") && password.getText().toString().equals("admin")) {
            prompt.setText("Login SUCCESS! Admin Access Granted ...");
            prompt.setTextFill(Color.rgb(21, 117, 84));
            PauseTransition pause = new PauseTransition(Duration.seconds(1));
            pause.setOnFinished(e -> {
                try { //TODO MAKE FXML FOR ADMIN
                    loginApp.changeScene("Thesis-Database.fxml");
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            });
            pause.play();
        } else if (username.getText().isEmpty() || password.getText().isEmpty()) {
            prompt.setText("Enter your username & password!");
            prompt.setTextFill(Color.rgb(210, 39, 30));
        } else {
            prompt.setText("Wrong Username or Password!");
            prompt.setTextFill(Color.rgb(210, 39, 30));
        }
    }
    @FXML //platform
    private void onExit(ActionEvent e) {
        Platform.exit();
    }
}