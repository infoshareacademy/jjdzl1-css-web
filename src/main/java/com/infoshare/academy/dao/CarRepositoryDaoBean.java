package com.infoshare.academy.dao;

import com.infoshare.academy.domain.Car;
import com.infoshare.academy.enums.BodyTypeEnum;
import com.infoshare.academy.enums.ColorEnum;
import com.infoshare.academy.enums.FuelSourceEnum;
import com.infoshare.academy.enums.TransmissionEnum;
import org.hibernate.Filter;
import org.hibernate.Session;

import javax.ejb.Stateless;
import java.util.List;
import java.util.stream.Stream;

import static com.infoshare.academy.utils.HibernateConf.getSessionFactory;

@Stateless
public class CarRepositoryDaoBean implements CarsRepositoryDao {

    private Session getSession() {
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        return session;
    }

    @Override
    public Car addCar(Car car){
        Session session=getSession();
        session.save(car);
        session.getTransaction().commit();
        session.close();
        return car;
    }

    @Override
    public Stream<Car> list() {
        Session session = getSession();
        List<Car> carList = session.createQuery("Select c FROM Car c").getResultList();
        session.getTransaction().commit();
        session.close();
        return (Stream<Car>) carList;
    }

    @Override
    public Car getCar(long id) {
        Session session = getSession();
        Car getCarById = session.get(Car.class, id);
        session.getTransaction().commit();
        session.close();
        return getCarById;
    }

    @Override
    public Car updateCar(long id, Integer carType, String make, String model, Integer year, Integer mileage, FuelSourceEnum
            fuelSourceEnum, Integer enginePower, ColorEnum colorEnum, BodyTypeEnum bodyTypeEnum, TransmissionEnum transmissionEnum) {
        Session session = getSession();
        Car carToUpdate = session.get(Car.class, id);
        if (carToUpdate != null) {
            carToUpdate.setCarType(carType);
            carToUpdate.setMake(make);
            carToUpdate.setModel(model);
            carToUpdate.setYear(year);
            carToUpdate.setMileage(mileage);
            carToUpdate.setFuelSource(fuelSourceEnum);
            carToUpdate.setEnginePower(enginePower);
            carToUpdate.setColor(colorEnum);
            carToUpdate.setBodyType(bodyTypeEnum);
            carToUpdate.setTransmission(transmissionEnum);
            session.getTransaction().commit();
            session.close();
        }
        return carToUpdate;
    }

    @Override
    public void deleteCar(long id) {
        Session session = getSession();
        Car carToDelete = session.get(Car.class, id);
        session.delete(carToDelete);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Stream<Car> searchCar(Filter filter) {
        return null;
    }
}
