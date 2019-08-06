package com.ming.ssm.controller;

import com.ming.ssm.domain.Role;
import com.ming.ssm.domain.User;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 用户操作
 * @author ming
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private com.ming.ssm.service.User userImpl;

    //查询指定id的用户
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        User userInfo = userImpl.findById(id);
        modelAndView.addObject("userInfo", userInfo);
        modelAndView.setViewName("user-show");
        return modelAndView;
    }

    @RequestMapping("/findAll.do")
    public ModelAndView findAll()throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<User> userList = userImpl.findAll();
        modelAndView.addObject("userList", userList);
        modelAndView.setViewName("user-list");
        return modelAndView;
    }

    @RequestMapping("/add.do")
    public ModelAndView add(com.ming.ssm.domain.User user)throws  Exception{
        ModelAndView modelAndView = new ModelAndView();
        int res = userImpl.save(user);
        if(res == 1){
            modelAndView.setViewName("success");
        }else{
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    // 查询用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(String id) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        // 根据用户查询出id
        User user = userImpl.findById(id);
        // 根据用户查询出可以添加的角色
        List<Role> roleList = userImpl.findOtherRoles(id);
        modelAndView.addObject("user", user);
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("user-role-add");
        return modelAndView;
    }

    // 用户角色关联
    @RequestMapping("/insert.do")
    public ModelAndView insert(String[] role_id, String user_id)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        boolean res = false;
        userImpl.insert(role_id, user_id);
        modelAndView.setViewName("success");
        return modelAndView;
    }
}
