package edu.fullerton.csu.jmtran.projectx.model;

import java.util.ArrayList;
import java.util.List;

public class SendMessageRequest {
    private String messageId;
    private List<String> services;

    public SendMessageRequest() {
        // Do nothing
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(ArrayList<String> services) {
        this.services = services;
    }
}
