package com.taskmanagment.Task.Management.System.Controller;

import com.taskmanagment.Task.Management.System.Model.User;
import com.taskmanagment.Task.Management.System.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("createUser")
    public String createUser(@RequestParam String name){
        return userService.saveUser(name);
    }

    @GetMapping("allUser")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

}
