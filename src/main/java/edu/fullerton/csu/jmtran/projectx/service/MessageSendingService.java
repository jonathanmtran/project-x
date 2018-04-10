package edu.fullerton.csu.jmtran.projectx.service;

import edu.fullerton.csu.jmtran.projectx.messaging.service.IMessagingService;
import edu.fullerton.csu.jmtran.projectx.model.Message;
import edu.fullerton.csu.jmtran.projectx.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MessageSendingService {

    @Autowired
    private List<IMessagingService> services;

    public void sendMessages(User recipient, Message message) {
        for(IMessagingService service : services) {
            service.sendMessage(recipient, message);
        }
    }

    public List<IMessagingService> getMessagingServices() {
        return services;
    }

    public void setMessagingServices(List<IMessagingService> messagingServices) {
        this.services = messagingServices;
    }
}
