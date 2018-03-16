package edu.fullerton.csu.jmtran.projectx.dao;

import edu.fullerton.csu.jmtran.projectx.model.Message;
import edu.fullerton.csu.jmtran.projectx.model.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("mailboxDao")
public class JdbcMailboxDao implements MailboxDao {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Message> getMessages(String userId) {
        String sql = "SELECT * FROM MC_INBOX WHERE user_id = :userId";

        Object[] args = new Object[] { userId };

        return this.jdbcTemplate.query(sql, args, new MessageMapper());
    }
}
