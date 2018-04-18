package edu.fullerton.csu.jmtran.projectx.dao;

import edu.fullerton.csu.jmtran.projectx.messaging.service.IMessagingService;
import edu.fullerton.csu.jmtran.projectx.model.MailboxMessage;
import edu.fullerton.csu.jmtran.projectx.model.Message;
import edu.fullerton.csu.jmtran.projectx.model.User;
import java.util.List;

public interface IMailboxDAO {
    public List<MailboxMessage> getMessages(String userId);

    public List<MailboxMessage> getMessages(String userId, String messagingService);

    public boolean sendMessage(User recipient, Message message, IMessagingService service);
}
