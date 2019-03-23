//package com.infoshare.academy.dao;
//
//import com.infoshare.academy.domain.User;
//import com.infoshare.academy.domain.UserAuthorization;
//import org.hibernate.Session;
//
//import javax.ejb.Stateless;
//import javax.persistence.NoResultException;
//import javax.persistence.Query;
//
//import java.util.UUID;
//
//import static com.infoshare.academy.utils.HibernateConf.getSessionFactory;
//
//@Stateless
//public class UserAuthorizationDaoBean implements UserAuthorizationDao {
//    @Override
//    public UserAuthorization addAuthorization(User user,UserAuthorization userAuthorization) {
//        Session session = getSession();
//        session.save(user);
//        session.save(userAuthorization);
//        commitTransaction(session);
//        return userAuthorization;
//    }
//
//    @Override
//    public UserAuthorization getUserAuthorizationById(int id) {
//        try {
//            Session session = getSession();
//            UserAuthorization userAuthorization = session.get(UserAuthorization.class, id);
//            commitTransaction(session);
//            return userAuthorization;
//        } catch (NoResultException e) {
//        }
//        return null;
//    }
//
//    public User getUserAuthorizationByAuthorizationNumber(String authorizationNumber) {
//        UserAuthorization userAuthorization;
//        try {
//            Session session = getSession();
//            String select = "SELECT u from UserAuthorization u WHERE authorizationNumber=:authorizationNumber";
//            Query query = session.createQuery(select);
//            query.setParameter("authorizationNumber", authorizationNumber);
//            userAuthorization = (UserAuthorization) query.getSingleResult();
//            commitTransaction(session);
//            return userAuthorization;
//        } catch (NoResultException e) {
//        }
//        return null;
//    }
//
//    public UUID setAuthorizationNumberWithUUID() {
//        UUID uuid = UUID.randomUUID();
//        return uuid;
//    }
//
//
//    private Session getSession() {
//        Session session = getSessionFactory().openSession();
//        session.beginTransaction();
//        return session;
//    }
//
//    private void commitTransaction(Session session) {
//        session.getTransaction().commit();
//        session.close();
//    }
//}
//