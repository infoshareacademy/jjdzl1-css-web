package com.infoshare.academy.dao;

import com.infoshare.academy.domain.User;
import com.infoshare.academy.utils.MailSend;
import com.infoshare.academy.utils.MyQuery;
import org.hibernate.Session;

import javax.ejb.Stateless;
import javax.mail.MessagingException;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static com.infoshare.academy.utils.HibernateConf.getSessionFactory;

@Stateless
public class UsersRepositoryDaoBean implements UsersRepositoryDao {

    MyQuery myQuery = new MyQuery();

    @Override
    public User addUser(User user) {
        Session session = getSession();
        session.save(user);
        commitTransaction(session);
        return user;
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
        User user;
        try {
            Session session = getSession();
            Query query = session.createQuery(myQuery.getUserByLogin())
                    .setParameter("login", login);
            user = (User) query.getSingleResult();
            commitTransaction(session);
            return user;
        } catch (NoResultException e) {
        }
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        User user;
        try {
            Session session = getSession();
            Query query = session.createQuery(myQuery.getUserByEmail())
                    .setParameter("email", email);
            user = (User) query.getSingleResult();
            commitTransaction(session);
            return user;
        } catch (NoResultException e) {
        }
        return null;
    }

    @Override
    public User getUserByToken(String passwordTokenUUID) {
        User user;
        try {
            Session session = getSession();
            Query query = session.createQuery(myQuery.getUserByToken())
                    .setParameter("passwordTokenUUID", passwordTokenUUID);
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
        List<User> usersList = session.createQuery(myQuery.getUserList()).getResultList();
        commitTransaction(session);
        return usersList;
    }

    @Override
    public List<User> searchUserByLoginOrEmail(String name) {
        Session session = getSession();
        org.hibernate.query.Query<User> query = session.createQuery(myQuery.searchUser(name), User.class);
        List<User> userList = query.getResultList();
        commitTransaction(session);
        return userList;
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
        Query query = session.createQuery(myQuery.deleteUserByLogin())
                .setParameter("login", login);
        query.executeUpdate();
        commitTransaction(session);
    }

    @Override
    public void updateUserAddress(Integer id, String postalCode, String city, String streetAddress) {
        Session session = getSession();
        Query query = session.createQuery(myQuery.updateUserAdress())
                .setParameter("id", id)
                .setParameter("postalCode", postalCode)
                .setParameter("city", city)
                .setParameter("streetAddress", streetAddress);
        query.executeUpdate();
        commitTransaction(session);
    }

    @Override
    public void updateUserPassword(Integer id, String password) {
        Session session = getSession();
        Query query = session.createQuery(myQuery.updateUserPassword())
                .setParameter("id", id)
                .setParameter("password", password);
        query.executeUpdate();
        commitTransaction(session);
    }

    @Override
    public void updateUserInfo(Integer id, String firstName, String lastName, Long phoneNumber, LocalDate birthDate) {
        Session session = getSession();
        Query query = session.createQuery(myQuery.updateUserInfo())
                .setParameter("id", id)
                .setParameter("firstName", firstName)
                .setParameter("lastName", lastName)
                .setParameter("phoneNumber", phoneNumber)
                .setParameter("birthDate", birthDate);
        query.executeUpdate();
        commitTransaction(session);
    }

    @Override
    public void sendEmailToNewUser(String login, String email, String UUID) throws MessagingException {
        MailSend mail = new MailSend();
        mail.sendEmailForRegistrationProcess(login, email, UUID);
    }

    @Override
    public void sendEmailToUserWithForgotPasswordToken(String email, String UUID){

    }

    @Override
    public void updateIsUserAccountActive(Integer id, Boolean isAccountActive) {
        Session session = getSession();
        Query query = session.createQuery(myQuery.updateIsUserAccountActive())
                .setParameter("id", id)
                .setParameter("isAccountActive", isAccountActive);
        query.executeUpdate();
        commitTransaction(session);
    }

    @Override
    public void updateChangePasswordTokenData(Integer id, String passwordTokenUIDD, LocalDateTime passwordTokenDateTime) {
        Session session = getSession();
        Query query = session.createQuery(myQuery.updateTokenData())
                .setParameter("id", id)
                .setParameter("passwordTokenUUID", passwordTokenUIDD)
                .setParameter("passwordTokenDateTime", passwordTokenDateTime);
        query.executeUpdate();
        commitTransaction(session);
    }

    @Override
    public int countUsers() {
        Session session = getSession();
        Long countUsers = (Long) session.createQuery(myQuery.countUsers()).getSingleResult();
        commitTransaction(session);
        return Math.toIntExact(countUsers);
    }

    @Override
    public List<User> getUsersListPaged(int currentPage, int pageSize) {
        Session session = getSession();
        Query list = session.createQuery(myQuery.getUserList())
                .setFirstResult(pageSize * (currentPage - 1))
                .setMaxResults(pageSize);
        List<User> userList = list.getResultList();
        commitTransaction(session);
        return userList;
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