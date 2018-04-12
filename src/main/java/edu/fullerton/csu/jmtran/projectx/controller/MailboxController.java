package edu.fullerton.csu.jmtran.projectx.controller;

import edu.fullerton.csu.jmtran.projectx.dao.IMailboxDAO;
import edu.fullerton.csu.jmtran.projectx.dao.IMessageDAO;
import edu.fullerton.csu.jmtran.projectx.model.MailboxMessage;
import edu.fullerton.csu.jmtran.projectx.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MailboxController {

    @Autowired
    private IMailboxDAO mailboxDao;

    @Autowired
    private IMessageDAO messageDao;

    @RequestMapping(value = "/api/v0/mailbox")
    public List<MailboxMessage> getMessages(@RequestParam("userId") long userId) {
        List<MailboxMessage> messages = null;

        messages = this.mailboxDao.getMessages(userId + "");

        return messages;
    }

    @RequestMapping(value = "/api/v0/mailbox/message/{messageId}")
    public Message getMessage(@PathVariable("messageId") long messageId) {
        return this.messageDao.get(messageId);
    }
}
