package edu.fullerton.csu.jmtran.projectx.dao;

import org.hibernate.SessionFactory;

public abstract class AbstractDAOImpl {
    protected SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
