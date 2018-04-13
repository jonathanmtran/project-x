package edu.fullerton.csu.jmtran.projectx.messaging.service;


public abstract class AbstractMessagingService implements IMessagingService {
    protected String name;
    protected String attributeKey;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttributeKey() {
        return attributeKey;
    }

    public void setAttributeKey(String attributeKey) {
        this.attributeKey = this.getClass().getSimpleName() + "." + attributeKey;
    }
}
