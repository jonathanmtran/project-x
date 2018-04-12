package edu.fullerton.csu.jmtran.projectx.dao;

import edu.fullerton.csu.jmtran.projectx.model.Message;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class MessageDAOImpl implements IMessageDAO {
    private SessionFactory sessionFactory;

    @Override
    public Message get(int id) {
        Session session = this.sessionFactory.openSession();

        Query query = session.createQuery("from Message where id = :id");
        query.setParameter("id", id);

        Message message = (Message)query.uniqueResult();

        return message;
    }

    @Override
    public List<Message> list() {
        Session session = this.sessionFactory.openSession();

        List<Message> messages = session.createQuery("from Message").list();

        return messages;
    }

    @Override
    public void save(Message message) {
        Session session = this.sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        session.persist(message);

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
