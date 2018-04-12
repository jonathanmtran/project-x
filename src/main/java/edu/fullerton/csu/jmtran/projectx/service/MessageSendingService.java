package edu.fullerton.csu.jmtran.projectx.service;

import edu.fullerton.csu.jmtran.projectx.dao.IMailboxDAO;
import edu.fullerton.csu.jmtran.projectx.messaging.service.DatabaseService;
import edu.fullerton.csu.jmtran.projectx.messaging.service.IMessagingService;
import edu.fullerton.csu.jmtran.projectx.model.Message;
import edu.fullerton.csu.jmtran.projectx.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MessageSendingService {

    @Autowired
    private IMailboxDAO mailboxDAO;

    @Autowired
    private List<IMessagingService> services;

    public void sendMessages(User recipient, Message message) {
        for(IMessagingService service : services) {
            boolean messageSent = service.sendMessage(recipient, message);

            if(!messageSent) {
                // Log a WARNing
            }

            this.mailboxDAO.sendMessage(recipient, message, service);
        }

        this.mailboxDAO.sendMessage(recipient, message, new DatabaseService());
    }

    public IMailboxDAO getMailboxDAO() {
        return mailboxDAO;
    }

    public void setMailboxDAO(IMailboxDAO mailboxDAO) {
        this.mailboxDAO = mailboxDAO;
    }

    public List<IMessagingService> getMessagingServices() {
        return services;
    }

    public void setMessagingServices(List<IMessagingService> messagingServices) {
        this.services = messagingServices;
    }
}
