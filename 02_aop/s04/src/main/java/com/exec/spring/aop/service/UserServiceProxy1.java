package com.exec.spring.aop.service;

public class UserServiceProxy1 implements UserService {
    private final UserService userService;

    public UserServiceProxy1(UserService userService) {
        System.out.println("22222222222222");
        this.userService = userService;
    }

    public void createUser() {
        userService.createUser();
        System.out.println("========后置扩展功能======");
    }
}
