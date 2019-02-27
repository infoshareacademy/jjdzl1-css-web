package com.infoshare.academy.dao;

import com.infoshare.academy.domain.Car;
import com.infoshare.academy.enums.BodyTypeEnum;
import com.infoshare.academy.enums.ColorEnum;
import com.infoshare.academy.enums.FuelSourceEnum;
import com.infoshare.academy.enums.TransmissionEnum;
import org.hibernate.Filter;

import java.util.stream.Stream;

public interface CarsRepositoryDao {
    Car addCar(Car car);

    Stream<Car> list();

    Car getCar(long id);

    Car updateCar(long id, Integer carType, String make, String model, Integer year, Integer mileage, FuelSourceEnum
            fuelSourceEnum, Integer enginePower, ColorEnum colorEnum, BodyTypeEnum bodyTypeEnum, TransmissionEnum transmissionEnum);

    void deleteCar(long id);

    Stream<Car> searchCar(Filter filter);
}
