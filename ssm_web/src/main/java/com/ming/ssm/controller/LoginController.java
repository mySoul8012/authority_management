package com.ming.ssm.controller;

import com.ming.ssm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/login")
@SessionAttributes(value="user")
public class LoginController {
    @Autowired
    private com.ming.ssm.service.User userImpl;

    @RequestMapping("/index.do")
    public ModelAndView index(User user) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        if(userImpl.isUser(user)){
            modelAndView.setViewName("login");
            modelAndView.addObject("user", user);
            return modelAndView;
        }
        modelAndView.setViewName("errorPassword");
        return modelAndView;
    }

    @RequestMapping("/success.do")
    public ModelAndView index1()throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/error.do")
    public ModelAndView error(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }

    @RequestMapping("/logOut.do")
    public ModelAndView logOut(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
