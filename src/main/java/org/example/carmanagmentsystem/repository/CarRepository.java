package org.example.carmanagmentsystem.repository;

import org.example.carmanagmentsystem.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    public List<Car> getAll() {
        return new ArrayList<>();
    }

    public void insert(Car car) {

        String connectionUrl = "jdbc:mysql://localhost:3306/carsdb";
        String username = "root";
        String password = "7Anxhelo2000";

        String query = "INSERT INTO car(id, brand, horse_power, color, fuel_type, production_date)" +
                " VALUES(?, ?, ?, ?, ?, ?)";
        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setInt(1, car.getId());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setInt(3, car.getHorsePower());
            preparedStatement.setString(4, car.getColor().name());
            preparedStatement.setString(5, car.getFuelType().name());
            preparedStatement.setDate(6, Date.valueOf(car.getProductionDate()));

            preparedStatement.executeUpdate();
        } catch (SQLException se) {

        }
    }

    public Car getById(int id) {
        return new Car();
    }

    public void update(Car car) {
        String connectionUrl = "jdbc:mysql://localhost:3306/carsdb";
        String username = "root";
        String password = "7Anxhelo2000";

        String query = "UPDATE car" +
                "SET brand = ?, horse_power = ?, color = ?, fuel_type = ?, production_date = ?" +
                "WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, car.getId());
            preparedStatement.setString(2, car.getBrand());
            preparedStatement.setInt(3,car.getHorsePower());
            preparedStatement.setString(4, car.getColor().name());
            preparedStatement.setString(5, car.getFuelType().name());
            preparedStatement.setDate(6, Date.valueOf(car.getProductionDate()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {

        String connectionUrl = "jdbc:mysql://localhost:3306/carsdb";
        String username = "root";
        String password = "7Anxhelo2000";

        String query = "DELETE FROM cars WHERE id = ?";
        try (Connection connection = DriverManager.getConnection(connectionUrl, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
