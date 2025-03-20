package org.example.myappm.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Appointment {
    private IntegerProperty id;
    private StringProperty time;
    private StringProperty masseuse;
    private StringProperty procedure;
    private StringProperty description;
    private IntegerProperty price;


    public Appointment (int id, String time, String masseuse, String procedure, int price, String description){
        this.id = new SimpleIntegerProperty(id);
        this.time = new SimpleStringProperty(time);
        this.masseuse = new SimpleStringProperty(masseuse);
        this.procedure = new SimpleStringProperty(procedure);
        this.price = new SimpleIntegerProperty(price);
        this.description = new SimpleStringProperty(description);

    }

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getTime() {
        return time.get();
    }

    public StringProperty timeProperty() {
        return time;
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public String getMasseuse() {
        return masseuse.get();
    }

    public StringProperty masseuseProperty() {
        return masseuse;
    }

    public void setMasseuse(String masseuse) {
        this.masseuse.set(masseuse);
    }


    public String getProcedure() {
        return procedure.get();
    }

    public StringProperty procedureProperty() {
        return procedure;
    }

    public void setProcedure(String procedure) {
        this.procedure.set(procedure);
    }


    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }


    public int getPrice() {
        return price.get();
    }

    public IntegerProperty priceProperty() {
        return price;
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

}
