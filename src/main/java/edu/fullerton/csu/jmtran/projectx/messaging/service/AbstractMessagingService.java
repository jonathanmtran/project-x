package edu.fullerton.csu.jmtran.projectx.messaging.service;


public abstract class AbstractMessagingService implements IMessagingService {
    protected String systemName;
    protected String name;
    protected String attributeKey;

    /**
     * If the messaging service systemName isn't explicitly set in applicationContext.xml,
     * the name will be lower-cased and returned.
     */
    public String getSystemName() {
        return systemName != null ? systemName : name.toLowerCase();
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

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
