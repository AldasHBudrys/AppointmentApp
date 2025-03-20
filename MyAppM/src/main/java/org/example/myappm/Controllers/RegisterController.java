package org.example.myappm.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.myappm.Models.Model;
import org.example.myappm.Utils.AlertUtility;
import org.example.myappm.Utils.UserUtility;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    public TextField user_name_field;
    public PasswordField password_field;
    public PasswordField repeat_password_field;
    public Button register_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        register_btn.setOnAction(actionEvent -> onRegister());
    }


    public void onRegister() {

        Stage stage = (Stage) register_btn.getScene().getWindow();

        if (user_name_field.getText().trim().isEmpty() || password_field.getText().trim().isEmpty()) {
            AlertUtility.displayError("Missing information. Try again");
        } else{
            if (!UserUtility.doPasswordsMatch(password_field.getText(), repeat_password_field.getText())) {
                AlertUtility.displayError("The passwords do not match. Try again");
            } else {
                Model.getInstance().createUser(user_name_field.getText(), password_field.getText());

                AlertUtility.displayInformation("New user registered successfully");

                Model.getInstance().getViewFactory().showLoginWindow();

                Model.getInstance().getViewFactory().closeStage(stage);

            }
        }

    }
}
