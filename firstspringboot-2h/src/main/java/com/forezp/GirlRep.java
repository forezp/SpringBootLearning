package com.forezp;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


//其中第二个参数为Id的类型
public interface GirlRep extends JpaRepository<Girl,Integer>{
    //通过年龄查询
    public List<Girl> findByAge(Integer age);
}
