package edu.fullerton.csu.jmtran.projectx.messaging.service;

import edu.fullerton.csu.jmtran.projectx.model.Message;

import edu.fullerton.csu.jmtran.projectx.model.User;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

    private String name = "E-mail";
public class EmailService extends AbstractMessagingService {
    private String attributeKey = this.getClass().getCanonicalName() + ".emailAddress";

    private MailSender mailSender;

    public MailSender getMailSender() {
        return mailSender;
    }

    public void setMailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Override
    public boolean sendMessage(User recipient, Message message) {
        String emailAddress = (String) recipient.getAttributes().getOrDefault(this.attributeKey, "");

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
            return false;
        }

        return true;
    }
}
