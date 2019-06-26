package com.forezp.shardingjdbcmasterslave.service.impl;

import com.forezp.shardingjdbcmasterslave.repository.UserRepository;
import com.forezp.shardingjdbcmasterslave.entity.User;
import com.forezp.shardingjdbcmasterslave.service.UserService;

import io.shardingsphere.api.HintManager;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl  implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public Long addUser(User user) {

        // 强制路由主库
        //HintManager.getInstance().setMasterRouteOnly();
        return userRepository.addUser(user);
    }

    @Override
    public List<User> list() {

        return userRepository.list();
    }
}
