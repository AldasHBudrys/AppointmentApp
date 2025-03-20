package org.example.myappm.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.myappm.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateAppointmentController implements Initializable {
    public TextField fld_time;
    public TextField fld_masseuse;
    public TextField fld_procedure;
    public TextField fld_description;
    public TextField fld_price;
    public Button create_appointment_btn;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        create_appointment_btn.setOnAction(event -> onCreateAppointment());
    }


    public void onCreateAppointment(){
        String time = fld_time.getText();
        String masseuse = fld_masseuse.getText();
        String procedure = fld_procedure.getText();
        String description = fld_description.getText();
        int price = Integer.parseInt(fld_price.getText());
        Model.getInstance().createAppointment(time, masseuse, procedure, description, price);


        Stage stage = (Stage) create_appointment_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().showAppointmentsWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }


}
