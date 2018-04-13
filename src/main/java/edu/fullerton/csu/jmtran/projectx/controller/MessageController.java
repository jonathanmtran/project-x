package edu.fullerton.csu.jmtran.projectx.controller;

import edu.fullerton.csu.jmtran.projectx.dao.IMessageDAO;
import edu.fullerton.csu.jmtran.projectx.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    @Autowired
    private IMessageDAO messageDao;

    @RequestMapping(value = "/api/v0/message")
    public Message getMessage(@RequestParam("messageId") int messageId) {
        return this.messageDao.get(messageId);
    }

    public IMessageDAO getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(IMessageDAO messageDao) {
        this.messageDao = messageDao;
    }
}
