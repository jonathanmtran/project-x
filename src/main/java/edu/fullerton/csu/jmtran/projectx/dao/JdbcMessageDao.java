package edu.fullerton.csu.jmtran.projectx.dao;

import edu.fullerton.csu.jmtran.projectx.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("messageDao")
public class JdbcMessageDao implements MessageDao {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Message> getMessages() {
        List<Message> messages = this.jdbcTemplate.query("SELECT * FROM MC_MESSAGES", new MessageMapper());

        return messages;
    }

    @Override
    public Message getMessage(String id) {
        String sql = "SELECT * FROM MC_MESSAGES WHERE id = :id";

        Object[] args = new Object[] { id };

        Message message = this.jdbcTemplate.queryForObject(sql, args, new MessageMapper());

        return message;
    }

    private static final class MessageMapper implements RowMapper<Message> {
        @Override
        public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
            Message message = new Message();

            message.setId(rs.getString("id"));
            message.setSubject(rs.getString("subject"));
            message.setMessage(rs.getString("message"));

            return message;
        }
    }
}
