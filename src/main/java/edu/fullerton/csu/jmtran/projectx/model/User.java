package edu.fullerton.csu.jmtran.projectx.model;

import java.util.Map;

public class User {
    private String id;
    private Map attributes;

    public User() {
        // Do nothing
    }

    public User(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map getAttributes() {
        return attributes;
    }

    public void setAttributes(Map attributes) {
        this.attributes = attributes;
    }
}
