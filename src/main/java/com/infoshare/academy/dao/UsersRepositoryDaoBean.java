package com.infoshare.academy.dao;

import com.infoshare.academy.domain.User;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

import static com.infoshare.academy.utils.HibernateConf.getSessionFactory;

public class UsersRepositoryDaoBean implements UsersRepositoryDao {

    @Override
    public void addUser(User user) {
        Session session = getSession();
        session.save(user);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public User getUserById(int id) {
        Session session = getSession();
        User user = session.get(User.class, id);
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public User getUserByLogin(String login) {
        Session session = getSession();
        String select = "SELECT u from User u WHERE login=:login";
        Query query = session.createQuery(select);
        query.setParameter("login",login);
        User user = (User) query.getSingleResult();
        session.getTransaction().commit();
        session.close();
        return user;
    }

    @Override
    public List<User> getUsersList() {
        Session session = getSession();
        List<User> usersList = session.createQuery("Select u FROM User u ").getResultList();
        session.getTransaction().commit();
        session.close();
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
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteUserByLogin(String login) {
        Session session = getSession();
        User user = session.get(User.class, login);
        session.delete(user);
        session.getTransaction().commit();
        session.close();
    }

    private Session getSession() {
        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();
        return session;
    }
}