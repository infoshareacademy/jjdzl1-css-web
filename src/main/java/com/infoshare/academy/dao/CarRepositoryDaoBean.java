package com.infoshare.academy.dao;

import com.infoshare.academy.domain.Car;
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
    public Car addCar(Car car) {
        Session session = getSession();
        session.save(car);
        session.getTransaction().commit();
        session.close();
        return car;
    }

    @Override
    public List<Car> list() {
        Session session = getSession();
        List<Car> carList = session.createQuery("Select c FROM Car c")
                .getResultList();
        session.getTransaction().commit();
        session.close();
        return carList;
    }

    @Override
    public Car getCar(Integer id) {
        Session session = getSession();
        Car getCarById = session.get(Car.class, id);
        session.getTransaction().commit();
        session.close();
        return getCarById;
    }

    @Override
    public Car updateCarMileage(Integer id, Integer mileage) {
        Session session = getSession();
        Car updateCar = session.get(Car.class, id);
        updateCar.setMileage(mileage);
        session.getTransaction().commit();
        session.close();
        return updateCar;
    }


    @Override
    public void deleteCar(Integer id) {
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
