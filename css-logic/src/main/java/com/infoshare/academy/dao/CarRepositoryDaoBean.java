package com.infoshare.academy.dao;

import com.infoshare.academy.domain.Car;
import com.infoshare.academy.utils.MyQuery;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.Query;
import java.util.List;

import static com.infoshare.academy.utils.HibernateConf.getSessionFactory;

@Stateless
public class CarRepositoryDaoBean implements CarsRepositoryDao {

    private MyQuery myQuery = new MyQuery();

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
    public Integer listCount() {
        Session session = getSession();
        Long countCars = (Long) session.createQuery(myQuery.countCars()).getSingleResult();
        commitTransaction(session);
        return Math.toIntExact(countCars);
    }

    @Override
    public List<Car> list(int currentPage, int pageSize) {
        Session session = getSession();
        Query list = session.createQuery(myQuery.getCar())
                .setFirstResult(pageSize * (currentPage - 1))
                .setMaxResults(pageSize);
        List<Car> carList = list.getResultList();
        commitTransaction(session);
        return carList;
    }

    @Override
    public List<Car> listCar() {
        Session session = getSession();
        List<Car> listCar = session.createQuery(myQuery.getCar()).getResultList();
        commitTransaction(session);
        return listCar;
    }

    @Override
    public Car getCar(Integer id) {
        Session session = getSession();
        Car getCarById = session.get(Car.class, id);
        commitTransaction(session);
        return getCarById;
    }

    @Override
    public Car updateCar(Car car) {
        Session session = getSession();
        Car updateCar = session.get(Car.class, car.getId());
        updateCar.setMake(car.getMake());
        updateCar.setModel(car.getModel());
        updateCar.setYear(car.getYear());
        updateCar.setMileage(car.getMileage());
        updateCar.setEnginePower(car.getEnginePower());
        updateCar.setSeats(car.getSeats());
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
    public Integer searchCarCount(String make, String model, String fuel) {
        Session session = getSession();
        List<Car> carList = session.createQuery(myQuery.getSearchCar(make, model, fuel)).getResultList();
        int carCount = carList.size();
        commitTransaction(session);
        return carCount;
    }

    @Override
    public List<Car> searchCar(String make, String model, String fuel, int page, int pageSize) {
        Session session = getSession();
        Query carList = session.createQuery(myQuery.getSearchCar(make, model, fuel))
                .setFirstResult(pageSize * (page - 1))
                .setMaxResults(pageSize);
        List<Car> carsList = carList.getResultList();
        commitTransaction(session);
        return carsList;
    }

    private void commitTransaction(Session session) {
        session.getTransaction().commit();
        session.close();
    }
}
