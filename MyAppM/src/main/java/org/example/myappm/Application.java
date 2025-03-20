package org.example.myappm;

import javafx.stage.Stage;
import org.example.myappm.Models.Model;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) {
        Model.getInstance().getViewFactory().showLoginWindow();
    }

    public static void main(String[] args) {
        launch();
    }
}
