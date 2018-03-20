package edu.fullerton.csu.jmtran.projectx.model;

public class MailboxMessage {
    private String id;
    private String userId;
    private String messageId;
    private String massMessagingId;
    private String receivedDate;

    public MailboxMessage() {
        // Do nothing
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getMassMessagingId() {
        return massMessagingId;
    }

    public void setMassMessagingId(String massMessagingId) {
        this.massMessagingId = massMessagingId;
    }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }
}
