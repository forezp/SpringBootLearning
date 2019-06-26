package com.forezp.shardingjdbcmasterslave.service;

import com.forezp.shardingjdbcmasterslave.entity.User;

import java.util.List;

public interface UserService {

    Long addUser(User user);

    List<User> list();
}
