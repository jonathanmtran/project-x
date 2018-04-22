package edu.fullerton.csu.jmtran.projectx.dao;

import edu.fullerton.csu.jmtran.projectx.messaging.service.IMessagingService;
import edu.fullerton.csu.jmtran.projectx.model.MailboxMessage;
import edu.fullerton.csu.jmtran.projectx.model.Message;
import edu.fullerton.csu.jmtran.projectx.model.User;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("mailboxDao")
public class MailboxDAOImpl extends AbstractDAOImpl implements IMailboxDAO {
    @Autowired
    private MessageDAOImpl messageDao;

    @Override
    @SuppressWarnings("unchecked")
    public List<MailboxMessage> getMessages(String userId) {
        Session session = this.sessionFactory.openSession();

        Query query = session.createQuery("FROM MailboxMessage WHERE USER_ID = :user_id ORDER BY RECEIVED_DATE DESC");
        query.setParameter("user_id", userId);

        List<MailboxMessage> messages = query.list();

        session.close();

        return messages;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<MailboxMessage> getMessages(String userId, String messagingService) {
        Session session = this.sessionFactory.openSession();

        String queryStr = "FROM MailboxMessage WHERE USER_ID = :user_id AND MESSAGING_SERVICE {} :messaging_service ORDER BY RECEIVED_DATE DESC";

        if (messagingService == null) {
            queryStr = queryStr.replace("{}", "IS");
            queryStr = queryStr.replace(":messaging_service", "NULL");
        }
        else {
            queryStr = queryStr.replace("{}", "=");
        }

        Query query = session.createQuery(queryStr);
        query.setParameter("user_id", userId);

        if (messagingService != null) {
            query.setParameter("messaging_service", messagingService);
        }

        List<MailboxMessage> messages = query.list();

        session.close();

        return messages;
    }

    public MailboxMessage save(MailboxMessage mailboxMessage) {
        Session session = this.sessionFactory.openSession();

        Transaction tx = session.beginTransaction();

        session.save(mailboxMessage);

        tx.commit();

        session.close();

        return mailboxMessage;
    }

    @Override
    public boolean sendMessage(User recipient, Message message, IMessagingService service) {
        MailboxMessage mailboxMessage = new MailboxMessage();

        mailboxMessage.setUserId(recipient.getId());
        mailboxMessage.setMessageId(message.getId());

        if (service.getName() != null) {
            mailboxMessage.setMessagingService(service.getSystemName());
        }

        mailboxMessage.setReceivedDate(new Date());

        mailboxMessage = this.save(mailboxMessage);

        return (mailboxMessage != null);
    }

    public MessageDAOImpl getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(MessageDAOImpl messageDao) {
        this.messageDao = messageDao;
    }
}
