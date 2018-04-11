package edu.fullerton.csu.jmtran.projectx.model;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.Map;
import java.util.Set;

public class User {
    private String id;

    private Map attributes;

    @OneToMany(mappedBy = "userId")
    private Set<UserAttribute> attribs;

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

    public Set<UserAttribute> getAttribs() {
        return attribs;
    }

    public void setAttribs(Set<UserAttribute> attribs) {
        this.attribs = attribs;
    }
}
