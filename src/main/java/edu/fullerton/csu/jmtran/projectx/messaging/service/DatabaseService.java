package edu.fullerton.csu.jmtran.projectx.messaging.service;

import edu.fullerton.csu.jmtran.projectx.model.Message;
import edu.fullerton.csu.jmtran.projectx.model.User;

public class DatabaseService extends AbstractMessagingService {
    @Override
    public boolean sendMessage(User recipient, Message message) {
        return true;
    }
}
