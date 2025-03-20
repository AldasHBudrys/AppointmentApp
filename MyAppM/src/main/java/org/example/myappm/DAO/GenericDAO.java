package org.example.myappm.DAO;

import java.util.List;


public interface GenericDAO<T> {

    T findById(int id);

    void create(String time, String masseuse, String procedure, String description, int price);

    void update(T entity);

    void delete(int id);

    List<T> findAll();

}
