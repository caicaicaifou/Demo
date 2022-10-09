package com.exec.spring.ioc;


import com.exec.spring.ioc.entity.Apple;
import com.exec.spring.ioc.entity.Child;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        Apple sweetApple = context.getBean("sweetApple", Apple.class);
        System.out.println(sweetApple.getTitle());

        Child andy = context.getBean("andy", Child.class);
        andy.eat();
    }
}
