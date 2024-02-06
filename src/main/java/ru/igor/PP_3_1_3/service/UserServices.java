package ru.igor.PP_3_1_3.service;

import ru.igor.PP_3_1_3.model.User;

import java.util.List;

public interface UserServices {

    List<User> getAllUser();

    void addUser(User user);

    User getUser(Integer id);

    void updateUser(User updateuser);

    void deleteUser(Integer id);

}
