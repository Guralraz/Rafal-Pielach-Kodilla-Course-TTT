package com.example.tictactoe;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class ControllerMultiPlayer implements Initializable {

    @FXML
    private Label textField;

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
    private Button menu;

    private int turn;

    ArrayList<Button> buttonsList;

    private boolean xWon = false;

    private boolean oWon = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonsList = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));
        buttonsList.forEach(button -> {
            button.setFocusTraversable(false);
            button.setStyle("-fx-background-color: skyblue");
        });
        textField.setStyle("-fx-progress-color: red");
        assignTurn();
        setTurnInfo();
    }

    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("controllermenu.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void setTurnInfo() {
        if (turn == 0) {
            textField.setText("Player X's turn");
        } else {
            textField.setText("Player O's turn");
        }
    }

    @FXML
    public void onButtonClick(Event event) {
        Button clickedButton = (Button) event.getSource();
        if (turn == 0) {
            clickedButton.setText("X");
            clickedButton.setStyle("-fx-background-color: black");
            turn = 1;
            System.out.println("X move");
        } else {
            clickedButton.setText("O");
            clickedButton.setStyle("-fx-background-color: white");
            turn = 0;
            System.out.println("O move");
        }
        clickedButton.setDisable(true);
        buttonsList.remove(clickedButton);
        setTurnInfo();
        checkVictoryCondition();
    }

    public void checkVictoryCondition() {
        if ((button1.getText().equals("X") && button2.getText().equals("X") && button3.getText().equals("X")) ||
                (button4.getText().equals("X") && button5.getText().equals("X") && button6.getText().equals("X")) ||
                (button7.getText().equals("X") && button8.getText().equals("X") && button9.getText().equals("X")) ||
                (button1.getText().equals("X") && button5.getText().equals("X") && button9.getText().equals("X")) ||
                (button2.getText().equals("X") && button5.getText().equals("X") && button8.getText().equals("X")) ||
                (button3.getText().equals("X") && button5.getText().equals("X") && button7.getText().equals("X")) ||
                (button1.getText().equals("X") && button4.getText().equals("X") && button7.getText().equals("X")) ||
                (button3.getText().equals("X") && button6.getText().equals("X") && button9.getText().equals("X"))) {
            buttonsList.forEach(button -> button.setDisable(true));
            xWon = true;
            textField.setText("Player X won!");
            System.out.println("Player X won");
        } else if ((button1.getText().equals("O") && button2.getText().equals("O") && button3.getText().equals("O")) ||
                (button4.getText().equals("O") && button5.getText().equals("O") && button6.getText().equals("O")) ||
                (button7.getText().equals("O") && button8.getText().equals("O") && button9.getText().equals("O")) ||
                (button1.getText().equals("O") && button5.getText().equals("O") && button9.getText().equals("O")) ||
                (button2.getText().equals("O") && button5.getText().equals("O") && button8.getText().equals("O")) ||
                (button3.getText().equals("O") && button5.getText().equals("O") && button7.getText().equals("O")) ||
                (button1.getText().equals("O") && button4.getText().equals("O") && button7.getText().equals("O")) ||
                (button3.getText().equals("O") && button6.getText().equals("O") && button9.getText().equals("O"))) {
            buttonsList.forEach(button -> button.setDisable(true));
            oWon = true;
            textField.setText("Player O won!");
            System.out.println("Player O won");
        } else if (button1.isDisabled() && button2.isDisabled() && button3.isDisabled() &&
                button4.isDisabled() && button5.isDisabled() && button6.isDisabled() &&
                button7.isDisabled() && button8.isDisabled() && button9.isDisabled() &&
                !xWon && !oWon) {
            textField.setText("Tie!");
            System.out.println("Tie");
        }
    }

    public void onResetButtonClick() {
        try {
            assignTurn();
            setTurnInfo();
            clearList();
            populateList();
            buttonsList.forEach(button -> {
                button.setText("");
                button.setDisable(false);
                button.setStyle("-fx-background-color: skyblue");
            });
        } catch(Exception e){
            System.out.println(e);
        }
    }

    public void clearList() {
        buttonsList.clear();
    }

    public void populateList() {
        buttonsList.add(button1);
        buttonsList.add(button2);
        buttonsList.add(button3);
        buttonsList.add(button4);
        buttonsList.add(button5);
        buttonsList.add(button6);
        buttonsList.add(button7);
        buttonsList.add(button8);
        buttonsList.add(button9);
    }

    public void assignTurn() {
        Random randomGenerator = new Random();
        turn = randomGenerator.nextInt(2);
    }

}