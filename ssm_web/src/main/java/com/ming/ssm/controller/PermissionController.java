package com.ming.ssm.controller;

import com.ming.ssm.domain.Permission;
import com.ming.ssm.service.IPermission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private IPermission permission;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> permissions = permission.findAll();
        modelAndView.addObject("permission", permissions);
        modelAndView.setViewName("permission-list");
        return modelAndView;
    }

    @RequestMapping("/add.do")
    public ModelAndView add(Permission permission)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        int res = this.permission.insert(permission);
        if(!"1".equals(res)){
            modelAndView.setViewName("success");
        }else{
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

}
