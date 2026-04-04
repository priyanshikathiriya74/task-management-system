package com.taskmanagment.Task.Management.System.Service;

import com.taskmanagment.Task.Management.System.Model.User;
import com.taskmanagment.Task.Management.System.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public String saveUser(String name) {
        User user = new User();
        user.setName(name);
        userRepository.save(user);
        return "User Created successfully";
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
