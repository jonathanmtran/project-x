package edu.fullerton.csu.jmtran.projectx.model;

import java.util.Date;

public class MailboxMessage {
    private long id;
    private String userId;
    private String messageId;
    private String massMessagingId;
    private String messagingService;
    private Date receivedDate;

    private Message message;

    public MailboxMessage() {
        // Do nothing
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getMessagingService() {
        return messagingService;
    }

    public void setMessagingService(String messagingService) {
        this.messagingService = messagingService;
    }

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
