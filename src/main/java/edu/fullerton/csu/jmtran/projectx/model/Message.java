package edu.fullerton.csu.jmtran.projectx.model;

import java.io.Serializable;

public class Message implements Serializable {
    private int id;
    private String subject;
    private String messageAbstract;
    private String message;

    public Message() {
        // Do nothing
    }

    public Message(int id, String subject, String message) {
        this.id = id;
        this.subject = subject;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageAbstract() {
        return messageAbstract;
    }

    public void setMessageAbstract(String messageAbstract) {
        this.messageAbstract = messageAbstract;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
