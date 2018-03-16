package edu.fullerton.csu.jmtran.projectx.model;

public class Mailbox {
    private String userId;
    private String messageId;

    public Mailbox() {
        // Do nothing
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }
}
