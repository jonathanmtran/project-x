package edu.fullerton.csu.jmtran.projectx.dao;

import edu.fullerton.csu.jmtran.projectx.model.Message;
import java.util.List;

public interface IMessageDAO {
    public Message get(int id);

    public List<Message> list();

    public void save(Message message);
}
