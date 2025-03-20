package org.example.myappm.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.myappm.Models.Model;
import org.example.myappm.Utils.AlertUtility;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    @FXML
    public TextField user_name_field;
    @FXML
    public PasswordField password_field;
    @FXML
    public Hyperlink register_link;
    @FXML
    public Button login_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        register_link.setOnAction(actionEvent -> onRegister());
        login_btn.setOnAction(actionEvent -> onLogin());
    }


    public void onLogin(){
        Stage stage = (Stage) register_link.getScene().getWindow();

        Model.getInstance().checkCredentials(user_name_field.getText(),password_field.getText());

        if(Model.getInstance().getLoginSuccessFlag()){
            Model.getInstance().getViewFactory().showMainWindow();
            Model.getInstance().getViewFactory().closeStage(stage);
        }else{
            user_name_field.setText("");
            password_field.setText("");
            AlertUtility.displayError("Incorrect username or password");
        }

    }


    public void onRegister(){
        Stage stage = (Stage) register_link.getScene().getWindow();
        Model.getInstance().getViewFactory().showRegisterWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }


}
