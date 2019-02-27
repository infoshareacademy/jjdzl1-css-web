package com.infoshare.academy.dao;

import com.infoshare.academy.domain.Reservation;
import org.hibernate.Session;

import java.util.List;

import static com.infoshare.academy.utils.HibernateConf.getSessionFactory;

public class ReservationRepositoryDaoBean implements ReservationRepositoryDao {

    private Session getSession() {
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        return session;
    }

    @Override
    public List<Reservation> getReservationList() {
        Session session = getSession();
        List<Reservation> reservationList = session.createQuery("SELECT r FROM Reservation r").getResultList();
        session.getTransaction().commit();
        session.close();
        return reservationList;
    }

    @Override
    public List<Reservation> getReservationByUserId(int user) {
        Session session = getSession();
        List<Reservation> reservationListByUserId = session.createQuery("SELECT r FROM Reservation r WHERE r.user='" + user + "'", Reservation.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return reservationListByUserId;
    }

    @Override
    public List<Reservation> getReservationByCarId(int car) {
        Session session = getSession();
        List<Reservation> reservationListByCarId = session.createQuery("SELECT r FROM Reservation r WHERE r.car='" + car + "'", Reservation.class).getResultList();
        session.getTransaction().commit();
        session.close();
        return reservationListByCarId;
    }
}
