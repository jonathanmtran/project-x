package edu.fullerton.csu.jmtran.projectx.dao;

import edu.fullerton.csu.jmtran.projectx.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAOImpl implements IUserDAO {
    private SessionFactory sessionFactory;

    @Override
    public User get(String userId) {
        Session session = this.sessionFactory.openSession();

        Query query = session.createQuery("from User where user_id = :userId");
        query.setParameter("userId", userId);

        User user = (User)query.uniqueResult();

        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> list() {
        Session session = this.sessionFactory.openSession();

        List<User> users = session.createQuery("from User").list();

        session.close();

        return users;
    }

    @Override
    public void save(User user) {
        Session session = this.sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        session.persist(user);

        tx.commit();

        session.close();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
