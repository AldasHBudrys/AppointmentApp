package org.example.myappm.Controllers;

import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.example.myappm.Models.Appointment;
import org.example.myappm.Models.Model;

import java.net.URL;
import java.util.ResourceBundle;

public class AppointmentsController implements Initializable {
    public Button add_appointment_btn;
    public TableView appointments_table;
    public TableColumn col_masseuse;
    public TableColumn col_procedure;
    public TableColumn col_description;
    public TableColumn col_price;
    public TableColumn col_Id;
    public TableColumn col_time;
    public MenuItem remove_appointment;
    public TextField filterMasseuse;
    public TextField filterProcedure;
    public Button filterButton;
    public Button return_btn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        return_btn.setOnAction(event -> onReturn());
        add_appointment_btn.setOnAction(event -> onAddAppointment());
        initTableColumns();
        loadAppointmentData();
    }

    public void onReturn(){
        Stage stage = (Stage) return_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().showMainWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }

    public void onAddAppointment(){
        Stage stage = (Stage) add_appointment_btn.getScene().getWindow();
        Model.getInstance().getViewFactory().showCreateAppointmentWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
    }

    private void initTableColumns(){
        col_Id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_time.setCellValueFactory(new PropertyValueFactory<>("time"));
        col_masseuse.setCellValueFactory(new PropertyValueFactory<>("masseuse"));
        col_procedure.setCellValueFactory(new PropertyValueFactory<>("procedure"));
        col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
    }

    private void loadAppointmentData(){
        ObservableList<Appointment> appointments = Model.getInstance().getAppointments();
        appointments_table.setItems(appointments);
    }

}
