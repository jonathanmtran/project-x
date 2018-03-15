package edu.fullerton.csu.jmtran.projectx.model;

public class Message {
    private String id;
    private String subject;
    private String message;

    public Message() {
        // Do nothing
    }

    public Message(String id, String subject, String message) {
        this.id = id;
        this.subject = subject;
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
