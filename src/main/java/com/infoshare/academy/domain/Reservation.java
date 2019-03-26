package com.infoshare.academy.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@GeneratedValue(generator = "UUID")
    //@GenericGenerator(name = "UUID", strategy = "org.hibernate.reservation_id.UUIDGenerator")
    @Column(name = "reservation_id")//, updatable = false)
    private Integer reservation_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @Column(name = "start_date")
    private LocalDate startDate;
    @Column(name = "end_date")
    private LocalDate endDate;

    public Reservation() {
    }

    public Reservation(User user, Car car, LocalDate startDate, LocalDate endDate) {
        this.user = user;
        this.car = car;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Reservation(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getReservation_id() {
        return reservation_id;
    }

    public User getUser() {
        return user;
    }

    public Car getCar() {
        return car;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + reservation_id +
                ", user=" + user +
                ", car=" + car +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
