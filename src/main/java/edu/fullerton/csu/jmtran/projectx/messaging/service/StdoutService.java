package edu.fullerton.csu.jmtran.projectx.messaging.service;

import edu.fullerton.csu.jmtran.projectx.model.Message;
import edu.fullerton.csu.jmtran.projectx.model.User;

public class StdoutService extends AbstractMessagingService {
    @Override
    public boolean sendMessage(User recipient, Message message) {
        String format = "{ user: %s, message: %s }";

        System.out.println(String.format(format, recipient.getId(), message.getMessageAbstract()));

        return true;
    }
}
