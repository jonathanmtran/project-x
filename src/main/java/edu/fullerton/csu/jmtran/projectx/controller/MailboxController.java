package edu.fullerton.csu.jmtran.projectx.controller;

import edu.fullerton.csu.jmtran.projectx.model.Message;
import edu.fullerton.csu.jmtran.projectx.service.HibernateMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MailboxController {

    @Autowired
    private HibernateMessageService messageService;

    @RequestMapping(value = "/api/v0/mailbox")
    public List<Message> getMessages(@RequestParam("userId") long userId) {
        List<Message> messages = null;

        messages = this.messageService.getAllMessages();

        return messages;
    }

    @RequestMapping(value = "/api/v0/mailbox/message/{messageId}")
    public Message getMessage(@PathVariable("messageId") long messageId) {
        return this.messageService.getMessage(messageId);
    }

    public HibernateMessageService getMessageService() {
        return messageService;
    }

    public void setMessageService(HibernateMessageService messageService) {
        this.messageService = messageService;
    }

}
