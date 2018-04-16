package edu.fullerton.csu.jmtran.projectx.dao;

import edu.fullerton.csu.jmtran.projectx.model.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDAOImpl extends AbstractDAOImpl implements IUserDAO {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User get(String userId) {
        Session session = this.sessionFactory.openSession();

        Query query = session.createQuery("from User where user_id = :userId");
        query.setParameter("userId", userId);

        User user = (User) query.uniqueResult();

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

}
