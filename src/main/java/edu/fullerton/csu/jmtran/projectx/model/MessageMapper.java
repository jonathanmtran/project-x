package edu.fullerton.csu.jmtran.projectx.model;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public final class MessageMapper implements RowMapper<Message> {
    @Override
    public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
        Message message = new Message();

        message.setId(rs.getInt("id"));
        message.setSubject(rs.getString("subject"));
        message.setMessage(rs.getString("message"));

        return message;
    }
}
