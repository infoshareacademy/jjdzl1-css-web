//package com.infoshare.academy.domain;
//
//
//import javax.persistence.*;
//import java.time.LocalDate;
//import java.util.UUID;
//
//@Entity
//@Table(name = "users_authorization")
//public class UserAuthorization extends User {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "authorization_number")
//    private String AuthorizationNumber;
//    @Column(name = "is_account_active")
//    private Boolean isAccountActive;
//
//    public UserAuthorization(String authorizationNumber, Boolean isAccountActive) {
//        AuthorizationNumber = authorizationNumber;
//        this.isAccountActive = isAccountActive;
//    }
//
//    public String getAuthorizationNumber() {
//        return AuthorizationNumber;
//    }
//
//    public Boolean getAuthorize() {
//        return isAccountActive;
//    }
//
//    public void setAuthorizationNumber(UUID authorizationNumber) {
//        AuthorizationNumber = authorizationNumber.toString();
//    }
//
//    public void setAuthorize(Boolean authorize) {
//        isAccountActive = authorize;
//    }
//
//    @Override
//    public String toString() {
//        return "UserAuthorization{" +
//                "AuthorizationNumber=" + AuthorizationNumber +
//                ", isAccountActive=" + isAccountActive +
//                '}';
//    }
//}
