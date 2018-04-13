package edu.fullerton.csu.jmtran.projectx.model;

import java.util.Set;
import javax.persistence.OneToMany;

public class User {
    private String id;

    @OneToMany(mappedBy = "userId")
    private Set<UserAttribute> attributes;

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

    public Set<UserAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<UserAttribute> attributes) {
        this.attributes = attributes;
    }

    public String getAttribute(String key) {
        for (UserAttribute userAttribute : attributes) {
            if (userAttribute.getKey().equals(key)) {
                return userAttribute.getValue();
            }
        }

        return null;
    }
}
