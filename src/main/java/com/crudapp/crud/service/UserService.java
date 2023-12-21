package com.crudapp.crud.service;

import com.crudapp.crud.model.User;
import com.crudapp.crud.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    public List<User> findAll() {
        return userRepo.findAll();
    }
    public User saveUser(User user) {
        return userRepo.save(user);
    }
    public void deleteById(Long id) {
        userRepo.deleteById(id);
    }
}
