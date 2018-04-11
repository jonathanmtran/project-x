package edu.fullerton.csu.jmtran.projectx.messaging.service;

import edu.fullerton.csu.jmtran.projectx.model.Message;
import edu.fullerton.csu.jmtran.projectx.model.User;
import edu.fullerton.csu.jmtran.projectx.service.HibernateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class DatabaseService extends AbstractMessagingService {
    @Override
    public boolean sendMessage(User recipient, Message message) {
        return true;
    }
}
