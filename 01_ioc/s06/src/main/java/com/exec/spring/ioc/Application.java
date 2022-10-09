package com.exec.spring.ioc;

import com.exec.spring.ioc.entity.Apple;
import com.exec.spring.ioc.context.ApplicationContext;
import com.exec.spring.ioc.context.ClassPathXmlApplicationContext;

public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext();
        Apple apple = (Apple) context.getBean("sweetApple");
        System.out.println(apple);
    }
}
