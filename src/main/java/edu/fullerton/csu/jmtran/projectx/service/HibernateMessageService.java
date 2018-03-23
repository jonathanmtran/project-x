package edu.fullerton.csu.jmtran.projectx.service;

import edu.fullerton.csu.jmtran.projectx.model.Message;
import org.hibernate.HibernateException;
import org.springframework.orm.hibernate3.HibernateJdbcException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

public class HibernateMessageService extends HibernateDaoSupport {
    public List<Message> getAllMessages() {
        List<Message> result;

        try {
            result = (List<Message>) getHibernateTemplate().find("from Message");
        }
        catch (HibernateException e) {
            throw convertHibernateAccessException(e);
        }

        return result;
    }

    public Message getMessage(Long id) {
        List<Message> result = null;

        try {
            result = (List<Message>) getHibernateTemplate().find("from Message where id = '" + id.toString() + "'");
        }
        catch (HibernateException e) {
            throw convertHibernateAccessException(e);
        }

        return result.get(0);
    }
}
