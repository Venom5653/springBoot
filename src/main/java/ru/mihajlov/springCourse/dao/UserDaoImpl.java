package ru.mihajlov.springCourse.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import ru.mihajlov.springCourse.model.User;

import java.util.List;


@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(int id, User editedUser) {
        User userToBeUpdated = entityManager.find(User.class, id);
        userToBeUpdated.setName(editedUser.getName());
        userToBeUpdated.setLastName(editedUser.getLastName());
        userToBeUpdated.setEmail(editedUser.getEmail());
        entityManager.merge(editedUser);
    }

    @Override
    public void removeUser(int id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user", User.class)
                .getResultList();
    }
}
