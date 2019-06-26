package com.forezp.shardingjdbcmasterslave.repository;

import com.forezp.shardingjdbcmasterslave.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {

    Long addUser(User user);

    List<User> list();

}

