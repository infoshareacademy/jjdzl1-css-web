package com.infoshare.academy.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;
    @Column(name = "user_type")
    private Integer userType;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private Long phoneNumber;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "street_address")
    private String streetAddress;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "city")
    private String city;
    @Column(name = "authorization_number")
    private String authorizationNumber;
    @Column(name = "is_account_active")
    private Boolean isAccountActive;
    @Column(name = "password_token_UUID")
    private String passwordTokenUUID;
    @Column(name = "password_token_dateTime")
    private LocalDateTime passwordTokenDateTime;

    @OneToMany(mappedBy = "user")
    private List<Reservation> reservations;


    public User() {
    }

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public User(Integer userType, String login, String password, String email, Long phoneNumber, String firstName,
                String lastName, LocalDate birthDate, String streetAddress, String postalCode, String city) {
        this.userType = userType;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
    }

    public User(Integer userType, String login, String password, String email, Long phoneNumber, String firstName,
                String lastName, LocalDate birthDate, String streetAddress, String postalCode, String city,
                String authorizationNumber, Boolean isAccountActive) {
        this.userType = userType;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.authorizationNumber = authorizationNumber;
        this.isAccountActive = isAccountActive;
    }

    public User(Integer userType, String login, String password, String email, Long phoneNumber, String firstName, String lastName, LocalDate birthDate, String streetAddress, String postalCode, String city, String authorizationNumber, Boolean isAccountActive, String passwordTokenUUID, LocalDateTime passwordTokenDateTime, List<Reservation> reservations) {
        this.userType = userType;
        this.login = login;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.city = city;
        this.authorizationNumber = authorizationNumber;
        this.isAccountActive = isAccountActive;
        this.passwordTokenUUID = passwordTokenUUID;
        this.passwordTokenDateTime = passwordTokenDateTime;
        this.reservations = reservations;
    }

    public Integer getId() {
        return id;
    }

    public Integer getUserType() {
        return userType;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getCity() {
        return city;
    }

    public String getAuthorizationNumber() {
        return authorizationNumber;
    }

    public Boolean getAccountActive() {
        return isAccountActive;
    }

    public Boolean getIsAccountActive() {
        return isAccountActive;
    }

    public String getPasswordTokenUUID() {
        return passwordTokenUUID;
    }

    public LocalDateTime getPasswordTokenDateTime() {
        return passwordTokenDateTime;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void addReservation(Reservation reservation) {
        if (reservations == null) {
            reservations = new ArrayList<>();
        }
        reservations.add(reservation);
        reservation.setUser(this);
    }

    public boolean userAuth() {
        if (getLogin().equals(login) && getPassword().equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public void setAuthorizationNumber(String authorizationNumber) {
        this.authorizationNumber = authorizationNumber;
    }

    public void setAccountActive(Boolean accountActive) {
        this.isAccountActive = accountActive;
    }

    public void setPasswordTokenUUID(String passwordTokenUUID) {
        this.passwordTokenUUID = passwordTokenUUID;
    }

    public void setPasswordTokenDateTime(LocalDateTime passwordTokenDateTime) {
        this.passwordTokenDateTime = passwordTokenDateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userType=" + userType +
                ", login='" + login + '\'' +
                ", password=***" +
                ", email='" + email + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", streetAddress='" + streetAddress + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
