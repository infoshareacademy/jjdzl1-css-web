package com.infoshare.academy.dao;

import com.infoshare.academy.domain.Car;
import org.hibernate.Filter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public interface CarsRepositoryDao {
    Car addCar(Car car);

    List<Car> list();

    Car getCar(Integer id);

    Car updateCarMileage(Integer id,Integer mileage);

    void deleteCar(Integer id);

    List<Car> search(String make,String model,String fuel);
}
