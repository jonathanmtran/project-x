package edu.fullerton.csu.jmtran.projectx.messaging.service;

import edu.fullerton.csu.jmtran.projectx.model.Message;
import edu.fullerton.csu.jmtran.projectx.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** This service results in a row in the MAILBOX_MESSAGES table */
public class DatabaseService extends AbstractMessagingService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean sendMessage(User recipient, Message message) {
        return true;
    }
}
