package edu.fullerton.csu.jmtran.projectx.messaging.service;

import edu.fullerton.csu.jmtran.projectx.model.Message;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class EmailService extends AbstractMessagingService {
    private String name = "E-mail";

    private MailSender mailSender;

    public MailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public boolean sendMessage(String recipient, Message message) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipient);
        email.setSubject(message.getSubject());
        email.setText(message.getMessage());

        try {
            this.mailSender.send(email);
        }
        catch(MailException mailException) {
            return false;
        }

        return true;
    }
}
