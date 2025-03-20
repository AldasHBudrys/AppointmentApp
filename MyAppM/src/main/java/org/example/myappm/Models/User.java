package org.example.myappm.Models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {
    private int id;
    private StringProperty userName;


    public User(int id, String userName){
        this.id = id;
        this.userName = new SimpleStringProperty(userName);
    }


    public String userNameProperty(){
        return userName.get();
    }


    public int getId(){
        return id;
    }
}
