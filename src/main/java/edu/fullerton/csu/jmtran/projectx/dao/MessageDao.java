package edu.fullerton.csu.jmtran.projectx.dao;

import edu.fullerton.csu.jmtran.projectx.model.Message;

import java.util.List;

public interface MessageDao {
    List<Message> getMessages();
    Message getMessage(String id);
}
