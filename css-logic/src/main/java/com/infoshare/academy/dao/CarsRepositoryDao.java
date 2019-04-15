package com.infoshare.academy.dao;

import com.infoshare.academy.domain.Car;

import java.util.List;

public interface CarsRepositoryDao {
    Car addCar(Car car);

    Integer listCount();

    List<Car> list(int currentPage,int pageSize);

    List<Car> listCar();

    Car getCar(Integer id);

    Car updateCar(Car car);

    void deleteCar(Integer id);

    Integer searchCarCount(String make, String model, String fuel);

    List<Car> searchCar(String make, String model, String fuel, int page, int pageSize);
}
