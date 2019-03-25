package com.infoshare.academy.dao;

import com.infoshare.academy.domain.Car;
import com.infoshare.academy.domain.Reservation;
import org.hibernate.Session;
import org.hibernate.query.Query;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Filter;
import java.util.stream.Stream;

import static com.infoshare.academy.utils.HibernateConf.getSessionFactory;

@Stateless
public class ReservationRepositoryDaoBean implements ReservationRepositoryDao {

    public LocalDate startDate;
    public LocalDate endDate;

    private String availableCar="SELECT  c FROM Car c  where id  IN " +
            "(SELECT car FROM Reservation WHERE (startDate>'"+startDate+"' and startDate>'"+endDate+"')" +
            " or (endDate<'"+startDate+"' and startDate>'"+endDate+"')" +
            " or (endDate<'"+startDate+"'))or id IN (SELECT c from Car c)" +
            "ORDER BY c.id ASC";

    @Override
    public Reservation addReservation(Reservation reservation) {
        Session session = getSession();
        session.save(reservation);
        commitTransaction(session);
        return reservation;
    }

    @Override
    public List<Reservation> list() {
        Session session = getSession();
        List<Reservation> reservationList = session.createQuery
                ("select r from Reservation r")
                .getResultList();
        commitTransaction(session);
        return reservationList;
    }

    @Override
    public Reservation getReservationById(Integer id) {
        Session session =getSession();
        Reservation getReservation=session.get(Reservation.class,id);
        commitTransaction(session);
        return getReservation;

    }

    public List<Reservation> getReservationListByUserId(Integer id) {
        Session session = getSession();
        List<Reservation> reservationListByUserId = session.createQuery
                ("select r from Reservation r where user='" + id + "'")
                .getResultList();
        commitTransaction(session);
        return reservationListByUserId;
    }

    @Override
    public Reservation updateReservation(Integer id, Car car, LocalDate startDate, LocalDate endDate) {
        Session session = getSession();
        Reservation updateReservation = session.get(Reservation.class, id);
        updateReservation.setCar(car);
        updateReservation.setStartDate(startDate);
        updateReservation.setEndDate(endDate);
        session.close();
        return updateReservation;
    }

    @Override
    public void deleteReservation(Integer id) {
        Session session = getSession();
        Reservation reservationToDelete = session.get(Reservation.class, id);
        session.delete(reservationToDelete);
        commitTransaction(session);
    }

    @Override
    public List<Car> getCarListAvailableCar(LocalDate startDate, LocalDate endDate) {
        Session session=getSession();
        List<Car> carListAvailableCar=session.createQuery(availableCar).getResultList();
        commitTransaction(session);
        return carListAvailableCar;
    }

    @Override
    public Integer getCountCarListAvailableCar(LocalDate startDate, LocalDate endDate) {
        Session session =getSession();
        List<Car> carList=session.createQuery(availableCar).getResultList();
        int carCount=carList.size();
        commitTransaction(session);
        return carCount;
    }

    @Override
    public List<Car> getCarListAvailableCarLimit(LocalDate startDate, LocalDate endDate,int i) {
        Session session=getSession();
        Query carList=session.createQuery(availableCar);
        int pageSize=3;
        carList.setFirstResult(pageSize*(i-1));
        carList.setMaxResults(pageSize);
        List<Car> carListAvailableCarLimit=carList.getResultList();
        commitTransaction(session);
        return carListAvailableCarLimit;
    }

    @Override
    public Stream<Reservation> searchReservation(Filter filter) {
        return null;
    }

    private Session getSession() {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        return session;
    }

    private void commitTransaction(Session session) {
        session.getTransaction().commit();
        session.close();
    }
}
