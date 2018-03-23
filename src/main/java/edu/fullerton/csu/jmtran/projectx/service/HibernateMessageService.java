package edu.fullerton.csu.jmtran.projectx.service;

import edu.fullerton.csu.jmtran.projectx.model.Message;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.util.List;

public class HibernateMessageService extends HibernateDaoSupport {
    public List<Message> getAllMessages() {
        List<Message> result;

        try {
            result = (List<Message>) getHibernateTemplate().find("from Message");
        }
        catch (HibernateException e) {
            throw e;
        }

        return result;
    }

    public Message getMessage(Long id) {
        List<Message> result = null;

        try {
            result = (List<Message>) getHibernateTemplate().find("from Message where id = '" + id.toString() + "'");
        }
        catch (HibernateException e) {
            throw e;
        }

        return result.get(0);
    }
}
