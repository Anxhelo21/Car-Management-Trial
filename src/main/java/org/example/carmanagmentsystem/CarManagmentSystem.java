package org.example.carmanagmentsystem;

import org.example.carmanagmentsystem.model.Car;
import org.example.carmanagmentsystem.model.enums.Color;
import org.example.carmanagmentsystem.model.enums.FuelType;
import org.example.carmanagmentsystem.repository.CarRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class CarManagmentSystem {

    public static void main(String[] args) {
        testConnection();
//        testGetAll();
//        testInsert();
//        testGetById();
        testUpdate();
//        testDelete();
    }

    private static void testConnection() {
        String connectionUrl = "jdbc:mysql://localhost:3306/carsdb";
        String username = "root";
        String password = "7Anxhelo2000";

        try(Connection connection = DriverManager.getConnection(connectionUrl, username, password)) {
            System.out.println("Connection successfully!");
        }
        catch (SQLException se){

        }
    }

    private static void testGetAll() {
        CarRepository carRepository = new CarRepository();

        List<Car> cars = carRepository.getAll();

        System.out.println("Cars: " + cars);
    }

    private static void testInsert() {

        Car car = createCar();

        CarRepository carRepository = new CarRepository();
        carRepository.insert(car);
    }

    private static Car createCar() {

        Car car = new Car();

        car.setId(1);
        car.setBrand("Benz");
        car.setColor(Color.BLACK);
        car.setFuelType(FuelType.DIESEL);
        car.setHorsePower(177);
        car.setProductionDate(LocalDate.of(2022, Month.JANUARY, 5));

        return car;
    }

    private static void testGetById() {

        int id = 1;
        CarRepository carRepository = new CarRepository();

        Car car = carRepository.getById(id);
        System.out.println("Car: " + car);
    }

    private static void testUpdate() {

        Car car = createCarForUpdate();

        CarRepository carRepository = new CarRepository();
        carRepository.update(car);
    }

    private static Car createCarForUpdate() {
        Car car = new Car();

        car.setId(1);
        car.setBrand("Audi");
        car.setColor(Color.BLACK);
        car.setFuelType(FuelType.DIESEL);
        car.setHorsePower(177);
        car.setProductionDate(LocalDate.of(2021, Month.JANUARY, 5));

        return car;
    }

    private static void testDelete() {
        int id = 1;

        CarRepository carRepository = new CarRepository();
        carRepository.delete(id);
    }
}
