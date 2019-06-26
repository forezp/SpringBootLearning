package com.forezp.shardingjdbcdbmstbl.service.impl;


import com.forezp.shardingjdbcdbmstbl.entity.User;
import com.forezp.shardingjdbcdbmstbl.repository.UserRepository;
import com.forezp.shardingjdbcdbmstbl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Resource
    UserRepository userRepository;

    @Override
    public Integer addUser(User user) {

        // 强制路由主库
        //HintManager.getInstance().setMasterRouteOnly();
        return userRepository.addUser(user);
    }

    @Override
    public List<User> list() {

        return userRepository.list();
    }

    @Override
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
