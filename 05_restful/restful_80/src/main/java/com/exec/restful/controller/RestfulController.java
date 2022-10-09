package com.exec.restful.controller;

import com.exec.restful.entity.Person;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/restful")
public class RestfulController {
    @GetMapping("/request")
    //@ResponseBody
    public String doGetRequest(){
        return "{\"message\":\"返回查询结果\"}";
    }

    @PostMapping("/request/{rid}")
    //@ResponseBody
    public String doPostRequest(@PathVariable("rid") Integer requestId, Person person){
        System.out.println(person.getName() + ":" + person.getAge());
        return "{\"message\":\"数据新建成功\",\"id\":" + requestId + "}";
    }

    @PutMapping("/request")
    //@ResponseBody
    public String doPutRequest(Person person){
        System.out.println(person.getName() + ":" + person.getAge());
        return "{\"message\":\"数据更新成功\"}";
    }

    @DeleteMapping("/request")
    //@ResponseBody
    public String doDeleteRequest(){
        return "{\"message\":\"数据删除成功\"}";
    }

    @GetMapping("/person")
    public Person findByPersonId(Integer id){
        Person p = new Person();
        if(id==1){
            p.setName("lily");
            p.setAge(23);
        }else if(id==2){
            p.setName("smith");
            p.setAge(22);
        }
        return p;
    }

    @GetMapping("/persons")
    public List<Person> findPersons(){
        List list = new ArrayList();
        Person p1 = new Person();
        p1.setName("lily");
        p1.setAge(23);
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("smith");
        p2.setAge(22);
        p2.setBirthday(new Date());
        list.add(p1);
        list.add(p2);
        return list;
    }

}
