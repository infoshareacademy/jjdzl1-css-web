package com.infoshare.academy.dao;

import com.infoshare.academy.domain.Car;
import com.infoshare.academy.domain.Reservation;
import org.hibernate.Session;

import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Filter;
import java.util.stream.Stream;

import static com.infoshare.academy.utils.HibernateConf.getSessionFactory;

@Stateless
public class ReservationRepositoryDaoBean implements ReservationRepositoryDao {

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
        List<Car> carListAvailableCar=session.createQuery("SELECT c FROM Car c " +
                "where id NOT IN (SELECT car FROM Reservation WHERE"  +
                "(startDate>'"+startDate+"' and startDate>'"+endDate+"')"+
                "or (endDate<'"+startDate+"' and startDate>'"+endDate+"')"+
                "or (endDate<'"+startDate+"'))").getResultList();
        commitTransaction(session);
        return carListAvailableCar;
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
