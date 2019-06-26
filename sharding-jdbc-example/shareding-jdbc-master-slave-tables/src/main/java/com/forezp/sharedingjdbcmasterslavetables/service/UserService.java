package com.forezp.sharedingjdbcmasterslavetables.service;



import com.forezp.sharedingjdbcmasterslavetables.entity.User;

import java.util.List;

public interface UserService {

    Integer addUser(User user);

    List<User> list();
}
