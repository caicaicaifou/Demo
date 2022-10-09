package com.exec.springmvc.controller;

import com.exec.springmvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/fm")
public class FreemarkerController {
    @GetMapping("/test02")
    public ModelAndView showTest() {
        System.out.println("asdas ");
        ModelAndView mav = new ModelAndView("/test");
        User user = new User();
        user.setUsername("andy");
        mav.addObject("u", user);
        return mav;
    }
}
