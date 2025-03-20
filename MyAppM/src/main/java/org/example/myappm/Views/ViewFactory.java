package org.example.myappm.Views;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.myappm.Controllers.RouteController;


public class ViewFactory {
    private final ObjectProperty<MenuItems> userSelectedMenuItem;
    private AnchorPane dashboard;

    public ViewFactory(){
        this.userSelectedMenuItem = new SimpleObjectProperty<>();
    }


    public ObjectProperty<MenuItems> getUserSelectedMenuItem(){
        return userSelectedMenuItem;
    }




    public AnchorPane getDashboardView(){
        if(dashboard == null){
            try {
                dashboard = new FXMLLoader(getClass().getResource("/Fxml/Dashboard.fxml")).load();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return dashboard;
    }


    public void showLoginWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));
        createStage(loader);
    }


    public void showRegisterWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Register.fxml"));
        createStage(loader);
    }


    public void showMainWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Main.fxml"));
        RouteController controller = new RouteController();
        loader.setController(controller);
        createStage(loader);

    }

    public void showFinanceWindow(){

    }

    public void showAppointmentsWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Appointments.fxml"));
        createStage(loader);
    }

    public void showCreateAppointmentWindow(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/CreateAppointment.fxml"));
        createStage(loader);
    }


    public void createStage(FXMLLoader loader){
        Scene scene = null;
        try{
            scene = new Scene(loader.load());
        }catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("The Good App");
        stage.show();
    }


    public void closeStage(Stage stage){
        stage.close();
    }
}
