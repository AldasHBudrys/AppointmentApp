package org.example.myappm.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.myappm.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    public Button logout_btn;
    public Text current_user_text;
    public Button finance_btn;
    public Button appointments_btn;
    public Button dashboard_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        current_user_text.setText(Model.getInstance().getLoggedUserName());

        addListeners();
    }

    private void addListeners() {
        logout_btn.setOnAction(event -> onLogout());

        appointments_btn.setOnAction(event -> onAppointments());
        dashboard_btn.setOnAction(event ->onDashboard());
    }

    public void onLogout(){

        Stage stage = (Stage) logout_btn.getScene().getWindow();

        Model.getInstance().getViewFactory().closeStage(stage);

        Model.getInstance().getViewFactory().showLoginWindow();

        Model.getInstance().setLoginSuccessFlag(false);
    }

    public void onFinance(){
        Stage stage = (Stage) finance_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().showMainWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }

    public void onAppointments(){
        Stage stage = (Stage) appointments_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().showAppointmentsWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }


    public void onDashboard(){
        Stage stage = (Stage) dashboard_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().showMainWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }

}


