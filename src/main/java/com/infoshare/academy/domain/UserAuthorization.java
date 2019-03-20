package com.infoshare.academy.domain;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "users_authorization")
public class UserAuthorization extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authorization_number")
    private Long AuthorizationNumber;
    @Column(name = "is_account_active")
    private Boolean isAccountActive;

    public UserAuthorization(Integer userType, String login, String password, String email,
                             Long phoneNumber, String firstName, String lastName,
                             LocalDate birthDate, String streetAddress, String postalCode,
                             String city, Long authorizationNumber, Boolean isAccountActive) {
        super(userType, login, password, email, phoneNumber, firstName, lastName, birthDate,
                streetAddress, postalCode, city);
        AuthorizationNumber = authorizationNumber;
        this.isAccountActive = isAccountActive;
    }

    public UserAuthorization(Long authorizationNumber, Boolean isAccountActive) {
        AuthorizationNumber = authorizationNumber;
        this.isAccountActive = isAccountActive;
    }

    public Long getAuthorizationNumber() {
        return AuthorizationNumber;
    }

    public Boolean getAuthorize() {
        return isAccountActive;
    }

    public void setAuthorizationNumber(Long authorizationNumber) {
        AuthorizationNumber = authorizationNumber;
    }

    public void setAuthorize(Boolean authorize) {
        isAccountActive = authorize;
    }

    @Override
    public String toString() {
        return "UserAuthorization{" +
                "AuthorizationNumber=" + AuthorizationNumber +
                ", isAccountActive=" + isAccountActive +
                '}';
    }
}
