package edu.fullerton.csu.jmtran.projectx.messaging.service;

import edu.fullerton.csu.jmtran.projectx.model.Message;

public interface MessagingService {
    public boolean sendMessage(String recipient, Message message);
}
