package org.example.myappm.Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class DatabaseDriver {

    private Connection connection;


    private static final Logger logger = Logger.getLogger(DatabaseDriver.class.getName());


    public DatabaseDriver(){
        try{
            this.connection = DriverManager.getConnection("jdbc:sqlite:AppDB.db");
        }catch (SQLException e){
            logger.severe("Cannot connect to DB: " + e.getMessage());
        }
    }


    public Connection getConnection(){
        return connection;
    }

    public void closeConnection(){
        try{
            if(connection !=null && !connection.isClosed()){
                //Closing connection if it's not already closed
                connection.close();
            }
        }catch (SQLException e){
            logger.severe("Error closing database connection: " + e.getMessage());
        }
    }

}
