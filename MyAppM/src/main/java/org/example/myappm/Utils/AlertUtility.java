package org.example.myappm.Utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class AlertUtility {

    public static void displayInformation(String content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText(content);
        alert.setHeaderText(null);
        alert.showAndWait();
    }


    public static void displayError(String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(content);
        alert.setHeaderText(null);
        alert.showAndWait();
    }


    public static boolean displayConfirmation(String question){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(question);
        alert.setHeaderText(null);
        alert.showAndWait();
        return alert.getResult() == ButtonType.OK;
    }
}
