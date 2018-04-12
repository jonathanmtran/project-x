package edu.fullerton.csu.jmtran.projectx.messaging.service;

import edu.fullerton.csu.jmtran.projectx.model.Message;

import edu.fullerton.csu.jmtran.projectx.model.User;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class EmailService extends AbstractMessagingService {
    private MailSender mailSender;

    public MailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public boolean sendMessage(User recipient, Message message) {
        @SuppressWarnings("unchecked")
        String emailAddress = recipient.getAttribute(this.attributeKey);

        if(emailAddress.isEmpty()) {
            return false;
        }

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(emailAddress);
        email.setSubject(message.getSubject());
        email.setText(message.getMessage());

        try {
            this.mailSender.send(email);
        }
        catch(MailException mailException) {
            System.err.println(mailException.getMessage());
            return false;
        }

        return true;
    }
}
