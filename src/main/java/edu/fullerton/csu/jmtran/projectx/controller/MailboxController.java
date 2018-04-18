package edu.fullerton.csu.jmtran.projectx.controller;

import edu.fullerton.csu.jmtran.projectx.dao.IMailboxDAO;
import edu.fullerton.csu.jmtran.projectx.dao.IMessageDAO;
import edu.fullerton.csu.jmtran.projectx.model.MailboxMessage;
import edu.fullerton.csu.jmtran.projectx.model.Message;
import edu.fullerton.csu.jmtran.projectx.model.SendMessageRequest;
import edu.fullerton.csu.jmtran.projectx.service.MessageSendingService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MailboxController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IMailboxDAO mailboxDao;

    @Autowired
    private IMessageDAO messageDao;

    @Autowired
    private MessageSendingService messageSendingService;

    @RequestMapping(value = "/api/v0/mailbox")
    public List<MailboxMessage> getMessages(@RequestParam("userId") String userId) {
        List<MailboxMessage> messages = null;

        messages = this.mailboxDao.getMessages(userId);

        return messages;
    }

    @RequestMapping(value = "/api/v0/mailbox/message/{messageId}")
    public Message getMessage(@PathVariable("messageId") int messageId) {
        return this.messageDao.get(messageId);
    }

    @RequestMapping(value = "/api/v0/mailbox/send", method = RequestMethod.POST)
    public void sendMessages(@RequestBody SendMessageRequest request) {
        this.messageSendingService.sendMessages(null, request.getMessageId(), request.getServices());
    }

    public IMailboxDAO getMailboxDao() {
        return mailboxDao;
    }

    public void setMailboxDao(IMailboxDAO mailboxDao) {
        this.mailboxDao = mailboxDao;
    }

    public IMessageDAO getMessageDao() {
        return messageDao;
    }

    public void setMessageDao(IMessageDAO messageDao) {
        this.messageDao = messageDao;
    }
}
