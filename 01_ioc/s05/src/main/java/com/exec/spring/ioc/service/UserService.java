package com.exec.spring.ioc.service;

import com.exec.spring.ioc.dao.UserDao;

public class UserService {
    private UserDao userDao;

    public UserService() {
        System.out.println("UserService已创建:" + this);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        System.out.println("调用setUserDao:" + userDao);
        this.userDao = userDao;
    }
}
