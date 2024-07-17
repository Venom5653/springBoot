package ru.mihajlov.springCourse.dao;

import ru.mihajlov.springCourse.model.User;
import java.util.List;

public interface UserDao {
    void addUser(User user);
    void updateUser(int id, User user);
    void removeUser(int id);
    User getUserById(int id);
    List<User> getAllUsers();
}
