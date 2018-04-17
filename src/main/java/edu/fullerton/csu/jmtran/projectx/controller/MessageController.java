package edu.fullerton.csu.jmtran.projectx.controller;

import edu.fullerton.csu.jmtran.projectx.dao.IMessageDAO;
import edu.fullerton.csu.jmtran.projectx.model.Message;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MessageController {
    @Autowired
    private IMessageDAO messageDao;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @RequestMapping(value = "/api/v0/message/{messageId}")
    public Message getMessage(@PathVariable("messageId") int messageId) {
        return this.messageDao.get(messageId);
    }

    @RequestMapping(value = "/api/v0/messages")
    public List<Message> getMessages() {
        return this.messageDao.list();
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
