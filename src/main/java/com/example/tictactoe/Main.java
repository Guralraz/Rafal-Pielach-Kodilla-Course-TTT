package com.example.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("controllermenu.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Image icon = new Image(getClass().getResourceAsStream("TTT_Project_icon.png"));
            stage.getIcons().add(icon);
            stage.setTitle("TicTacToe");
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}