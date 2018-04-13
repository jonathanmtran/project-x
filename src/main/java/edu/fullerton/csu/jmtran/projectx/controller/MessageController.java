package edu.fullerton.csu.jmtran.projectx.controller;

import edu.fullerton.csu.jmtran.projectx.dao.IMessageDAO;
import edu.fullerton.csu.jmtran.projectx.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    @Autowired
    private IMessageDAO messageDao;

    @RequestMapping(value = "/api/v0/message")
    public Message getMessage(@RequestParam("messageId") int messageId) {
        return this.messageDao.get(messageId);
    }

    @RequestMapping(value = "/api/v0/message", method = RequestMethod.POST)
    public Message createMessage(@RequestBody Message message) {
        return this.messageDao.save(message);
    }

    public IMessageDAO getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(IMessageDAO messageDao) {
        this.messageDao = messageDao;
    }
}
