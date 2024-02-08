package ru.igor.PP_3_1_3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.igor.PP_3_1_3.dao.UserDao;
import ru.igor.PP_3_1_3.model.User;
import ru.igor.PP_3_1_3.repositories.PeopleRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServicesImp implements UserServices {

    private final UserDao userDao;
    private final PeopleRepository peopleRepository;

    @Autowired
    public UserServicesImp(UserDao userDao, PeopleRepository peopleRepository) {
        this.userDao = userDao;
        this.peopleRepository = peopleRepository;
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
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }

}

