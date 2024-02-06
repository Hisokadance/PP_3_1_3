package ru.igor.PP_3_1_3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.igor.PP_3_1_3.dao.UserDao;
import ru.igor.PP_3_1_3.model.User;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServicesImp implements UserServices {

    private final UserDao userDao;

    @Autowired
    public UserServicesImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getAllUsers();
    }

    @Transactional
    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User updateuser) {
        userDao.updateUser(updateuser);
    }

    @Transactional
    @Override
    public void deleteUser(Integer id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUser(Integer id) {
        return userDao.getUser(id);
    }
}

