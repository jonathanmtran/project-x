package edu.fullerton.csu.jmtran.projectx.service;

import edu.fullerton.csu.jmtran.projectx.dao.IMailboxDAO;
import edu.fullerton.csu.jmtran.projectx.dao.IMessageDAO;
import edu.fullerton.csu.jmtran.projectx.dao.IUserDAO;
import edu.fullerton.csu.jmtran.projectx.messaging.service.DatabaseService;
import edu.fullerton.csu.jmtran.projectx.messaging.service.IMessagingService;
import edu.fullerton.csu.jmtran.projectx.model.Message;
import edu.fullerton.csu.jmtran.projectx.model.User;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageSendingService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private IMailboxDAO mailboxDao;

    @Autowired
    private IMessageDAO messageDao;

    @Autowired
    private List<IMessagingService> messagingServices;

    @Autowired
    private IUserDAO userDao;

    public void sendMessages(
            List<User> recipients, Message message, List<IMessagingService> services) {
        if (services == null) {
            services = this.messagingServices;
        }

        if (recipients == null) {
            recipients = this.userDao.list();
        }

        for (User recipient : recipients) {
            for (IMessagingService service : services) {
                boolean messageSent = service.sendMessage(recipient, message);

                if (!messageSent) {
                    logger.warn(
                            String.format(
                                    "Unable to send message %s via %s to %s",
                                    message.getId(), service.getSystemName(), recipient.getId()));
                }

                this.mailboxDao.sendMessage(recipient, message, service);
            }

            this.mailboxDao.sendMessage(recipient, message, new DatabaseService());
        }
    }

    /**
     * This method will resolve the message and build the list of services from strings
     *
     * @param recipients
     * @param messageId
     * @param services
     */
    public void sendMessages(List<User> recipients, String messageId, List<String> services) {
        List<IMessagingService> targetMessagingServices = new ArrayList<>();

        for (IMessagingService messagingService : messagingServices) {
            if (services.contains(messagingService.getSystemName())) {
                targetMessagingServices.add(messagingService);
            }
        }

        Message message = this.messageDao.get(Integer.parseInt(messageId));

        sendMessages(recipients, message, targetMessagingServices);
    }

    /**
     * This will send a user a single message via all messaging services
     *
     * @param recipient
     * @param message
     */
    public void sendMessages(User recipient, Message message) {
        List<User> recipients = new ArrayList<>();
        recipients.add(recipient);

        this.sendMessages(recipients, message, this.messagingServices);
    }

    public IMailboxDAO getMailboxDao() {
        return mailboxDao;
    }

    public void setMailboxDao(IMailboxDAO mailboxDao) {
        this.mailboxDao = mailboxDao;
    }

    public IMessageDAO getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(IMessageDAO messageDao) {
        this.messageDao = messageDao;
    }

    public List<IMessagingService> getMessagingServices() {
        return messagingServices;
    }

    public void setMessagingServices(List<IMessagingService> messagingServices) {
        this.messagingServices = messagingServices;
    }

    public IUserDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(IUserDAO userDao) {
        this.userDao = userDao;
    }
}
