package org.example.myappm.Models;

import javafx.collections.ObservableList;
import org.example.myappm.DAO.AppointmentsDAO;
import org.example.myappm.DAO.UserDAO;
import org.example.myappm.Views.ViewFactory;

import java.time.LocalDate;

public class Model {

    private static Model model;
    private final ViewFactory viewFactory;
    public final UserDAO userDAO;
    private boolean loginSuccessFlag;
    private User currentUser;
    public final AppointmentsDAO appointmentsDAO;

    private Model() {
        this.viewFactory = new ViewFactory();
        this.userDAO = new UserDAO(new DatabaseDriver().getConnection());
        this.appointmentsDAO = new AppointmentsDAO(new DatabaseDriver().getConnection());
    }

    //@return instance of Model class

    public static synchronized Model getInstance() {
        if (model == null) {
            model = new Model();
        }

        return model;
    }

    //@return ViewFactory instance

    public ViewFactory getViewFactory() {
        return viewFactory;
    }


    public boolean getLoginSuccessFlag() {
        return loginSuccessFlag;
    }

    public void setLoginSuccessFlag(boolean flag) {
        this.loginSuccessFlag = flag;
    }


    public void createUser(String userName, String password) {
        userDAO.createUser(userName, password, LocalDate.now());
    }

    public void checkCredentials(String userName, String password) {
        User user = userDAO.findUserByCredentials(userName, password);
        if (user != null) {
            this.loginSuccessFlag = true;
            this.currentUser = user;
        }
    }

    public String getLoggedUserName(){
        return currentUser != null ? currentUser.userNameProperty(): null;
    }

    public void createAppointment(String time, String masseuse, String procedure, String description, int price){
        appointmentsDAO.create(time, masseuse, procedure, description, price);
    }

    public ObservableList<Appointment> getAppointments(){
        return appointmentsDAO.findAll();
    }

    public void deleteAppointment(int id){
        appointmentsDAO.delete(id);
    }
}
