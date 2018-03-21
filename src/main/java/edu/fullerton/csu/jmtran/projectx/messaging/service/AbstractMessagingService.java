package edu.fullerton.csu.jmtran.projectx.messaging.service;

import edu.fullerton.csu.jmtran.projectx.model.Message;

public class AbstractMessagingService implements MessagingService {
    protected String name;

    public String getName() {
        return this.name;
    }

    @Override
    public boolean sendMessage(String recipient, Message message) {
        return false;
    }
}
