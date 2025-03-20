module org.example.myappm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens org.example.myappm to javafx.fxml;
    exports org.example.myappm;
    exports org.example.myappm.Controllers;
    exports org.example.myappm.Models;
    exports org.example.myappm.Views;


}
