package com.forezp.shardingjdbcmasterslave.web;

import com.forezp.shardingjdbcmasterslave.entity.User;
import com.forezp.shardingjdbcmasterslave.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public Object list() {
        return userService.list();
    }

    @GetMapping("/add")
    public Object add(@RequestParam Integer id,@RequestParam String username,@RequestParam String  password) {
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        user.setPassword(password);
        return userService.addUser(user);
    }
}
