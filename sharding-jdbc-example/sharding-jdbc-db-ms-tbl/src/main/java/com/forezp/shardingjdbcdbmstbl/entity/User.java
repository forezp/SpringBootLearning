package com.forezp.shardingjdbcdbmstbl.entity;

import java.io.Serializable;

public class User implements Serializable ,Comparable{

    private static final long serialVersionUID = -1205226416664488559L;
    private Integer id;
    private String username;
    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        User u= (User) o;
        return this.id.compareTo(u.id);
    }
}
