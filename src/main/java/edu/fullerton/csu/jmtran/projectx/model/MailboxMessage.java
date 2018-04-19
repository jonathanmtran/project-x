package edu.fullerton.csu.jmtran.projectx.model;

import java.util.Date;

public class MailboxMessage {
    private int id;
    private String userId;
    private int messageId;
    private Message message;
    private String massMessagingId;
    private String messagingService;
    private Date receivedDate;
    private Date seenDate;

    public MailboxMessage() {
        // Do nothing
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMassMessagingId() {
        return massMessagingId;
    }

    public void setMassMessagingId(String massMessagingId) {
        this.massMessagingId = massMessagingId;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
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

    public Date getSeenDate() {
        return seenDate;
    }

    public void setSeenDate(Date seenDate) {
        this.seenDate = seenDate;
    }
}
