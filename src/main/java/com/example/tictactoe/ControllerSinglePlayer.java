package com.example.tictactoe;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.*;

public class ControllerSinglePlayer implements Initializable {
    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button reset;

    @FXML
    private CheckBox levelCb;

    private int turn;

    ArrayList<Button> buttonsList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonsList = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));

        buttonsList.forEach(button -> {
            button.setFocusTraversable(false);
            button.setStyle("-fx-background-color: skyblue");
        });

        Random randomGenerator = new Random();
        turn = randomGenerator.nextInt(2);
    }

    @FXML
    public void onButton1Click() {
        if (turn == 0) {
            button1.setText("X");
            button1.setStyle("-fx-background-color: black");
            turn = 1;
            System.out.println("X move");
        } else {
            button1.setText("O");
            button1.setStyle("-fx-background-color: white");
            turn = 0;
            System.out.println("O move");
        }
        button1.setDisable(true);
        buttonsList.remove(button1);
        checkVictoryCondition();
    }

    @FXML
    public void onButton2Click() {
        if (turn == 0) {
            button2.setText("X");
            button2.setStyle("-fx-background-color: black");
            turn = 1;
            System.out.println("X move");
        } else {
            button2.setText("O");
            button2.setStyle("-fx-background-color: white");
            turn = 0;
            System.out.println("O move");
        }
        button2.setDisable(true);
        buttonsList.remove(button2);
        checkVictoryCondition();
    }

    @FXML
    public void onButton3Click() {
        if (turn == 0) {
            button3.setText("X");
            button3.setStyle("-fx-background-color: black");
            turn = 1;
            System.out.println("X move");
        } else {
            button3.setText("O");
            button3.setStyle("-fx-background-color: white");
            turn = 0;
            System.out.println("O move");
        }
        button3.setDisable(true);
        buttonsList.remove(button3);
        checkVictoryCondition();
    }

    @FXML
    public void onButton4Click() {
        if (turn == 0) {
            button4.setText("X");
            button4.setStyle("-fx-background-color: black");
            turn = 1;
            System.out.println("X move");
        } else {
            button4.setText("O");
            button4.setStyle("-fx-background-color: white");
            turn = 0;
            System.out.println("O move");
        }
        button4.setDisable(true);
        buttonsList.remove(button4);
        checkVictoryCondition();
    }

    @FXML
    public void onButton5Click() {
        if (turn == 0) {
            button5.setText("X");
            button5.setStyle("-fx-background-color: black");
            turn = 1;
            System.out.println("X move");
        } else {
            button5.setText("O");
            button5.setStyle("-fx-background-color: white");
            turn = 0;
            System.out.println("O move");
        }
        button5.setDisable(true);
        buttonsList.remove(button5);
        checkVictoryCondition();
    }

    @FXML
    public void onButton6Click() {
        if (turn == 0) {
            button6.setText("X");
            button6.setStyle("-fx-background-color: black");
            turn = 1;
            System.out.println("X move");
        } else {
            button6.setText("O");
            button6.setStyle("-fx-background-color: white");
            turn = 0;
            System.out.println("O move");
        }
        button6.setDisable(true);
        buttonsList.remove(button6);
        checkVictoryCondition();
    }

    @FXML
    public void onButton7Click() {
        if (turn == 0) {
            button7.setText("X");
            button7.setStyle("-fx-background-color: black");
            turn = 1;
            System.out.println("X move");
        } else {
            button7.setText("O");
            button7.setStyle("-fx-background-color: white");
            turn = 0;
            System.out.println("O move");
        }
        button7.setDisable(true);
        buttonsList.remove(button7);
        checkVictoryCondition();
    }

    @FXML
    public void onButton8Click() {
        if (turn == 0) {
            button8.setText("X");
            button8.setStyle("-fx-background-color: black");
            turn = 1;
            System.out.println("X move");
        } else {
            button8.setText("O");
            button8.setStyle("-fx-background-color: white");
            turn = 0;
            System.out.println("O move");
        }
        button8.setDisable(true);
        buttonsList.remove(button8);
        checkVictoryCondition();
    }

    @FXML
    public void onButton9Click() {
        if (turn == 0) {
            button9.setText("X");
            button9.setStyle("-fx-background-color: black");
            turn = 1;
            System.out.println("X move");
        } else {
            button9.setText("O");
            button9.setStyle("-fx-background-color: white");
            turn = 0;
            System.out.println("O move");
        }
        button9.setDisable(true);
        buttonsList.remove(button9);
        checkVictoryCondition();
    }

    public void checkVictoryCondition() {
        if ((button1.getText() == "X" && button2.getText() == "X" && button3.getText() == "X") ||
                (button4.getText() == "X" && button5.getText() == "X" && button6.getText() == "X") ||
                (button7.getText() == "X" && button8.getText() == "X" && button9.getText() == "X") ||
                (button1.getText() == "X" && button5.getText() == "X" && button9.getText() == "X") ||
                (button2.getText() == "X" && button5.getText() == "X" && button8.getText() == "X") ||
                (button3.getText() == "X" && button5.getText() == "X" && button7.getText() == "X") ||
                (button1.getText() == "X" && button4.getText() == "X" && button7.getText() == "X") ||
                (button3.getText() == "X" && button6.getText() == "X" && button9.getText() == "X")) {
            buttonsList.forEach(button -> button.setDisable(true));
            System.out.println("Player X won");
        } else if ((button1.getText() == "O" && button2.getText() == "O" && button3.getText() == "O") ||
                (button4.getText() == "O" && button5.getText() == "O" && button6.getText() == "O") ||
                (button7.getText() == "O" && button8.getText() == "O" && button9.getText() == "O") ||
                (button1.getText() == "O" && button5.getText() == "O" && button9.getText() == "O") ||
                (button2.getText() == "O" && button5.getText() == "O" && button8.getText() == "O") ||
                (button3.getText() == "O" && button5.getText() == "O" && button7.getText() == "O") ||
                (button1.getText() == "O" && button4.getText() == "O" && button7.getText() == "O") ||
                (button3.getText() == "O" && button6.getText() == "O" && button9.getText() == "O")) {
            System.out.println("Player O won");
            buttonsList.forEach(button -> button.setDisable(true));
        }
    }

    public void onResetButtonClick() {
        button1.setText("");
        button1.setDisable(false);
        button1.setStyle("-fx-background-color: skyblue");
        button2.setText("");
        button2.setDisable(false);
        button2.setStyle("-fx-background-color: skyblue");
        button3.setText("");
        button3.setDisable(false);
        button3.setStyle("-fx-background-color: skyblue");
        button4.setText("");
        button4.setDisable(false);
        button4.setStyle("-fx-background-color: skyblue");
        button5.setText("");
        button5.setDisable(false);
        button5.setStyle("-fx-background-color: skyblue");
        button6.setText("");
        button6.setDisable(false);
        button6.setStyle("-fx-background-color: skyblue");
        button7.setText("");
        button7.setDisable(false);
        button7.setStyle("-fx-background-color: skyblue");
        button8.setText("");
        button8.setDisable(false);
        button8.setStyle("-fx-background-color: skyblue");
        button9.setText("");
        button9.setDisable(false);
        button9.setStyle("-fx-background-color: skyblue");
    }

}