package com.infoshare.academy.dao;

import com.infoshare.academy.domain.Reservation;

import java.util.List;

public interface ReservationRepositoryDao {
    List<Reservation> getReservationList();
    List<Reservation> getReservationByUserId(int user);
    List<Reservation> getReservationByCarId(int car);
}

