package com.forezp.service;


import org.springframework.stereotype.Component;
/**
 * Created by fangzhipeng on 2017/4/19.
 */
@Component
public class Service {

    private final String message;

    public Service(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}
