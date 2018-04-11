package edu.fullerton.csu.jmtran.projectx.dao;

import edu.fullerton.csu.jmtran.projectx.model.User;

import java.util.List;

public interface IUserDAO {
    public User get(String userId);
    public List<User> list();
    public void save(User user);
}
