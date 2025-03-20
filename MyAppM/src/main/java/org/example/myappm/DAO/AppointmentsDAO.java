package org.example.myappm.DAO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.example.myappm.Models.Appointment;

import java.sql.*;
import java.util.logging.Logger;

public class AppointmentsDAO implements GenericDAO {

    private Connection connection;

    private static final Logger logger = Logger.getLogger(AppointmentsDAO.class.getName());

    public AppointmentsDAO(Connection connection){
        this.connection = connection;
    }

    @Override
    public Object findById(int id) {
        return null;
    }

    @Override
    public void create(String time, String masseuse, String procedure, String description, int price) {
        String sql = "INSERT INTO appointments(time, masseuse, procedure, description, price) VALUES(?, ?, ?, ?, ?)";

        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setString(1, time);
            stmt.setString(2, masseuse);
            stmt.setString(3, procedure);
            stmt.setString(4, description);
            stmt.setInt(5, price);
            stmt.executeUpdate();
            logger.info("Appointment created successfully");
        }catch (SQLException e){
            logger.severe("Error creating appointment: " + e.getMessage());
        }
    }

    @Override
    public void update(Object entity) {
        if(!(entity instanceof Appointment)){
            throw new IllegalArgumentException("Excepted Appointment object");
        }

        Appointment appointment = (Appointment) entity;

        String sql = "UPDATE appointments SET time = ?, masseuse = ?, procedure = ?,price = ?, description = ? WHERE id = ?";
        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setString(1, appointment.getTime());
            stmt.setString(2, appointment.getMasseuse());
            stmt.setString(3, appointment.getProcedure());
            stmt.setString(4, appointment.getDescription());
            stmt.setInt(5, appointment.getPrice());
            stmt.setInt(5, appointment.getId());

            int rowsUpdated = stmt.executeUpdate();

            if(rowsUpdated > 0){
                logger.info("Appointment updated: " + appointment);
            }else{
                logger.warning("No appointment found with id: " + appointment.getId());
            }
        }catch (SQLException e){
            logger.severe("Error updating appointment: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM appointments WHERE id = ?";
        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0){
                logger.info("Appointment with ID " + id + " wes deleted successfully");
            }else{
                logger.warning("No appointment found with ID " + id);
            }
        }catch(SQLException e){
            logger.severe("Error deleting appointment with  ID: " + id + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public ObservableList<Appointment> findAll() {
        ObservableList<Appointment> appointments = FXCollections.observableArrayList();
        String sql = "SELECT id, Time, Masseuse, Procedure, Price, Description FROM appointments";

        try(PreparedStatement stmt = this.connection.prepareStatement(sql)){
            ResultSet resultSet = stmt.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String time = resultSet.getString("Time");
                String masseuse = resultSet.getString("Masseuse");
                String procedure = resultSet.getString("Procedure");
                int price = resultSet.getInt("Price");
                String description = resultSet.getString("Description");
                Appointment appointment = new Appointment(id, time, masseuse, procedure, price, description);
                appointments.add(appointment);
            }
        }catch (SQLException e){
            logger.severe("Error fetching appointments: " + e.getMessage());
        }

        return appointments;
    }
}
