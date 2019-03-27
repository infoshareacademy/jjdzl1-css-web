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
        commitTransaction(session);
        return car;
    }

    @Override
    public List<Car> list() {
        Session session = getSession();
        List<Car> carList = session.createQuery("Select c FROM Car c")
                .getResultList();
        commitTransaction(session);
        return carList;
    }

    @Override
    public Car getCar(Integer id) {
        Session session = getSession();
        Car getCarById = session.get(Car.class, id);
        commitTransaction(session);
        return getCarById;
    }

    @Override
    public Car updateCarMileage(Integer id, Integer mileage) {
        Session session = getSession();
        Car updateCar = session.get(Car.class, id);
        updateCar.setMileage(mileage);
        commitTransaction(session);
        return updateCar;
    }

    @Override
    public void deleteCar(Integer id) {
        Session session = getSession();
        Car carToDelete = session.get(Car.class, id);
        session.delete(carToDelete);
        commitTransaction(session);
    }

    @Override
    public List<Car> search(String make,String model,String fuel) {
        Session session= getSession();
        List<Car> carsList=session.createQuery("select c from Car c where c.make LIKE '%"+make+"%' and c.model LIKE '%"+model+"%' and c.fuelSource LIKE '%"+fuel+"%'  ")
                .getResultList();
        commitTransaction(session);
        return carsList;
    }

    private void commitTransaction(Session session) {
        session.getTransaction().commit();
        session.close();
    }
}
