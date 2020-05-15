package com.library.controller;


import com.library.entity.User;
import com.library.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value="/all")
    @ApiOperation(value = "Получить все тэги")
    public List<User> getAllUsers() {
        return userService.findAll();
    }
    @DeleteMapping("/{mail}")
    @ApiOperation(value = "Удалить юзера")
    public void deleteUser(@PathVariable ("mail") String mail)
    {
        userService.deleteOne(mail);
    }

    @GetMapping("/{mail}")
    @ApiOperation(value = "Найти юзера по мэилу")
    public User getUser(@PathVariable ("mail") String  mail) throws Exception {
        return userService.findOne(mail);
    }
    @GetMapping("/name/{name}")
    @ApiOperation(value = "Найти юзера по имени")
    public List<User> getUserByName(@PathVariable ("name") String  name) throws Exception {
        return userService.findByName(name);
    }

}