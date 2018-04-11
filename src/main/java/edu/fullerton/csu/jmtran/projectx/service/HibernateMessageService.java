package edu.fullerton.csu.jmtran.projectx.service;

import edu.fullerton.csu.jmtran.projectx.messaging.service.IMessagingService;
import edu.fullerton.csu.jmtran.projectx.model.MailboxMessage;
import edu.fullerton.csu.jmtran.projectx.model.Message;
import edu.fullerton.csu.jmtran.projectx.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import java.util.Date;
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

    public List<MailboxMessage> getMailboxMessages(Long id) {
        List<MailboxMessage> result;

        try {
            result = (List<MailboxMessage>) getHibernateTemplate().find("from MailboxMessage where USER_ID = " + id.toString());
        }
        catch(HibernateException e) {
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

    public void sendMessage(User recipient, Message message, IMessagingService service) {
        MailboxMessage mailboxMessage = new MailboxMessage();

        mailboxMessage.setUserId(recipient.getId());
        // TODO: Do something about this (long + "" cast) business
        mailboxMessage.setMessageId(message.getId() + "");

        if(service.getName() != null) {
            mailboxMessage.setMessagingService(service.getName());
        }

        mailboxMessage.setReceivedDate(new Date());

        Session session = this.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        session.save(mailboxMessage);

        tx.commit();

        session.close();
    }
}
