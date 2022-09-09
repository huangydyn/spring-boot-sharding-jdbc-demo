package com.huangydyn.sharding.controller;

import com.huangydyn.sharding.pojo.UserModel;
import com.huangydyn.sharding.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getUsers")
    public List<UserModel> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/getUser")
    public UserModel getUser(@RequestParam Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("/addUsers")
    public String add() {
        for (int i = 1; i <= 5; i++) {
            UserModel user = new UserModel();
            long id = userService.addUser(user);

            user.setUsername("sharding-" + (user.getId() % 2));
            user.setPassword("pw" + (user.getId() % 2));
            userService.update(user);
        }
        return "添加成功";
    }

    @GetMapping("/deleteOne")
    public String deleteOne(@RequestParam Integer id) {
        userService.deleteOne(id);
        return "删除成功！";
    }

    @GetMapping("/join")
    public List<UserModel> joinUserStatus() {
        return userService.selectByJoinStatus();
    }
}