package edu.fullerton.csu.jmtran.projectx.messaging.service;

import edu.fullerton.csu.jmtran.projectx.model.Message;
import edu.fullerton.csu.jmtran.projectx.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** This service simply logs the fact that a message was sent */
public class StdoutService extends AbstractMessagingService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean sendMessage(User recipient, Message message) {
        String format = "{ user: %s, message: %s }";

        logger.info(String.format(format, recipient.getId(), message.getMessageAbstract()));

        return true;
    }
}
