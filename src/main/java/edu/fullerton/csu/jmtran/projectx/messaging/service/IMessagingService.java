package edu.fullerton.csu.jmtran.projectx.messaging.service;

import edu.fullerton.csu.jmtran.projectx.model.Message;
import edu.fullerton.csu.jmtran.projectx.model.User;

public interface IMessagingService {
    public String getName();

    public void setName(String name);

    public String getSystemName();

    public void setSystemName(String systemName);

    public boolean sendMessage(User recipient, Message message);
}
