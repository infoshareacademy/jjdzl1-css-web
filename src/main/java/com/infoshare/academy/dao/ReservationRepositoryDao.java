package com.infoshare.academy.dao;

import com.infoshare.academy.domain.Car;
import com.infoshare.academy.domain.Reservation;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Filter;
import java.util.stream.Stream;

public interface ReservationRepositoryDao {

    Reservation addReservation(Reservation reservation);

    Integer listCount(String login,String name);

    List<Reservation> listLimit(String login,String name,int currentPage);

    Reservation getReservationById(Integer id);

    Integer reservationCount(Integer id);

    List<Reservation> reservationListByUserIdLimit(Integer id, int currentPage);

    Reservation updateReservation(Integer id, Car car, LocalDate startDate, LocalDate endDate);

    void deleteReservation(Integer id);

    List<Car> getCarListAvailableCar(LocalDate startDate, LocalDate endDate);

    Integer getCountCarListAvailableCar(LocalDate startDate, LocalDate endDate);

    List<Car> getCarListAvailableCarLimit(LocalDate startDate, LocalDate endDate, int i);

    Stream<Reservation> searchReservation(Filter filter);

}

