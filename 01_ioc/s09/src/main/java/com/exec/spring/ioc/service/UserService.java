package com.exec.spring.ioc.service;

import com.exec.spring.ioc.dao.UserDao;

public class UserService {
    private UserDao userDao;

    public void createUser() {
        System.out.println("调用创建用户业务代码");
        userDao.insert();
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
