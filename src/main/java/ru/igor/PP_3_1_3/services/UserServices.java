package ru.igor.PP_3_1_3.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.igor.PP_3_1_3.model.User;
import ru.igor.PP_3_1_3.repositories.PeopleRepository;
import ru.igor.PP_3_1_3.repositories.RoleRepository;

import java.util.List;

@Service
public class UserServices {

    private final PeopleRepository peopleRepository;

    @Autowired
    public UserServices(PeopleRepository peopleRepository, RoleRepository roleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public User findByUsername(String username) {
        return peopleRepository.findByUsername(username).orElse(null);
    }

    public List<User> findAll() {
        return peopleRepository.findAll();
    }

    public User findOne(Long id) {
        return peopleRepository.findById(id).orElse(null);
    }

    public void save(User user) {
        peopleRepository.save(user);
    }

    public void delete(Long id) {
        peopleRepository.deleteById(id);
    }


}
