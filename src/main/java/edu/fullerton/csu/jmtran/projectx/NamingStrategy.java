package edu.fullerton.csu.jmtran.projectx;

import org.hibernate.cfg.ImprovedNamingStrategy;

public class NamingStrategy extends ImprovedNamingStrategy {
    private String prefix;

    public String tableName(String tableName) {
        return this.prefix + tableName;
    }

    public String propertyToTableName(String className, String propertyName) {
        return this.prefix + classToTableName(className) + "_" + propertyToColumnName(propertyName);
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }
}
