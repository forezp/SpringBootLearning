package com.forezp.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fangzhipeng on 2017/4/18.
 */
@RestController
public class MiyaController {

    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private int age;

    @RequestMapping(value = "/miya")
    public String miya(){
        return name+":"+age;
    }

}
