package edu.fullerton.csu.jmtran.projectx.model;

public class UserAttribute {
    private long id;

    private String userId;
    private String key;
    private String value;

    public UserAttribute() {
        // Do nothing
    }

    public UserAttribute(String key, String value) {
        this.key = key;
        this.value = value;
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

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
