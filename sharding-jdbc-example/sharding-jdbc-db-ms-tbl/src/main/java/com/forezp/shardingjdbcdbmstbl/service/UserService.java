package com.forezp.shardingjdbcdbmstbl.service;



import com.forezp.shardingjdbcdbmstbl.entity.User;

import java.util.List;

public interface UserService {

    Integer addUser(User user);

    List<User> list();

    void deleteAll();
}
