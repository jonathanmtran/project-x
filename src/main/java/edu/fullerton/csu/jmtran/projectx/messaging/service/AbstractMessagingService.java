package edu.fullerton.csu.jmtran.projectx.messaging.service;

/**
 * This class implements IMessagingService such that the setters and getters do not have to be
 * redefined over and over again
 */
public abstract class AbstractMessagingService implements IMessagingService {
    /**
     * The system name of the service
     */
    protected String systemName;
    /**
     * The human-readable name of the service
     */
    protected String name;
    /**
     * The attribute key used to get user-specific information to use with this messaging service
     */
    protected String attributeKey;

    /**
     * If the messaging service systemName isn't explicitly set in applicationContext.xml, the name
     * will be lower-cased and returned.
     *
     * @return systemName, if set. Otherwise, lowercased name
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
