package com.library.service;

import com.library.entity.User;
import com.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void save(User user) {
        userRepository.save(user);
    }


    public User findOne(String email) {
        return userRepository.getOne(email);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> findByName(String name) {
        return userRepository.findByUsernameLike("%" + name + "%");
    }

    public void deleteOne(String mail) {
        userRepository.deleteById(mail);
    }
}
