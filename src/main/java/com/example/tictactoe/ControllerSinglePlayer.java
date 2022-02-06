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
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ControllerSinglePlayer implements Initializable {

    @FXML
    private Label textField, highScoreLabel;

    @FXML
    private Button button1, button2, button3, button4, button5, button6, button7, button8, button9, playButton, reset, menu;

    @FXML
    private RadioButton playerBegins, AIBegins, easyMode, hardMode;

    private boolean AITurn;

    private int turn;

    private int initialTurn;

    private int condition;

    private ArrayList<Button> buttonsList;

    private ArrayList<Integer> scoreList;

    private boolean victoryCondition = false;

    private boolean xWon = false;

    private boolean oWon = false;

    private boolean startTimer = true;

    private long timerStart, timerStop, totalPlayTime;

    private String highScore;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonsList = new ArrayList<>(Arrays.asList(button1, button2, button3, button4, button5, button6, button7, button8, button9));
        buttonsList.forEach(button -> {
            button.setFocusTraversable(false);
            button.setStyle("-fx-background-color: skyblue");
        });
        playButton.setDisable(true);
        scoreList = new ArrayList<>();
        textField.setStyle("-fx-progress-color: red");
        assignTurn();
        setTurnInfo();
        loadScore();
    }

    public void switchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("controllermenu.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onButtonClick(Event event) {
        Button clickedButton = (Button) event.getSource();
        if (startTimer) {
            timerStart();
            startTimer = false;
        }
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
        disableButtonAndRadioButtonOptions();
        buttonsList.remove(clickedButton);
        setTurnInfo();
        System.out.println("Initial turn value: " + initialTurn);
        System.out.println("Turn value: " + turn);
        checkAndActOnVictoryCondition();
        if (!victoryCondition) {
            checkWhoseTurn();
            AIMove();
        }
    }

    public void timerStart() {
        timerStart = System.currentTimeMillis();
    }

    public void timerStop() {
        timerStop = System.currentTimeMillis();
    }

    public void totalPlayTime() {
        totalPlayTime = timerStop - timerStart;
        System.out.println("Won in " + totalPlayTime + "ms");
    }

    public void checkAndActOnVictoryCondition() {
        if (checkVictoryCondition() == 1) {
            timerStop();
            buttonsList.forEach(button -> button.setDisable(true));
            xWon = true;
            textField.setText("Player X won!");
            System.out.println("Player X won");
            victoryCondition = true;
            if ((initialTurn == 0 && playerBegins.isSelected()) || (initialTurn == 1 && AIBegins.isSelected())) {
                totalPlayTime();
                saveHighestScore();
            }
        } else if (checkVictoryCondition() == 2) {
            timerStop();
            buttonsList.forEach(button -> button.setDisable(true));
            oWon = true;
            textField.setText("Player O won!");
            System.out.println("Player O won");
            victoryCondition = true;
            if ((initialTurn == 1 && playerBegins.isSelected()) || (initialTurn == 0 && AIBegins.isSelected())) {
                totalPlayTime();
                saveHighestScore();
            }
        } else if (checkVictoryCondition() == 3) {
            timerStop();
            textField.setText("Tie!");
            System.out.println("Tie");
            victoryCondition = true;
        }
    }

    public int checkVictoryCondition() {
        if ((button1.getText().equals("X") && button2.getText().equals("X") && button3.getText().equals("X")) ||
                (button4.getText().equals("X") && button5.getText().equals("X") && button6.getText().equals("X")) ||
                (button7.getText().equals("X") && button8.getText().equals("X") && button9.getText().equals("X")) ||
                (button1.getText().equals("X") && button5.getText().equals("X") && button9.getText().equals("X")) ||
                (button2.getText().equals("X") && button5.getText().equals("X") && button8.getText().equals("X")) ||
                (button3.getText().equals("X") && button5.getText().equals("X") && button7.getText().equals("X")) ||
                (button1.getText().equals("X") && button4.getText().equals("X") && button7.getText().equals("X")) ||
                (button3.getText().equals("X") && button6.getText().equals("X") && button9.getText().equals("X"))) {
            condition = 1;
        } else if ((button1.getText().equals("O") && button2.getText().equals("O") && button3.getText().equals("O")) ||
                (button4.getText().equals("O") && button5.getText().equals("O") && button6.getText().equals("O")) ||
                (button7.getText().equals("O") && button8.getText().equals("O") && button9.getText().equals("O")) ||
                (button1.getText().equals("O") && button5.getText().equals("O") && button9.getText().equals("O")) ||
                (button2.getText().equals("O") && button5.getText().equals("O") && button8.getText().equals("O")) ||
                (button3.getText().equals("O") && button5.getText().equals("O") && button7.getText().equals("O")) ||
                (button1.getText().equals("O") && button4.getText().equals("O") && button7.getText().equals("O")) ||
                (button3.getText().equals("O") && button6.getText().equals("O") && button9.getText().equals("O"))) {
            condition = 2;
        } else if (button1.isDisabled() && button2.isDisabled() && button3.isDisabled() &&
                button4.isDisabled() && button5.isDisabled() && button6.isDisabled() &&
                button7.isDisabled() && button8.isDisabled() && button9.isDisabled() &&
                !xWon && !oWon) {
            condition = 3;
        }
        return condition;
    }

    public void collectScore() {
        scoreList.add((int) totalPlayTime);
        Collections.sort(scoreList);
    }

    public void saveHighestScore() {
        collectScore();
        Path file = Paths.get("e:/output.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(file)) {
            writer.write(String.valueOf(scoreList.get(0)));
            System.out.println(scoreList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadScore() {
        Path file = Paths.get("e://output.txt");
        try {
            Scanner scoreScanner = new Scanner(file);
            highScore = scoreScanner.nextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        highScoreLabel.setText(highScore + " ms");
    }

    public void onResetButtonClick() {
        loadScore();
        try {
            condition = 4;
            startTimer = true;
            timerStart = 0;
            timerStop = 0;
            totalPlayTime = 0;
            victoryCondition = false;
            xWon = false;
            oWon = false;
            assignTurn();
            setTurnInfo();
            clearList();
            populateList();
            buttonsList.forEach(button -> {
                button.setText("");
                button.setDisable(false);
                button.setStyle("-fx-background-color: skyblue");
            });
            enableButtonAndRadioButtonOptions();
            setWhoBegins();
            if (playerBegins.isSelected()) {
                playButton.setDisable(true);
            } else if (AIBegins.isSelected()) {
                playButton.setDisable(false);
                buttonsList.forEach(button -> button.setDisable(true));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setTurnInfo() {
        if (turn == 0) {
            textField.setText("Player X's turn");
        } else {
            textField.setText("Player O's turn");
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
        initialTurn = turn;
    }

    public void AIMove() {
        if (AITurn) {
            Random randomGenerator = new Random();
            int buttonIndexNo = randomGenerator.nextInt(buttonsList.size());
            buttonsList.get(buttonIndexNo).fire();
        }
    }

    public void AIMoveHard() {

    }

    public void checkWhoseTurn() {
        if (!AITurn) {
            AITurn = true;
        } else {
            AITurn = false;
        }
    }

    public void setWhoBegins() {
        if (playerBegins.isSelected()) {
            AITurn = false;
            System.out.println(AITurn);
        } else if (AIBegins.isSelected()) {
            AITurn = true;
            System.out.println(AITurn);
        }
    }

    public void onPlayButtonClick() {
        if (!victoryCondition) {
            buttonsList.forEach(button -> button.setDisable(false));
            if (AIBegins.isSelected()) {
                if (easyMode.isSelected()) {
                    AIMove();
                } else if (hardMode.isSelected()) {
                    AIMoveHard();
                }
            }
        }
    }

    private void disableButtonAndRadioButtonOptions() {
        playerBegins.setDisable(true);
        AIBegins.setDisable(true);
        easyMode.setDisable(true);
        hardMode.setDisable(true);
        playButton.setDisable(true);
    }

    private void enableButtonAndRadioButtonOptions() {
        playerBegins.setDisable(false);
        AIBegins.setDisable(false);
        easyMode.setDisable(false);
        hardMode.setDisable(false);
        playButton.setDisable(false);
    }

    public void onAIBeginsSelection() {
        playButton.setDisable(false);
        buttonsList.forEach(button -> button.setDisable(true));
        AITurn = true;
    }

    public void onPlayerBeginsSelection() {
        playButton.setDisable(true);
    }

}