package com.example.tictactoe;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.Label;

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

    public void setTurnInfo() {
        if (turn == 0) {
            textField.setText("Player X's turn");
        } else {
            textField.setText("Player O's turn");
        }
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
        setTurnInfo();
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
        setTurnInfo();
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
        setTurnInfo();
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
        setTurnInfo();
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
        setTurnInfo();
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
        setTurnInfo();
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
        setTurnInfo();
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
        setTurnInfo();
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
        for (Button button : buttonsList) {
            buttonsList.remove(button);
        }
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