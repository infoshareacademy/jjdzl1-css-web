package com.infoshare.academy.dao;

import com.infoshare.academy.domain.User;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

import static com.infoshare.academy.utils.HibernateConf.getSessionFactory;

@Stateless
public class UsersRepositoryDaoBean implements UsersRepositoryDao {

    @Override
    public void addUser(User user) {
        Session session = getSession();
        session.save(user);
        commitTransaction(session);
    }

    @Override
    public User getUserById(int id) {
        try {
            Session session = getSession();
            User user = session.get(User.class, id);
            commitTransaction(session);
            return user;
        } catch (NoResultException e) {
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        User user = null;
        try {
            Session session = getSession();
            String select = "SELECT u from User u WHERE login=:login";
            Query query = session.createQuery(select);
            query.setParameter("login", login);
            user = (User) query.getSingleResult();
            commitTransaction(session);
            return user;
        } catch (NoResultException e) {
        }
        return null;
    }

    @Override
    public List<User> getUsersList() {
        Session session = getSession();
        List<User> usersList = session.createQuery("Select u FROM User u ").getResultList();
        commitTransaction(session);
        return usersList;
    }

    @Override
    public void updateUser() {
        // TODO: 2019-02-24 todo here
    }

    @Override
    public void deleteUserById(int id) {
        Session session = getSession();
        User user = session.get(User.class, id);
        session.delete(user);
        commitTransaction(session);
    }

    @Override
    public void deleteUserByLogin(String login) {
        Session session = getSession();
        User user = session.get(User.class, login);
        session.delete(user);
        commitTransaction(session);
    }

    @Override
    public void updateUserAddress(Integer id, String postalCode, String city, String streetAddress) {
        Session session = getSession();
        String update = "UPDATE User u SET u.postalCode=:postalCode, u.city=:city, u.streetAddress=:streetAddress WHERE u.id=:id";
        Query query = session.createQuery(update);
        query.setParameter("id", id);
        query.setParameter("postalCode", postalCode);
        query.setParameter("city", city);
        query.setParameter("streetAddress", streetAddress);
        query.executeUpdate();
        commitTransaction(session);
    }

    @Override
    public void updateUserPassword(Integer id, String password) {
        Session session = getSession();
        String update = "UPDATE User u SET u.password=:password WHERE u.id=:id";
        Query query = session.createQuery(update);
        query.setParameter("id", id);
        query.setParameter("password", password);
        query.executeUpdate();
        commitTransaction(session);
    }

    @Override
    public void updateUserInfo(Integer id, String firstName, String lastName, Long phoneNumber, LocalDate birthDate) {
        Session session = getSession();
        String update = "UPDATE User u SET u.firstName=:firstName, u.lastName=:lastName, u.phoneNumber=:phoneNumber, u.birthDate=:birthDate WHERE u.id=:id";
        Query query = session.createQuery(update);
        query.setParameter("id", id);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        query.setParameter("phoneNumber", phoneNumber);
        query.setParameter("birthDate", birthDate);
        query.executeUpdate();
        commitTransaction(session);
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