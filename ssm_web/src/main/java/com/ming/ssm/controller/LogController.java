package com.ming.ssm.controller;


import com.ming.ssm.dao.ISysLogDao;
import com.ming.ssm.domain.SysLog;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/log")
public class LogController {
    @Autowired
    private ISysLogDao iSysLogDao;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        List<SysLog> sysLogList = iSysLogDao.findAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("sysLogList", sysLogList);
        modelAndView.setViewName("log-list");
        return modelAndView;
    }
}
