package com.exec.spring.aop;

import com.exec.spring.aop.service.UserService;
import com.exec.spring.aop.service.UserServiceImpl;
import com.exec.spring.aop.service.UserServiceProxy;
import com.exec.spring.aop.service.UserServiceProxy1;

public class Application {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUser();
        System.out.println("================1==============");
        UserService userService1 = new UserServiceProxy(new UserServiceImpl());
        userService1.createUser();
        System.out.println("================2==============");
        UserService userService2 = new UserServiceProxy1(new UserServiceProxy(new UserServiceImpl()));
        userService2.createUser();
    }
}
