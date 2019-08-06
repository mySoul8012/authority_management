package com.ming.ssm.controller;

import com.ming.ssm.domain.Permission;
import com.ming.ssm.domain.Product;
import com.ming.ssm.domain.Role;
import com.ming.ssm.service.IPermission;
import com.ming.ssm.service.IProductService;
import com.ming.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/Role")
public class RoleController {
    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private IPermission iPermission;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        List<Role> roleList = iRoleService.findAll();
        modelAndView.addObject("roleList", roleList);
        modelAndView.setViewName("role-list");
        return modelAndView;
    }

    @RequestMapping("/add.do")
    public ModelAndView add(Role role)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        int res = iRoleService.insert(role);
        if(!"1".equals(res)){
            modelAndView.setViewName("success");
        }else{
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }

    @RequestMapping("/insert.do")
    public ModelAndView insert(String roleId)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        List<Permission> listPermission = iPermission.findAll();
        modelAndView.addObject("listPermission", listPermission);
        modelAndView.addObject("role_id", roleId);
        modelAndView.setViewName("user-role-list");
        return modelAndView;
    }

    @RequestMapping(value = "/insert1.do")
    public ModelAndView insert1(String role_id, String[] permission)throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        boolean res = iRoleService.insert1(role_id, permission);
        if(res){
            modelAndView.setViewName("success");
        }else{
            modelAndView.setViewName("error");
        }
        return modelAndView;
    }
}
