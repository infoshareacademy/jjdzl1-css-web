package com.infoshare.academy.dao;

import com.infoshare.academy.domain.Car;
import org.hibernate.Filter;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public interface CarsRepositoryDao {
    Car addCar(Car car);

    Integer listCount();

    List<Car> list(int currentPage,int pageSize);

    List<Car> listCar();

    Car getCar(Integer id);

    Car updateCar(Car car);

    void deleteCar(Integer id);

    Integer searchCount(String make,String model,String fuel);

    List<Car> search(String make,String model,String fuel,int page,int pageSize);
}
